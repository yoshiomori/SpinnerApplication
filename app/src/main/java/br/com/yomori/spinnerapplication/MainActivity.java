package br.com.yomori.spinnerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner studentsSpinner = findViewById(R.id.studentsSpinner);

        ArrayList<String> students = new ArrayList<>();
        students.add("Meisam");
        students.add("Brad");
        students.add("Sarah");
        students.add("Madeline");
        students.add("Tom");

        ArrayAdapter<String> studentsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                students
        );

        studentsSpinner.setAdapter(studentsAdapter);

        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, students.get(i) + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        };
        studentsSpinner.setOnItemSelectedListener(
                onItemSelectedListener
        );
    }
}