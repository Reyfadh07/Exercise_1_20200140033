package com.example.exercise_1_20200140033;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AvtivityTampilTask extends AppCompatActivity {
    TextView dtask2,djentask2,dtimetask2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampiltask);

        dtask2 = findViewById(R.id.isiTask);
        djentask2 = findViewById(R.id.isiJtask);
        dtimetask2 = findViewById(R.id.isiTtask);

        Bundle bu = getIntent().getExtras();

        String dtask3 = bu.getString("Task");
        String djentask3 = bu.getString("Jenis");
        String dtimetask3 = bu.getString("Time");

        dtask2.setText(dtask3);
        djentask2.setText(djentask3);
        dtimetask2.setText(dtimetask3);
    }
}
