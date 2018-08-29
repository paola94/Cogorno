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

public class StruttureItem extends Fragment {
    private String nomeStruttura, indirizzoStruttura;
    private DataBase db;
    private ListView lvContatti;
    private TextView tv_nomeStruttura, tv_indirizzoStruttura;

    private List<Contatti> contatti;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            nomeStruttura = getArguments().getString("nomeStruttura");
            indirizzoStruttura = getArguments().getString("indirizzoStruttura");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_struttura_item, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        contatti = db.getContattiFromNomeStruttura(nomeStruttura);

        tv_nomeStruttura = view.findViewById(R.id.tv_nomeStruttura);
        tv_nomeStruttura.setText(nomeStruttura);

        tv_indirizzoStruttura = view.findViewById(R.id.tv_indirizzoStruttura);
        tv_indirizzoStruttura.setText(indirizzoStruttura);

        lvContatti = view.findViewById(R.id.lv_contattiStruttura);
        CustomAdapter customAdapter = new CustomAdapter();
        lvContatti.setAdapter(customAdapter);


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
