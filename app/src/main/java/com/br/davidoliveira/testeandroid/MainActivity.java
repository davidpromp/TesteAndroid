package com.br.davidoliveira.testeandroid;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnInvestimento)
    Button btnInvestimento;
    @BindView(R.id.btnContato)
    Button btnContato;
    Button ibtnActive = btnContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        formatButtonActive(btnContato, btnInvestimento);

        btnInvestimento.setOnClickListener(v -> onNavigation(v));
        btnContato.setOnClickListener(v -> onNavigation(v));

//       formatButtonCont();
    }

    public void onNavigation(View view){
        switch (view.getId()){
            case R.id.btnContato:
                formatButtonActive(btnContato, btnInvestimento);
                break;
            case R.id.btnInvestimento:
                formatButtonActive(btnInvestimento,btnContato);
                break;
        }

    }

    public void formatButtonActive( Button btnAtivar, Button btnDesativar){
        if(ibtnActive == btnAtivar) return;

        // Formata o botão Investimento para SELECIONADO;
        btnAtivar.setBackground(getResources().getDrawable(R.drawable.button_santander_selected));
        ViewGroup.LayoutParams pInvest = btnAtivar.getLayoutParams();
        // Formatar o botão Contato Para Normal
        btnDesativar.setBackground(getResources().getDrawable(R.drawable.button_santander_default));
        ViewGroup.LayoutParams pCont = btnDesativar.getLayoutParams();

        pInvest.height = pInvest.height <= pCont.height ? pInvest.height + 4 :  pInvest.height;
        btnAtivar.setLayoutParams(pInvest);

        // Formata o botão Investimento para SELECIONADO;
        pCont.height = pCont.height >= pInvest.height ? pCont.height - 4 :  pCont.height;
        btnDesativar.setLayoutParams(pCont);


        ibtnActive = btnAtivar;
    }
}
