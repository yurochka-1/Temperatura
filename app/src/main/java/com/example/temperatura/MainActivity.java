package com.example.temperatura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    TextView textView;
    RadioButton c1,k1, f1, c2, k2, f2;
    Button buttonOblicz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView2);
        buttonOblicz = findViewById(R.id.button);
        c1 = findViewById(R.id.radioButton);
        k1 = findViewById(R.id.radioButton2);
        f1 = findViewById(R.id.radioButton3);
        c2 = findViewById(R.id.radioButton4);
        k2 = findViewById(R.id.radioButton5);
        f2 = findViewById(R.id.radioButton6);

        buttonOblicz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String liczbatxt = editText1.getText().toString();
                        double liczba = Double.parseDouble(liczbatxt);
                        double wynik = liczba;


                        if (c1.isChecked() && f2.isChecked()) {
                            wynik = (9.0 / 5.0) * liczba + 32;
                        }if (c1.isChecked() && k2.isChecked()){
                            wynik = liczba + 273.15;
                        }if (c1.isChecked() && c2.isChecked()){
                            wynik = liczba;
                        }if (f1.isChecked() && c2.isChecked()){
                            wynik = (liczba - 32)*5/9;
                        }if (f1.isChecked() && k2.isChecked()){
                            wynik = (liczba - 32)*5/9 + 273.15;
                        }if (f1.isChecked() && f2.isChecked()){
                            wynik = liczba;
                        }if (k1.isChecked() && c2.isChecked()){
                            wynik = liczba - 273.15;
                        }if (k1.isChecked() && f2.isChecked()){
                            wynik = (liczba - 273.15) * 1.8 + 32 ;
                        }
                        textView.setText(String.format(String.valueOf(wynik)));
                    }
                }

        );

    }
}