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
import android.widget.Toast;

public class RisorseDisponibiliFragment extends Fragment implements View.OnClickListener{

    private Button btnPersonale, btnMezziComune, btnMaterialiComune, btnProtezione, btnProfessionisti, btnSanita, btnImprese, btnApprov;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_risorse_disponibili, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPersonale = view.findViewById(R.id.btn_personaleApicale);
        btnPersonale.setOnClickListener(this);

        btnMezziComune = view.findViewById(R.id.btn_mezziComune);
        btnMezziComune.setOnClickListener(this);

        btnMaterialiComune = view.findViewById(R.id.btn_materialiComune);
        btnMaterialiComune.setOnClickListener(this);

        btnProtezione = view.findViewById(R.id.btn_protezioneCivile);
        btnProtezione.setOnClickListener(this);

        btnProfessionisti = view.findViewById(R.id.btn_professionistiTecnici);
        btnProfessionisti.setOnClickListener(this);

        btnSanita = view.findViewById(R.id.btn_sanita);
        btnSanita.setOnClickListener(this);

        btnImprese = view.findViewById(R.id.btn_impreseEdilizia);
        btnImprese.setOnClickListener(this);

        btnApprov = view.findViewById(R.id.btn_attivitaApprov);
        btnApprov.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;
        switch (v.getId()){
            case R.id.btn_personaleApicale:
                fragment = new PersonaleFragment();
                goToFragment(fragment);
                break;

            case R.id.btn_mezziComune:
                fragment = new MezziFragment();
                goToFragment(fragment);
                break;

            case R.id.btn_materialiComune:
                fragment = new MaterialiFragment();
                goToFragment(fragment);
                break;

            case R.id.btn_protezioneCivile:
                fragment = new FiltroPersonale();
                args = new Bundle();
                args.putString("titoloPagina", btnProtezione.getText().toString());
                args.putString("tipoPersonale", "protezione civile");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_professionistiTecnici:
                fragment = new FiltroPersonale();
                args = new Bundle();
                args.putString("titoloPagina", btnProfessionisti.getText().toString());
                args.putString("tipoPersonale", "Professionisti tecnici");
                fragment.setArguments(args);
                goToFragment(fragment);

                break;

            case R.id.btn_sanita:
                fragment = new FiltroPersonale();
                args = new Bundle();
                args.putString("titoloPagina", btnSanita.getText().toString());
                args.putString("tipoPersonale", "sanita");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_impreseEdilizia:
                fragment = new Filtra();
                args = new Bundle();
                args.putString("titoloPagina", btnImprese.getText().toString());
                args.putString("tipoStruttura", "imprese");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_attivitaApprov:
                fragment = new Filtra();
                args = new Bundle();
                args.putString("titoloPagina", btnApprov.getText().toString());
                args.putString("tipoStruttura", "approvvigionamento");
                fragment.setArguments(args);
                goToFragment(fragment);
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
