package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bOk;
    Button b1;
    String ref = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bOk=findViewById(R.id.bOk);
        bOk.setOnClickListener(this);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        String name = new String();
        String ref = new String(" ");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bOk:
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.b1:
                Uri url = Uri.parse(ref);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent1);
                break;
        }
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (data == null) {
                return;
            }
            String name = new String();
            Bundle arg = data.getExtras();
            if (arg != null) {
                name = arg.get("name").toString();
                ref = arg.get("ref").toString();
                if (name.equals("")) {
                    name = "Please, enter your name";
                }
                if (ref.equals("")) {
                    ref = "Please, enter your page";
                }
                else {
                    b1 = findViewById(R.id.b1);
                    b1.setVisibility(View.VISIBLE);
                }
                Toast.makeText(getApplication(), name + "\n" + ref, Toast.LENGTH_LONG).show();
            }
        }
    }