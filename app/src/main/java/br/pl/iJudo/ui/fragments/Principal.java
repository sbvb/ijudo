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
import br.pl.iJudo.ui.SearchableDictionary;
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

        /*getFragmentManager().beginTransaction()
                .replace(R.id.contentFrame, Fragment
                        .instantiate(getActivity().getApplicationContext(), Fragments.DICIONARIO.getFragment()))
                .commit();*/

        Intent dictionary;
        dictionary = new Intent(getActivity().getApplicationContext(), SearchableDictionary.class);
        startActivity(dictionary);


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
