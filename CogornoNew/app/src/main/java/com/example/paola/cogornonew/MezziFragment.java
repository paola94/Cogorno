package com.example.paola.cogornonew;

import android.os.Bundle;
import android.provider.ContactsContract;
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

public class MezziFragment extends Fragment {

    private DataBase db;
    private List<Mezzi> mezzi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mezzi, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());

        mezzi = db.getMezzi();

        ListView listView = view.findViewById(R.id.lv_mezzi);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mezzi.size();
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
            convertView = getLayoutInflater().inflate(R.layout.item_mezzi, null);

            TextView tvQuantita = convertView.findViewById(R.id.tv_quantitaMezzi);
            tvQuantita.setText(mezzi.get(position).getQuantita());

            TextView tvTipologia = convertView.findViewById(R.id.tv_tipologiaMezzi);
            tvTipologia.setText(mezzi.get(position).getTipologia());

            TextView tvLoc = convertView.findViewById(R.id.tv_locMezzi);
            tvLoc.setText(mezzi.get(position).getLocazione());

            TextView tvDisp = convertView.findViewById(R.id.tv_dispMezzi);
            tvDisp.setText(mezzi.get(position).getDisponibilita());

            TextView tvTarga = convertView.findViewById(R.id.tv_targaMezzi);
            tvTarga.setText(mezzi.get(position).getTarga());



            return convertView;
        }
    }
}
