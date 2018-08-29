package com.example.paola.cogornonew;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaginaAmministratore extends Fragment implements View.OnClickListener {

    private EditText etUsernameAmm, etPasswordAmm;
    private Button btnLoginAmm, btnEsciAmm, btnAggiungi, btnElimina, btnTutti;
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
        btnElimina = view.findViewById(R.id.btn_eliminaUtenteAut);
        btnTutti = view.findViewById(R.id.btn_TuttiUtentiAut);

        btnAggiungi.setVisibility(View.INVISIBLE);
        btnEsciAmm.setVisibility(View.INVISIBLE);
        btnElimina.setVisibility(View.INVISIBLE);
        btnTutti.setVisibility(View.INVISIBLE);

        btnLoginAmm.setOnClickListener(this);
        btnAggiungi.setOnClickListener(this);
        btnEsciAmm.setOnClickListener(this);
        btnTutti.setOnClickListener(this);
        btnElimina.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;
        switch (v.getId()){
            case R.id.btn_loginAmm:
                String username = etUsernameAmm.getText().toString().trim();
                String password = etPasswordAmm.getText().toString().trim();

                if(db.getUtenteAmm(username, password)){
                    btnEsciAmm.setVisibility(View.VISIBLE);
                    btnAggiungi.setVisibility(View.VISIBLE);
                    btnElimina.setVisibility(View.VISIBLE);
                    btnTutti.setVisibility(View.VISIBLE);

                    closeKeyboard();
                }else{
                    Toast.makeText(getContext(), "username e/o password non validi", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_aggiungiUtente:
                fragment = new AggiungiUtenteAut();
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

            case R.id.btn_eliminaUtenteAut:
                fragment = new VisualizzaUtentiAut();
                args = new Bundle();
                args.putString("tipo", "elimina");
                fragment.setArguments(args);
                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.containerAmministratore, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                break;

            case R.id.btn_TuttiUtentiAut:
                fragment = new VisualizzaUtentiAut();
                args = new Bundle();
                args.putString("tipo", "visualizza");
                fragment.setArguments(args);
                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.containerAmministratore, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                break;
        }

    }

    public void goToMainActivity(){
        Intent intent_home = new Intent(getContext(), MainActivity.class);
        startActivity(intent_home);
        getActivity().finish();
    }

    private void closeKeyboard(){
        View view = this.getActivity().getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)this.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
