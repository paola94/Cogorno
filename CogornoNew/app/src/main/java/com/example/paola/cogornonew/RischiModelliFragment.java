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

public class RischiModelliFragment extends Fragment implements View.OnClickListener {
    private String tipoEvento;
    private Button btnScenari, btnModelli, btnPost;
   private  String nomeScenari;
    private String nomeModelli, nomePost;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            tipoEvento = getArguments().getString("tipoEvento");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rischi_modelli, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            TextView tvTitolo = view.findViewById(R.id.tv_tipoEvento);
            tvTitolo.setText(tipoEvento);

            btnScenari = view.findViewById(R.id.btn_scenariDiRischio);
            btnScenari.setOnClickListener(this);

            btnModelli = view.findViewById(R.id.btn_modelliDiIntervento);
            btnModelli.setOnClickListener(this);

            btnPost = view.findViewById(R.id.btn_postEvento);
            btnPost.setOnClickListener(this);


        switch (tipoEvento){
            case "Evento Alluvionale":
                nomeScenari = "cap.5ScenariAlluvione.pdf";
                nomeModelli = "cap.12ModelliAlluvione.pdf";
                nomePost = "cap.12PostAlluvione.pdf";
                break;

            case "Evento sismico":
                nomeScenari = "cap.5ScenariSisma.pdf";
                nomeModelli = "cap.13ModelliSisma.pdf";
                nomePost = "cap.13PostSisma.pdf";
                break;

            case "Evento Nivologico":
                nomeScenari = "cap.5ScenariNeve.pdf";
                nomeModelli = "cap.14ModelliNeve.pdf";
                nomePost = "cap.14PostNeve.pdf";
                break;

            case "Rischio Incendi":
                nomeScenari = "cap.5ScenariIncendi.pdf";
                nomeModelli = "cap.17ModelliIncendi.pdf";
                nomePost = "cap.17PostIncendi.pdf";
                break;

            case "Rischi Vari":
                btnScenari.setText("Modello di intervento per altri eventi meteorologici");
                btnModelli.setText("Modello di intervento per rischi vari");
                btnPost.setVisibility(View.INVISIBLE);
                nomeScenari = "cap.15AltriEventi.pdf";
                nomeModelli = "cap.16ModelliRischiVari.pdf";
                break;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_scenariDiRischio:
                goToMostraPDF(nomeScenari);
                break;

            case R.id.btn_modelliDiIntervento:
                goToMostraPDF(nomeModelli);
                break;

            case R.id.btn_postEvento:
                goToMostraPDF(nomePost);
                break;
        }

    }

    public void goToMostraPDF(String nomePDF){
        Fragment fragment;
        Bundle args;
        fragment = new MostraPDF();
        args = new Bundle();
        args.putString("nomePDF", nomePDF);
        fragment.setArguments(args);
        if(fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.containerScenari, fragment);
            ft.addToBackStack("myscreen");
            ft.commit();
        }
    }
}
