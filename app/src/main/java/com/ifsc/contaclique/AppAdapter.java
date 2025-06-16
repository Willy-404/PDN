package com.ifsc.contaclique;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {
    int mresource;
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflar o layout xml -> view
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(mresource,parent,false);
        // v é uma instancia de nosso app_litem.xml
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.textView);
        //recuperamos o item de dado para preencher a posição da lista
        ApplicationInfo appinfo = getItem(position);

        tv.setText(appinfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appinfo.loadIcon(getContext().getPackageManager()));

        return v;
    }
}
