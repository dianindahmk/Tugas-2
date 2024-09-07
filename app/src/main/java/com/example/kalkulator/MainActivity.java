package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private RadioGroup radioGroup;
    private Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonHitung = findViewById(R.id.buttonHitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1String = editTextNumber1.getText().toString();
                String num2String = editTextNumber2.getText().toString();

                if (num1String.isEmpty() || num2String.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mohon masukkan kedua angka", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(num1String);
                double num2 = Double.parseDouble(num2String);
                double result = 0;

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Mohon pilih operasi", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedId == R.id.radioButtonPlus) {
                    result = num1 + num2;
                } else if (selectedId == R.id.radioButtonMinus) {
                    result = num1 - num2;
                } else if (selectedId == R.id.radioButtonMultiply) {
                    result = num1 * num2;
                } else if (selectedId == R.id.radioButtonDivide) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(MainActivity.this, "Pembagi tidak boleh nol", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("result", result);
                intent.putExtra("nim", "225150400111017");
                intent.putExtra("nama", "Dian Indah May Kurnia");
                startActivity(intent);
            }
        });
    }
}
