package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DatiGeografici extends Fragment{

    private DataBase db;
    private TextView tv_alt, tv_latSess, tv_longSess, tv_latDec, tv_longDec;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dati_geografici, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_alt = view.findViewById(R.id.tv_altitudine);
        tv_latSess = view.findViewById(R.id.tv_latSess);
        tv_longSess = view.findViewById(R.id.tv_longSess);
        tv_latDec = view.findViewById(R.id.tv_latDec);
        tv_longDec = view.findViewById(R.id.tv_longDec);

        db = new DataBase(getContext());
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


        SedeComunale sedeComunale = db.getDatiGeografici("sede comunale");
        tv_alt.setText(sedeComunale.getAltitudine());
        tv_latSess.setText(sedeComunale.getLatitudineSess());
        tv_longSess.setText(sedeComunale.getLongitudineSess());
        tv_latDec.setText(sedeComunale.getLatitudineDec());
        tv_longDec.setText(sedeComunale.getLongitudineDec());

    }
}
