package com.lt.unitreesdk;

/**
 * Created by 14942 on 2018/3/26.
 */

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class SendThread implements Runnable {

    private String ip;
    private int port;
    DataInputStream in;
    PrintWriter out;      //打印流
    DataOutputStream writer;
    Handler mainHandler;
    Socket s;
    private String receiveMsg;
    private String testdata = "FEEF0B0800000000000000005AE7E5CC";
    ArrayList<String> list = new ArrayList<String>();

    public SendThread(String ip, int port, Handler mainHandler) {     //IP，端口，数据
        this.ip = ip;
        this.port = port;
        this.mainHandler = mainHandler;
    }

    /**
     * 套接字的打开
     */
    void open() {
        try {
            s = new Socket(ip, port);
            //in收单片机发的数据
            in = new DataInputStream(s.getInputStream());
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    s.getOutputStream())), true);
            writer = new DataOutputStream(s.getOutputStream());
            Message msg = mainHandler.obtainMessage();
            msg.what = MSGCATE.CONN;
            mainHandler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 套接字的关闭
     */
    public void close() {
        try {
            if (s != null)
                s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        //创建套接字
        open();

        //BufferedReader
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                        close();
                        open();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (s != null && !s.isClosed()) {
                        if (s.isConnected()) {
                            if (!s.isInputShutdown()) {
                                try {
                                    Log.i("mr", "等待接收信息");


                                    byte[] bytes = new byte[1024];
                                    byte[] byte1 = new byte[40];
                                    byte1 = DigitalTrans.hex2byte(testdata);
                                    //byte[] bys = new byte[1024];
                                    int len = 0;                            //int len = 0;
                                    //把输入流的数据写入bytes数组中。再依次读取出来即可
                                    while ((len = in.read(bytes)) != -1) {
                                        //while((len = in.read(bys)) != -1) {
                                        writer.writeBytes(DigitalTrans.bytetoString(byte1));
                                        writer.flush();
//                                        writer.close();
                                        receiveMsg = DigitalTrans.byte2hex(bytes);
                                        Message msg = mainHandler.obtainMessage();
                                        msg.what = MSGCATE.REC_DATA;
                                        msg.obj = receiveMsg;
                                        mainHandler.sendMessage(msg);
                                    }

                                } catch (IOException e) {
                                    Log.i("mr", e.getMessage());
                                    try {
                                        s.shutdownInput();
                                        s.shutdownOutput();
                                        s.close();
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
            }

        });
        thread.start();

        while (true) {
            //连接中
            if (s != null && !s.isClosed() && s.isConnected() && !s.isInputShutdown()) {

                // 如果消息集合有东西，并且发送线程在工作。
                if (list.size() > 0 && !s.isOutputShutdown()) {
                    out.println(list.get(0));
                    list.remove(0);
                }

                Message msg = mainHandler.obtainMessage();
                msg.what = MSGCATE.SEND;
                mainHandler.sendMessage(msg);
            } else {
                //连接中断了
                Log.i("mr", "连接断开了");
                Message msg = mainHandler.obtainMessage();
                msg.what = MSGCATE.CLOSE;
                mainHandler.sendMessage(msg);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                try {
                    if (out != null)
                        out.close();
                    if (in != null)
                        in.close();
                    if (s != null)
                        s.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }

    public void send(String msg) {
        System.out.println("msg的值为：  " + msg);
        Log.i("msg的值为", "send: "+msg);
        list.add(msg);
    }

    public class MSGCATE {
        public final static int CONN = 0x00;
        public final static int SEND = 0x01;
        public final static int CLOSE = 0x02;
        public final static int REC_DATA = 0x03;
    }

}
