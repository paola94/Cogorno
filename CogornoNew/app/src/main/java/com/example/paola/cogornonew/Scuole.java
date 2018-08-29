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

public class Scuole extends Fragment implements AdapterView.OnItemClickListener {

    private DataBase db;
    private List<String> nomiStrutture, indirizziStrutture;
    private String tipoRicerca;
    private List<Struttura> strutturaList;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            tipoRicerca = getArguments().getString("tipoFiltro");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scuole, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        textView = view.findViewById(R.id.textView29);

        if(tipoRicerca.equals("tutte")){
            nomiStrutture = db.getNomiStrutture("scuola");
            indirizziStrutture = db.getIndirizziStrutture("scuola");
        }else if(tipoRicerca.equals("nomeStruttura")){
            String nomeStruttura = getArguments().getString("nomeStruttura");
            strutturaList = db.getStruttureFromNome(nomeStruttura);
            Log.d("nome struttura", strutturaList.get(0).getNome());
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
        }else if(tipoRicerca.equals("viaStruttura")){
            String nomeVia = getArguments().getString("nomeVia");
            int idVia = db.getIdViaFromNomeVia(nomeVia);
            strutturaList = db.getStruttureFromVia("scuola", idVia);
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


        ListView listView = view.findViewById(R.id.list_scuole);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment = new ScuolaItem();
        Bundle args = new Bundle();
        args.putString("nomeScuola", nomiStrutture.get(position));
        args.putString("indirizzoScuola", indirizziStrutture.get(position));
        fragment.setArguments(args);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("myscreen");
        ft.commit();
    }

    class CustomAdapter extends BaseAdapter{

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

            TextView textView = convertView.findViewById(R.id.tv_scuola);
            TextView tv_2 = convertView.findViewById(R.id.tv_scuola2);

            textView.setText(nomiStrutture.get(position));
            tv_2.setText(indirizziStrutture.get(position));

            return convertView;
        }
    }
}
