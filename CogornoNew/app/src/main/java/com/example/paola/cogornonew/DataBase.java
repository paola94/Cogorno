package com.example.paola.cogornonew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String DB_NAME = "db.db";
    private static final int DB_VERSION = 1;

    // creo la tabella degli utenti
    private static final String UTENTI_TABLE = "utenti";
    private static final String UTENTI_ID = "id_utente";
    private static final int UTENTI_ID_COL = 0;
    private static final String UTENTI_NOME = "nome_utente";
    private static final int UTENTI_NOME_COL = 1;
    private static final String UTENTI_COGNOME = "cognome_utente";
    private static final int UTENTI_COGNOME_COL = 2;
    private static final String UTENTI_RUOLO = "ruolo_utente";
    private static final int UTENTI_RUOLO_COL = 3;
    private static final String UTENTI_USERNAME = "username_utente";
    private static final int UTENTI_USERNAME_COL = 4;
    private static final String UTENTI_PASSWORD = "password_utente";
    private static final int UTENTI_PASSWORD_COL = 5;


    // creo la tabella degli utenti_autorizzati
    private static final String UTENTI_AUT_TABLE = "utenti_autorizzati";
    private static final String UTENTI_AUT_ID = "id_utenteAut";
    private static final int UTENTI_AUT_ID_COL = 0;
    private static final String UTENTI_AUT_NOME = "nome_utenteAut";
    private static final int UTENTI_AUT_NOME_COL = 1;
    private static final String UTENTI_AUT_COGNOME = "cognome_utenteAut";
    private static final int UTENTI_AUT_COGNOME_COL = 2;
    private static final String UTENTI_AUT_RUOLO = "ruolo_utenteAut";
    private static final int UTENTI_AUT_RUOLO_COL = 3;

    // creo tabella struttura
    private static final String STRUTTURA_TABLE = "struttura";
    private static final String STRUTTURA_ID = "id_struttura";
    private static final int STRUTTURA_ID_COL = 0;
    private static final String STRUTTURA_NOME = "nome_struttura";
    private static final int STRUTTURA_NOME_COL = 1;
    private static final String STRUTTURA_IDVIE = "idVie_struttura";
    private static final int STRUTTURA_IDVIE_COL = 2;
    private static final String STRUTTURA_IDCOMUNE = "idComune_struttura";
    private static final int STRUTTURA_IDCOMUNE_COL = 3;
    private static final String STRUTTURA_TIPO = "tipo_struttura";
    private static final int STRUTTURA_TIPO_COL = 4;

    // creo tabella contatti
    private static final String CONTATTI_TABLE = "contatti";
    private static final String CONTATTI_ID = "id_contatti";
    private static final int CONTATTI_ID_COL = 0;
    private static final String CONTATTI_IDSTRUTTURA = "idStruttura_contatti";
    private static final int CONTATTI_IDSTRUTTURA_COL = 1;
    private static final String CONTATTI_NOME = "nome_contatti";
    private static final int CONTATTI_NOME_COL = 2;
    private static final String CONTATTI_COGNOME = "cognome_contatti";
    private static final int CONTATTI_COGNOME_COL = 3;
    private static final String CONTATTI_TIPO = "tipo_contatti";
    private static final int CONTATTI_TIPO_COL = 4;
    private static final String CONTATTI_VALORE = "valore_contatti";
    private static final int CONTATTI_VALORE_COL = 5;

    // creo tabella popolazione
    private static final String POPOLAZIONE_TABLE = "popolazione";
    private static final String POPOLAZIONE_ID = "id_popolazione";
    private static final int POPOLAZIONE_ID_COL = 0;
    private static final String POPOLAZIONE_IDSTRUTTURA = "idStruttura_popolazione";
    private static final int POPOLAZIONE_IDSTRUTTURA_COL = 1;
    private static final String POPOLAZIONE_TIPO = "tipo_popolazione";
    private static final int POPOLAZIONE_TIPO_COL = 2;
    private static final String POPOLAZIONE_QUANTITA = "quantita_popolazione";
    private static final int POPOLAZIONE_QUANTITA_COL = 3;
    private static final String POPOLAZIONE_INTESTAZIONE = "intestazione_popolazione";
    private static final int POPOLAZIONE_INTESTAZIONE_COL = 4;


    // creo tabella sedeComunale
    private static final String SEDECOMUNE_TABLE = "sedeComune";
    private static final String SEDECOMUNE_ID = "id_sedeComune";
    private static final int SEDECOMUNE_ID_COL = 0;
    private static final String SEDECOMUNE_IDSTRUTTURA = "idStruttura_sedeComune";
    private static final int SEDECOMUNE_IDSTRUTTURA_COL = 1;
    private static final String SEDECOMUNE_ALTITUDINE = "altitudine_sedeComune";
    private static final int SEDECOMUNE_ALTITUDINE_COl = 2;
    private static final String SEDECOMUNE_LATITUDINE_SESS = "latitudineSess_sedeComune";
    private static final int SEDECOMUNE_LATITUDINE_COL = 3;
    private static final String SEDECOMUNE_LONGITUDINE_SESS = "longitudineSess_sedeComune";
    private static final int SEDECOMUNE_LONGITUDINE_COL = 4;
    private static final String SEDECOMUNE_LATITUDINE_DEC = "latitudineDec_sedeComune";
    private static final int SEDECOMUNE_LATITUDINE_DEC_COL = 5;
    private static final String SEDECOMUNE_LONGITUDINE_DEC = "longitudineDec_sedeComune";
    private static final int SEDECOMUNE_LONGITUDINE_DEC_COL = 6;

    // creo tabella comune
    private static final String COMUNE_TABLE = "comune";
    private static final String COMUNE_ID = "id_comune";
    private static final int COMUNE_ID_COL = 0;
    private static final String COMUNE_NOME = "nome_comune";
    private static final int COMUNE_NOME_COL = 1;


    // creo tabella vie
    private static final String VIE_TABLE = "vie";
    private static final String VIE_ID = "id_vie";
    private static final int VIE_ID_COL = 0;
    private static final String VIE_NOME = "nome_vie";
    private static final int VIE_NOME_COL = 1;
    private static final String VIE_IDCOMUNE = "idComune_vie";
    private static final int VIE_IDCOMUNE_COL = 2;

    // creo tabella personale
    private static final String PERSONALE_TABLE = "personale";
    private static final String PERSONALE_ID = "id_personale";
    private static final int PERSONALE_ID_COL = 0;
    private static final String PERSONALE_NOME = "nome_personale";
    private static final int PERSONALE_NOME_COL = 1;
    private static final String PERSONALE_COGNOME = "cognome_personale";
    private static final int PERSONALE_COGNOME_COL = 2;
    private static final String PERSONALE_FUNZIONE = "funzione_personale";
    private static final int PERSONALE_FUNZIONE_COL = 3;
    private static final String PERSONALE_RESIDENZA = "residenza_personale";
    private static final int PERSONALE_RESIDENZA_COL = 4;
    private static final String PERSONALE_TELEFONO = "telefono_personale";
    private static final int PERSONALE_TELEFONO_COL = 5;
    private static final String PERSONALE_TITOLO = "titolo_personale";
    private static final int PERSONALE_TITOLO_COL = 6;

    // creo tabella mezzi
    private static final String MEZZI_TABLE = "mezzi";
    private static final String MEZZI_ID = "id_mezzo";
    private static final int MEZZI_ID_COL = 0;
    private static final String MEZZI_QUANTITA = "quantita_mezzo";
    private static final int MEZZI_QUANTITA_COL = 1;
    private static final String MEZZI_TIPOLOGIA = "tipologia_mezzo";
    private static final int MEZZI_TIPOLOGIA_COL = 2;
    private static final String MEZZI_LOCAZIONE = "locazione_mezzo";
    private static final int MEZZI_LOCAZIONE_COL = 3;
    private static final String MEZZI_DISPONIBILITA = "disponibilita_mezzo";
    private static final int MEZZI_DISPONIBILITA_COL = 4;
    private static final String MEZZI_TARGA = "targa_mezzo";
    private static final int MEZZI_TARGA_COL = 5;
    private static final String MEZZI_PROPRIETARIO = "proprietario_mezzo";
    private static final int MEZZI_PROPRIETARIO_COL = 6;

    // creo tabella materiali
    private static final String MATERIALI_TABLE = "materiali";
    private static final String MATERIALI_ID = "id_materiale";
    private static final int MATERIALI_ID_COL = 0;
    private static final String MATERIALI_QUANTITA = "quantita_materiale";
    private static final int MATERIALI_QUANTITA_COL = 1;
    private static final String MATERIALI_GENERE = "genere_materiale";
    private static final int MATERIALI_GENERE_COL = 2;
    private static final String MATERIALI_LOCAZIONE = "locazione_materiale";
    private static final int MATERIALI_LOCAZIONE_COL = 3;
    private static final String MATERIALI_DISPONIBILITA = "disponibilita_materiale";
    private static final int MATERIALE_DISPONIBILITA_COL = 4;

    // creo tabella cartelli
    private static final String CARTELLI_TABLE = "cartelli";
    private static final String CARTELLI_ID = "id_cartello";
    private static final int CARTELLI_ID_COL = 0;
    private static final String CARTELLI_QUANTITA = "quantita_cartello";
    private static final int CARTELLI_QUANTITA_COL = 1;
    private static final String CARTELLI_LOCAZIONE = "locazione_cartello";
    private static final int CARTELLI_LOCAZIONE_COL = 2;

    private static final String CREATE_UTENTI_TABLE =
            "CREATE TABLE " + UTENTI_TABLE + " (" + UTENTI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    UTENTI_NOME + " TEXT NOT NULL, " +
                    UTENTI_COGNOME + " TEXT NOT NULL, " +
                    UTENTI_RUOLO + " TEXT NOT NULL, " +
                    UTENTI_USERNAME + " TEXT NOT NULL, " +
                    UTENTI_PASSWORD + " TEXT NOT NULL );";

    private static final String CREATE_UTENTI_AUT_TABLE =
            "CREATE TABLE " + UTENTI_AUT_TABLE + " (" + UTENTI_AUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    UTENTI_AUT_NOME + " TEXT NOT NULL, " +
                    UTENTI_AUT_COGNOME + " TEXT NOT NULL, " +
                    UTENTI_AUT_RUOLO + " TEXT NOT NULL ); ";

    private static final String CREATE_STRUTTURA_TABLE =
            "CREATE TABLE " + STRUTTURA_TABLE + " (" + STRUTTURA_ID + " INTEGER PRIMARY KEY, " +
                    STRUTTURA_NOME + " TEXT NOT NULL, " +
                    STRUTTURA_IDVIE + " INTEGER NOT NULL, " +
                    STRUTTURA_IDCOMUNE + " INTEGER NOT NULL, " +
                    STRUTTURA_TIPO + " TEXT NOT NULL ); ";

    private static final String CREATE_CONTATTI_TABLE =
            "CREATE TABLE " + CONTATTI_TABLE + " (" + CONTATTI_ID + " INTEGER PRIMARY KEY, " +
                    CONTATTI_IDSTRUTTURA + " INTEGER NOT NULL, " +
                    CONTATTI_NOME + " TEXT NOT NULL, " +
                    CONTATTI_COGNOME + " TEXT NOT NULL, " +
                    CONTATTI_TIPO + " TEXT NOT NULL, " +
                    CONTATTI_VALORE + " TEXT NOT NULL );";

    private static final String CREATE_POPOLAZIONE_TABLE =
            "CREATE TABLE " + POPOLAZIONE_TABLE + " (" + POPOLAZIONE_ID + " INTEGER PRIMARY KEY, " +
                    POPOLAZIONE_IDSTRUTTURA + " INTEGER NOT NULL, " +
                    POPOLAZIONE_TIPO + " TEXT NOT NULL, " +
                    POPOLAZIONE_QUANTITA + " INTEGER NOT NULL, " +
                    POPOLAZIONE_INTESTAZIONE + " TEXT NOT NULL ); ";

    private static final String CREATE_COMUNE_TABLE =
            "CREATE TABLE " + COMUNE_TABLE + " (" + COMUNE_ID + " INTEGER PRIMARY KEY, " +
                    COMUNE_NOME + " TEXT NOT NULL );";

    private static final String CREATE_VIE_TABLE =
            "CREATE TABLE " + VIE_TABLE + " (" + VIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    VIE_NOME + " TEXT NOT NULL, " +
                    VIE_IDCOMUNE + " INTEGER NOT NULL );";

    private static final String CREATE_SEDE_COMUNE_TABLE =
            "CREATE TABLE " + SEDECOMUNE_TABLE + " (" + SEDECOMUNE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SEDECOMUNE_IDSTRUTTURA + " INTEGER NOT NULL, " +
                    SEDECOMUNE_ALTITUDINE + " TEXT NOT NULL, " +
                    SEDECOMUNE_LATITUDINE_SESS + " TEXT NOT NULL, " +
                    SEDECOMUNE_LONGITUDINE_SESS + " TEXT NOT NULL, " +
                    SEDECOMUNE_LATITUDINE_DEC + " TEXT NOT NULL, " +
                    SEDECOMUNE_LONGITUDINE_DEC + " TEXT NOT NULL );";

    private static final String CREATE_PERSONALE_TABLE =
            "CREATE TABLE " + PERSONALE_TABLE + " (" + PERSONALE_ID + " INTEGER PRIMARY KEY, " +
                    PERSONALE_NOME + " TEXT NOT NULL, " +
                    PERSONALE_COGNOME + " TEXT NOT NULL, " +
                    PERSONALE_FUNZIONE + " TEXT NOT NULL, " +
                    PERSONALE_RESIDENZA + " TEXT NOT NULL, " +
                    PERSONALE_TELEFONO + " TEXT NOT NULL, " +
                    PERSONALE_TITOLO + " TEXT NOT NULL );";

    private static final String CREATE_MEZZI_TABLE =
            "CREATE TABLE " + MEZZI_TABLE + " (" + MEZZI_ID + " INTEGER PRIMARY KEY, " +
                    MEZZI_QUANTITA + " TEXT NOT NULL, " +
                    MEZZI_TIPOLOGIA + " TEXT NOT NULL, " +
                    MEZZI_LOCAZIONE + " TEXT NOT NULL, " +
                    MEZZI_DISPONIBILITA + " TEXT NOT NULL, " +
                    MEZZI_TARGA + " TEXT NOT NULL, " +
                    MEZZI_PROPRIETARIO + " TEXT NOT NULL );";

    private static final String CREATE_MATERIALI_TABLE =
            "CREATE TABLE " + MATERIALI_TABLE + " (" + MATERIALI_ID + " INTEGER PRIMARY KEY, " +
                    MATERIALI_QUANTITA + " TEXT NOT NULL, " +
                    MATERIALI_GENERE + " TEXT NOT NULL, " +
                    MATERIALI_LOCAZIONE + " TEXT NOT NULL, " +
                    MATERIALI_DISPONIBILITA + " TEXT NOT NULL );";

    private static final String CREATE_CARTELLI_TABLE =
            "CREATE TABLE " + CARTELLI_TABLE + " (" + CARTELLI_ID + " INTEGER PRIMARY KEY, " +
                    CARTELLI_QUANTITA + " TEXT NOT NULL, " +
                    CARTELLI_LOCAZIONE + " TEXT NOT NULL );";

    public static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_UTENTI_TABLE);
            Log.d("creo utenti", "true");
            db.execSQL(CREATE_UTENTI_AUT_TABLE);
            Log.d("creo utenti_aut", "true");
            db.execSQL(CREATE_STRUTTURA_TABLE);
            db.execSQL(CREATE_CONTATTI_TABLE);
            db.execSQL(CREATE_POPOLAZIONE_TABLE);
            db.execSQL(CREATE_COMUNE_TABLE);
            db.execSQL(CREATE_VIE_TABLE);
            db.execSQL(CREATE_SEDE_COMUNE_TABLE);
            db.execSQL(CREATE_PERSONALE_TABLE);
            db.execSQL(CREATE_MEZZI_TABLE);
            db.execSQL(CREATE_MATERIALI_TABLE);
            db.execSQL(CREATE_CARTELLI_TABLE);
            //db.execSQL("INSERT INTO utenti_autorizzati VALUES(1,'Paola','Silvestre','Sindaco')");
            //db.execSQL("INSERT INTO utenti_autorizzati VALUES(2,'Mario','Rossi','Consigliere')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public DataBase(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWritableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null) {
            db.close();
        }
    }

    // funzione che restituisce true se esiste già un utente nel db con nome cognome e ruolo uguali
    // a quelli inseriti dall'utente
    public boolean checkInUtenti(Utente utente) {
        Log.d("database: ", "checkInUtenti");
        String where = UTENTI_NOME + "= ? AND " + UTENTI_COGNOME + "= ? AND " + UTENTI_RUOLO + "= ?";
        Log.d("String where: ", where);
        String[] whereArgs = {utente.getNome_utente().toUpperCase(), utente.getCognome_utente().toUpperCase(), utente.getRuolo_utente().toUpperCase()};
        Log.d("String[] whereArgs", String.valueOf(whereArgs));
        this.openReadableDB();
        Cursor cursor = db.query(UTENTI_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Utente utenti = getUtenteFromCursor(cursor);

        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (utenti != null) {
            Log.d("dentro check", utenti.getNome_utente());
            return true;
        }
        return false;
    }

    private static Utente getUtenteFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Utente utente = new Utente(
                        cursor.getString(UTENTI_NOME_COL),
                        cursor.getString(UTENTI_COGNOME_COL),
                        cursor.getString(UTENTI_RUOLO_COL),
                        cursor.getString(UTENTI_USERNAME_COL),
                        cursor.getString(UTENTI_PASSWORD_COL));
                Log.d("try", "----try");
                return utente;
            } catch (Exception e) {
                Log.d("catch", "----catch");
                return null;
            }
        }
    }

    public boolean checkInUtentiAut(UtenteAut utenteAut) {
        Log.d("database aut: ", "checkInUtentiAut");
        String where = UTENTI_AUT_NOME + "= ? AND " + UTENTI_AUT_COGNOME + "= ? AND " + UTENTI_AUT_RUOLO + "= ?";
        Log.d("String where aut: ", where);
        String[] whereArgs = {utenteAut.getNome_utenteAut().toUpperCase(), utenteAut.getCognome_utenteAut().toUpperCase(), utenteAut.getRuolo_utenteAut().toUpperCase()};
        Log.d("String[] whereArgs aut", String.valueOf(whereArgs));
        this.openReadableDB();
        Cursor cursor = db.query(UTENTI_AUT_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        UtenteAut utentiAut = getUtenteAutFromCursor(cursor);

        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (utentiAut != null) {
            Log.d("dentro check", utentiAut.getNome_utenteAut());
            return true;
        }
        return false;
    }

    public List<UtenteAut> getUtentiAut(){
        this.openReadableDB();
        Cursor cursor = db.query(UTENTI_AUT_TABLE, null, null, null, null, null, null);
        List<UtenteAut> utentiAut = new ArrayList<>();
        while (cursor.moveToNext()) {
            utentiAut.add(getUtenteAutFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return utentiAut;
    }

    public int cancellaUtenteAut(UtenteAut utenteAut){
        String where = UTENTI_AUT_COGNOME + "= ? AND " + UTENTI_AUT_NOME + "= ? AND " + UTENTI_AUT_RUOLO + "= ?";
        String[] whereArgs = {utenteAut.getCognome_utenteAut(), utenteAut.getNome_utenteAut(), utenteAut.getRuolo_utenteAut()};
        this.openWritableDB();
        int row = db.delete(UTENTI_AUT_TABLE, where, whereArgs);
        this.closeDB();
        return row;
    }

    public int cancellaUtente(String nome, String cognome, String ruolo){
        String where = UTENTI_COGNOME + "= ? AND " + UTENTI_NOME + "= ? AND " + UTENTI_RUOLO + "= ?";
        String[] whereArgs = {cognome.toUpperCase(), nome.toUpperCase(), ruolo.toUpperCase()};
        this.openWritableDB();
        int row = db.delete(UTENTI_TABLE, where, whereArgs);
        this.closeDB();
        return row;
    }


    private static UtenteAut getUtenteAutFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                UtenteAut utenteAut = new UtenteAut(
                        cursor.getString(UTENTI_AUT_NOME_COL),
                        cursor.getString(UTENTI_AUT_COGNOME_COL),
                        cursor.getString(UTENTI_AUT_RUOLO_COL));
                Log.d("try aut", "----try");
                return utenteAut;
            } catch (Exception e) {
                Log.d("catch aut", "----catch");
                return null;
            }
        }
    }

    public long popolaUtentiAut(String nome, String cognome, String ruolo) {
        ContentValues cv = new ContentValues();
        cv.put(UTENTI_AUT_NOME, nome.toUpperCase());
        cv.put(UTENTI_AUT_COGNOME, cognome.toUpperCase());
        cv.put(UTENTI_AUT_RUOLO, ruolo.toUpperCase());
        Log.d("inserisco paola", "paola");
        this.openWritableDB();
        long rowId = db.insert(UTENTI_AUT_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaSedeComunale(int idSede, int idStruttura, String altitudine, String latSess, String longSess, String latDec, String longDec) {
        ContentValues cv = new ContentValues();
        cv.put(SEDECOMUNE_ID, idSede);
        cv.put(SEDECOMUNE_IDSTRUTTURA, idStruttura);
        cv.put(SEDECOMUNE_ALTITUDINE, altitudine.toUpperCase());
        cv.put(SEDECOMUNE_LATITUDINE_SESS, latSess.toUpperCase());
        cv.put(SEDECOMUNE_LONGITUDINE_SESS, longSess.toUpperCase());
        cv.put(SEDECOMUNE_LATITUDINE_DEC, latDec.toUpperCase());
        cv.put(SEDECOMUNE_LONGITUDINE_DEC, longDec.toUpperCase());
        Log.d("inserisco sede comune", "fatto");
        this.openWritableDB();
        long rowId = db.insert(SEDECOMUNE_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaStruttura(int idStruttura, String nome, int idVia, int idComune, String tipo) {
        ContentValues cv = new ContentValues();
        cv.put(STRUTTURA_ID, idStruttura);
        cv.put(STRUTTURA_NOME, nome.toUpperCase());
        cv.put(STRUTTURA_IDVIE, idVia);
        cv.put(STRUTTURA_IDCOMUNE, idComune);
        cv.put(STRUTTURA_TIPO, tipo.toUpperCase());
        Log.d("inserisco struttura: ", "comune");
        this.openWritableDB();
        long rowId = db.insert(STRUTTURA_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaVie(int idVia, String nomeVia, int idComune) {
        ContentValues cv = new ContentValues();
        cv.put(VIE_ID, idVia);
        cv.put(VIE_NOME, nomeVia.toUpperCase());
        cv.put(VIE_IDCOMUNE, idComune);
        Log.d("inserisco via: ", "piazza aldo moro");
        this.openWritableDB();
        long rowId = db.insert(VIE_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaContatti(int idContatto, int idStruttura, String nome, String cognome, String tipo, String valore) {
        ContentValues cv = new ContentValues();
        cv.put(CONTATTI_ID, idContatto);
        cv.put(CONTATTI_IDSTRUTTURA, idStruttura);
        cv.put(CONTATTI_NOME, nome.toUpperCase());
        cv.put(CONTATTI_COGNOME, cognome.toUpperCase());
        cv.put(CONTATTI_TIPO, tipo.toUpperCase());
        cv.put(CONTATTI_VALORE, valore.toUpperCase());
        Log.d("inserisco contatto: ", "telefono: " + valore);
        this.openWritableDB();
        long rowId = db.insert(CONTATTI_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaPopolazione(int idPop, int idStruttura, String tipo, String quantita, String intestazione) {
        ContentValues cv = new ContentValues();
        cv.put(POPOLAZIONE_ID, idPop);
        cv.put(POPOLAZIONE_IDSTRUTTURA, idStruttura);
        cv.put(POPOLAZIONE_TIPO, tipo.toUpperCase());
        cv.put(POPOLAZIONE_QUANTITA, quantita.toUpperCase());
        cv.put(POPOLAZIONE_INTESTAZIONE, intestazione.toUpperCase());
        Log.d("inseriscoPopolazione", "residenti");
        this.openWritableDB();
        long rowId = db.insert(POPOLAZIONE_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaComune(int idComune, String nomeComune) {
        ContentValues cv = new ContentValues();
        cv.put(COMUNE_ID, idComune);
        cv.put(COMUNE_NOME, nomeComune.toUpperCase());
        Log.d("inserisco comune", "cogorno");
        this.openWritableDB();
        long rowId = db.insert(COMUNE_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaPersonale(int idPersonale, String nomePersonale, String cognomePersonale, String funzione, String residenza, String telefono, String titolo) {
        ContentValues cv = new ContentValues();
        cv.put(PERSONALE_ID, idPersonale);
        cv.put(PERSONALE_NOME, nomePersonale.toUpperCase());
        cv.put(PERSONALE_COGNOME, cognomePersonale.toUpperCase());
        cv.put(PERSONALE_FUNZIONE, funzione.toUpperCase());
        cv.put(PERSONALE_RESIDENZA, residenza.toUpperCase());
        cv.put(PERSONALE_TELEFONO, telefono.toUpperCase());
        cv.put(PERSONALE_TITOLO, titolo.toUpperCase());

        this.openWritableDB();
        long rowId = db.insert(PERSONALE_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaMezzi(int idMezzo, String quantita, String tipologiaMezzo, String locMezzo, String dispMezzo, String targaMezzo, String proprietario) {
        ContentValues cv = new ContentValues();
        cv.put(MEZZI_ID, idMezzo);
        cv.put(MEZZI_QUANTITA, quantita.toUpperCase());
        cv.put(MEZZI_TIPOLOGIA, tipologiaMezzo.toUpperCase());
        cv.put(MEZZI_LOCAZIONE, locMezzo.toUpperCase());
        cv.put(MEZZI_DISPONIBILITA, dispMezzo.toUpperCase());
        cv.put(MEZZI_TARGA, targaMezzo.toUpperCase());
        cv.put(MEZZI_PROPRIETARIO, proprietario.toUpperCase());

        this.openWritableDB();
        long rowId = db.insert(MEZZI_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaMateriali(int idMateriale, String quantita, String genere, String locMateriale, String dispMateriale) {
        ContentValues cv = new ContentValues();
        cv.put(MATERIALI_ID, idMateriale);
        cv.put(MATERIALI_QUANTITA, quantita.toUpperCase());
        cv.put(MATERIALI_GENERE, genere.toUpperCase());
        cv.put(MATERIALI_LOCAZIONE, locMateriale.toUpperCase());
        cv.put(MATERIALI_DISPONIBILITA, dispMateriale.toUpperCase());

        this.openWritableDB();
        long rowId = db.insert(MATERIALI_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public long popolaCartelli(int idCartello, String quantita, String locazione) {
        ContentValues cv = new ContentValues();
        cv.put(CARTELLI_ID, idCartello);
        cv.put(CARTELLI_QUANTITA, quantita.toUpperCase());
        cv.put(CARTELLI_LOCAZIONE, locazione.toUpperCase());

        this.openWritableDB();
        long rowId = db.insert(CARTELLI_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    // INSERIMENTO DI UN UTENTE NEL DATABASE
    public long inserisciUtente(Utente utente) {
        ContentValues cv = new ContentValues();
        cv.put(UTENTI_NOME, utente.getNome_utente().toUpperCase());
        cv.put(UTENTI_COGNOME, utente.getCognome_utente().toUpperCase());
        cv.put(UTENTI_RUOLO, utente.getRuolo_utente().toUpperCase());
        cv.put(UTENTI_USERNAME, utente.getUsername_utente().toUpperCase());
        cv.put(UTENTI_PASSWORD, utente.getPassword_utente().toUpperCase());

        Log.d("dentro inserisci db", "inserisci utente");
        this.openWritableDB();
        long rowId = db.insert(UTENTI_TABLE, null, cv);
        this.closeDB();
        return rowId;
    }

    public boolean getUtente(String username, String password) {
        String where = UTENTI_USERNAME + "= ? AND " + UTENTI_PASSWORD + "= ?";
        String[] whereArgs = {username.toUpperCase(), password.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(UTENTI_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Utente utenti = getUtenteFromCursor(cursor);


        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (utenti != null) {
            Log.d("dentro getUtente", utenti.getNome_utente());
            return true;
        }
        return false;
    }

    public boolean getUtenteAmm(String username, String password){
        String where = UTENTI_USERNAME + "= ? AND " + UTENTI_PASSWORD + "= ? AND " + UTENTI_RUOLO + "= ?";
        String[] whereArgs = {username.toUpperCase(), password.toUpperCase(), "AMMINISTRATORE"};

        this.openReadableDB();
        Cursor cursor = db.query(UTENTI_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Utente utenti = getUtenteFromCursor(cursor);


        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (utenti != null) {
            return true;
        }
        return false;
    }

/*
    public int getIdComune(String nomeComune){
        String where = COMUNE_NOME + "= ?";
        String[] whereArgs = {nomeComune};
        this.openReadableDB();
        Cursor cursor = db.query(COMUNE_TABLE, null, where, whereArgs, null,null,null);
        cursor.moveToFirst();
        Comune comune = getComuneFromCursor(cursor);
        if(cursor != null){
            cursor.close();
        }
        this.closeDB();
        if(comune !=null){
            return comune.getId_comune();
        }
        return -1;
    }


    private static Comune getComuneFromCursor(Cursor cursor){

        if(cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try{
                Comune comune = new Comune(
                        cursor.getInt(COMUNE_IDSTRUTTURA_COL),
                        cursor.getString(COMUNE_ALTITUDINE_COl),
                        cursor.getString(COMUNE_LATITUDINE_COL),
                        cursor.getString(COMUNE_LONGITUDINE_COL),
                        cursor.getString(COMUNE_NOME_COL));
                return comune;
            } catch (Exception e ){
                return null;
            }
        }
    }
    */


    public String getIndirizzo(String nomeStruttura) {
        int idVia = getIdVia(nomeStruttura.toUpperCase());
        String nomeVia = getNomeVia(idVia);
        if (nomeVia != null) {
            return nomeVia;
        }

        return "indirizzo non trovato";
    }

    public int getIdVia(String nomeStruttura) {
        String where = STRUTTURA_NOME + "= ?";
        String[] whereArgs = {nomeStruttura.toUpperCase()};
        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Struttura struttura = getStrutturaFromCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (struttura != null) {
            return struttura.getIdVie();
        }
        return -1;
    }

    public int getIdViaFromNomeVia(String nomeVia) {
        String where = VIE_NOME + "= ?";
        String[] whereArgs = {nomeVia.toUpperCase()};
        this.openReadableDB();
        Cursor cursor = db.query(VIE_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Vie vie = getVieFromCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (vie != null) {
            return vie.getId_via();
        }
        return -1;
    }

    public List<Struttura> getStruttureFromVia(String tipo, int idVia){
        String where = STRUTTURA_TIPO + "= ? AND " + STRUTTURA_IDVIE + "= ?";
        String[] whereArgs = {tipo.toUpperCase(), String.valueOf(idVia)};

        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        List<Struttura> nomi = new ArrayList<>();
        while (cursor.moveToNext()) {
            nomi.add(getStrutturaFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return nomi;

    }

    public List<Struttura> getStruttureFromNome(String nomeStruttura){
        String where = STRUTTURA_NOME + "= ?";
        String[] whereArgs = {nomeStruttura.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        List<Struttura> strutture = new ArrayList<>();
        while (cursor.moveToNext()) {
            strutture.add(getStrutturaFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return strutture;
    }

    private static Struttura getStrutturaFromCursor(Cursor cursor) {

        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Struttura struttura = new Struttura(
                        cursor.getInt(STRUTTURA_ID_COL),
                        cursor.getString(STRUTTURA_NOME_COL),
                        cursor.getInt(STRUTTURA_IDVIE_COL),
                        cursor.getInt(STRUTTURA_IDCOMUNE_COL),
                        cursor.getString(STRUTTURA_TIPO_COL));
                return struttura;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public String getNomeVia(int idVia) {
        String where = VIE_ID + "= ?";
        String[] whereArgs = {String.valueOf(idVia)};
        this.openReadableDB();
        Cursor cursor = db.query(VIE_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Vie vie = getVieFromCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        if (vie != null) {
            return vie.getNome();
        }
        return "nomeVia non trovato";
    }

    private static Vie getVieFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Vie via = new Vie(
                        cursor.getInt(VIE_ID_COL),
                        cursor.getString(VIE_NOME_COL),
                        cursor.getInt(VIE_IDCOMUNE_COL));
                return via;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public ArrayList<Contatti> getContatti(String nomeStruttura, String tipo) {
        int idStruttura = getIdStruttura(nomeStruttura.toUpperCase());
        String where = CONTATTI_IDSTRUTTURA + "= ? AND " + CONTATTI_TIPO + "= ?";
        String[] whereArgs = {String.valueOf(idStruttura), tipo.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(CONTATTI_TABLE, null, where, whereArgs, null, null, null);
        ArrayList<Contatti> contatti = new ArrayList<>();
        while (cursor.moveToNext()) {
            contatti.add(getContattiFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return contatti;
    }

    public ArrayList<Contatti> getContattiFromIntestazione(String nomeStruttura, String tipo, String intestazione) {
        int idStruttura = getIdStruttura(nomeStruttura.toUpperCase());
        String where = CONTATTI_IDSTRUTTURA + "= ? AND " + CONTATTI_TIPO + "= ? AND " + CONTATTI_NOME + "= ?";
        String[] whereArgs = {String.valueOf(idStruttura), tipo.toUpperCase(), intestazione.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(CONTATTI_TABLE, null, where, whereArgs, null, null, null);
        ArrayList<Contatti> contatti = new ArrayList<>();
        while (cursor.moveToNext()) {
            contatti.add(getContattiFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return contatti;
    }

    private static Contatti getContattiFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Contatti contatti = new Contatti(
                        cursor.getInt(CONTATTI_ID_COL),
                        cursor.getInt(CONTATTI_IDSTRUTTURA_COL),
                        cursor.getString(CONTATTI_NOME_COL),
                        cursor.getString(CONTATTI_COGNOME_COL),
                        cursor.getString(CONTATTI_TIPO_COL),
                        cursor.getString(CONTATTI_VALORE_COL));
                return contatti;

            } catch (Exception e) {
                return null;
            }
        }
    }

    public int getIdStruttura(String nomeStruttura) {
        String where = STRUTTURA_NOME + "= ?";
        String[] whereArgs = {nomeStruttura.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Struttura struttura = getStrutturaFromCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();

        if (struttura != null) {

            return struttura.getId_struttura();
        }
        return -1;
    }

    public int getNumeroPopolazione(String nomeStruttura, String tipo) {
        int idStruttura = getIdStruttura(nomeStruttura.toUpperCase());
        String where = POPOLAZIONE_IDSTRUTTURA + "= ? AND " + POPOLAZIONE_TIPO + "= ?";
        String[] whereArgs = {String.valueOf(idStruttura), tipo.toUpperCase()};
        int numero = 0;
        this.openReadableDB();
        Cursor cursor = db.query(POPOLAZIONE_TABLE, null, where, whereArgs, null, null, null);
        //cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Popolazione popolazione = getPopolazioneFromCursor(cursor);
            numero = numero + Integer.valueOf(popolazione.getQuantita());
            Log.d("numeroPop", "vale " + numero);
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();


        return numero;
    }


    private static Popolazione getPopolazioneFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Popolazione popolazione = new Popolazione(
                        cursor.getInt(POPOLAZIONE_ID_COL),
                        cursor.getInt(POPOLAZIONE_IDSTRUTTURA_COL),
                        cursor.getString(POPOLAZIONE_TIPO_COL),
                        cursor.getString(POPOLAZIONE_QUANTITA_COL),
                        cursor.getString(POPOLAZIONE_INTESTAZIONE_COL));
                return popolazione;

            } catch (Exception e) {
                return null;
            }
        }
    }

    public SedeComunale getDatiGeografici(String nomeStruttura) {
        int idStruttura = getIdStruttura(nomeStruttura.toUpperCase());
        String where = SEDECOMUNE_IDSTRUTTURA + "= ?";
        String[] whereArgs = {String.valueOf(idStruttura)};

        this.openReadableDB();
        Cursor cursor = db.query(SEDECOMUNE_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        SedeComunale sedeComunale = getSedeComunaleFromCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();

        if (sedeComunale != null) {

            return sedeComunale;
        }

        return null;

    }

    private static SedeComunale getSedeComunaleFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                SedeComunale sedeComunale = new SedeComunale(
                        cursor.getInt(SEDECOMUNE_ID_COL),
                        cursor.getInt(SEDECOMUNE_IDSTRUTTURA_COL),
                        cursor.getString(SEDECOMUNE_ALTITUDINE_COl),
                        cursor.getString(SEDECOMUNE_LATITUDINE_COL),
                        cursor.getString(SEDECOMUNE_LONGITUDINE_COL),
                        cursor.getString(SEDECOMUNE_LATITUDINE_DEC_COL),
                        cursor.getString(SEDECOMUNE_LONGITUDINE_DEC_COL));
                return sedeComunale;

            } catch (Exception e) {
                return null;
            }
        }
    }

    public List<String> getNomiStrutture(String tipoStruttura) {
        String where = STRUTTURA_TIPO + "= ?";
        String[] whereArgs = {tipoStruttura.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        List<String> nomi = new ArrayList<>();
        while (cursor.moveToNext()) {
            nomi.add(getStrutturaFromCursor(cursor).getNome());
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return nomi;
    }

    public List<String> getIndirizziStrutture(String tipoStruttura) {
        String where = STRUTTURA_TIPO + "= ?";
        String[] whereArgs = {tipoStruttura.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(STRUTTURA_TABLE, null, where, whereArgs, null, null, null);
        List<String> indirizzi = new ArrayList<>();
        while (cursor.moveToNext()) {
            int idVia = getStrutturaFromCursor(cursor).getIdVie();
            String nome = getNomeVia(idVia);
            indirizzi.add(nome);
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return indirizzi;

    }

    public List<Contatti> getContattiFromNomeStruttura(String nomeStruttura) {
        int idStruttura = getIdStruttura(nomeStruttura.toUpperCase());
        String where = CONTATTI_IDSTRUTTURA + "= ?";
        String[] whereArgs = {String.valueOf(idStruttura)};

        this.openReadableDB();
        Cursor cursor = db.query(CONTATTI_TABLE, null, where, whereArgs, null, null, null);
        List<Contatti> contatti = new ArrayList<>();
        while (cursor.moveToNext()) {
            contatti.add(getContattiFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return contatti;
    }

    public List<Personale> getPersonale() {
        String where = PERSONALE_TITOLO + "!= ? AND " + PERSONALE_TITOLO + "!= ? AND " + PERSONALE_TITOLO + "!= ? AND " + PERSONALE_TITOLO + "!= ?";
        String[] whereArgs = {"PROTEZIONE CIVILE", "PROFESSIONISTI", "SANITA", "CARTELLI"};
        this.openReadableDB();
        Cursor cursor = db.query(PERSONALE_TABLE, null, where, whereArgs, null, null, null);
        List<Personale> personale = new ArrayList<>();
        while (cursor.moveToNext()) {
            personale.add(getPersonaleFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return personale;
    }

    public List<Personale> getPersonaleFromCognome(String cognome, String titolo){
        String where = PERSONALE_COGNOME + "= ? AND " + PERSONALE_TITOLO + "= ?";
        String[] whereArgs = {cognome.toUpperCase(), titolo.toUpperCase()};
        this.openReadableDB();
        Cursor cursor = db.query(PERSONALE_TABLE, null, where, whereArgs, null, null, null);
        List<Personale> personale = new ArrayList<>();
        while (cursor.moveToNext()) {
            personale.add(getPersonaleFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return personale;

    }

    public List<Personale> getPersonaleFromTitolo(String titolo){
        String where = PERSONALE_TITOLO + "= ?";
        String[] whereArgs = {titolo.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(PERSONALE_TABLE, null, where, whereArgs, null, null, null);
        List<Personale> personale = new ArrayList<>();
        while (cursor.moveToNext()) {
            personale.add(getPersonaleFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return personale;
    }

    public List<Personale> getPersonaleFromFunzione(String funzione, String titolo){
        String where = PERSONALE_FUNZIONE + "= ? AND " + PERSONALE_TITOLO + "= ?";
        String[] whereArgs = {funzione.toUpperCase(), titolo.toUpperCase()};

        this.openReadableDB();
        Cursor cursor = db.query(PERSONALE_TABLE, null, where, whereArgs, null, null, null);
        List<Personale> personale = new ArrayList<>();
        while (cursor.moveToNext()) {
            personale.add(getPersonaleFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return personale;
    }

    private static Personale getPersonaleFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Personale personale = new Personale(
                        cursor.getInt(PERSONALE_ID_COL),
                        cursor.getString(PERSONALE_NOME_COL),
                        cursor.getString(PERSONALE_COGNOME_COL),
                        cursor.getString(PERSONALE_FUNZIONE_COL),
                        cursor.getString(PERSONALE_RESIDENZA_COL),
                        cursor.getString(PERSONALE_TELEFONO_COL),
                        cursor.getString(PERSONALE_TITOLO_COL));
                return personale;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public List<Mezzi> getMezzi() {
        this.openReadableDB();
        Cursor cursor = db.query(MEZZI_TABLE, null, null, null, null, null, null);
        List<Mezzi> mezzi = new ArrayList<>();
        while (cursor.moveToNext()) {
            mezzi.add(getMezziFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return mezzi;
    }

    private static Mezzi getMezziFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Mezzi mezzi = new Mezzi(
                        cursor.getInt(MEZZI_ID_COL),
                        cursor.getString(MEZZI_QUANTITA_COL),
                        cursor.getString(MEZZI_TIPOLOGIA_COL),
                        cursor.getString(MEZZI_LOCAZIONE_COL),
                        cursor.getString(MEZZI_DISPONIBILITA_COL),
                        cursor.getString(MEZZI_TARGA_COL),
                        cursor.getString(MEZZI_PROPRIETARIO_COL));
                return mezzi;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public List<Materiali> getMateriali() {
        this.openReadableDB();
        Cursor cursor = db.query(MATERIALI_TABLE, null, null, null, null, null, null);
        List<Materiali> materiali = new ArrayList<>();
        while (cursor.moveToNext()) {
            materiali.add(getMaterialiFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return materiali;

    }

    private static Materiali getMaterialiFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Materiali materiali = new Materiali(
                        cursor.getInt(MATERIALI_ID_COL),
                        cursor.getString(MATERIALI_QUANTITA_COL),
                        cursor.getString(MATERIALI_GENERE_COL),
                        cursor.getString(MATERIALI_LOCAZIONE_COL),
                        cursor.getString(MATERIALE_DISPONIBILITA_COL));
                return materiali;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public List<Cartello> getCartelli(){
        this.openReadableDB();
        Cursor cursor = db.query(CARTELLI_TABLE, null, null, null, null, null, null);
        List<Cartello> cartelli = new ArrayList<>();
        while (cursor.moveToNext()) {
            cartelli.add(getCartelloFromCursor(cursor));
        }
        if (cursor != null) {
            cursor.close();
        }
        this.closeDB();
        return cartelli;
    }

    private static Cartello getCartelloFromCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Cartello cartello = new Cartello(
                        cursor.getInt(CARTELLI_ID_COL),
                        cursor.getString(CARTELLI_QUANTITA_COL),
                        cursor.getString(CARTELLI_LOCAZIONE_COL));
                return cartello;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
