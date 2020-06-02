package br.pucpr.async;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        final EstudanteListAdapter adapter = new EstudanteListAdapter(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtNome = findViewById(R.id.txt_nome);
                TextView txtEmail = findViewById(R.id.txt_email);
                TextView txtMatricula = findViewById(R.id.txt_matricula);
                ParallelTask task = new ParallelTask();
                task.execute(txtNome.getText().toString(), txtEmail.getText().toString(), txtMatricula.getText().toString());
            }
        });

        this.db = AppDatabase.getDatabase(this);
    }

    private class ParallelTask extends AsyncTask<String, Void, String> {
        @Override
        public void onPreExecute() {
        }

        @Override
        public String doInBackground(String... parametros) {
            try {
                Estudante estudante = new Estudante(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
                EstudanteDAO estudanteDAO = db.estudanteDAO();
                estudanteDAO.inserir(estudante);
                return "Dados inseridos com sucesso\n";
            } catch (Exception err) {
                return err.getMessage();
            }
        }

        @Override
        public void onPostExecute(String retorno) {
            Toast.makeText(MainActivity.this, retorno, Toast.LENGTH_LONG).show();
        }
    }


}