package ua.ho.andro.marvelapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ua.ho.andro.marvelapp.BaseActivity;
import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.R;
import ua.ho.andro.marvelapp.adapters.RegionAdapter;
import ua.ho.andro.marvelapp.helper.BundleKeys;
import ua.ho.andro.marvelapp.helper.HolderData;

public class RegionActivity extends BaseActivity {
    private TextView mTitle;
    private GridView gridView;
    private RegionAdapter regionAdapter;
    private RegionsList result;
    private int position;
    private RelativeLayout relativeLayout;
    private ImageView navigationIcon;

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
        navigationIcon.setImageResource(R.drawable.ic_world_globe_dark);
        navigationIcon.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                onBackPressed();
            }
        }));

        if (10 == 0) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
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
                    if (result.getRegion().get(position).getRegion().get(positions).getRegion() != null) {
                        Intent intent = new Intent(RegionActivity.this, SubRegionActivity.class);
                        intent.putExtra(BundleKeys.ELEMENTS, positions);
                        intent.putExtra(BundleKeys.ELEMENT,position);
                        startActivity(intent);
                        HolderData.init(result);
                    }else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "<---", Toast.LENGTH_LONG);
                        toast.show();
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
}
