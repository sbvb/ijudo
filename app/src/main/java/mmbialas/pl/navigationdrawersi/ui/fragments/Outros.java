package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.support.v4.app.Fragment;

import butterknife.ButterKnife;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class Outros extends Fragment {

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




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
