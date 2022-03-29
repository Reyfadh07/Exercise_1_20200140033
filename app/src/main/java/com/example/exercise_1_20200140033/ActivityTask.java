package com.example.exercise_1_20200140033;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityTask extends AppCompatActivity {
    EditText edTask2,edJentask2,edTimetask2;
    FloatingActionButton floatbtn2;
    TextView welcome2;

    String dtask1,djen1,dtime1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit) {
            dtask1 = edTask2.getText().toString();
            djen1 = edJentask2.getText().toString();
            dtime1 = edTimetask2.getText().toString();

            //Mengecek apakah user sudah mengisi semua yang diperlukan atau belum
            if (edTask2.getText().toString().isEmpty() || edJentask2.getText().toString().isEmpty() || edTimetask2.getText().toString().isEmpty()) {
                Toast.makeText(ActivityTask.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            if (dtask1.isEmpty()) {
                edTask2.setError("wajib diisi!!");
            } else if (djen1.isEmpty()) {
                edJentask2.setError("wajib diisi!!");
            } else if (dtime1.isEmpty()) {
                edTimetask2.setError("wajib diisi!!");
            }
            else {
                Toast.makeText(ActivityTask.this, "Berhasil", Toast.LENGTH_SHORT).show();
                Bundle bl = new Bundle();
                bl.putString("Task", dtask1.trim());
                bl.putString("Jenis", djen1.trim());
                bl.putString("Time", dtime1.trim());

                Intent i = new Intent(ActivityTask.this, AvtivityTampilTask.class);
                i.putExtras(bl);
                startActivity(i);
            }
        } else {
            Intent i = new Intent(ActivityTask.this, MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        welcome2 = findViewById(R.id.welcome);
        edTask2 =  findViewById(R.id.edTask);
        edJentask2 = findViewById(R.id.edJentask);
        edTimetask2 = findViewById(R.id.edTimetask);
        floatbtn2 = findViewById(R.id.floatBtn);

        Bundle bu = getIntent().getExtras();
        String tname = bu.getString("name");
        welcome2.setText(tname);

        floatbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                dtask1 = edTask2.getText().toString();
                djen1 = edJentask2.getText().toString();
                dtime1 = edTimetask2.getText().toString();

                if (edTask2.getText().toString().isEmpty() || edJentask2.getText().toString().isEmpty() || edTimetask2.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityTask.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else if (dtask1.isEmpty()) {
                    edTask2.setError("wajib diisi!!");
                } else if (djen1.isEmpty()) {
                    edJentask2.setError("wajib diisi!!");
                } else if (dtime1.isEmpty()) {
                    edTimetask2.setError("wajib diisi!!");
                }
                else {
                    Toast.makeText(ActivityTask.this, "Berhasil", Toast.LENGTH_SHORT).show();
                    Bundle bu = new Bundle();
                    bu.putString("Task", dtask1.trim());
                    bu.putString("Jenis", djen1.trim());
                    bu.putString("Time", dtime1.trim());

                    Intent i = new Intent(ActivityTask.this, AvtivityTampilTask.class);
                    i.putExtras(bu);
                    startActivity(i);
                }

            }
        });
    }
}
