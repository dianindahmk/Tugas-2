package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewResult, textViewNIM, textViewNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResult = findViewById(R.id.textViewResult);
        textViewNIM = findViewById(R.id.textViewNIM);
        textViewNama = findViewById(R.id.textViewNama);

        double result = getIntent().getDoubleExtra("result", 0);
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");

        textViewResult.setText("Hasil: " + result);
        textViewNIM.setText("NIM: " + nim);
        textViewNama.setText("Nama: " + nama);
    }
}
