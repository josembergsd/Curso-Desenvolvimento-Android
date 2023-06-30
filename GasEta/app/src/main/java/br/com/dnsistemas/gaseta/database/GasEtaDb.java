package br.com.dnsistemas.gaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class GasEtaDb extends SQLiteOpenHelper {

    Cursor cursor;
    SQLiteDatabase db;
    private static final String DB_NAME = "gaseta_db";
    private static final int DB_VERSION = 1;

    public GasEtaDb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";
        db.execSQL(sqlTabelaCombustivel);

        String sqlTabelaVeiculo
                = "CREATE TABLE Veiculo (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeDoVeiculo TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";
        db.execSQL(sqlTabelaVeiculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

   //-------------------------------------------- CRUD ----------------------------------------
    public void salvarObjeto(String tabela, ContentValues dados){
            db.insert(tabela, null, dados);
    }

}