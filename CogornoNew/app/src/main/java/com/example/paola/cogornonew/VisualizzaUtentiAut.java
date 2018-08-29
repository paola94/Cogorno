package com.example.paola.cogornonew;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.Boolean.FALSE;

public class VisualizzaUtentiAut extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private String tipo;
    private ListView lv_utentiAut;
    private List<UtenteAut> utentiAut;
    private DataBase db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            tipo = getArguments().getString("tipo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visualizza_utenti_aut, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv_utentiAut = view.findViewById(R.id.list_utentiAut);
        db = new DataBase(getContext());
        utentiAut = db.getUtentiAut();

        CustomAdapter customAdapter = new CustomAdapter();
        lv_utentiAut.setAdapter(customAdapter);
        if (tipo.equals("elimina")) {
            lv_utentiAut.setOnItemClickListener(this);
        }else{
            lv_utentiAut.setClickable(FALSE);
        }



    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(tipo.equals("elimina")){
            final UtenteAut utenteAut = new UtenteAut(utentiAut.get(position). getNome_utenteAut(),utentiAut.get(position).getCognome_utenteAut(),utentiAut.get(position).getRuolo_utenteAut());
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Attenzione")
                    .setMessage("Vuoi eliminare " + utenteAut.getCognome_utenteAut() + " " + utenteAut.getNome_utenteAut() +
                    " " + utenteAut.getRuolo_utenteAut() + "?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // funzione di elimina nel db
                            int elimina = db.cancellaUtenteAut(utenteAut);
                            if(elimina > 0){
                                Toast.makeText(getContext(),"Eliminazione avvenuta con successo", Toast.LENGTH_SHORT).show();
                                Fragment fragment = new VisualizzaUtentiAut();
                                Bundle args = new Bundle();
                                args.putString("tipo", "elimina");
                                fragment.setArguments(args);
                                if (fragment != null) {
                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction ft = fragmentManager.beginTransaction();
                                    ft.replace(R.id.containerAmministratore, fragment);
                                    ft.addToBackStack("myscreen");
                                    ft.commit();
                                }
                            }
                        }
                    })
                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(R.drawable.danger)
                    .show();
        }

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return utentiAut.size();
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
            convertView = getLayoutInflater().inflate(R.layout.item_utente_aut, null);
            TextView tv_cognome, tv_nome, tv_funzione;
            ImageView cestino = convertView.findViewById(R.id.imageView3);
            tv_cognome = convertView.findViewById(R.id.tv_cognomeUtenteAut);
            tv_cognome.setText(utentiAut.get(position).getCognome_utenteAut());

            tv_nome = convertView.findViewById(R.id.tv_nomeUtenteAut);
            tv_nome.setText(utentiAut.get(position).getNome_utenteAut());

            tv_funzione = convertView.findViewById(R.id.tv_funzioneUtenteAut);
            tv_funzione.setText(utentiAut.get(position).getRuolo_utenteAut());

            if(tipo.equals("visualizza")){
                cestino.setVisibility(View.INVISIBLE);
            }else{
                cestino.setVisibility(View.VISIBLE);
            }
            return convertView;
        }
    }
}
