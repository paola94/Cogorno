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

import java.sql.DatabaseMetaData;
import java.util.List;

public class MaterialiFragment extends Fragment {

    private DataBase db;
    private List<Materiali> materialiList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_materiali, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());

        materialiList = db.getMateriali();

        ListView listView = view.findViewById(R.id.lv_materiali);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return materialiList.size();
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
            convertView = getLayoutInflater().inflate(R.layout.item_materiali, null);
            Materiali materiali = materialiList.get(position);

            TextView tvQuantita = convertView.findViewById(R.id.tv_quantitaMateriali);
            tvQuantita.setText(materiali.getQuantita());

            TextView tvGenere = convertView.findViewById(R.id.tv_genereMateriali);
            tvGenere.setText(materiali.getGenere());

            TextView tvLoc = convertView.findViewById(R.id.tv_locMateriali);
            tvLoc.setText(materiali.getLocazione());

            TextView tvDisp = convertView.findViewById(R.id.tv_dispMateriali);
            tvDisp.setText(materiali.getDisponibilita());


            return convertView;
        }
    }
}
