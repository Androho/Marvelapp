package ua.ho.andro.marvelapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ua.ho.andro.marvelapp.BaseActivity;
import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.R;
import ua.ho.andro.marvelapp.adapters.RegionAdapter;
import ua.ho.andro.marvelapp.helper.BundleKeys;
import ua.ho.andro.marvelapp.helper.HolderData;

public class SubRegionActivity extends BaseActivity {
    private TextView mTitle;
    private GridView gridView;
    private RegionAdapter regionAdapter;
    private RegionsList result;
    private int position,positions;
    private RelativeLayout relativeLayout;
    private ImageView navigationIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        result = HolderData.getInstance().result;

        position = (int) getIntent().getSerializableExtra(BundleKeys.ELEMENT);
        positions=(int) getIntent().getSerializableExtra(BundleKeys.ELEMENTS);
        String title = result.getRegion().get(position).getRegion().get(positions).getName();
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText(title.substring(0, 1).toUpperCase() + title.substring(1));
        navigationIcon = (ImageView)findViewById(R.id.iv_navigation_button);
        navigationIcon.setImageResource(R.drawable.ic_arrow_back_white);
        navigationIcon.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                onBackPressed();
            }
        }));

        relativeLayout = (RelativeLayout) findViewById(R.id.rl_progress);

        if (10 == 0) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        relativeLayout.setVisibility(View.GONE);

        gridView = (GridView) findViewById(R.id.gv_region_list);
        gridView.setNumColumns(1);
        gridView = (GridView) findViewById(R.id.gv_region_list);
        gridView.setNumColumns(1);

        if (result.getRegion().get(position).getRegion() != null) {
            regionAdapter = new RegionAdapter(this);
            gridView.setAdapter(regionAdapter);
            regionAdapter.addAll(result.getRegion().get(position).getRegion().get(positions).getRegion());
        }
    }
}
