package br.com.dnsistemas.appclientevip.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.dnsistemas.appclientevip.model.Pessoa;

public class ListaVipDb extends SQLiteOpenHelper {

    Cursor cursor;
    SQLiteDatabase db;
    private static final String DB_NAME = "listavip_db";
    private static final int DB_VERSION = 1;

    public ListaVipDb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaPessoa
                = "CREATE TABLE Pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "primeiroNome TEXT, " +
                "sobrenome TEXT, " +
                "cursoDesejado TEXT, " +
                "telefoneContato TEXT)";
        db.execSQL(sqlTabelaPessoa);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

   //-------------------------------------------- CRUD ----------------------------------------
    protected void salvarObjeto(String tabela, ContentValues dados){
            db.insert(tabela, null, dados);
    }

    protected List<Pessoa> listarDados(){
        List<Pessoa> lista = new ArrayList<>();
        Pessoa registro; //Representa um registro salvo na tabela
        String querySql = "SELECT * FROM Pessoa";
        cursor = db.rawQuery(querySql, null);

        if(cursor.moveToFirst()){
            do{
                registro = new Pessoa();
                registro.setId(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobrenome(cursor.getString(2));
                registro.setCursoDesejado(cursor.getString(3));
                registro.setTelefoneContato(cursor.getString(4));

                lista.add(registro);
            }while(cursor.moveToNext());
        }else{

        }
        return lista;
    }

    protected void deletarObjeto(String tabela, int id){
        db.delete(tabela, "id=?", new String[]{Integer.toString(id)});
    }

    protected void alterarObjeto(String tabela, ContentValues dados){
        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});
    }
}