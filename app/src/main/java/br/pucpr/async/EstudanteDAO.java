package br.pucpr.async;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface EstudanteDAO {
    @Insert
    void inserir(Estudante... estudantes);

    @Query("SELECT * FROM estudante order by nome, email, matricula;")
    List<Estudante> list();
}
