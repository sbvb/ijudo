package br.pl.iJudo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.pl.iJudo.R;

public class Gokyo extends Fragment {
    private ExpandableListAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,                   Bundle              savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gokyo, null);

        return v;
    }

    private static final String NAME = "NAME";
    private static final String IS_EVEN = "IS_EVEN";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

        for (int i = 0; i < 5; i++) {
            Map<String, String> curGroupMap = new HashMap<String, String>();

            groupData.add(curGroupMap);

            switch (i){
                case 0: curGroupMap.put(NAME, "Primeiro Gokyo");
                    curGroupMap.put(IS_EVEN, "Teste");
                    break;
                case 1: curGroupMap.put(NAME, "Segundo Gokyo");
                    curGroupMap.put(IS_EVEN, "Teste");
                    break;
                case 2: curGroupMap.put(NAME, "Terceiro Gokyo");
                    curGroupMap.put(IS_EVEN, "Teste");
                    break;
                case 3: curGroupMap.put(NAME, "Quarto Gokyo");
                    curGroupMap.put(IS_EVEN, "Teste");
                    break;
                case 4: curGroupMap.put(NAME, "Quinto Gokyo");
                    curGroupMap.put(IS_EVEN, "Teste");
                    break;
            }

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
            for (int j = 0; j < 2; j++) {
                Map<String, String> curChildMap = new HashMap<String, String>();
                children.add(curChildMap);
                curChildMap.put(NAME, "nome do golpe");
                curChildMap.put(IS_EVEN, "  ");
            }
            childData.add(children);
        }

        ExpandableListView lv = (ExpandableListView) getActivity().findViewById(R.id.expandableListView);
        // Set up our adapter
        mAdapter = new SimpleExpandableListAdapter(
                getActivity(),
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { NAME, IS_EVEN },
                new int[] { android.R.id.text1, android.R.id.text2 },
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { NAME, IS_EVEN },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        lv.setAdapter(mAdapter);
    }
}

//Primeiro Gokyo (Dai-ikkyo)
//Segundo Gokyo (Dai-nikio)
//Terceiro Gokyo (Dai-sankio)
//Quarto Gokyo (Dai-yonkyo)
//Quinto Gokyo (Dai-gokyo)