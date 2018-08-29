package com.example.paola.cogornonew;

public class PopolaDB {

    private DataBase db;

    public PopolaDB(DataBase db) {
        this.db = db;
    }

    public void Popola() {

        // vie
        db.popolaVie(1, "VIA BENEDETTO CHIAPPE", 1);
        db.popolaVie(2, "PIAZZA ALDO MORO", 1);
        db.popolaVie(3, "VIA ALLA BASILICA", 1);
        db.popolaVie(4, "VIA VALPARAISO", 1);
        db.popolaVie(5, "PIAZZA INNOCENZO", 1);
        db.popolaVie(6, "VIA ROSSI", 1);
        db.popolaVie(7, "VIA XXV APRILE", 1);

        // strutture
        db.popolaStruttura(3, "sede comunale", 2, 1, "comune");
        db.popolaStruttura(4, "ufficio ass soc", 3, 1, "ufficio ass soc");
        db.popolaStruttura(5, "SERVIZIO DI EDUCATORIE DOMICILIARIE", 4, 1, "scuola");
        db.popolaStruttura(6, "SCUOLA MATERNA (INFANZIA) STATALE 'B.CHIAPPE' DI COGORNO", 1, 1, "scuola");
        db.popolaStruttura(7, "BASILICA SAN SALVATORE DEI FIESCHI", 5, 1, "culto");
        db.popolaStruttura(8, "AUDITORIUM SAN SALVATORE DEI FIESCHI", 5, 1, "culto");
        db.popolaStruttura(9, "IMPRESA EDILE DI PAOLO", 6, 1, "imprese");
        db.popolaStruttura(10, "FERRAMENTA", 7, 1, "approvvigionamento");
        db.popolaStruttura(11, "VILLAGGIO DEL RAGAZZO", 4,1,"scuola");

        // dati comune
        db.popolaComune(1, "Cogorno");
        db.popolaSedeComunale(1, 3, "38 m s.l.m. (min 8 - max 701)", "44°19'48,72''N", "9°21'14,40''E", "44,3302°N", "9,3540°E");
        db.popolaPopolazione(1, 3, "residenti", "5646", "residenti");
        db.popolaPopolazione(2, 5, "alunni", "16", "alunni");
        db.popolaPopolazione(3, 6, "alunni", "27", "alunni");
        db.popolaPopolazione(4, 5, "personale", "4", "personale");
        db.popolaPopolazione(5, 6, "personale", "2", "maestre");
        db.popolaPopolazione(6, 6, "personale", "1", "bidella");
        db.popolaPopolazione(7, 6, "personale", "1", "cuoco");
        db.popolaPopolazione(8,11, "personale", "40","personale");
        db.popolaPopolazione(9,11,"alunni", "270","alunni");

        // contatti comune
        db.popolaContatti(1, 3, "sede comunale", "", "telefono", "018538571");
        db.popolaContatti(2, 3, "sede comunale","", "tel/fax", "0185380825");
        db.popolaContatti(3, 3, "sede comunale", "","sito", "www.comune.cogorno.ge.it");


        // contatti polizia municipale
        db.popolaContatti(4, 3, "Polizia Municipale","", "telefono", "0185385728/29");
        db.popolaContatti(5, 3, "Polizia Municipale","", "cell", "3293198546");
        db.popolaContatti(6, 3, "Polizia Municipale", "","sito", "polizialocale@comune.cogorno.ge.it");

        // contatti uffici distaccati
        db.popolaContatti(7, 4, "Ufficio Assistente Sociale", "","telefono", "0185385020");

        // contatti scuole
        db.popolaContatti(8, 5, "Paolo","Rossi", "telefono", "1234567");
        db.popolaContatti(9, 5, "Marco", "Bianchi", "telefono", "987654");
        db.popolaContatti(10, 6, "Davide","Verdi", "telefono", "01234");
        db.popolaContatti(11, 5, "Segreteria", "","email", "servizioeducatorie@gmail.com");
        db.popolaContatti(16,11,"Direttore","", "telefono", "018512345");
        db.popolaContatti(17,11,"Segreteria","", "telefono", "12345678");

        // contatti culto
        db.popolaContatti(12, 7, "Don Maurizio", "","cell", "1234567");

        // contatti imprese
        db.popolaContatti(13, 9, "Titolare impresa","", "telefono", "1234556");

        // contatti approvviggionamento
        db.popolaContatti(14, 10, "Ferramenta","", "email", "ferramenta@gmail.com");
        db.popolaContatti(15, 10, "Ferramenta", "","telefono", "26128191");

        // personale
        db.popolaPersonale(1, "PIPPO","PLUTO", "LAVORI PUBBLICI E AMBIENTE", "Chiavari", "123456789", "personale");
        db.popolaPersonale(2, "TOPOLINO","PAPERINO", "POLIZIA MUNICIPALE", "Cogorno", "987654321", "personale");
        db.popolaPersonale(3, "GIANNI","ROSSI", "DIRETTORE OPERATIVO", "chiavari", "123467890", "protezione civile");
        db.popolaPersonale(4, "CARLO","BIANCHI", "GEOLOGO", "Sestri Levante", "65837348", "professionisti");
        db.popolaPersonale(5, "ANNA","ROSSI", "MEDICO PRIVATO", "", "93012901", "sanita");
        db.popolaPersonale(6, "DITTA CARTELLI","SIG.ROSSI", "MANUTENTORE HARDWARE", "Via Pastrengo - Bergamo", "12345678", "cartelli");
        db.popolaPersonale(7, "SOVR.TE","CAPO PM", "OPERATORI PER MESSAGGI", "postazione ufficio pm", "23243567", "cartelli");
        db.popolaPersonale(8,"PAOLO","VERDI", "VOLONTARIO","cogorno","1234567","protezione civile");

        // mezzi
        db.popolaMezzi(1, "n.1", "Fiat 600", "Sede comunale", "Esclusiva", "ab123cd", "comune");
        db.popolaMezzi(2, "n.1", "Porter blu", "Sede magazzino", "Esclusiva", "ab123qw", "comune");


        // materiali
        db.popolaMateriali(1, "n.1", "motogeneratore", "magazzino comunale", "esclusiva");

        // cartelli
        db.popolaCartelli(1, "1", "S.P.33");
        db.popolaCartelli(2, "1", "S.P.33");

    }
}
