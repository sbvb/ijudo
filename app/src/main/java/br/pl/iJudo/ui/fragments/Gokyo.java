package br.pl.iJudo.ui.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.pl.iJudo.R;
import br.pl.iJudo.ui.MySimpleExpandableListAdapter;
import br.pl.iJudo.ui.golpe;
import butterknife.ButterKnife;

public class Gokyo extends Fragment {

    private ExpandableListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
            curGroupMap.put(NAME, Gokyu[i][0] );
            curGroupMap.put(IS_EVEN, Gokyu[i][1] );

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
            for (int j = 0; j < 8; j++) {
                Map<String, String> curChildMap = new HashMap<String, String>();
                children.add(curChildMap);
                curChildMap.put(NAME, golpesgokyu[i][j]);
                curChildMap.put(IS_EVEN, " ");
            }
            childData.add(children);
        }


        ExpandableListView lv = (ExpandableListView) getActivity().findViewById(R.id.expandableListView);

        ExpandableListView.OnChildClickListener occl = new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String textonaposicao;
                Intent meuGolpe;
                textonaposicao = golpesgokyu[groupPosition][childPosition];
                //Toast.makeText(getActivity().getApplicationContext(), textonaposicao, Toast.LENGTH_SHORT).show();

                String nomelimpo;
                nomelimpo = textonaposicao.toLowerCase().replace(" ", "").replace("-", "");


                meuGolpe = new Intent(getActivity().getApplicationContext(), golpe.class);
                meuGolpe.putExtra("xmlfile", nomelimpo);
                meuGolpe.putExtra("nomedogolpe", textonaposicao);

                startActivity(meuGolpe);

                return false;
            }
        };


            lv.setOnChildClickListener(occl);

        // Set up our adapter

        mAdapter = new MySimpleExpandableListAdapter(getActivity(),groupData,android.R.layout.simple_expandable_list_item_2,new String[] { NAME, IS_EVEN },new int[] { android.R.id.text1, android.R.id.text2 },
                childData, android.R.layout.simple_expandable_list_item_2,new String[] { NAME, IS_EVEN },new int[] { android.R.id.text1, android.R.id.text2 }

        );




        lv.setAdapter(mAdapter);

    }

    private String [][] Gokyu = { {"DAI-IKKYO", "Primeiro Gokyo"} , {"DAI-NIKYO", "Segundo Gokyo"} , {"DAI-SANKIO", "Terceiro Gokyo"}, {"DAI-YONKYO", "Quarto Gokyo"} , {"DAI-GOKYO", "Quinto Gokyo"} };
    private String golpesgokyu [][] = {
            {"De-Ashi-Barai",
                    "Hiza-Guruma",
                    "Sassae-Tsuri-Komi-Ashi",
                    "Uki-Goshi",
                    "O-soto-Gari",
                    "O-Goshi",
                    "Ouchi-Gari",
                    "Ippon-Seoi-Nage"
            },
            {
                    "Ko-Soto-Gari",
                    "Ko-Uchi-Gari",
                    "Koshi-Guruma",
                    "Tsuri-Komi-Goshi",
                    "Okuri-Ashi-Barai",
                    "Tai-Otoshi",
                    "Harai-Goshi",
                    "Uchi-Mata"

            },
            {
                    "Ko-Soto-Gake",
                    "Tsuri-Goshi",
                    "Yoko-Otoshi",
                    "Ashi-Guruma",
                    "Hane-Goshi",
                    "Harai-Tsuri-Komi-Ashi",
                    "Tomoe-Nage",
                    "Kata-Guruma"

            },
            {
                    "Sumi-Gaeshi",
                    "Tani-Otoshi",
                    "Hane-Makikomi",
                    "Sukui-Nage",
                    "Utsuri-Goshi",
                    "O-Guruma",
                    "Soto-Makikomi",
                    "Uki-Otoshi"
            },
            {
                    "O-Soto-Guruma",
                    "Uki-Waza",
                    "Yoko-Wakare",
                    "Yoko-Guruma",
                    "Ushiro-Goshi",
                    "Ura-Nage",
                    "Sumi-Otoshi",
                    "Yoko-Gake"
            }
    };






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

//Primeiro Gokyo (Dai-ikkyo)
//Segundo Gokyo (Dai-nikio)
//Terceiro Gokyo (Dai-sankio)
//Quarto Gokyo (Dai-yonkyo)
//Quinto Gokyo (Dai-gokyo)