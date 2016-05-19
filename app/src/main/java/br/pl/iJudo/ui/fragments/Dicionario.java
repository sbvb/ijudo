package br.pl.iJudo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.pl.iJudo.R;
import br.pl.iJudo.ui.ColumnComparator;
import br.pl.iJudo.ui.MainActivity;
import butterknife.ButterKnife;

public class Dicionario extends ListFragment {


        //ArrayList holds the data (as HashMaps) to load into the ListView
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        //SimpleAdapter does the work to load the data in to the ListView
        private SimpleAdapter sa;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dicionario, container,
                    false);


            ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.dicionariotitle));


            Arrays.sort(termos, new ColumnComparator(0));


            HashMap<String,String> item;

            for(int i = 0; i< termos.length; i++){
                item = new HashMap<String,String>();
                item.put( "line1", termos[i][0]);
                item.put( "line2", termos[i][1]);
                list.add( item );
            }

            sa = new SimpleAdapter(getActivity().getApplicationContext(), list, R.layout.my_two_lines, new String[] { "line1","line2" }, new int[] {R.id.line_a, R.id.line_b});
            setListAdapter(sa);


            return rootView;
            //setListShown(true);




        }



        private String[][] termos =
                {{"DOJÔ","Área de Treinamento"},
                        {"JÔ-SEKI","Lugar onde se sentam as autoridades"},
                        {"REI-HÔ","Saudação"},
                        {"REI","Cumprimento"},
                        {"MOKUSO","Meditação (Fechar os olhos e manter  silêncio)"},
                        {"ZA-REI","Cumprimento ajoelhado"},
                        {"RITSU-REI","Cumprimento em pé"},
                        {"SHI-HAN","Mestre"},
                        {"SENSEI","Professor"},
                        {"SEITÔ","Aluno"},
                        {"DÔO-HAI","Colegas"},
                        {"NINTAI","Perserverança"},
                        {"DORYOKU","Esforço, empenho"},
                        {"HISSHYÔ","Ei de vencer"},
                        {"KATANÁ","Espada"},
                        {"DAITÔO","Espada Maior"},
                        {"SHÔOTÔO","Espada Menor"},
                        {"TANTÔO","Punhal"},
                        {"BOKKEN","Espada de Madeira"},
                        {"TÊ - GATANÁ","Mão usada como Espada"},
                        {"HÔOTYÔO","Faca"},
                        {"HASSAMI","Tesoura"},
                        {"TANJYÚ","Revolver"},
                        {"TOKEI","Relógio"},
                        {"TAIMU-DOKEI","Cronômetro"},
                        {"JIKAN","Horário (ou horas)"},
                        {"FUN","Minutos"},
                        {"BYÔO","Segundos"},
                        {"SEMPAI","Superiores (Classe)"},
                        {"KÔ -HAI","Inferiores (Classe)"},
                        {"ANATA","Senhor (ou Senhora)"},
                        {"KIMI","Você"},
                        {"WATAKUSHI","Eu"},
                        {"BOKU","Eu"},
                        {"OHAYÔ-GOZAIMASU","Bom Dia"},
                        {"KON-NITI-WA","Boa Tarde"},
                        {"KON-BAN-WA","Boa Noite"},
                        {"SAYONARA","Até Logo"},
                        {"GOMEM (SHIKKEI)","Perdão, desculpe-me"},
                        {"GOMEN-KUDASSAI","Com licença"},
                        {"ONEGAI-SHIMASU","Por Favor"},
                        {"ARIGATÔ-GOZAIMASU","Obrigado"},
                        {"SUMIMASEN","Perdão"},
                        {"HATÁ","Bandeira"},
                        {"KOKKI","Bandeira Nacional"},
                        {"AKÁ","Vermelho"},
                        {"SHIRÔ","Branco"},
                        {"AÔ","Azul"},
                        {"KII","Amarelo"},
                        {"MIDORI","Verde"},
                        {"MURASAKI","Roxo"},
                        {"TYAIRÔ","Marrom"},
                        {"ORENJI","Laranja"},
                        {"KURÔ","Preto"},
                        {"SENSHU-KEN","Campeonato"},
                        {"SEKAI","Mundial"},
                        {"KOKUSAI","Internacional"},
                        {"NAMBEI","Panamericano"},
                        {"ZENKOKU","Nacional"},
                        {"KEN","Estadual"},
                        {"CHI","Capital"},
                        {"GUN","Munícipio"},
                        {"MURÁ","Bairro"},
                        {"KUIKI","Distrito"},
                        {"KIAI ","Grito"},
                        {"ATAMA","Cabeça"},
                        {"KAMI","Cabelo"},
                        {"MIMI","Orelha"},
                        {"HANA","Nariz"},
                        {"MÊ","Olho"},
                        {"MAYGUÊ","Sobrancelha"},
                        {"MATSUGUÊ","Cílios"},
                        {"KUTI","Boca"},
                        {"HÁ","Há"},
                        {"AGÓ","Queixo"},
                        {"KUBI","Pescoço"},
                        {"NODÔ","Garganta"},
                        {"KAO","Rosto"},
                        {"HITAI","Testa"},
                        {"UDÊ","Braço"},
                        {"HIDI","Cotovelo"},
                        {"TÊ-KUBI","Pulso"},
                        {"KOBUSHI","Punho"},
                        {"TÊ-NO-KÔ","Dorso da Mão"},
                        {"TÊ","Mão"},
                        {"YUBI","Dedo"},
                        {"TSUMÊ","Unha"},
                        {"DÔO","Tronco"},
                        {"KOSHI","Quadris"},
                        {"MOMÔ","Cocha"},
                        {"WAKI","Axila"},
                        {"TAI","Corpo"},
                        {"HIZÁ","Joelho"},
                        {"KAKATO","Calcanhar"},
                        {"SUNÊ","Canela"},
                        {"KIBISU","Calcanhar"},
                        {"ASHI","Pé"},
                        {"ASHI","Perna"},
                        {"KURUBUSHI","Tornozelo"},
                        {"ASHI-NO-URA","Sola do Pé"},
                        {"ASHI-NO-YUBI","Dedo do Pé"},
                        {"ASHI-NO-KÔ","Dorso do Pé"},
                        {"KARADA","Corpo"},
                        {"HARA","Ventre"},
                        {"TÊ-UTI-UKEKI","Queda e batida de mão"},
                        {"ZEMPÔ-KAITEM-UKEMI","Amortecimento de queda com giro frontal"},
                        {"MAE-UKEMI","Amortecimento de queda frontal"},
                        {"YOKO-UKEMI","Amortecimento de queda de lado"},
                        {"USHIRO-UKEMI","Amortecimento de queda de costas"},
                        {"ZAI","Posição sentado"},
                        {"ZEI-ZÁ","Ajoelhado"},
                        {"KYOSHY","Apenas uma perna ajoelhada"},
                        {"TYU-GOSHI","Posição agachado"},
                        {"TYOKU-RITSU","Posição de sentido"},
                        {"RITSUI-I","Posição em pé"},
                        {"SHIZEI-HONTAI","Posição Natural Fundamental"},
                        {"MIGUI-SHIZENTAI","Posição Natural Direita"},
                        {"HIDARI-SHIZENTAI","Posição Natural Esquerda"},
                        {"JIGÔ-TAI","Posição de Defesa"},
                        {"JIGÔ-HONTAI","Posição de Defesa Fundamental"},
                        {"MIGUI-JIGÔ-TAI","Posição de Defesa Direita"},
                        {"HIDARI-JIGÔ-TAI","Posição de Defesa Esquerda"},
                        {"AYUMI-ASHI","Passo normal"},
                        {"SURI-ASHI","Passo normal arrastado"},
                        {"TSUGO-ASHI","Passo emendado"},
                        {"MIGUI-KUMI","Pegada na posição direita"},
                        {"HIDARI-KUMI","Pegada na posição esquerda"},
                        {"FUSEGUI","Defesa"},
                        {"MAE-SABAKI","esquivas com movimento para frente"},
                        {"YOKÔ-SABAKI","esquivas com movimento para o lado"},
                        {"MAWARI-SABAKI","esquivas com movimento em volta"},
                        {"USHIRÔ-SABAKI","esquivas com movimento para trás"},
                        {"DANGAI","Faixa branca à marrom"},
                        {"YUDANSHA","Faixa preta"},
                        {"KÔ-DANSHA","Faixas de alto grau"},
                        {"IKKYU","Faixa Marrom"},
                        {"NI-KYU","Faixa Roxa"},
                        {"SAN-KYU","Faixa Verde"},
                        {"YON-KYU","Faixa Laranja"},
                        {"GO-KYU","Faixa Amarela"},
                        {"RO-KYU","Faixa Azul"},
                        {"MUKYU","Faixa Branca"},
                        {"SHODAN","1º Grau Preta"},
                        {"NIDAN","2º Grau"},
                        {"SAN-DAN","3º Grau"},
                        {"YON-DAN","4º Grau"},
                        {"GO-DAN","5º Grau"},
                        {"ROKU-DAN","6º Grau Branca e Vermelha"},
                        {"HITI-DAN","7º Grau"},
                        {"HATI-DAN","8º Grau"},
                        {"KYU-DAN","9º Grau Vermelha"},
                        {"DYU-DAN","10º Grau"},
                        {"TATAMI","Acolchoado"},
                        {"ZÔRI","Chinelo"},
                        {"KIMONO","Tipo de Vestimenta típica do Japão"},
                        {"JUDOGUI","Roupa usada na prática do Judô"},
                        {"OBI","Faixa"},
                        {"SHITABAKI","Calça"},
                        {"HIMÔ","Fio"},
                        {"ERI","Gola"},
                        {"NAKAERI","Meio da Gola"},
                        {"OKU–ERI","Fundo da Gola"},
                        {"USHIRO–ERI","Atrás da Gola"},
                        {"UÊ","Acima"},
                        {"SHITÁ","Abaixo"},
                        {"KAMI","Acima"},
                        {"SHIMÔ","Abaixo"},
                        {"GYAKU","Contrário"},
                        {"KESSA","Ângulo"},
                        {"NIGUIRI","Apertar"},
                        {"KÔ-TAI","Trocar de Adversário"},
                        {"KIKEN","Desistência"},
                        {"SHISÔO","Quatro Lados"},
                        {"ZEMPÔ","Parte Frontal"},
                        {"UTIKOMI-RENSHU","Treinamento de Técnicas"},
                        {"KATA","Forma"},
                        {"RANDORI","Treino Livre"},
                        {"KANGUEIKO","Treino de Inverno"},
                        {"SHOTSUGUEIKO","Treino de Verão"},
                        {"HARI-SOKE-GUEIKO","Ataque Combinado"},
                        {"HYAPPON-GUEIKO","Treinamento com Queda"},
                        {"SHIAI-GUEIKO","Treinamento de Disputa"},
                        {"RENRAKU-RENKA-WASA","Técnicas em Sequência"},
                        {"MAE-OBI","Frente da Faixa"},
                        {"YOKÔ-OBI","Lado da Faixa"},
                        {"USHIRO-OBI","Atrás da Faixa"},
                        {"KAESHI-WAZA","Contra-Ataque"},
                        {"KUZUSHI","Desequilibrio"},
                        {"TSUKURI","Preparo"},
                        {"KAKÊ","Projeção"},
                        {"MIGUI","Direita"},
                        {"HIDARI","Esquerda"},
                        {"OMOTÊ","Frente"},
                        {"URA","Atrás"},
                        {"UTSUBUSSE","Bruço"},
                        {"YUTSU-BAI","De qatro"},
                        {"SANKAKU","Triângulo"},
                        {"JU-JI","Cruzado"},
                        {"TORI","Atacante"},
                        {"UKE","Defensor"},
                        {"MOROTE","Duas Mãos"},
                        {"RYO-TÊ","Duas Mãos"},
                        {"KATA-TÊ","Uma Mão"},
                        {"WIKI","Puchada"},
                        {"SHIBORI","Apertar, torcer"},
                        {"SEISHIN","Espírito"},
                        {"SHIN-SHIN","Espírito e Físico (corpo)"},
                        {"MATE" , "Parar"},
                        {"KIOTSUKE","Atenção"},
                        {"SHOMEN NI", "Virem-se de frente para a parte frontal do Dojo"},
                        {"SENSEI NI", "Virem-se de frente para o Sensei"},
                        {"SHOMEN","Jigoro Kano"}

                };



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}


