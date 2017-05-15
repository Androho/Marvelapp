package ua.ho.andro.marvelapp.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

import java.lang.ref.WeakReference;

import ua.ho.andro.marvelapp.Model.RegionsList;
import ua.ho.andro.marvelapp.TheApplication;
import ua.ho.andro.marvelapp.activity.RegionActivity;
import ua.ho.andro.marvelapp.activity.RegionsListActivity;
import ua.ho.andro.marvelapp.adapters.RegionsListAdapter;


public class LoaderCallbackImpl {
    public static class LoaderCallbacksImpl implements Callback<RegionsList> {
        private WeakReference<RegionsListActivity> activityRef;

        public LoaderCallbacksImpl(RegionsListActivity regionListActivity) {
            activityRef = new WeakReference<>(regionListActivity);
        }

        @Override
        public void onSuccess(@NonNull final RegionsList result) {
            final RegionsListActivity activity = activityRef.get();
            if (activity != null) {
                activity.gAdapter=new RegionsListAdapter(activity);
                activity.gridView.setAdapter(activity.gAdapter);
                activity.gAdapter.addAll(result.getRegion());
                activity.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(activity, RegionActivity.class);
                        intent.putExtra(BundleKeys.ELEMENT, position);
                        activity.startActivity(intent);
                        HolderData.init(result);
                    }
                });
            }
        }

        @Override
        public void onError() {
            String error = "ERROR";
            String e=error;
        }
    }
}
