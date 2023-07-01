package br.com.dnsistemas.gaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.dnsistemas.gaseta.model.Combustivel;

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
    protected void salvarObjeto(String tabela, ContentValues dados){
            db.insert(tabela, null, dados);
    }

    protected List<Combustivel> listarDados(){
        List<Combustivel> lista = new ArrayList<>();
        Combustivel registro; //Representa um registro salvo na tabela
        String querySql = "SELECT * FROM Combustivel";
        cursor = db.rawQuery(querySql, null);

        if(cursor.moveToFirst()){
            do{
                registro = new Combustivel();
                registro.setId(cursor.getInt(0));
                registro.setNomeDoCombustivel(cursor.getString(1));
                registro.setPrecoDoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);
            }while(cursor.moveToNext());
        }else{

        }
        return lista;
    }

    protected void excluirDados(){

    }

    protected void alterarObjeto(String tabela, ContentValues dados){
        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});
    }
}