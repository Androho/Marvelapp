package ua.ho.andro.marvelapp.helper;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import ua.ho.andro.marvelapp.R;
import ua.ho.andro.marvelapp.activity.RegionActivity;

public class DownloadTask extends AsyncTask<String, Integer, Drawable> {
    private RegionActivity regionActivity;

    public DownloadTask(RegionActivity regionActivity) {
        if (regionActivity == null)
            this.regionActivity = regionActivity;
    }


    @Override
    protected void onPreExecute() {
        String title = regionActivity.getRegionName();
        regionActivity.relativeLayout.setVisibility(View.VISIBLE);
        regionActivity.downloadingRegion.setText("Downloading "
                + title.substring(0, 1).toUpperCase()
                + title.substring(1));
    }

    @Override
    protected Drawable doInBackground(String... params) {
        int count;
        File saveDir = new File(regionActivity.getString(R.string.save_dir));
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        try {
            URL url = new URL(params[0]);
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            OutputStream output = new FileOutputStream(regionActivity.getString(R.string.save_dir)
                    + regionActivity.getRegionName()
                    + "_"
                    + regionActivity.getRegionsName()
                    + "_2.obf.zip");
            byte data[] = new byte[256];
            long total = 0;

            while ((count = input.read(data)) != -1) {

                if (isCancelled()) {
                    return null;
                }
                total += count;
                output.write(data, 0, count);

                publishProgress((int) ((total * 100) / lenghtOfFile));
            }
            output.flush();
            output.close();
            input.close();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        String imagePath = Environment.getExternalStorageDirectory().toString()
                + regionActivity.getString(R.string.save_dir)
                + regionActivity.getRegionName()
                + "_"
                + regionActivity.getRegionsName()
                + "_2.obf.zip";
        return Drawable.createFromPath(imagePath);
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        regionActivity.progressBar.setProgress(progress[0]);
        regionActivity.capacityPercent.setText(progress[0].toString());
    }

    @Override
    protected void onPostExecute(Drawable result) {
        regionActivity.relativeLayout.setVisibility(View.GONE);
        //imageView.setImageDrawable(result);

    }

    @Override
    protected void onCancelled() {
    }
}