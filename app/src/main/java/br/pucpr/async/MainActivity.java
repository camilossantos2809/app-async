package br.pucpr.async;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtNome = findViewById(R.id.txt_nome);
                ParallelTask task = new ParallelTask();
                task.execute(txtNome.getText().toString(), "teste@teste.com", "1");
            }
        });
    }

    private class ParallelTask extends AsyncTask<String, Void, String> {
        @Override
        public void onPreExecute() {
        }

        @Override
        public String doInBackground(String... parametros) {
            try {
                Estudante estudante = new Estudante(parametros[0], parametros[1], Integer.parseInt(parametros[2]));
                EstudanteDAO estudanteDAO = new EstudanteDAO(MainActivity.this);
                estudanteDAO.inserir(estudante);
                return "Dados inseridos com sucesso\n" + estudante.toString();
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