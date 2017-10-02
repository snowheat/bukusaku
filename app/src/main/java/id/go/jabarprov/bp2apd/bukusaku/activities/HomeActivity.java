package id.go.jabarprov.bp2apd.bukusaku.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.go.jabarprov.bp2apd.bukusaku.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar homeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(homeToolbar);


        Button buttonCariIndikator = (Button) findViewById(R.id.home_button_cari_indikator);
        Button buttonCariDokumen = (Button) findViewById(R.id.home_button_cari_dokumen);
        Button buttonCatatan = (Button) findViewById(R.id.home_button_catatan);
        Button buttonContohFormat = (Button) findViewById(R.id.home_button_contoh_format);
        Button buttonFasumsosgo = (Button) findViewById(R.id.home_button_fasumsosgo);
        Button buttonPengetahuanDasar = (Button) findViewById(R.id.home_button_pengetahuan_dasar);
        Button buttonPermintaanData = (Button) findViewById(R.id.home_button_permintaan_data);
        Button buttonSurveiKm0propoor = (Button) findViewById(R.id.home_button_survei_km0propoor);

        buttonCariIndikator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intention = new Intent(HomeActivity.this,CariIndikatorActivity.class);
                startActivity(intention);
            }
        });

    }

}
