package com.tecnologiajo.virtualmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

/**
 * Created by Admin on 23/05/2016.
 */
public class AdapterGeneral<T> extends ArrayAdapter<T> {


    public AdapterGeneral(Context context,List<T> objects) {
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView=convertView;
        if(null == convertView){
            listItemView = inflater.inflate(R.layout.list_menu,parent,false);
        }
        T item = (T) getItem(position);
        return listItemView;

    }
}


