package br.pl.iJudo.ui;

//             mDrawerLayout.openDrawer(mLinearDrawerLayout);    para abrir gaveta


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.pl.iJudo.R;
import br.pl.iJudo.data.Fragments;
import br.pl.iJudo.data.model.NavigationDrawerItem;
import br.pl.iJudo.ui.fragments.FaixaAmarela;
import br.pl.iJudo.ui.fragments.FaixaAzul;
import br.pl.iJudo.ui.fragments.FaixaCinza;
import br.pl.iJudo.ui.fragments.FaixaLaranja;
import br.pl.iJudo.ui.fragments.FaixaMarrom;
import br.pl.iJudo.ui.fragments.FaixaRoxa;
import br.pl.iJudo.ui.fragments.FaixaVerde;
import br.pl.iJudo.ui.fragments.FragmentAbout;
import br.pl.iJudo.ui.fragments.KansetsuWaza;
import br.pl.iJudo.ui.fragments.OsaekomiWaza;
import br.pl.iJudo.ui.fragments.Principal;
import br.pl.iJudo.ui.fragments.ShimeWaza;
import br.pl.iJudo.ui.fragments.Todos;
import br.pl.iJudo.ui.ijudo.NavigationDrawerView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import timber.log.Timber;

public class MainActivity extends ActionBarActivity {


    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private int currentSelectedPosition = 0;

    @InjectView(R.id.navigationDrawerListViewWrapper)
    NavigationDrawerView mNavigationDrawerListViewWrapper;

    @InjectView(R.id.linearDrawer)
    LinearLayout mLinearDrawerLayout;

    @InjectView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.leftDrawerListView)
    ListView leftDrawerListView;

    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mTitle;

    private CharSequence mDrawerTitle;

    private List<NavigationDrawerItem> navigationItems;

    private boolean naofecha = true;

    private boolean comnaguewaza;

    private int positionnew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        mTitle = mDrawerTitle = getTitle();

        mTitle = "      ";

        comnaguewaza = false; Log.d("myTag","acabei de setar comnaguezawa para falso");

        getSupportActionBar().setIcon(R.drawable.ic_action_ab_transparent);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);


        Timber.tag("LifeCycles");
        Timber.d("Activity Created");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame,
                    Fragment.instantiate(MainActivity.this, Fragments.MAIN.getFragment())).commit();
        } else {
            currentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }
        navigationItems = new ArrayList<>();

        populatesemNageWaza();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_navigation_drawer, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        selectItem(currentSelectedPosition);





    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, currentSelectedPosition);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getFragments()
                .get(0) instanceof Principal && mDrawerLayout.isDrawerOpen(mLinearDrawerLayout)) {
            mDrawerLayout.closeDrawer(mLinearDrawerLayout);
            //FragmentManager.popBackStack();
            Log.d("myTag", "DETECTEI BACK BUTTON NO PRINCIPAL, VOU FECHAR GAVETA");

        }

        else if (getSupportFragmentManager().getFragments()
                    .get(0) instanceof Principal) {
                super.onBackPressed();
                Log.d("myTag", "DETECTEI BACK BUTTON NO PRINCIPAL, VOU SAIR");
            }

        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentFrame, Fragment
                            .instantiate(MainActivity.this, Fragments.MAIN.getFragment()))
                    .commit();
            getSupportActionBar()
                    .setTitle(navigationItems.get(0).getItemName());

            Log.d("myTag", "DETECTEI BACK BUTTON FORA DO PRINCIPAL, VOU VOLTAR PRO PRINCIPAL");

        }


    }





    public void populateNageWaza() {
            navigationItems.clear();
            navigationItems = new ArrayList<>();
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_main), R.drawable.ic_home, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_nagewaza), R.drawable.ic_a, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_cinza), R.drawable.ic_cinza, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_azul), R.drawable.ic_azul, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_amarela), R.drawable.ic_amarela, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_laranja), R.drawable.ic_laranja, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_verde), R.drawable.ic_verde, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_roxa), R.drawable.ic_roxa, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_marrom), R.drawable.ic_marrom, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_todos), R.drawable.ic_preta, true));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_osaekomiwaza), R.drawable.ic_b, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_kansetsuwaza), R.drawable.ic_c, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_shimewaza), R.drawable.ic_d, false));

            mNavigationDrawerListViewWrapper.replaceWith(navigationItems);



    }



    public void populatesemNageWaza() {
            navigationItems.clear();
            navigationItems = new ArrayList<>();
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_main), R.drawable.ic_home, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_nagewaza), R.drawable.ic_a, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_osaekomiwaza), R.drawable.ic_b, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_kansetsuwaza), R.drawable.ic_c, false));
            navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_shimewaza), R.drawable.ic_d, false));

            mNavigationDrawerListViewWrapper.replaceWith(navigationItems);

    }

    public void drawerToggle() {
        mDrawerLayout.openDrawer(mLinearDrawerLayout);

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.action_sair) {
            //return true;
            Toast.makeText(MainActivity.this,
                    "Soremadê", Toast.LENGTH_LONG).show();
            finish();
        }
        else if (item.getItemId() == R.id.action_about) {

            if (!(getSupportFragmentManager().getFragments().get(0) instanceof FragmentAbout)) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFrame, Fragment
                                .instantiate(MainActivity.this, Fragments.ABOUT.getFragment()))
                     .commit();
           }
        }

        return super.onOptionsItemSelected(item);
    }

    @OnItemClick(R.id.leftDrawerListView)
    public void OnItemClick(int position, long id) {
        if (mDrawerLayout.isDrawerOpen(mLinearDrawerLayout)) {
            //mDrawerLayout.closeDrawer(mLinearDrawerLayout);
            onNavigationDrawerItemSelected(position);
            selectItem(position);
        }
    }


    private void selectItem(int position) {

        if (leftDrawerListView != null) {

                leftDrawerListView.setItemChecked(position, true);

                navigationItems.get(currentSelectedPosition).setSelected(false);
                navigationItems.get(position).setSelected(true);

                //currentSelectedPosition = position;
                //getSupportActionBar()
                      //  .setTitle(navigationItems.get(currentSelectedPosition).getItemName());


        }

        if (mLinearDrawerLayout != null) {
            //mDrawerLayout.closeDrawer(mLinearDrawerLayout);
        }
    }

    private void onNavigationDrawerItemSelected(int position) {
        if (comnaguewaza){
            switch (position) {

                case 0:
                    if (!(getSupportFragmentManager().getFragments()
                            .get(0) instanceof Principal)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.MAIN.getFragment()))
                                .commit();
                    }
                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                    getSupportActionBar().setTitle(R.string.fragment_main);//set o titulo da janela !!!
                    break;

                case 1:
                if (!comnaguewaza) {
                    comnaguewaza = true; Log.d("myTag","acabei de setar para true na option1");
                    populateNageWaza();
                    Log.d("myTag", "option1");
                    getSupportActionBar().setTitle("Nage-Waza");//set o titulo da janela !!!



                }
                else {
                    comnaguewaza = false;  Log.d("myTag","acabei de setar para false na option2");
                    populatesemNageWaza();
                    getSupportActionBar().setTitle("Nague-Waza");//set o titulo da janela !!!


                }
                break;

            case 2:
                if (!(getSupportFragmentManager().getFragments()
                        .get(0) instanceof FaixaCinza)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.CINZA.getFragment()))
                            .commit();
                }
                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                getSupportActionBar().setTitle(R.string.fragment_cinza);//set o titulo da janela !!!

                break;
            case 3:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaAzul)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.AZUL.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_azul);//set o titulo da janela !!!
                mDrawerLayout.closeDrawer(mLinearDrawerLayout);

                break;
            case 4:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaAmarela)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.AMARELA.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_amarela);//set o titulo da janela !!!
                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;
            case 5:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaLaranja)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.LARANJA.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_laranja);//set o titulo da janela !!!
                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;
            case 6:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaVerde)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.VERDE.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_verde);//set o titulo da janela !!!

                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;
            case 7:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaRoxa)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.ROXA.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_roxa);//set o titulo da janela !!!

                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;
            case 8:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FaixaMarrom)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.MARROM.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_marrom);//set o titulo da janela !!!

                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;
            case 9:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof Todos)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.TODOS.getFragment()))
                            .commit();
                }
                getSupportActionBar().setTitle(R.string.fragment_todos);//set o titulo da janela !!!

                mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                break;

                case 10:
                    if (!(getSupportFragmentManager().getFragments()
                            .get(0) instanceof OsaekomiWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.OSAEKOMIWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_osaekomiwaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);

                    break;
                case 11:
                    if (!(getSupportFragmentManager().getFragments().get(0) instanceof KansetsuWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.KANSETSUIWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_kansetsuwaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);

                    break;
                case 12:
                    if (!(getSupportFragmentManager().getFragments().get(0) instanceof ShimeWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.SHIMEWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_shimewaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                    break;
        }

    }

        else {
            switch (position) {

                case 0:
                    if (!(getSupportFragmentManager().getFragments()
                            .get(0) instanceof Principal)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.MAIN.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_main);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                    break;

                case 1:
                    if (!comnaguewaza) {
                        comnaguewaza = true; Log.d("myTag","acabei de setar para true na option3");
                        getSupportActionBar().setTitle(R.string.fragment_nagewaza);//set o titulo da janela !!!

                        Log.d("myTag", "option3");
                        populateNageWaza();


                    }
                    else {
                        comnaguewaza = false; Log.d("myTag","acabei de setar para false na option 4");
                        getSupportActionBar().setTitle(R.string.fragment_nagewaza);//set o titulo da janela !!!

                        populatesemNageWaza();
                        Log.d("myTag", "option4");


                    }
                    break;

                case 2:
                    if (!(getSupportFragmentManager().getFragments()
                            .get(0) instanceof OsaekomiWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.OSAEKOMIWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_osaekomiwaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                    break;
                case 3:
                    if (!(getSupportFragmentManager().getFragments().get(0) instanceof KansetsuWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.KANSETSUIWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_kansetsuwaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);

                    break;
                case 4:
                    if (!(getSupportFragmentManager().getFragments().get(0) instanceof ShimeWaza)) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentFrame, Fragment
                                        .instantiate(MainActivity.this, Fragments.SHIMEWAZA.getFragment()))
                                .commit();
                    }
                    getSupportActionBar().setTitle(R.string.fragment_shimewaza);//set o titulo da janela !!!

                    mDrawerLayout.closeDrawer(mLinearDrawerLayout);
                    break;

            }
        }
    }

}