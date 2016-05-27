package com.tecnologiajo.virtualmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

/**
 * Created by Admin on 23/05/2016.
 */
public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        String json;
        JSONArray jsonArray = null;
        RestResult rest = new RestResult();
        try {
            json = rest.execute("http://nodejsbuscaproducto-jcsoluciones.rhcloud.com/business/", "GET").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List productos = new ArrayList<Producto>();
        productos.add(new Producto(1,"lasaña de pollo","",1,9800));
        productos.add(new Producto(2,"lasaña mixta","",1,10800));

        ListView listView = (ListView) view.findViewById(R.id.comida);
        ArrayAdapter arrayAdapter = new AdapterGeneral<Producto>(getActivity(),productos);
        listView.setAdapter(arrayAdapter);
        return view;
    }


}