package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import butterknife.ButterKnife;
import mmbialas.pl.navigationdrawersi.R;

/**
 * Created by Michal Bialas on 19/07/14.
 */


    //@InjectView(R.id.circleLayout)
    //LinearLayout circleLayout;

   // @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup containter,
    //        Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.fragment_one, containter, false);
        //ButterKnife.inject(this, view);
        //((GradientDrawable) circleLayout.getBackground())
         //       .setColor(getResources().getColor(R.color.material_blue));
      //  return view;
  //  }
public class Outros extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_outros, container,
                false);

        String[] values = new String[] { "Message1", "Message2", "Message3", "Message4", "Message5" };
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
