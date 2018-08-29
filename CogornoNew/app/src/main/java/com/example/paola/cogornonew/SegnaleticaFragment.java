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

public class SegnaleticaFragment extends Fragment implements View.OnClickListener{

    private Button btnCartelli, btnAttesa, btnRicovero, btnAmmassamento, btnAtterraggio, btnScoccaggio, btnDistrAcqua;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_segnaletica, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCartelli = view.findViewById(R.id.btn_cartelli);
        btnCartelli.setOnClickListener(this);

        btnAttesa = view.findViewById(R.id.btn_attesa);
        btnAttesa.setOnClickListener(this);

        btnRicovero = view.findViewById(R.id.btn_ricovero);
        btnRicovero.setOnClickListener(this);

        btnAmmassamento = view.findViewById(R.id.btn_ammassamento);
        btnAmmassamento.setOnClickListener(this);

        btnAtterraggio = view.findViewById(R.id.btn_atterraggio);
        btnAtterraggio.setOnClickListener(this);

        btnScoccaggio = view.findViewById(R.id.btn_scoccaggio);
        btnScoccaggio.setOnClickListener(this);

        btnDistrAcqua = view.findViewById(R.id.btn_distrAcqua);
        btnDistrAcqua.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;
        switch(v.getId()){
            case R.id.btn_cartelli:
                fragment = new CartelloFragment();
                goToFragment(fragment);
                break;

            case R.id.btn_attesa:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.2AreeDiAttesa.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_ricovero:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.3AreeDiRicovero.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_ammassamento:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.4AreeDiAmmassamento.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_atterraggio:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.5AreeDiAtterraggio.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_scoccaggio:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.6AreePerLoScoccaggio.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

            case R.id.btn_distrAcqua:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "4.7SitiPerLaDistribuzioneDiAcqua.pdf");
                fragment.setArguments(args);
                goToFragment(fragment);
                break;

        }

    }

    public void goToFragment(Fragment fragment){
        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.containerSegnaletica, fragment);
            ft.addToBackStack("myscreen");
            ft.commit();
        }
    }
}
