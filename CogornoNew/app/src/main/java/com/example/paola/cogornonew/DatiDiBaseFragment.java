package com.example.paola.cogornonew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DatiDiBaseFragment extends Fragment implements View.OnClickListener {

    private Button btn_generalita, btn_datiGeografici, btn_accessi, btn_scuole, btn_culto, btn_disabili, btn_viabilita, btn_cartografia;
    private DataBase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dati, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = new DataBase(getContext());



        btn_generalita = view.findViewById(R.id.btn_generalita);
        btn_generalita.setOnClickListener(this);

        btn_datiGeografici = view.findViewById(R.id.btn_datiGeografici);
        btn_datiGeografici.setOnClickListener(this);

        btn_accessi = view.findViewById(R.id.btn_accessi);
        btn_accessi.setOnClickListener(this);

        btn_scuole = view.findViewById(R.id.btn_scuole);
        btn_scuole.setOnClickListener(this);

        btn_culto = view.findViewById(R.id.btn_culto);
        btn_culto.setOnClickListener(this);

        btn_disabili = view.findViewById(R.id.btn_disabili);
        btn_disabili.setOnClickListener(this);

        btn_viabilita = view.findViewById(R.id.btn_viabilita);
        btn_viabilita.setOnClickListener(this);

        btn_cartografia = view.findViewById(R.id.btn_cartografia);
        btn_cartografia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        Bundle args;
        switch (v.getId()){
            case R.id.btn_generalita:
                fragment = new Generalita();
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_datiGeografici:
                fragment = new DatiGeografici();
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_cartografia:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "2.3cartografiaDisponibile.pdf");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn_viabilita:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "2.4Viabilita.pdf");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_accessi:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "cap.2Accessi.pdf");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_scuole:
                fragment = new Filtra();
                args = new Bundle();
                args.putString("titoloPagina", btn_scuole.getText().toString());
                args.putString("tipoStruttura","scuola");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                //Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_culto:
                fragment = new Filtra();
                args = new Bundle();
                args.putString("titoloPagina", btn_culto.getText().toString());
                args.putString("tipoStruttura", "culto");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                //Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_disabili:
                fragment = new MostraPDF();
                args = new Bundle();
                args.putString("nomePDF", "cap.2Disabili.pdf");
                fragment.setArguments(args);
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.addToBackStack("myscreen");
                    ft.commit();
                }
                //Toast.makeText(getActivity(), "dentro dati di base fragment", Toast.LENGTH_SHORT).show();
                break;


        }
    }
}
