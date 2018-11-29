package com.lt.unitreesdk;

public class CRCUtil {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    public native int getCRC(int[] bytes);
}
