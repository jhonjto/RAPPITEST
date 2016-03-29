package com.jhon.co.rappitest.Helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jhon.co.rappitest.R;

import java.util.List;

/**
 * Created by jhon on 27/03/2016.
 */
public class SwipeListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<CategoryList> appsList;
    private String[] bgColors;

    public SwipeListAdapter(Activity activity, List<CategoryList> movieList) {
        this.activity = activity;
        this.appsList = movieList;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.apps_serial_bg);
    }

    @Override
    public int getCount() {
        return appsList.size();
    }

    @Override
    public Object getItem(int position) {
        return appsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (layoutInflater == null)
            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.list_row, null);

        TextView serial = (TextView) convertView.findViewById(R.id.id);
        TextView title = (TextView) convertView.findViewById(R.id.title);

        serial.setText(String.valueOf(appsList.get(position).id));
        title.setText(appsList.get(position).title);

        String color = bgColors[position % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return convertView;

    }
}
