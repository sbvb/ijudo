package br.pl.iJudo.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.pl.iJudo.R;
import br.pl.iJudo.data.Fragments;
import br.pl.iJudo.ui.MainActivity;
import br.pl.iJudo.ui.StateCapitalsActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Principal extends Fragment {




    public static Principal newInstance() {
        Principal fragmentPrincipal = new Principal();
        return fragmentPrincipal;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, containter, false);
        ButterKnife.inject(this, view);
        //setSpans();
        return view;

    }



    @OnClick(R.id.btnGolpes)
    public void onClickGolpe() {
        ((MainActivity)getActivity()).drawerToggle();

    }



    @OnClick(R.id.btnDicionario)
    public void onClickDicionario() {
        //getFragmentManager().beginTransaction()
          //      .replace(R.id.contentFrame, Fragment
            //            .instantiate(getActivity().getApplicationContext(), Fragments.DICIONARIO.getFragment()))
              //  .commit();
        Intent intent = new Intent(getActivity(), StateCapitalsActivity.class);
        startActivity(intent);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


   /* private void setSpans() {
        final SpannableString text1 = new SpannableString(getString(R.string.about_text));
        final SpannableString text2 = new SpannableString(getString(R.string.about_text2));
        text1.setSpan(new RelativeSizeSpan(1.5f), 23, 31,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new RelativeSizeSpan(1.5f), text1.length() - 45, text1.length() - 29,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new RelativeSizeSpan(1.5f), text1.length() - 20, text1.length() - 9,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)), 23,
                31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                text1.length() - 45,
                text1.length() - 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                text1.length() - 20, text1.length() - 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 23, 31,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), text1.length() - 45, text1.length() - 29,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), text1.length() - 20, text1.length() - 9,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new RelativeSizeSpan(1.5f), 24, text2.length() - 10,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                24,
                text2.length() - 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 24, text2.length() - 10,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }
*/

}
