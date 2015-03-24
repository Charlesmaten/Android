package com.example.charlesmaten.fragmentassignement;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {

    private Button buttonBlue;
    public MainActivity ma;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        //final Button buttonBlue = (Button) view.findViewById(R.id.buttonBlue);
        buttonBlue = (Button) view.findViewById(R.id.buttonBlue);




       /*
        ma = (MainActivity)getActivity();

        int[] clickButtons = new int[]{R.id.buttonBlue ,R.id.buttonGreen
        };
        for (int i : clickButtons) {
            view.findViewById(i).setOnClickListener(this);
        }

        ma = (MainActivity)getActivity();
        */
        return view;

    }



/*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBlue:

        }
    }
    */
}
