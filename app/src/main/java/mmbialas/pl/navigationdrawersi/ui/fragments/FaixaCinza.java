package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mmbialas.pl.navigationdrawersi.R;
import mmbialas.pl.navigationdrawersi.ui.osotogari;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class FaixaCinza extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cinza, container,
                false);

        String[] values = new String[] { "O-soto-Gari" , "O-Goshi" };
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
                Toast.makeText(getActivity().getApplicationContext(), "OsotoGari",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity().getApplicationContext(), osotogari.class));
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
