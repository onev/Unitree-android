package com.lt.unitreesdk;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lt.unitreesdk.model.Battery;
import com.lt.unitreesdk.model.Btn;
import com.lt.unitreesdk.model.Cruise;
import com.lt.unitreesdk.model.Heartbeat;
import com.lt.unitreesdk.model.IAP;
import com.lt.unitreesdk.model.Motor;
import com.lt.unitreesdk.model.Navegation;
import com.lt.unitreesdk.model.Rocker;
import com.lt.unitreesdk.model.Status;
import com.lt.unitreesdk.model.Vertion;
import com.lt.unitreesdk.model.Waypoint;
import com.lt.unitreesdk.model.WiFi;

import java.util.Arrays;

public class UnitreeSDK {


    private String mIp;
    private int mPort;

    public void setIp(String ip) {
        this.mIp = ip;
    }

    public void setPort(int port) {
        this.mPort = port;
    }

    private SendThread sendthread;

    public UnitreeSDK(String ip, int port) {     //IP，端口，数据
        this.mIp = ip;
        this.mPort = port;
    }

    public void SendData(String data) {
        sendthread.send(data);
    }

    public void Conn() {
        /***************连接*****************/
        sendthread = new SendThread(mIp, mPort, mHandler);
        StartThread();
        // new Thread().start();
        /**********************************/
    }

    public void Colse() {
        if (sendthread != null)
            sendthread.close();
    }

    /**
     * 开启socket连接线程
     */
    void StartThread() {
        // sendthread = new SendThread(mIp, mPort, mHandler);
        new Thread(sendthread).start();//创建一个新线程
    }

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SendThread.MSGCATE.CONN: {
                    if (onSocketListener != null)
                        onSocketListener.conn();
                }
                break;
                case SendThread.MSGCATE.CLOSE: {
                    sendthread = null;
                    if (onSocketListener != null)
                        onSocketListener.colse();
                }
                break;
                case SendThread.MSGCATE.SEND: {
                    if (onSocketListener != null)
                        onSocketListener.send();
                }
                break;
                case SendThread.MSGCATE.REC_DATA: {
                    Log.i("mr_收到的数据： ", msg.obj.toString());
                    String receive_Msg = msg.obj.toString();

                    if (onSocketListener != null)
                        onSocketListener.recData(receive_Msg);


                    String regex = "FEEF";
                    String[] rs = receive_Msg.split(regex);
                    for (String str : rs) {
                        System.out.println("========>>>>" + regex + str);
                        System.out.print("========>>>>"+analyzeData(regex+str));
//                        System.out.println("========>>>>"+(regex+str).length());
                    }
                }
                break;
            }
        }
    };

    private boolean checkCRC(int[] data) {
        int len = data.length;
        int[] crcData = Arrays.copyOfRange(data, 0, len - 4);
        String crcStr = Integer.toHexString(new CRCUtil().getCRC(crcData));
        int[] crcs = DigitalTrans.hex2int(crcStr);
        if (crcs.length < 4 || data.length < 7) return false;
        return data[len - 1] == crcs[0] && data[len - 2] == crcs[1] && data[len - 3] == crcs[2] && data[len - 4] == crcs[3];
    }

    private String analyzeData(String data) {
        int[] ints = DigitalTrans.hex2int(data);
        if (ints.length >= 7) {
            if (ints[0] == 0xFE && ints[1] == 0xEF) {
                if (checkCRC(ints)){
                    String retMsg = "CRC检验成功";
                    int fn = ints[2];
                    switch (fn) {
                        case 0x00: {
                            if (onFuncListener != null)
                                onFuncListener.heartBeat(new Heartbeat().analyzeData(ints));
                        }
                        case 0x01: {
                            if (onFuncListener != null)
                                onFuncListener.vertion(new Vertion().analyzeData(ints));
                        }
                        break;
                        case 0x02: {
                            if (onFuncListener != null)
                                onFuncListener.status(new Status().analyzeData(ints));
                        }
                        break;
                        case 0x03: {
                            if (onFuncListener != null)
                                onFuncListener.wifi(new WiFi().analyzeData(ints));
                        }
                        break;
                        case 0x04: {
                            if (onFuncListener != null)
                                onFuncListener.battery(new Battery().analyzeData(ints));
                        }
                        break;
                        case 0x05: {
                            if (onFuncListener != null)
                                onFuncListener.rocker(new Rocker().analyzeData(ints));
                        }
                        break;
                        case 0x06: {
                            if (onFuncListener != null)
                                onFuncListener.motor(new Motor().analyzeData(ints));
                        }
                        break;
                        case 0x07: {
                            if (onFuncListener != null)
                                onFuncListener.btn(new Btn().analyzeData(ints));
                        }
                        break;
                        case 0x08: {
                            if (onFuncListener != null)
                                onFuncListener.cruise(new Cruise().analyzeData(ints));
                        }
                        break;
                        case 0x09: {
                            if (onFuncListener != null)
                                onFuncListener.navegation(new Navegation().analyzeData(ints));
                        }
                        break;
                        case 0x0A: {
                            if (onFuncListener != null)
                                onFuncListener.waypoint(new Waypoint().analyzeData(ints));
                        }
                        break;
                        case 0x0B: {
                            if (onFuncListener != null)
                                onFuncListener.iap(new IAP().analyzeData(ints));
                        }
                        break;
                    }
                    return retMsg;
                }
            } else {
                return "CRC检验失败";
            }
        }
        return "data数据不正确";
    }

    private OnSocketListener onSocketListener;

    public void setOnSocketListener(OnSocketListener socketListener) {
        this.onSocketListener = socketListener;
    }

    private OnFuncListener onFuncListener;

    public void setOnFuncListener(OnFuncListener funcListener) {
        this.onFuncListener = funcListener;
    }

}
