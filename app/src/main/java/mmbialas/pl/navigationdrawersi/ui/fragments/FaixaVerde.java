package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mmbialas.pl.navigationdrawersi.R;

/**
 * Created by Michal Bialas on 19/07/14.
 */
/*public class FaixaVerde extends Fragment {

    @InjectView(R.id.circleLayout)
    LinearLayout circleLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, containter, false);
        ButterKnife.inject(this, view);
        ((GradientDrawable) circleLayout.getBackground())
                .setColor(getResources().getColor(R.color.green_light));
        return view;
    }*/

public class FaixaVerde extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_verde, container,
                false);

        String[] values = new String[] { "Ko-Soto-Gake" , "Sassae-Tsuri-Komi-Ashi" , "Hiza-Guruma" , "ko-Soto-Gari" ,
        "Uchi-Mata" , "Okuri-Ashi-Barai" , "Harai-Goshi" , "Uki-Goshi" , "Hane-Goshi" , "Tsuri-Komi-Goshi" , "Sode-Tsuri-Komi-Goshi"
                , "Seoi-Nage" , "Tai-OToshi" , "Soto-Makikomi"        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}