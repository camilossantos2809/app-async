package br.pucpr.async;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estudante")
public class Estudante {
    @NonNull
    @ColumnInfo(name = "nome")
    private String nome;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "matricula")
    private int matricula;

    public Estudante(String nome, String email, int matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
