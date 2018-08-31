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
import android.widget.Toast;

public class FiltroPersonale extends Fragment implements View.OnClickListener{

    private Button btnTutte, btnFiltraCognome, btnFiltraFunzione;
    private ImageButton btnCercaCognome, btnCercaFunzione;
    private String nomePagina, tipoPersonale;
    private TextView tvTitolo;
    private EditText editCognome, editFunzione;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            nomePagina = getArguments().getString("titoloPagina");
            tipoPersonale = getArguments().getString("tipoPersonale");
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

        btnFiltraCognome = view.findViewById(R.id.btn_filtraNome);
        btnFiltraCognome.setText("Filtra per cognome");
        btnFiltraCognome.setOnClickListener(this);

        btnFiltraFunzione = view.findViewById(R.id.btn_filtraVia);
        btnFiltraFunzione.setText("Filtra per Funzione");
        btnFiltraFunzione.setOnClickListener(this);

        editCognome = view.findViewById(R.id.editNomeFiltro);
        editCognome.setHint("Inserisci il cognome");
        editFunzione = view.findViewById(R.id.editViaFiltro);
        editFunzione.setHint("Inserisci la funzione");

        btnCercaCognome = view.findViewById(R.id.btn_CercaNomeFiltro);
        btnCercaCognome.setOnClickListener(this);

        btnCercaFunzione = view.findViewById(R.id.btn_cercaViaFiltro);
        btnCercaFunzione.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;

        switch (v.getId()){
            case R.id.btn_filtraTutto:
                switch (tipoPersonale){
                    case "protezione civile":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("titolo", "protezione civile");
                        args.putString("nomePagina", "Protezione civile e altri gruppi di volontariato");
                        args.putString("tipoFiltro", "tutte");
                        fragment.setArguments(args);
                        goToFragment(fragment);
                        break;

                    case "Professionisti tecnici":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("titolo", "professionisti");
                        args.putString("nomePagina", "Professionisti tecnici");
                        args.putString("tipoFiltro","tutte");
                        fragment.setArguments(args);
                        goToFragment(fragment);
                        break;

                    case "sanita":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("titolo", "sanita");
                        args.putString("nomePagina", "Sanità, Assistenza sociale e veterinaria");
                        args.putString("tipoFiltro","tutte");
                        fragment.setArguments(args);
                        goToFragment(fragment);
                        break;

                }
                break;

            case R.id.btn_filtraNome:
                if(editFunzione.getVisibility() == View.VISIBLE){
                    editFunzione.setVisibility(View.INVISIBLE);
                    btnCercaFunzione.setVisibility(View.INVISIBLE);
                }
                editCognome.setVisibility(View.VISIBLE);
                btnCercaCognome.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_filtraVia:
                if(editCognome.getVisibility() == View.VISIBLE){
                    editCognome.setVisibility(View.INVISIBLE);
                    btnCercaCognome.setVisibility(View.INVISIBLE);
                }
                editFunzione.setVisibility(View.VISIBLE);
                btnCercaFunzione.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_CercaNomeFiltro:
                String cognome = editCognome.getText().toString().toUpperCase().trim();
                switch (tipoPersonale){
                    case "protezione civile":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "cognome");
                        args.putString("cognomeInserito", cognome);
                        args.putString("titolo","protezione civile");
                        args.putString("nomePagina", "Protezione civile e altri gruppi di volontariato");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }

                        break;

                    case "Professionisti tecnici":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "cognome");
                        args.putString("cognomeInserito", cognome);
                        args.putString("titolo","professionisti");
                        args.putString("nomePagina", "Professionisti tecnici");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "sanita":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "cognome");
                        args.putString("cognomeInserito", cognome);
                        args.putString("titolo","sanita");
                        args.putString("nomePagina", "Sanità, Assistenza sociale e veterinaria");
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
                String funzione = editFunzione.getText().toString().toUpperCase().trim();
                switch (tipoPersonale){
                    case "protezione civile":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "funzione");
                        args.putString("funzioneInserita", funzione);
                        args.putString("titolo","protezione civile");
                        args.putString("nomePagina", "Protezione civile e altri gruppi di volontariato");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "Professionisti tecnici":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "funzione");
                        args.putString("funzioneInserita", funzione);
                        args.putString("titolo","professionisti");
                        args.putString("nomePagina", "Professionisti tecnici");
                        fragment.setArguments(args);
                        if (fragment != null){
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            ft.replace(R.id.containerRisorse, fragment);
                            ft.addToBackStack("myscreen");
                            ft.commit();
                        }
                        break;

                    case "sanita":
                        fragment = new PersonaleFragment();
                        args = new Bundle();
                        args.putString("tipoFiltro", "funzione");
                        args.putString("funzioneInserita", funzione);
                        args.putString("titolo","sanita");
                        args.putString("nomePagina", "Sanità, Assistenza sociale e veterinaria");
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

    private void goToFragment(Fragment fragment){

        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.containerRisorse, fragment);
            ft.addToBackStack("myscreen");
            ft.commit();
        }
        //Toast.makeText(getActivity(), "dentro risorse diponibili fragment", Toast.LENGTH_SHORT).show();

    }
}
