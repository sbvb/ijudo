package br.pl.iJudo.data;

import android.support.v4.app.Fragment;

import br.pl.iJudo.ui.fragments.Dicionario;
import br.pl.iJudo.ui.fragments.FaixaLaranja;
import br.pl.iJudo.ui.fragments.FaixaMarrom;
import br.pl.iJudo.ui.fragments.FaixaRoxa;
import br.pl.iJudo.ui.fragments.FaixaVerde;
import br.pl.iJudo.ui.fragments.FragmentAbout;
import br.pl.iJudo.ui.fragments.FaixaCinza;
import br.pl.iJudo.ui.fragments.FaixaAmarela;
import br.pl.iJudo.ui.fragments.FaixaAzul;
import br.pl.iJudo.ui.fragments.KansetsuWaza;
import br.pl.iJudo.ui.fragments.MessagesFragment;
import br.pl.iJudo.ui.fragments.OsaekomiWaza;
import br.pl.iJudo.ui.fragments.ShimeWaza;
import br.pl.iJudo.ui.fragments.Todos;


public enum Fragments {

    MAIN(br.pl.iJudo.ui.fragments.Principal.class), CINZA(FaixaCinza.class), AZUL(FaixaAzul.class), AMARELA(FaixaAmarela.class), LARANJA(FaixaLaranja.class), VERDE(FaixaVerde.class), ROXA(FaixaRoxa.class), MARROM(FaixaMarrom.class),  MESSAGES(MessagesFragment.class), TODOS(Todos.class),ABOUT(
                FragmentAbout.class), OSAEKOMIWAZA(OsaekomiWaza.class), KANSETSUIWAZA(KansetsuWaza.class), SHIMEWAZA(ShimeWaza.class), DICIONARIO(Dicionario.class);

    final Class<? extends Fragment> fragment;

    private Fragments(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }


  public String getFragment() {
        return fragment.getName();
    }
}
