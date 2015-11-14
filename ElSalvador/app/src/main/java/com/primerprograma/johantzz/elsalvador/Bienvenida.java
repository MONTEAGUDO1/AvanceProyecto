package com.primerprograma.johantzz.elsalvador;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class Bienvenida extends AppCompatActivity {


    public static final int segundos=8;
    public static final int milisegundos=segundos*1000;
    private ProgressBar progressBar;
    public static final int delay=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        getSupportActionBar().hide();
        progressBar= (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(maximo_progreso());
        empezaranimacion();
    }

    public int establecerprogreso(long miliseconds){ return (int)((milisegundos-miliseconds)/1000); }

    public int maximo_progreso(){
        return segundos-delay;
    }

    public void empezaranimacion() {
        new CountDownTimer(milisegundos, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(establecerprogreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {

                Intent llamar = new Intent(Bienvenida.this, MenuPrincipal.class);
                startActivity(llamar);
                finish();
            }
        }.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenida, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
