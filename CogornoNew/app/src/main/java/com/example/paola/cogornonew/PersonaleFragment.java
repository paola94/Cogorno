package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PersonaleFragment extends Fragment {

    private DataBase db;
    private List<Personale> personaleList;
    private String titoloPersonale, nomePagina, tipoRicerca;
    private TextView tv_nomePagina;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            titoloPersonale = getArguments().getString("titolo");
            nomePagina = getArguments().getString("nomePagina");
            tipoRicerca = getArguments().getString("tipoFiltro");
        }else{
            titoloPersonale = "personale";
            tipoRicerca = "personale";
            nomePagina = "Personale Apicale";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personale, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext());

        tv_nomePagina = view.findViewById(R.id.tv_nomePaginaPersonale);
        tv_nomePagina.setText(nomePagina);
        switch (tipoRicerca){
            case "tutte":
                personaleList = db.getPersonaleFromTitolo(titoloPersonale);
                /*
                switch (titoloPersonale) {
                    case "protezione civile":
                        personaleList = db.getPersonaleFromTitolo("protezione civile");
                        break;

                    case "professionisti":
                        personaleList = db.getPersonaleFromTitolo("professionisti");
                        break;

                    case "sanita":
                        personaleList = db.getPersonaleFromTitolo("sanita");
                        break;
                }
                */
                break;

            case "cognome":
                String cognome = getArguments().getString("cognomeInserito");
                personaleList = db.getPersonaleFromCognome(cognome, titoloPersonale);
                if(personaleList.size() == 0){
                    tv_nomePagina.setText("Nessun risultato");
                }

                break;

            case "funzione":
                String funzione = getArguments().getString("funzioneInserita");
                personaleList = db.getPersonaleFromFunzione(funzione, titoloPersonale);
                if(personaleList.size() == 0){
                    tv_nomePagina.setText("Nessun risultato");
                }
                break;
            case "personale":
                personaleList = db.getPersonale();
                break;
        }

        ListView listView = view.findViewById(R.id.lv_personale);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);



    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return personaleList.size();
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
            convertView = getLayoutInflater().inflate(R.layout.item_personale, null);

            TextView tv_cognome = convertView.findViewById(R.id.tv_cognomePersonale);
            TextView tv_nome = convertView.findViewById(R.id.tv_nomePersonale);
            TextView tv_funzione = convertView.findViewById(R.id.tv_funzionePersonale);
            TextView tv_residenza = convertView.findViewById(R.id.tv_residenzaPersonale);
            TextView tv_tel = convertView.findViewById(R.id.tv_telPersonale);

            //if(titoloPersonale.equals("protezioneCivile")){
                Personale personale = personaleList.get(position);

                tv_cognome.setText(personale.getCognome_personale());
                tv_nome.setText(personale.getNome_personale());
                tv_residenza.setText(personale.getResidenza_personale());
                tv_funzione.setText(personale.getFunzione_personale());
                tv_tel.setText(personale.getTelefono_personale());


           /* } else if(titoloPersonale.equals("professionistiTecnici")) {

                Personale professionisti = professionistiList.get(position);
                tv_cognome.setText(professionisti.getCognome_personale());
                tv_nome.setText(professionisti.getNome_personale());
                tv_residenza.setText(professionisti.getResidenza_personale());
                tv_funzione.setText(professionisti.getFunzione_personale());
                tv_tel.setText(professionisti.getTelefono_personale());
            }else if(titoloPersonale.equals("sanita")) {
                Personale sanita = sanitaList.get(position);
                tv_cognome.setText(sanita.getCognome_personale());
                tv_nome.setText(sanita.getNome_personale());
                tv_residenza.setText(sanita.getResidenza_personale());
                tv_funzione.setText(sanita.getFunzione_personale());
                tv_tel.setText(sanita.getTelefono_personale());
            }else {
                Personale personale = personaleList.get(position);
                tv_cognome.setText(personale.getCognome_personale());
                tv_nome.setText(personale.getNome_personale());
                tv_funzione.setText(personale.getFunzione_personale());
                tv_residenza.setText(personale.getResidenza_personale());
                tv_tel.setText(personale.getTelefono_personale());
            }
*/
            return convertView;
        }
    }
}
