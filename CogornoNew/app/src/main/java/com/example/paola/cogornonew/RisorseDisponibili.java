package com.example.paola.cogornonew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

public class RisorseDisponibili extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Sessione sessione;

    private KillReceiver clearActivityStack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risorse_disponibili);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_login);

        sessione = new Sessione(this);
        if(sessione.loggedIn()) {
            item.setTitle("Logout");
            Log.d("cambiomenu", "in logout");
        }else {
            item.setTitle("Login");
        }
        navigationView.setNavigationItemSelectedListener(this);


        clearActivityStack = new KillReceiver();
        registerReceiver(clearActivityStack, IntentFilter.create("clearStackActivity", "text/plain"));

        Fragment fragment = new RisorseDisponibiliFragment();
        if(savedInstanceState == null) {

            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.containerRisorse, fragment);
                ft.commit();
            }
        }

    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        Log.d("count ", "vale" + count);

        if (count == 0){
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
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
                if (item.getTitle().equals("Logout")) {
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

                    Log.d("logout", "in logout");
                } else if (item.getTitle().equals("Login")) {
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

    public void goToMainActivity(){
        Intent intent = new Intent("clearStackActivity");
        intent.setType("text/plain");
        sendBroadcast(intent);

        Intent intent_home = new Intent(RisorseDisponibili.this, MainActivity.class);
        startActivity(intent_home);
    }

    public void goToLogin(){
        Intent intent_login = new Intent(RisorseDisponibili.this, Login.class);
        startActivity(intent_login);
    }

    public void goToRegistrati(){
        Intent intent_registrati = new Intent(RisorseDisponibili.this, Registrati.class);
        startActivity(intent_registrati);
    }

    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void goToDatiDiBase(){
        Intent intent = new Intent(RisorseDisponibili.this, DatiDiBase.class );
        startActivity(intent);
    }

    public void goToSchede(){
        Intent intent = new Intent(RisorseDisponibili.this, Schede.class);
        startActivity(intent);
    }

    public void goToRisorse(){
        Intent intent = new Intent(RisorseDisponibili.this, RisorseDisponibili.class);
        startActivity(intent);
    }

    public void goToSegnaletica(){
        Intent intent =  new Intent(RisorseDisponibili.this, SegnaleticaEAreeEmergenza.class);
        startActivity(intent);
    }

    public void goToScenari(){
        Intent intent =  new Intent(RisorseDisponibili.this, ScenariEModelli.class);
        startActivity(intent);
    }

    public void goToEmail(){
        Intent intent = new Intent(RisorseDisponibili.this, Email.class);
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
