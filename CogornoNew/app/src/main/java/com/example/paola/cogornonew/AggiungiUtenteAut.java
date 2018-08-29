package com.example.paola.cogornonew;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AggiungiUtenteAut extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText etNomeUtenteAut, etCognomeUtenteAut;
    private Spinner spinnerRuolo;
    private Button btnAggiungi;
    private String nomeUtente, cognomeUtente, ruoloUtente;
    private DataBase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aggiungi_utente_aut, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        etNomeUtenteAut = view.findViewById(R.id.etNomeUtenteAut);
        etCognomeUtenteAut = view.findViewById(R.id.etCognomeUtenteAut);

        spinnerRuolo = view.findViewById(R.id.spinnerRuoloUtenteAut);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.scelta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRuolo.setAdapter(adapter);
        spinnerRuolo.setOnItemSelectedListener(this);

        btnAggiungi = view.findViewById(R.id.btn_aggiungi);
        btnAggiungi.setOnClickListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
        ruoloUtente = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        nomeUtente = etNomeUtenteAut.getText().toString().trim();
        cognomeUtente = etCognomeUtenteAut.getText().toString().trim();
        if(nomeUtente.equals("")) {
            etNomeUtenteAut.setError("Inserire un nome");
        }else if (cognomeUtente.equals("")) {
            etCognomeUtenteAut.setError("Inserire un cognome");
        }else {
            UtenteAut utenteAut = new UtenteAut(nomeUtente, cognomeUtente, ruoloUtente);
            if(db.checkInUtentiAut(utenteAut)){
                Toast.makeText(getContext(), "Utente già autorizzato", Toast.LENGTH_SHORT).show();
            }else {
                db.popolaUtentiAut(nomeUtente, cognomeUtente, ruoloUtente);
                Toast.makeText(getContext(), "Inserimento avvenuto con successo", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
