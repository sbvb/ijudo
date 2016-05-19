package br.pl.iJudo.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.pl.iJudo.R;
import br.pl.iJudo.ui.golpe;
import butterknife.ButterKnife;


public class FaixaCinza extends ListFragment {

    private String[] values = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cinza, container,
                false);

        values = getResources().getStringArray(R.array.golpescinza);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_1_golpes, values);

        sortAscending();
        setListAdapter(adapter);
        return rootView;
    }


    @Override
    public void onListItemClick (ListView l, View rootView , int position, long id) {

        String textonaposicao;
        Intent meuGolpe;
        textonaposicao = values[position];
        //Toast.makeText(getActivity().getApplicationContext(), textonaposicao, Toast.LENGTH_SHORT).show();
        String nomelimpo;
        nomelimpo = textonaposicao.toLowerCase().replace(" ", "").replace("-", "");  //tira traços e espaços do nome do golpe, para referenciar o xml referente ao golpe
        meuGolpe = new Intent(getActivity().getApplicationContext(), golpe.class);
        meuGolpe.putExtra("xmlfile", nomelimpo);
        meuGolpe.putExtra("nomedogolpe", textonaposicao);
        startActivity(meuGolpe);

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
