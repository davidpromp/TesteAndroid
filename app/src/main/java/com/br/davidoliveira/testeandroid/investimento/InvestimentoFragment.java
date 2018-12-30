package com.br.davidoliveira.testeandroid.investimento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.davidoliveira.testeandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestimentoFragment extends Fragment {


    public InvestimentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_investimento, container, false);
    }

}
