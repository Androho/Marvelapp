package ua.ho.andro.marvelapp.helper;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import ua.ho.andro.marvelapp.activity.RegionActivity;


public class DownloadTask extends AsyncTask<String, Integer, Drawable> {
    private RegionActivity regionActivity;

    public DownloadTask(RegionActivity regionActivity) {
        this.regionActivity = regionActivity;
    }

    @Override
    protected void onPreExecute() {
        regionActivity.relativeLayout.setVisibility(View.VISIBLE);
        regionActivity.progressBar = new ProgressBar(regionActivity);

    }

    @Override
    protected Drawable doInBackground(String... strings) {

        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... progress) {
        regionActivity.progressBar.setProgress(progress[0]);
        regionActivity.capacityPercent.setText(progress[0]);
    }
    @Override
    protected void onPostExecute(Drawable result) {
        regionActivity.relativeLayout.setVisibility(View.GONE);
        //imageView.setImageDrawable(result);

    }
}