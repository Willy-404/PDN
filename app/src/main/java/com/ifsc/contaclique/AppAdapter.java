package com.ifsc.contaclique;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    int mresource;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects){
        super(context, resource, objects);
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(mresource, parent, false);

        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.textView);
        LinearLayout ll = v.findViewById(R.id.linearLayout);

        ApplicationInfo appInfo = getItem(position);

        tv.setText(appInfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appInfo.loadIcon(getContext().getPackageManager()));

        TextView tvpackageName = new TextView(getContext());
        tvpackageName.setText(appInfo.packageName);

        ll.addView(tvpackageName);

        return v;
    }

}
