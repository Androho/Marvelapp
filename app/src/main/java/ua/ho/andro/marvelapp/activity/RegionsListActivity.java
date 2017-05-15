package ua.ho.andro.marvelapp.activity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import ua.ho.andro.marvelapp.BaseActivity;
import ua.ho.andro.marvelapp.helper.LoaderCallbackImpl;
import ua.ho.andro.marvelapp.helper.LocalDataLoader;
import ua.ho.andro.marvelapp.helper.StorageCapacity;
import ua.ho.andro.marvelapp.R;
import ua.ho.andro.marvelapp.adapters.RegionsListAdapter;


public class RegionsListActivity extends BaseActivity {

    public GridView gridView;
    private LoaderCallbackImpl.LoaderCallbacksImpl loaderCallbacks;
    private ProgressBar progressBar;
    private TextView tvFreeRamSize,mTitle;
    public RegionsListAdapter gAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regions_list);

        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText(R.string.download_map);

        tvFreeRamSize =(TextView) findViewById(R.id.tv_capacity);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        StorageCapacity storage = new StorageCapacity();
        progressBar.setMax(storage.getIntTotalSize());
        progressBar.setProgress(storage.getIntFreeSize());
        tvFreeRamSize.setText(storage.getStrFreeSize());
        gridView = (GridView) findViewById(R.id.gv_regions_list);
        gridView.setNumColumns(1);
        loaderCallbacks = new LoaderCallbackImpl.LoaderCallbacksImpl(this);

        LocalDataLoader loader = new LocalDataLoader(loaderCallbacks);
        loader.execute();
    }
}


