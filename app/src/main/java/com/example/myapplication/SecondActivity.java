package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button save;
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            EditText nameTXT = findViewById(R.id.name);
            EditText refTXT = findViewById(R.id.ref);
            String name = nameTXT.getText().toString();
            String ref = refTXT.getText().toString();
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("ref", ref);
            setResult(RESULT_OK, intent);
            finish();
        }});
}}
