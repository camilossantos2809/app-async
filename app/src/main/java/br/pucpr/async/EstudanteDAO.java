package br.pucpr.async;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EstudanteDAO {

    private Conexao con;
    private SQLiteDatabase db;

    public EstudanteDAO(Context context){
        con = new Conexao(context);
        db = con.getWritableDatabase();
    }

    public void inserir(Estudante estudante){

    }
}
