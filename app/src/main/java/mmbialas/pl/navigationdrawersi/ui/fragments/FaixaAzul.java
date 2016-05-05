package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mmbialas.pl.navigationdrawersi.R;
import mmbialas.pl.navigationdrawersi.data.Fragments;
import mmbialas.pl.navigationdrawersi.ui.MainActivity;
import mmbialas.pl.navigationdrawersi.ui.osotogari;

import static mmbialas.pl.navigationdrawersi.R.color.blue_light;
import static mmbialas.pl.navigationdrawersi.R.color.orange_light;

/**
 * Created by Michal Bialas on 19/07/14.
 */
/*public class FaixaAzul extends Fragment {

    @InjectView(R.id.circleLayout)
    LinearLayout circleLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, containter, false);
        ButterKnife.inject(this, view);
        ((GradientDrawable) circleLayout.getBackground())
                .setColor(getResources().getColor(blue_light));
        return view;
    } */

public class FaixaAzul extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_azul, container,
                false);

        String[] values = new String[] {"De-Ashi-Barai", "Ippon-Seoi-Nage" , "O-Goshi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return rootView;




    }

    @Override
    public void onListItemClick (ListView l, View rootView , int position, long id){

        //do something
        switch (position) {

            case 0:
                //do something
                break;
            case 1:
                //do something;

                break;

            case 2:
                //do someting

                break;

        }

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}