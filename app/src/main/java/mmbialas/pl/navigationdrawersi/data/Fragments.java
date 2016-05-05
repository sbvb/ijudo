package mmbialas.pl.navigationdrawersi.data;

import android.support.v4.app.Fragment;

import java.security.Principal;

import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaLaranja;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaMarrom;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaRoxa;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaVerde;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentAbout;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaCinza;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaAmarela;
import mmbialas.pl.navigationdrawersi.ui.fragments.FaixaAzul;
import mmbialas.pl.navigationdrawersi.ui.fragments.MessagesFragment;
import mmbialas.pl.navigationdrawersi.ui.fragments.Outros;

/**
 * Created by Michal Bialas on 19/07/14.
 *
 */
public enum Fragments {

    MAIN(mmbialas.pl.navigationdrawersi.ui.fragments.Principal.class), CINZA(FaixaCinza.class), AZUL(FaixaAzul.class), AMARELA(FaixaAmarela.class), LARANJA(FaixaLaranja.class), VERDE(FaixaVerde.class), ROXA(FaixaRoxa.class), MARROM(FaixaMarrom.class),  MESSAGES(MessagesFragment.class), OUTROS(Outros.class),ABOUT(
            FragmentAbout.class);

    final Class<? extends Fragment> fragment;

    private Fragments(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }

    public String getFragment() {
        return fragment.getName();
    }
}
