package ua.ho.andro.marvelapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.R;

public class RegionAdapter extends ArrayAdapter<RegionsList.Region> {
    private String groupTitle;
    private String pathImg;

    public RegionAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grid_region, null);
        }
        RegionsList.Region item = getItem(position);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_region_name);
        ImageView iv = (ImageView) convertView.findViewById(R.id.image_world_globe);

        groupTitle = item.getName();
        String test = groupTitle.substring(0, 1).toUpperCase() + groupTitle.substring(1);

        tv.setText(test);
        return convertView;
    }
}
