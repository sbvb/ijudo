package br.pl.iJudo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.pl.iJudo.R;
import butterknife.ButterKnife;

public class Dicionario extends ListFragment {

    private String[] values = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dicionario, container,
                false);

        /*values = getResources().getStringArray(R.array.golpesamarela);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        sortAscending();
        setListAdapter(adapter);*/
        return rootView;
    }



    private void sortAscending () {
        List<String> sortedGolpesList = Arrays.asList(values);
        Collections.sort(sortedGolpesList);
        values = (String[]) sortedGolpesList.toArray();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}


