package br.pl.iJudo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import br.pl.iJudo.R;
import br.pl.iJudo.data.Fragments;
import br.pl.iJudo.ui.fragments.FragmentAbout;

public class SearchableDictionary extends ActionBarActivity {

    private EditText filterText;
    //private ArrayAdapter<String> listAdapter;

    private String[][] termos =
            {{"DOJO","Area de Treinamento"},
                    {"JO-SEKI","Lugar onde se sentam as autoridades"},
                    {"REI-HO","Saudação"},
                    {"REI","Cumprimento"},
                    {"MOKUSO","Meditação (Fechar os olhos e manter  silêncio)"},
                    {"ZA-REI","Cumprimento ajoelhado"},
                    {"RITSU-REI","Cumprimento em pé"},
                    {"SHI-HAN","Mestre"},
                    {"SENSEI","Professor"},
                    {"SEITO","Aluno"},
                    {"DOO-HAI","Colegas"},
                    {"NINTAI","Perserverança"},
                    {"DORYOKU","Esforço, empenho"},
                    {"HISSHYO","Ei de vencer"},
                    {"KATANA","Espada"},
                    {"DAITOO","Espada Maior"},
                    {"SHOOTOO","Espada Menor"},
                    {"TANTOO","Punhal"},
                    {"BOKKEN","Espada de Madeira"},
                    {"TE - GATANA","Mão usada como Espada"},
                    {"HOOTYOO","Faca"},
                    {"HASSAMI","Tesoura"},
                    {"TANJYÚ","Revolver"},
                    {"TOKEI","Relógio"},
                    {"TAIMU-DOKEI","Cronômetro"},
                    {"JIKAN","Horário (ou horas)"},
                    {"FUN","Minutos"},
                    {"BYOO","Segundos"},
                    {"SEMPAI","Superiores (Classe)"},
                    {"KO -HAI","Inferiores (Classe)"},
                    {"ANATA","Senhor (ou Senhora)"},
                    {"KIMI","Você"},
                    {"WATAKUSHI","Eu"},
                    {"BOKU","Eu"},
                    {"OHAYO-GOZAIMASU","Bom Dia"},
                    {"KON-NITI-WA","Boa Tarde"},
                    {"KON-BAN-WA","Boa Noite"},
                    {"SAYONARA","Até Logo"},
                    {"GOMEM (SHIKKEI)","Perdão, desculpe-me"},
                    {"GOMEN-KUDASSAI","Com licença"},
                    {"ONEGAI-SHIMASU","Por Favor"},
                    {"ARIGATO-GOZAIMASU","Obrigado"},
                    {"SUMIMASEN","Perdão"},
                    {"HATA","Bandeira"},
                    {"KOKKI","Bandeira Nacional"},
                    {"AKA","Vermelho"},
                    {"SHIRO","Branco"},
                    {"AO","Azul"},
                    {"KII","Amarelo"},
                    {"MIDORI","Verde"},
                    {"MURASAKI","Roxo"},
                    {"TYAIRO","Marrom"},
                    {"ORENJI","Laranja"},
                    {"KURO","Preto"},
                    {"SENSHU-KEN","Campeonato"},
                    {"SEKAI","Mundial"},
                    {"KOKUSAI","Internacional"},
                    {"NAMBEI","Panamericano"},
                    {"ZENKOKU","Nacional"},
                    {"KEN","Estadual"},
                    {"CHI","Capital"},
                    {"GUN","Munícipio"},
                    {"MURA","Bairro"},
                    {"KUIKI","Distrito"},
                    {"KIAI ","Grito"},
                    {"ATAMA","Cabeça"},
                    {"KAMI","Cabelo"},
                    {"MIMI","Orelha"},
                    {"HANA","Nariz"},
                    {"ME","Olho"},
                    {"MAYGUE","Sobrancelha"},
                    {"MATSUGUE","Cílios"},
                    {"KUTI","Boca"},
                    {"HA","Há"},
                    {"AGÓ","Queixo"},
                    {"KUBI","Pescoço"},
                    {"NODO","Garganta"},
                    {"KAO","Rosto"},
                    {"HITAI","Testa"},
                    {"UDE","Braço"},
                    {"HIDI","Cotovelo"},
                    {"TE-KUBI","Pulso"},
                    {"KOBUSHI","Punho"},
                    {"TE-NO-KO","Dorso da Mão"},
                    {"TE","Mão"},
                    {"YUBI","Dedo"},
                    {"TSUME","Unha"},
                    {"DOO","Tronco"},
                    {"KOSHI","Quadris"},
                    {"MOMO","Cocha"},
                    {"WAKI","Axila"},
                    {"TAI","Corpo"},
                    {"HIZA","Joelho"},
                    {"KAKATO","Calcanhar"},
                    {"SUNE","Canela"},
                    {"KIBISU","Calcanhar"},
                    {"ASHI","Pé"},
                    {"ASHI","Perna"},
                    {"KURUBUSHI","Tornozelo"},
                    {"ASHI-NO-URA","Sola do Pé"},
                    {"ASHI-NO-YUBI","Dedo do Pé"},
                    {"ASHI-NO-KO","Dorso do Pé"},
                    {"KARADA","Corpo"},
                    {"HARA","Ventre"},
                    {"TE-UTI-UKEKI","Queda e batida de mão"},
                    {"ZEMPO-KAITEM-UKEMI","Amortecimento de queda com giro frontal"},
                    {"MAE-UKEMI","Amortecimento de queda frontal"},
                    {"YOKO-UKEMI","Amortecimento de queda de lado"},
                    {"USHIRO-UKEMI","Amortecimento de queda de costas"},
                    {"ZAI","Posição sentado"},
                    {"ZEI-ZA","Ajoelhado"},
                    {"KYOSHY","Apenas uma perna ajoelhada"},
                    {"TYU-GOSHI","Posição agachado"},
                    {"TYOKU-RITSU","Posição de sentido"},
                    {"RITSUI-I","Posição em pé"},
                    {"SHIZEI-HONTAI","Posição Natural Fundamental"},
                    {"MIGUI-SHIZENTAI","Posição Natural Direita"},
                    {"HIDARI-SHIZENTAI","Posição Natural Esquerda"},
                    {"JIGO-TAI","Posição de Defesa"},
                    {"JIGO-HONTAI","Posição de Defesa Fundamental"},
                    {"MIGUI-JIGO-TAI","Posição de Defesa Direita"},
                    {"HIDARI-JIGO-TAI","Posição de Defesa Esquerda"},
                    {"AYUMI-ASHI","Passo normal"},
                    {"SURI-ASHI","Passo normal arrastado"},
                    {"TSUGO-ASHI","Passo emendado"},
                    {"MIGUI-KUMI","Pegada na posição direita"},
                    {"HIDARI-KUMI","Pegada na posição esquerda"},
                    {"FUSEGUI","Defesa"},
                    {"MAE-SABAKI","esquivas com movimento para frente"},
                    {"YOKO-SABAKI","esquivas com movimento para o lado"},
                    {"MAWARI-SABAKI","esquivas com movimento em volta"},
                    {"USHIRO-SABAKI","esquivas com movimento para trás"},
                    {"DANGAI","Faixa branca à marrom"},
                    {"YUDANSHA","Faixa preta"},
                    {"KO-DANSHA","Faixas de alto grau"},
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
                    {"ZORI","Chinelo"},
                    {"KIMONO","Tipo de Vestimenta típica do Japão"},
                    {"JUDOGUI","Roupa usada na prática do Judô"},
                    {"OBI","Faixa"},
                    {"SHITABAKI","Calça"},
                    {"HIMO","Fio"},
                    {"ERI","Gola"},
                    {"NAKAERI","Meio da Gola"},
                    {"OKU–ERI","Fundo da Gola"},
                    {"USHIRO–ERI","Atrás da Gola"},
                    {"UE","Acima"},
                    {"SHITA","Abaixo"},
                    {"KAMI","Acima"},
                    {"SHIMO","Abaixo"},
                    {"GYAKU","Contrário"},
                    {"KESSA","Ângulo"},
                    {"NIGUIRI","Apertar"},
                    {"KO-TAI","Trocar de Adversário"},
                    {"KIKEN","Desistência"},
                    {"SHISOO","Quatro Lados"},
                    {"ZEMPO","Parte Frontal"},
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
                    {"YOKO-OBI","Lado da Faixa"},
                    {"USHIRO-OBI","Atrás da Faixa"},
                    {"KAESHI-WAZA","Contra-Ataque"},
                    {"KUZUSHI","Desequilibrio"},
                    {"TSUKURI","Preparo"},
                    {"KAKE","Projeção"},
                    {"MIGUI","Direita"},
                    {"HIDARI","Esquerda"},
                    {"OMOTE","Frente"},
                    {"URA","Atrás"},
                    {"UTSUBUSSE","Bruço"},
                    {"YUTSU-BAI","De qatro"},
                    {"SANKAKU","Triângulo"},
                    {"JU-JI","Cruzado"},
                    {"TORI","Atacante"},
                    {"UKE","Defensor"},
                    {"MOROTE","Duas Mãos"},
                    {"RYO-TE","Duas Mãos"},
                    {"KATA-TE","Uma Mão"},
                    {"WIKI","Puchada"},
                    {"SHIBORI","Apertar, torcer"},
                    {"SEISHIN","Espírito"},
                    {"SHIN-SHIN","Espírito e Físico (corpo)"},
                    {"MATE" , "Parar"},
                    {"KIOTSUKE","Atenção"},
                    {"SHOMEN NI", "Virem-se de frente para a parte frontal do Dojo"},
                    {"SENSEI NI", "Virem-se de frente para o Sensei"},
                    {"SHOMEN","Jigoro Kano"},
                    {"SOREMADE","Final, Terminou"}

            };

    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter sa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

        filterText = (EditText)findViewById(R.id.editText);
        ListView itemList = (ListView)findViewById(R.id.listView);

        //DbBackend dbBackend = new DbBackend(SearchableDictionary.this);


//orginal
        //String[] terms = dbBackend.dictionaryWords();
        //listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, terms);
        //itemList.setAdapter(listAdapter);

//meu modificado

        Arrays.sort(termos, new ColumnComparator(0));
        HashMap<String,String> item;
        for(int i = 0; i< termos.length; i++){
            item = new HashMap<String,String>();
            item.put( "line1", termos[i][0]);
            item.put( "line2", termos[i][1]);
            list.add( item );
        }
        sa = new SimpleAdapter(this.getApplicationContext(), list, R.layout.dicionario_two_lines, new String[] { "line1","line2" }, new int[] {R.id.line_a, R.id.line_b});
        itemList.setAdapter(sa);



//on click listener do dicionario

       /* itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // make Toast when click
                Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SearchableDictionary.this, DictionaryActivity.class);
                intent.putExtra("DICTIONARY_ID", position);
                startActivity(intent);
            }
        });*/

        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchableDictionary.this.sa.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}
