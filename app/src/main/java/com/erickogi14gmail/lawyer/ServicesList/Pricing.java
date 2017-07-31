package com.erickogi14gmail.lawyer.ServicesList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.erickogi14gmail.lawyer.R;

/**
 * Created by kimani kogi on 7/27/2017.
 */

public class Pricing extends Fragment {
    private View view;
    private String [] items={"Mpesa","Bank","Paypal"};
    Spinner spinner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pricing, container, false);
        getActivity().setTitle("Pricing");
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, items);
        //SimpleArrayAdapter adapter=new SimpleAdapter(getActivity(),items);
        spinner.setAdapter(adapter);
        return view;

    }


}
