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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StruttureFragment extends Fragment implements AdapterView.OnItemClickListener{

    private DataBase db;
    private List<String> nomiStrutture, indirizziStrutture;
    private String nomePagina, tipologia, tipoRicerca;
    private List<Struttura> strutturaList;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            nomePagina = getArguments().getString("nomePagina");
            tipologia = getArguments().getString("titolo");
            tipoRicerca = getArguments().getString("tipoFiltro");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_struttura, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext());
        textView = view.findViewById(R.id.tv_titoloStruttura);

        switch (tipoRicerca){
            case "tutte":
                if(tipologia.equals("culto")){
                    nomiStrutture = db.getNomiStrutture("culto");
                    indirizziStrutture = db.getIndirizziStrutture("culto");
                } else if(tipologia.equals("imprese")){
                    nomiStrutture = db.getNomiStrutture("imprese");
                    indirizziStrutture = db.getIndirizziStrutture("imprese");
                }else if(tipologia.equals("approvvigionamento")){
                    nomiStrutture = db.getNomiStrutture("approvvigionamento");
                    indirizziStrutture = db.getIndirizziStrutture("approvvigionamento");
                }
                break;

            case "nomeStruttura":
                String nomeStruttura = getArguments().getString("nomeStruttura");
                strutturaList = db.getStruttureFromNome(nomeStruttura);
                nomiStrutture = new ArrayList<>();
                indirizziStrutture = new ArrayList<>();
                if(strutturaList.size() == 0){
                    textView.setText("Nessun risultato");

                }else{
                    for (int i = 0; i<strutturaList.size(); i++){
                        nomiStrutture.add(strutturaList.get(i).getNome());
                        String indirizzo = db.getIndirizzo(nomiStrutture.get(i));
                        indirizziStrutture.add(indirizzo);
                    }
                }

                break;

            case "viaStruttura":
                String nomeVia = getArguments().getString("nomeVia");
                int idVia = db.getIdViaFromNomeVia(nomeVia);
                strutturaList = db.getStruttureFromVia(tipologia, idVia);
                nomiStrutture = new ArrayList<>();
                indirizziStrutture = new ArrayList<>();
                if(strutturaList.size() == 0){
                    textView.setText("Nessun risultato");

                }else {
                    for (int i = 0; i < strutturaList.size(); i++) {
                        nomiStrutture.add(strutturaList.get(i).getNome());
                        String indirizzo = db.getIndirizzo(nomiStrutture.get(i));
                        indirizziStrutture.add(indirizzo);
                    }
                }

        }


        TextView tv_titolo = view.findViewById(R.id.tv_titoloStruttura);
        /*if(tipologia.equals("approvvigionamento")){
            tv_titolo.setText(nomePagina);
        }*/



        ListView listView = view.findViewById(R.id.list_struttura);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Fragment fragment = new StruttureItem();
            Bundle args = new Bundle();
            args.putString("nomeStruttura", nomiStrutture.get(position));
            args.putString("indirizzoStruttura", indirizziStrutture.get(position));
            fragment.setArguments(args);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            if(tipologia.equals("culto")) {
                ft.replace(R.id.container, fragment);
            }else if(tipologia.equals("imprese")){
                ft.replace(R.id.containerRisorse, fragment);
            }else if(tipologia.equals("approvvigionamento")){
                ft.replace(R.id.containerRisorse, fragment);
            }
            ft.addToBackStack("myscreen");
            ft.commit();

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return nomiStrutture.size() ;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.item_scuola, null);
            TextView tv_nome = convertView.findViewById(R.id.tv_scuola);
            TextView tv_indirizzo = convertView.findViewById(R.id.tv_scuola2);

            tv_nome.setText(nomiStrutture.get(position));
            tv_indirizzo.setText(indirizziStrutture.get(position));

            return convertView;
        }
    }
}
