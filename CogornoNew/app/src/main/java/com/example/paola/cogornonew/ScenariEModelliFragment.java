package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ScenariEModelliFragment extends Fragment implements View.OnClickListener{

    private Button btnAlluvione, btnSisma, btnNeve, btnIncendi, btnVari;

    private String tipoEvento;

    private String nomePagina, tipo;

    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            nomePagina = getArguments().getString("nomePagina");
            tipo = getArguments().getString("tipo");
        }else{
            nomePagina = "Scenari di Rischio e Modelli di Intervento";
            tipo = "scenari";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scenari_emodelli, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.textView57);
        textView.setText(nomePagina);

        btnAlluvione = view.findViewById(R.id.btn_alluvione);
        btnAlluvione.setOnClickListener(this);

        btnSisma = view.findViewById(R.id.btn_sisma);
        btnSisma.setOnClickListener(this);

        btnNeve = view.findViewById(R.id.btn_neve);
        btnNeve.setOnClickListener(this);

        btnIncendi = view.findViewById(R.id.btn_incendi);
        btnIncendi.setOnClickListener(this);

        btnVari = view.findViewById(R.id.btn_vari);
        btnVari.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_alluvione:
                if(tipo.equals("schede")){
                    goToFragmentSchede("cap.20SchedeAlluvione.pdf");
                }else{
                    tipoEvento = btnAlluvione.getText().toString();
                    goToNextFragment(tipoEvento);
                }

                break;

            case R.id.btn_sisma:
                if(tipo.equals("schede")){
                    goToFragmentSchede("cap.20SchedeSisma.pdf");
                }else {
                    tipoEvento = btnSisma.getText().toString();
                    goToNextFragment(tipoEvento);
                }
                break;

            case R.id.btn_neve:
                if(tipo.equals("schede")){
                    goToFragmentSchede("cap.20SchedeNeve.pdf");
                }else {
                    tipoEvento = btnNeve.getText().toString();
                    goToNextFragment(tipoEvento);
                }
                break;

            case R.id.btn_incendi:
                if(tipo.equals("schede")){
                    goToFragmentSchede("cap.20SchedeIncendi.pdf");
                }else {
                    tipoEvento = btnIncendi.getText().toString();
                    goToNextFragment(tipoEvento);
                }
                break;

            case R.id.btn_vari:
                if(tipo.equals("schede")){
                    goToFragmentSchede("cap.20SchedeVarie.pdf");
                }else {
                    tipoEvento = btnVari.getText().toString();
                    goToNextFragment(tipoEvento);
                }
                break;
        }


    }

    private void goToNextFragment(String tipoEvento){
        Fragment fragment;
        Bundle args;
        fragment = new RischiModelliFragment();
        args = new Bundle();
        args.putString("tipoEvento", tipoEvento);
        fragment.setArguments(args);
        if(fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.containerScenari, fragment);
            ft.addToBackStack("myscreen");
            ft.commit();
        }
    }

    private void goToFragmentSchede(String nomePDF){
        Fragment fragment = new MostraPDF();
        Bundle args = new Bundle();
        args.putString("nomePDF", nomePDF);
        fragment.setArguments(args);
        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.containerSchede, fragment);
            ft.addToBackStack("myscreen");
            ft.commit();
        }
    }
}
