package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class ScuolaItem extends Fragment {

    private DataBase db;
    private String nomeScuola, indirizzoScuola;
    private TextView tv_nomeScuola, tv_indirizzoScuola, tv_nAlunni, tv_nPersonale;
    private int nAlunni, nPersonale;

    private List<Contatti> contatti;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            nomeScuola = getArguments().getString("nomeScuola");
            indirizzoScuola = getArguments().getString("indirizzoScuola");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scuole_item, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext());
        nAlunni = db.getNumeroPopolazione(nomeScuola, "alunni");
        tv_nomeScuola = view.findViewById(R.id.tv_nomeScuolaItem);
        tv_nomeScuola.setText(nomeScuola);
        tv_indirizzoScuola = view.findViewById(R.id.tv_indirizzoScuolaItem);
        tv_indirizzoScuola.setText(indirizzoScuola);
        tv_nAlunni = view.findViewById(R.id.tv_nAlunni);
        tv_nAlunni.setText(String.valueOf(nAlunni));

        nPersonale = db.getNumeroPopolazione(nomeScuola, "personale");
        tv_nPersonale = view.findViewById(R.id.tv_nPersonale);
        tv_nPersonale.setText(String.valueOf(nPersonale));


        ListView lvContatti = view.findViewById(R.id.lv_contatti);

        contatti = db.getContattiFromNomeStruttura(nomeScuola);

        CustomAdapter customAdapter = new CustomAdapter();
        lvContatti.setAdapter(customAdapter);

        //lvContatti.setOnItemClickListener(this);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contatti.size() ;
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
            convertView = getLayoutInflater().inflate(R.layout.item_specifiche_struttura, null);

            TextView tvNome = convertView.findViewById(R.id.tv_nomeContatto);
            TextView tvCognome = convertView.findViewById(R.id.tv_cognomeContatto);
            TextView tvTipo = convertView.findViewById(R.id.tv_tipoContatto);
            TextView tvValore = convertView.findViewById(R.id.tv_valoreContatto);

            tvNome.setText(contatti.get(position).getNome());
            tvCognome.setText(contatti.get(position).getCognome());
            tvTipo.setText(contatti.get(position).getTipo());
            tvValore.setText(contatti.get(position).getValore());

            return convertView;
        }
    }
}
