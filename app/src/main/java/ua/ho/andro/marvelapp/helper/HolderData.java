package ua.ho.andro.marvelapp.helper;


import android.support.annotation.NonNull;

import ua.ho.andro.marvelapp.Model.RegionsList;

public class HolderData {

    private static volatile HolderData instance;

    public RegionsList result;

    private HolderData(RegionsList region) {
        result = region;
    }

    public static void init(@NonNull RegionsList region) {
        if (instance == null) {
            synchronized (HolderData.class) {
                if (instance == null) {
                    instance = new HolderData(region);
                }
            }
        }
    }

    public static HolderData getInstance() {
        if (instance == null) {
            throw new RuntimeException("Call init(RegionsList region) before.");
        }
        return instance;
    }
}