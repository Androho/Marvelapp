package ua.ho.andro.marvelapp.helper;


import android.app.ActivityManager;

import ua.ho.andro.marvelapp.TheApplication;

import static android.content.Context.ACTIVITY_SERVICE;

public class StorageCapacity {

    private long freeRamMemorySize=freeRamMemorySize();
    private long totalRamMemorySize=totalRamMemorySize();
    private int intFreeSize = (int) freeRamMemorySize;
    private int intTotalSize = (int) totalRamMemorySize;
    private double doubleFreeSize=(double)freeRamMemorySize;
    private String strFreeSize = String.format("%(.2f",doubleFreeSize/1024);

    public  long freeRamMemorySize() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) TheApplication.getInstance().getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.availMem / 1048576L;

        return availableMegs;
    }

    public long totalRamMemorySize() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager)TheApplication.getInstance().getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.totalMem / 1048576L;
        return availableMegs;
    }

    public long getFreeRamMemorySize() {
        return freeRamMemorySize;
    }

    public long getTotalRamMemorySize() {
        return totalRamMemorySize;
    }

    public int getIntFreeSize() {
        return intFreeSize;
    }

    public int getIntTotalSize() {
        return intTotalSize;
    }

    public double getDoubleFreeSize() {
        return doubleFreeSize;
    }

    public String getStrFreeSize() {
        return strFreeSize;
    }
}
