package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Filtra extends Fragment implements View.OnClickListener {


    private String nomePagina;
    private TextView tvTitolo;
    private Button btnTutte, btnFiltraNome, btnFiltraVia;
    private EditText editNome, editVia;
    private ImageButton btnCercaNome, btnCercaVia;
    private String tipoStruttura;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            nomePagina = getArguments().getString("titoloPagina");
            tipoStruttura = getArguments().getString("tipoStruttura");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filtra, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitolo = view.findViewById(R.id.tv_titoloFiltra);
        tvTitolo.setText(nomePagina);

        btnTutte = view.findViewById(R.id.btn_filtraTutto);
        btnTutte.setOnClickListener(this);

        btnFiltraNome = view.findViewById(R.id.btn_filtraNome);
        btnFiltraNome.setOnClickListener(this);

        btnFiltraVia = view.findViewById(R.id.btn_filtraVia);
        btnFiltraVia.setOnClickListener(this);

        editNome = view.findViewById(R.id.editNomeFiltro);
        editVia = view.findViewById(R.id.editViaFiltro);

        btnCercaNome = view.findViewById(R.id.btn_CercaNomeFiltro);
        btnCercaNome.setOnClickListener(this);

        btnCercaVia = view.findViewById(R.id.btn_cercaViaFiltro);
        btnCercaVia.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;
        switch (v.getId()){
            case R.id.btn_filtraTutto:

                switch (tipoStruttura){
                    case "scuola":
                        fragment = new Scuole();
                        args = new Bundle();
                        args.putString("tipoFiltro", "tutte");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;
                    case "culto":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("nomePagina", "Centri di culto e di aggregazione");
                        args.putString("titolo", "culto");
                        args.putString("tipoFiltro", "tutte");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "imprese":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("nomePagina", "Imprese di Edilizia e Fornitori");
                        args.putString("titolo", "imprese");
                        args.putString("tipoFiltro", "tutte");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }

                        break;

                    case "approvvigionamento":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("nomePagina", "Attività produttive utili all'approvvigionamento di risorse");
                        args.putString("titolo", "approvvigionamento");
                        args.putString("tipoFiltro", "tutte");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }

                        break;
                }
                break;

            case R.id.btn_filtraNome:
                if(editVia.getVisibility() == View.VISIBLE){
                    editVia.setVisibility(View.INVISIBLE);
                    btnCercaVia.setVisibility(View.INVISIBLE);
                }
                editNome.setVisibility(View.VISIBLE);
                btnCercaNome.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_filtraVia:
                if(editNome.getVisibility() == View.VISIBLE){
                    editNome.setVisibility(View.INVISIBLE);
                    btnCercaNome.setVisibility(View.INVISIBLE);
                }
                editVia.setVisibility(View.VISIBLE);
                btnCercaVia.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_CercaNomeFiltro:
                String nomeStruttura= editNome.getText().toString().toUpperCase().trim();
                switch (tipoStruttura){
                    case "scuola":
                        fragment = new Scuole();
                        args = new Bundle();
                        args.putString("tipoFiltro", "nomeStruttura");
                        args.putString("nomeStruttura", nomeStruttura);
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "culto":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "nomeStruttura");
                        args.putString("nomeStruttura", nomeStruttura);
                        args.putString("titolo", "culto");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "imprese":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "nomeStruttura");
                        args.putString("nomeStruttura", nomeStruttura);
                        args.putString("titolo", "imprese");
                        args.putString("nomePagina", "Imprese di Edilizia e Fornitori");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "approvvigionamento":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "nomeStruttura");
                        args.putString("nomeStruttura", nomeStruttura);
                        args.putString("titolo", "approvvigionamento");
                        args.putString("nomePagina", "Attività produttive utili all'approvvigionamento di risorse");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;
                }

                break;

            case R.id.btn_cercaViaFiltro:
                String nomeVia = editVia.getText().toString().toUpperCase().trim();
                switch (tipoStruttura){
                    case "scuola":
                        fragment = new Scuole();
                        args = new Bundle();
                        args.putString("tipoFiltro", "viaStruttura");
                        args.putString("nomeVia", nomeVia);
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "culto":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "viaStruttura");
                        args.putString("nomeVia", nomeVia);
                        args.putString("titolo", "culto");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.container, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "imprese":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "viaStruttura");
                        args.putString("nomeVia", nomeVia);
                        args.putString("titolo", "imprese");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "approvvigionamento":
                        fragment = new StruttureFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "viaStruttura");
                        args.putString("nomeVia", nomeVia);
                        args.putString("titolo", "approvvigionamento");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                }


                break;
        }

    }
}
