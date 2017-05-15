package ua.ho.andro.marvelapp.helper;


import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.TheApplication;

public class LocalDataLoader extends AsyncTask<Void, Void, RegionsList> {
    public static final String FILE_NAME = "xml/regions.xml";

    private WeakReference<Callback<RegionsList>> mCallbackRef;

    public LocalDataLoader(@NonNull Callback<RegionsList> callback) {
        this.mCallbackRef = new WeakReference<>(callback);
    }


    @Override
    protected RegionsList doInBackground(Void... voids) {
        RegionsList resultJson = null;
        try {
            AssetManager assetManager = TheApplication.getInstance().getAssets();
            InputStream is = assetManager.open(FILE_NAME);
            Serializer ser = new Persister();
            resultJson = ser.read(RegionsList.class, new InputStreamReader(is, "UTF-8"));

        } catch (IOException ex) {
            Log.e("Loader", "failed when read json from assets", ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    @Override
    protected void onPostExecute(RegionsList regionsList) {
        super.onPostExecute(regionsList);
        String s = regionsList.getRegion().get(0).getTranslate();
        String q = s;
        Callback<RegionsList> callback = mCallbackRef.get();
        if (callback != null) {
            if (regionsList != null) {
                callback.onSuccess(regionsList);
            } else {
                callback.onError();
            }
        }
    }
}