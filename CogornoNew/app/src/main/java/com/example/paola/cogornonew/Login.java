package com.example.paola.cogornonew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Button login;
    private DataBase db;
    private Sessione sessione;
    private EditText etUsername;
    private EditText etPassword;
    private PopolaDB popolaDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        login = (Button) findViewById(R.id.btnLogin);
        sessione = new Sessione(this);
        etUsername = (EditText) findViewById(R.id.editUsernameLogin);
        etPassword = (EditText) findViewById(R.id.editPasswordLogin);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        db = new DataBase(this);

        login.setOnClickListener((View.OnClickListener) this);
        if(sessione.loggedIn()){
            makeToast("sei già loggato");
            goToMainActivity();
            finish();
        }

        popolaDB = new PopolaDB(db);
        popolaDB.Popola();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        Log.d("on back", "login");
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_home:
                goToMainActivity();
                break;
            case R.id.nav_registrati:
                goToRegistrati();
                finish();
                break;
            case R.id.nav_login:
                if(sessione.loggedIn()) {
                    item.setTitle("Logout");
                    Log.d("cambiomenu", "in logout");
                }else {
                    goToLogin();
                    finish();
                }
                break;

            case R.id.nav_dat_di_base:
                break;

            case R.id.nav_risorse:
                break;

            case R.id.nav_segnaletica:
                break;

            case R.id.nav_scenari:
                break;

            case R.id.nav_schede:
                break;

            case R.id.nav_chat:
                break;

            case R.id.nav_mail:
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

        Intent intent_home = new Intent(Login.this, MainActivity.class);
        startActivity(intent_home);
    }

    public void goToLogin(){
        Intent intent_login = new Intent(Login.this, Login.class);
        startActivity(intent_login);
    }

    public void goToRegistrati(){
        Intent intent_registrati = new Intent(Login.this, Registrati.class);
        startActivity(intent_registrati);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnLogin){
            Log.d("valori: ", etUsername.getText().toString() + etPassword.getText().toString());
            login();
            makeToast("login avvenuto con successo");
            popolaDB = new PopolaDB(db);
        }
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(db.getUtente(username, password)){
            sessione.setLoggedIn(true);
            goToMainActivity();
            finish();
        }else{
            makeToast("username e/o password non validi");
        }
    }

    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
