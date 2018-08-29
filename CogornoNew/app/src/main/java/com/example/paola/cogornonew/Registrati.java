package com.example.paola.cogornonew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrati extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener, View.OnClickListener,  TextWatcher {

    private EditText nomeUtente;
    private EditText cognomeUtente;
    private Spinner ruoloUtente;
    private EditText usernameUtente;
    private EditText passwordUtente;
    private EditText confermaUtente;
    private Button inviaReg;
    private String ruolo;
    private DataBase db;

    private String Nome;
    private String Cognome;
    private static final String NOME_REGEX = "^([a-zA-Z\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]\\s?)+$";

    private String Username;
    private static final String USERNAME_REGEX = "^[0-9A-Za-z ]{3,200}$";

    private String Password;
    private String Conferma;
    private static final String PASSWORD_REGEX = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}";

    private Sessione sessione;

    private KillReceiver clearActivityStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ruoloUtente = (Spinner) findViewById(R.id.spinnerRuolo);
        // create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.scelta, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ruoloUtente.setAdapter(adapter);
        ruoloUtente.setOnItemSelectedListener(this);

        nomeUtente = (EditText) findViewById(R.id.editNome);
        cognomeUtente = (EditText) findViewById(R.id.editCognome);
        usernameUtente = (EditText) findViewById(R.id.editUsernameLogin);
        passwordUtente = (EditText) findViewById(R.id.editPassword);
        confermaUtente = (EditText) findViewById(R.id.editConferma);
        inviaReg = (Button) findViewById(R.id.buttonInvia);

        inviaReg.setOnClickListener(this);
        sessione = new Sessione(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_login);

        if(sessione.loggedIn()) {
            item.setTitle("Logout");
            Log.d("cambiomenu", "in logout");
        }else {
            item.setTitle("Login");
        }

        clearActivityStack = new KillReceiver();
        registerReceiver(clearActivityStack, IntentFilter.create("clearStackActivity", "text/plain"));

        navigationView.setNavigationItemSelectedListener(this);

        db = new DataBase(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        Log.d("on back", "registrati");
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
        switch (id) {
            case R.id.nav_home:
                goToMainActivity();
                break;

            case R.id.nav_registrati:
                goToRegistrati();
                finish();
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
                                    item.setTitle("Login");
                                    goToMainActivity();
                                    finish();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // in this way I can take what the user chose
        parent.getItemAtPosition(pos);
        final int prova = Log.d("ruolo", parent.getItemAtPosition(pos).toString());
        ruolo = (String) parent.getItemAtPosition(pos);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonInvia:
                Nome = nomeUtente.getText().toString();
                Cognome = cognomeUtente.getText().toString();
                Username = usernameUtente.getText().toString();
                Password = passwordUtente.getText().toString();
                Conferma = confermaUtente.getText().toString();

                if(!Nome.matches(NOME_REGEX)){
                    nomeUtente.setError("nome utente non valido, inserire solo caratteri");
                } else if(!Cognome.matches(NOME_REGEX)){
                    cognomeUtente.setError("cognome non valido, inserire solo caratteri");
                } else if(!Username.matches(USERNAME_REGEX)){
                    usernameUtente.setError("username non valido. Sono consentiti solo caratteri e numeri");
                } else if(!Password.matches(PASSWORD_REGEX)){
                    passwordUtente.setError("La password deve avere una lunghezza minima di 6 caratteri, contenere almeno una maiuscola ed almeno un numero");
                } else if(!Conferma.equals(Password)){
                    confermaUtente.setError("Le password non corrispondono");
                } else {
                    Utente utente = new Utente(Nome, Cognome, ruolo, Username, Password);
                    if (db.checkInUtenti(utente)) {
                        makeToast("utente già esistente");
                        goToRegistrati();
                        finish();
                    } else {

                        UtenteAut utenteAut = new UtenteAut(Nome, Cognome, ruolo);
                        // se non esiste in Utente controllo che sia tra quelli autorizzati a iscriversi
                        if (db.checkInUtentiAut(utenteAut)) {
                            makeToast("utente autorizzato");
                            // se è autorizzato inserisco l'utente nel database
                            long update = db.inserisciUtente(utente);
                            Log.d("update", "vale" + update);
                            if (update > 0) {
                                makeToast("utente creato");
                                goToMainActivity();
                                finish();
                            }
                            // se l'utente non è autorizzato invio un messaggio per comunicarlo e ripresento il form di registrazione
                        } else {
                            makeToast("utente non autorizzato");
                            goToRegistrati();
                            finish();
                        }
                    }
                }
        }
    }

    public void goToMainActivity(){
        Intent intent = new Intent("clearStackActivity");
        intent.setType("text/plain");
        sendBroadcast(intent);

        Intent intent_home = new Intent(Registrati.this, MainActivity.class);
        startActivity(intent_home);
    }

    public void goToLogin(){
        Intent intent_login = new Intent(Registrati.this, Login.class);
        startActivity(intent_login);
    }

    public void goToRegistrati(){
        Intent intent_registrati = new Intent(Registrati.this, Registrati.class);
        startActivity(intent_registrati);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("dentro onextChanged", "sono qui");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void goToDatiDiBase(){
        Intent intent = new Intent(Registrati.this, DatiDiBase.class );
        startActivity(intent);
    }

    public void goToSchede(){
        Intent intent = new Intent(Registrati.this, Schede.class);
        startActivity(intent);
    }

    public void goToRisorse(){
        Intent intent = new Intent(Registrati.this, RisorseDisponibili.class);
        startActivity(intent);
    }

    public void goToSegnaletica(){
        Intent intent =  new Intent(Registrati.this, SegnaleticaEAreeEmergenza.class);
        startActivity(intent);
    }

    public void goToScenari(){
        Intent intent =  new Intent(Registrati.this, ScenariEModelli.class);
        startActivity(intent);
    }

    public void goToEmail(){
        Intent intent = new Intent(Registrati.this, Email.class);
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

    private final class KillReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    }
}
