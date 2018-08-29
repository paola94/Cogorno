package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class Generalita extends Fragment {

    private DataBase db;
    private TextView tv_indirizzoSedeComunale, tv_telefono, tv_telfax, tv_sito, tv_poliziaTel, tv_poliziaCell;
    private TextView tv_indAssSociali, tv_telAssSociali, tv_totResidenti;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_generalita, null);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        tv_indirizzoSedeComunale = (TextView) view.findViewById(R.id.tv_indirizzoSedeComunale);
        tv_telefono = (TextView) view.findViewById(R.id.tv_telefono);
        tv_telfax = (TextView) view.findViewById(R.id.tv_telfax);
        tv_sito = (TextView) view.findViewById(R.id.tv_sito);
        tv_poliziaTel = (TextView) view.findViewById(R.id.tv_poliziaTel);
        tv_poliziaCell = (TextView) view.findViewById(R.id.tv_poliziaCell);
        tv_indAssSociali = (TextView) view.findViewById(R.id.tv_indAssSociali);
        tv_telAssSociali = (TextView) view.findViewById(R.id.tv_telAssSociali);
        tv_totResidenti = (TextView) view.findViewById(R.id.tv_totResidenti);

        /*
        // dati comune
        db.popolaComune(1,"Cogorno");
        db.popolaSedeComunale(1,3, "altitudine", "latSess", "longSess", "latDec", "longDec");
        db.popolaStruttura(3,"sede comunale", 2, 1);
        db.popolaVie(2,"piazza Aldo Moro", 1);
        db.popolaContatti(1, 3, "sede comunale","telefono", "018538571");
        db.popolaContatti(2,3, "sede comunale", "tel/fax", "0185380825");
        db.popolaContatti(3, 3,"sede comunale", "sito", "www.comune.cogorno.ge.it");
        db.popolaPopolazione(1, 3,"residenti", "5646");

        // dati polizia municipale
        db.popolaContatti(4, 3, "Polizia Municipale", "telefono", "0185385728/29");
        db.popolaContatti(5, 3,"Polizia Municipale", "cell", "3293198546");
        db.popolaContatti(6,3,"Polizia Municipale", "sito", "polizialocale@comune.cogorno.ge.it");

        // dati uffici distaccati
        db.popolaVie(3,"Via alla Basilica 7", 1 );
        db.popolaStruttura(4,"ufficio ass soc", 3, 1);
        db.popolaContatti(7, 4,"Ufficio Assistente Sociale", "telefono", "0185385020");
        */



        String nome_via = db.getIndirizzo("sede comunale");
        Log.d("nome via ", nome_via);
        tv_indirizzoSedeComunale.setText(nome_via);

        ArrayList<Contatti> telefoni_sedeComunale = db.getContatti("sede comunale", "telefono");
        ArrayList<Contatti> telFax_sedeComunale = db.getContatti("sede comunale", "tel/fax");
        ArrayList<Contatti> sito_sedeComunale = db.getContatti("sede comunale", "sito");

        tv_telefono.setText(telefoni_sedeComunale.get(0).getValore());
        tv_telfax.setText(telFax_sedeComunale.get(0).getValore());
        tv_sito.setText(sito_sedeComunale.get(0).getValore());

        ArrayList<Contatti> telefoni_pm = db.getContattiFromIntestazione("sede comunale", "telefono", "Polizia Municipale");
        tv_poliziaTel.setText(telefoni_pm.get(0).getValore());

        ArrayList<Contatti> cell_pm = db.getContattiFromIntestazione("sede comunale", "cell", "Polizia Municipale");
        tv_poliziaCell.setText(cell_pm.get(0).getValore());

        String indirizzoAssSoc = db.getIndirizzo("ufficio ass soc");
        tv_indAssSociali.setText(indirizzoAssSoc);

        ArrayList<Contatti> telefoni_assSoc = db.getContatti("ufficio ass soc", "telefono");
        tv_telAssSociali.setText(telefoni_assSoc.get(0).getValore());


        int numResidenti = db.getNumeroPopolazione("sede comunale", "residenti");
        tv_totResidenti.setText(String.valueOf(numResidenti));

    }
}
