package com.example.paola.cogornonew;

import android.content.Intent;
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
import android.widget.Toast;

public class PaginaAmministratore extends Fragment implements View.OnClickListener {

    private EditText etUsernameAmm, etPasswordAmm;
    private Button btnLoginAmm, btnEsciAmm, btnAggiungi;
    private DataBase db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pagina_amministrazione, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        etUsernameAmm = view.findViewById(R.id.et_usernameAmm);
        etPasswordAmm = view.findViewById(R.id.et_passwordAmm);
        btnLoginAmm = view.findViewById(R.id.btn_loginAmm);
        btnAggiungi = view.findViewById(R.id.btn_aggiungiUtente);
        btnEsciAmm = view.findViewById(R.id.btn_esciAmm);

        btnAggiungi.setVisibility(View.INVISIBLE);
        btnEsciAmm.setVisibility(View.INVISIBLE);

        btnLoginAmm.setOnClickListener(this);
        btnAggiungi.setOnClickListener(this);
        btnEsciAmm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_loginAmm:
                String username = etUsernameAmm.getText().toString().trim();
                String password = etPasswordAmm.getText().toString().trim();

                if(db.getUtenteAmm(username, password)){
                    btnEsciAmm.setVisibility(View.VISIBLE);
                    btnAggiungi.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getContext(), "username e/o password non validi", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_aggiungiUtente:
                Fragment fragment = new AggiungiUtenteAut();
                    if (fragment != null) {
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.containerAmministratore, fragment);
                        ft.addToBackStack("myscreen");
                        ft.commit();
                    }
                break;

            case R.id.btn_esciAmm:
                goToMainActivity();
                break;
        }

    }

    public void goToMainActivity(){
        Intent intent_home = new Intent(getContext(), MainActivity.class);
        startActivity(intent_home);
        getActivity().finish();
    }
}
