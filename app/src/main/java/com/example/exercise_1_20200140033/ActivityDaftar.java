package com.example.exercise_1_20200140033;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityDaftar extends AppCompatActivity {
    EditText ednama2,edemail2,edpassword2,edrepass2;
    Button btndaftar;
    String dnama,demail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ednama2 = findViewById(R.id.edNama2);
        edemail2 = findViewById(R.id.edEmail2);
        edpassword2 = findViewById(R.id.edPassword2);
        edrepass2 = findViewById(R.id.edRepass2);
        btndaftar = findViewById(R.id.buttonDaftar);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                dnama = ednama2.getText().toString();
                demail = edemail2.getText().toString();

                if (dnama.isEmpty() && demail.isEmpty())
                {
                    ednama2.setError("Masukan Nama");
                    edemail2.setError("Masukan Email");
                }
                else if (edpassword2.getText().toString().equals(edrepass2.getText().toString())){
                    Toast.makeText(ActivityDaftar.this,"Registrasi Berhasil", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("name", dnama.trim());

                    Intent i = new Intent(ActivityDaftar.this,ActivityTask.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(ActivityDaftar.this, "Password Salah", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
