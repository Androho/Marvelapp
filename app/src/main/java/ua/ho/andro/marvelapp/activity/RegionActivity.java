package ua.ho.andro.marvelapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ua.ho.andro.marvelapp.BaseActivity;
import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.R;
import ua.ho.andro.marvelapp.adapters.RegionAdapter;
import ua.ho.andro.marvelapp.helper.BundleKeys;
import ua.ho.andro.marvelapp.helper.DownloadTask;
import ua.ho.andro.marvelapp.helper.HolderData;

public class RegionActivity extends BaseActivity {
    private TextView mTitle;
    private GridView gridView;
    private RegionAdapter regionAdapter;
    private RegionsList result;
    private int position, positions1;
    public RelativeLayout relativeLayout;
    private ImageView navigationIcon;
    public ProgressBar progressBar;
    public TextView downloadingRegion, capacityPercent;
    private DownloadTask downloadTask;
    private String MAP_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        result = HolderData.getInstance().result;
        position = (int) getIntent().getSerializableExtra(BundleKeys.ELEMENT);
        String title = result.getRegion().get(position).getName();
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText(title.substring(0, 1).toUpperCase() + title.substring(1));
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_progress);
        navigationIcon = (ImageView)findViewById(R.id.iv_navigation_button);
        navigationIcon.setImageResource(R.drawable.ic_arrow_back_white);
        navigationIcon.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                onBackPressed();
            }
        }));
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        downloadingRegion=(TextView)findViewById(R.id.tv_downloading);
        capacityPercent=(TextView)findViewById(R.id.tv_capacity_percent);
        downloadingRegion.setText("Downloading "+title.substring(0, 1).toUpperCase() + title.substring(1));

        relativeLayout.setVisibility(View.GONE);

        gridView = (GridView) findViewById(R.id.gv_region_list);
        gridView.setNumColumns(1);

        if (result.getRegion().get(position).getRegion() != null) {
            regionAdapter = new RegionAdapter(this);
            gridView.setAdapter(regionAdapter);
            regionAdapter.addAll(result.getRegion().get(position).getRegion());
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int positions, long id) {
                    positions1=positions;
                    if (result.getRegion().get(position).getRegion().get(positions).getRegion() != null) {
                        Intent intent = new Intent(RegionActivity.this, SubRegionActivity.class);
                        intent.putExtra(BundleKeys.ELEMENTS, positions);
                        intent.putExtra(BundleKeys.ELEMENT,position);
                        startActivity(intent);
                        HolderData.init(result);

                    }else {
                        String region =getRegionName().substring(0, 1).toUpperCase() + getRegionName().substring(1);
                        String regions=getRegionsName();
                        MAP_URL="http://download.osmand.net/download.php?standard=yes&file="+region+"_"+regions+"_2.obf.zip";
                        downloadTask = new DownloadTask(RegionActivity.this);
                        downloadTask.execute(MAP_URL);
                    }
                }
            });
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "This region does not contain maps", Toast.LENGTH_LONG);
            toast.show();
            this.finish();
        }
    }
    @Override
    protected void onStop() {
        if (downloadTask!=null)
        downloadTask.cancel(true);
        super.onStop();
    }
    public String getRegionName() {
        return result.getRegion().get(position).getRegion().get(positions1).getName();
    }
    public String getRegionsName() {
        return result.getRegion().get(position).getName();
    }
}
