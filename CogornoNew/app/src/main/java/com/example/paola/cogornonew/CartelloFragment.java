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

public class CartelloFragment extends Fragment {

    private List<Personale> manutentore, operatori;
    private DataBase db;
    private TextView tvNomeMan, tvCognomeMan, tvIndMan, tvTelMan;
    private List<Cartello> cartelli;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cartello, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());
        manutentore = db.getPersonaleFromFunzione("MANUTENTORE HARDWARE","cartelli");

        tvNomeMan = view.findViewById(R.id.tv_nomeManCartelli);
        tvCognomeMan = view.findViewById(R.id.tv_CognomeManCartelli);
        tvIndMan = view.findViewById(R.id.tv_indManCartelli);
        tvTelMan = view.findViewById(R.id.tv_telManCartelli);

        tvNomeMan.setText(manutentore.get(0).getNome_personale());
        tvCognomeMan.setText(manutentore.get(0).getCognome_personale());
        tvIndMan.setText(manutentore.get(0).getResidenza_personale());
        tvTelMan.setText(manutentore.get(0).getTelefono_personale());

        cartelli = db.getCartelli();
        operatori = db.getPersonaleFromFunzione("OPERATORI PER MESSAGGI", "cartelli");

        ListView lvIndirizziCartelli = view.findViewById(R.id.lv_locCartelli);
        ListView lvTelCartelli = view.findViewById(R.id.lv_operatoriCartelli);

        CustomAdapterListIndirizzi customAdapterListIndirizzi = new CustomAdapterListIndirizzi();
        lvIndirizziCartelli.setAdapter(customAdapterListIndirizzi);

        CustomAdapterOperatori customAdapterOperatori = new CustomAdapterOperatori();
        lvTelCartelli.setAdapter(customAdapterOperatori);
    }

    class CustomAdapterListIndirizzi extends BaseAdapter{

        @Override
        public int getCount() {
            return cartelli.size();
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
            convertView = getLayoutInflater().inflate(R.layout.item_indirizzi, null);
            TextView tvIndirizzo = convertView.findViewById(R.id.tvIndirizziItem);
            tvIndirizzo.setText(cartelli.get(position).getLocCartello());
            return convertView;
        }
    }

    class CustomAdapterOperatori extends BaseAdapter{

        @Override
        public int getCount() {
            return operatori.size();
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
            TextView tvLoc = convertView.findViewById(R.id.tv_tipoContatto);
            TextView tvValore = convertView.findViewById(R.id.tv_valoreContatto);

            tvNome.setText(operatori.get(position).getNome_personale());
            tvCognome.setText(operatori.get(position).getCognome_personale());
            tvLoc.setText(operatori.get(position).getResidenza_personale());
            tvValore.setText(operatori.get(position).getTelefono_personale());
            return convertView;
        }
    }
}
