package com.example.exercise_1_20200140033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    TextView edDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan componen button pada layout
        btnLogin=findViewById(R.id.button1);

        //Menghubungkan variabel edemail dengan componen button pada layout
        ednama=findViewById(R.id.edNama);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        edDaftar = (TextView) findViewById(R.id.btnDaftar);
        edDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                startActivity(new Intent(MainActivity.this,ActivityDaftar.class ));
            }
        });

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1) {
                //menyimpan input user di edittext email kedalam variabel nama
                nama = ednama.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                if (nama.equals("Rey") && password.equals("iniRey")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("Name",nama.trim());
                    b.putString("pw" ,password.trim());

                    Intent i = new Intent(MainActivity.this, ActivityTask.class );
                    i.putExtras(b);
                    startActivity(i);
                }
                else if (nama.isEmpty()){
                    ednama.setError("Masukkan Nama");
                }
                else if (password.isEmpty()){
                    edpassword.setError("Masukkan Password");
                }
                else if(nama.equals("Rey") && password.equals(password)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                }
                else if(nama.equals(nama) && password.equals("iniRey")){
                    Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Email dan Password Salah", Toast.LENGTH_LONG).show();
                }

            }


        });

    }


}