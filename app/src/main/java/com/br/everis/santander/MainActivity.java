package com.br.everis.santander;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.br.everis.santander.contato.ContatoFragment;

import butterknife.ButterKnife;

public class MainActivity extends PrincipalActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Inicia o fragmento Padrão
        Fragment defaultfrgmanet = new ContatoFragment();
        setDefaultFragment(defaultfrgmanet);

        formatButtonActive(btnContato, btnInvestimento);

        btnInvestimento.setOnClickListener(v -> onNavigation(v));
        btnContato.setOnClickListener(v -> onNavigation(v));

//       formatButtonCont();
    }






}
