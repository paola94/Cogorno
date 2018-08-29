package com.example.paola.cogornonew;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Sessione sessione;
    private EditText mEditTextTo, mEditTextSubject, mEditTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
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
        if(sessione.loggedIn()){
            item.setTitle("Logout");
        }else{
            item.setTitle("Login");
        }
        navigationView.setNavigationItemSelectedListener(this);

        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        Button button = findViewById(R.id.btn_inviaMail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String destinatariList = mEditTextTo.getText().toString();
        String[] destinatari = destinatariList.split(";");

        String oggetto = mEditTextSubject.getText().toString();
        String messaggio = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, destinatari);
        intent.putExtra(Intent.EXTRA_SUBJECT, oggetto);
        intent.putExtra(Intent.EXTRA_TEXT, messaggio);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Scegli un'applicazione"));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        Intent intent_home = new Intent(Email.this, MainActivity.class);
        startActivity(intent_home);
    }

    public void goToLogin(){
        Intent intent_login = new Intent(Email.this, Login.class);
        startActivity(intent_login);
    }

    public void goToRegistrati(){
        Intent intent_registrati = new Intent(Email.this, Registrati.class);
        startActivity(intent_registrati);
    }

    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
