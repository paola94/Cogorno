package com.example.paola.cogornonew;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    Button btn_registrati, btn_login, btn_amministratore;
    Button btnDatiDiBase, btnSchede, btnRisorse, btnSegnaletica, btnScenari;
    Button btnMail, btnChat;
    private DataBase db;


    private Sessione sessione;

    private KillReceiver clearActivityStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_login);

        sessione = new Sessione(this);
        if(sessione.loggedIn()) {
            item.setTitle("Logout");
            Log.d("cambiomenu", "in logout");
        }else {
            item.setTitle("Login");
        }
        navigationView.setNavigationItemSelectedListener(this);
        db = new DataBase(this);

        Utente utenteAmm = new Utente("admin","password","amministratore","admin", "password");

        db.inserisciUtente(utenteAmm);



        /*int count = 0;
        if (count == 0){
            popolaDB.Popola();
            count = 1;
        }*/




        sessione = new Sessione(this);

        // btn_registrati
        btn_registrati = (Button) findViewById(R.id.btn_registrati);
        btn_registrati.setOnClickListener((View.OnClickListener) this);

        // btn_login
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        // btn_amministratore
        btn_amministratore = findViewById(R.id.btn_amministratore);
        btn_amministratore.setOnClickListener(this);

        // btnDatiDiBase
        btnDatiDiBase = (Button) findViewById(R.id.btn_datiDiBase);
        btnDatiDiBase.setOnClickListener(this);

        // btnSchedeDiAutoProtezione
        btnSchede = findViewById(R.id.btn_schede);
        btnSchede.setOnClickListener(this);

        // btnRisorse
        btnRisorse = findViewById(R.id.btn_risorse);
        btnRisorse.setOnClickListener(this);

        // btnSegnaletica
        btnSegnaletica = findViewById(R.id.btn_segnaletica);
        btnSegnaletica.setOnClickListener(this);

        // btnScenari
        btnScenari = findViewById(R.id.btn_scenari);
        btnScenari.setOnClickListener(this);

        // btnMail
        btnMail = findViewById(R.id.btn_email);
        btnMail.setOnClickListener(this);

        // btnChat
        btnChat = findViewById(R.id.btn_chat);
        btnChat.setOnClickListener(this);

        if(sessione.loggedIn()){
            //makeToast("sei già loggato");
            btn_login.setText("LOGOUT");
        }




        clearActivityStack = new KillReceiver();
        registerReceiver(clearActivityStack, IntentFilter.create("clearStackActivity", "text/plain"));
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        Log.d("on back", "mainActivity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_home:
                Intent intent_home = new Intent (MainActivity.this, MainActivity.class);
                intent_home.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent_home);
                break;

            case R.id.nav_registrati:
                goToRegistrati();
                break;

            case R.id.nav_login:
                if(item.getTitle().equals("Logout")) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Vuoi uscire?")
                            .setMessage("Sei sicuro di voler effettuare il logout?")
                            .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    sessione.setLoggedIn(false);
                                    makeToast("non sei più loggato");
                                    btn_login.setText("Login");
                                    item.setTitle("Login");
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                            .show();


                    //Intent intent_login = new Intent(MainActivity.this, MainActivity.class);
                    //startActivity(intent_login);
                    //finish();
                    Log.d("logout", "in logout");
                }else if(item.getTitle().equals("Login")) {
                    goToLogin();
                    finish();
                }
                break;

            case R.id.nav_dat_di_base:
                if(sessione.loggedIn()){
                    goToDatiDiBase();
                } else {
                   makeDialog();
                }

                break;

            case R.id.nav_risorse:
                if(sessione.loggedIn()){
                    goToRisorse();
                } else {
                    makeDialog();
                }
                break;

            case R.id.nav_segnaletica:
                if(sessione.loggedIn()){
                    goToSegnaletica();
                }else{
                    makeDialog();
                }
                break;

            case R.id.nav_scenari:
                if(sessione.loggedIn()){
                    goToScenari();
                }else{
                    makeDialog();
                }
                break;

            case R.id.nav_schede:
                if(sessione.loggedIn()){
                    goToSchede();
                }else{
                    makeDialog();
                }
                break;

            case R.id.nav_chat:
                if(sessione.loggedIn()){
                    goToChat();
                }else{
                    makeDialog();
                }
                break;

            case R.id.nav_mail:
                if(sessione.loggedIn()){
                    goToEmail();
                }else{
                    makeDialog();
                }
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.btn_registrati:
                goToRegistrati();
                break;

            case R.id.btn_login:
                if(btn_login.getText().equals("Login")) {
                    goToLogin();
                }else if(btn_login.getText().equals("LOGOUT")){
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(this);
                    builder.setTitle("Vuoi uscire?")
                            .setMessage("Sei sicuro di voler effettuare il logout?")
                            .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    sessione.setLoggedIn(false);
                                    makeToast("non sei più loggato");
                                    btn_login.setText("Login");
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                            .show();

                }
                break;

            case R.id.btn_amministratore:
                goToAmministratore();
                break;

            case R.id.btn_datiDiBase:
                if(sessione.loggedIn()){
                    Log.d("tag: ", "clicco dati di base");
                    goToDatiDiBase();
                } else {
                    makeDialog();
                }

                break;

            default:
                break;

            case R.id.btn_risorse:
                if(sessione.loggedIn()){
                    goToRisorse();
                } else {
                    makeDialog();
                }
                break;

            case R.id.btn_segnaletica:
                if(sessione.loggedIn()){
                    goToSegnaletica();
                }else{
                    makeDialog();
                }

                break;

            case R.id.btn_scenari:
                if(sessione.loggedIn()){
                    goToScenari();
                }else{
                    makeDialog();
                }
                break;

            case R.id.btn_schede:
                if(sessione.loggedIn()){
                    goToSchede();
                }else{
                    makeDialog();
                }
                break;

            case R.id.btn_email:
                if(sessione.loggedIn()){
                    goToEmail();
                }else{
                    makeDialog();
                }
                break;

            case R.id.btn_chat:
                if(sessione.loggedIn()){
                    goToChat();
                }else{
                    makeDialog();
                }
                break;
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }

    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void goToLogin(){
        Intent intent_login = new Intent(MainActivity.this, Login.class);
        startActivity(intent_login);
    }

    public void goToRegistrati(){
        Intent intent_registrati = new Intent(MainActivity.this, Registrati.class);
        startActivity(intent_registrati);
    }

    public void goToAmministratore(){
        Intent intent = new Intent(MainActivity.this, Amministratore.class);
        startActivity(intent);
    }

    public void goToDatiDiBase(){
        Intent intent = new Intent(MainActivity.this, DatiDiBase.class );
        startActivity(intent);
    }

    public void goToSchede(){
        Intent intent = new Intent(MainActivity.this, Schede.class);
        startActivity(intent);
    }

    public void goToRisorse(){
        Intent intent = new Intent(MainActivity.this, RisorseDisponibili.class);
        startActivity(intent);
    }

    public void goToSegnaletica(){
        Intent intent =  new Intent(MainActivity.this, SegnaleticaEAreeEmergenza.class);
        startActivity(intent);
    }

    public void goToScenari(){
        Intent intent =  new Intent(MainActivity.this, ScenariEModelli.class);
        startActivity(intent);
    }

    public void goToEmail(){
        Intent intent = new Intent(MainActivity.this, Email.class);
        startActivity(intent);
    }

    public void goToChat(){
        final String appName = "org.telegram.messenger";
        final boolean isAppInstalled = isAppAvailable(getApplicationContext(), appName);
        if(isAppInstalled){
            Intent telegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/"));
            startActivity(telegram);
            /*
              Se si vuole scrivere un messaggio direttamente nell'app da mandare su telegram
              Intent intent = new Intent(Intent.ACTION_VIEW);
              intent.setType("text/plain");
              intent.setPackage(appName);
              intent.putExtra(Intent.EXTRA_TEXT, msg);
              startActivity(Intent.createChooser(intent, "Scegli un'applicazione"));*/
        }else{
            makeToast("Telegram non installato");
        }
    }

    public static boolean isAppAvailable(Context context, String appName){
        PackageManager packageManager = context.getPackageManager();
        try{
            packageManager.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
            return true;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }

    private void makeDialog(){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Attenzione")
                .setMessage("Per eseguire l'operazione effettua il login o registrati")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(R.drawable.danger)
                .show();
    }

    private final class KillReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    }
}
