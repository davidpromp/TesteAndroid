package com.br.everis.santander;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.br.everis.santander.contato.ContatoFragment;
import com.br.everis.santander.investimento.InvestimentoFragment;

import butterknife.BindView;

public class PrincipalActivity extends AppCompatActivity {


    @BindView(R.id.btnInvestimento)
    Button btnInvestimento;
    @BindView(R.id.btnContato)
    Button btnContato;
    Button ibtnActive = btnContato;


    public void onNavigation(View view){
        switch (view.getId()){
            case R.id.btnContato:
//                if(ibtnActive == btnContato) break;
                Fragment contatoFragment = new ContatoFragment();
                replaceFragment(contatoFragment);
                formatButtonActive(btnContato, btnInvestimento);
                break;
            case R.id.btnInvestimento:
//                if(ibtnActive == btnInvestimento) break;

                Fragment investimentoFragment = new InvestimentoFragment();
                replaceFragment(investimentoFragment);
                formatButtonActive(btnInvestimento,btnContato);
                break;
        }

    }


    protected void setDefaultFragment(Fragment defaultFragment)
    {
        this.replaceFragment(defaultFragment);
    }

    public void replaceFragment(Fragment destFragment)
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        ft.replace(R.id.fragment_container, destFragment);

        ft.commit();
    }

    public void formatButtonActive(Button btnAtivar, Button btnDesativar){
        if(ibtnActive == btnAtivar) return;

        btnAtivar.setBackground(getResources().getDrawable(R.drawable.button_santander_selected));
        ViewGroup.LayoutParams pInvest = btnAtivar.getLayoutParams();

        btnDesativar.setBackground(getResources().getDrawable(R.drawable.button_santander_default));
        ViewGroup.LayoutParams pCont = btnDesativar.getLayoutParams();

        pInvest.height = pInvest.height <= pCont.height ? pInvest.height + 4 :  pInvest.height;
        btnAtivar.setLayoutParams(pInvest);
        pCont.height = pCont.height >= pInvest.height ? pCont.height - 4 :  pCont.height;
        btnDesativar.setLayoutParams(pCont);


        ibtnActive = btnAtivar;
    }
}
