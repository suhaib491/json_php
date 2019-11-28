package com.codingelab.tutorial;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText shFirstName,shLastName,shFavFood;
    private Button bttnView,bttnAdd;

    //private Syn syn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


       // this.syn=new Syn();
        // preparing listener (onAction)
        shFavFood = (EditText) findViewById(R.id.etFavFood);
        shFirstName = (EditText) findViewById(R.id.etFirstName);
        shLastName = (EditText) findViewById(R.id.etLastName);
        final Intent intent = new Intent(this, ViewListContents.class);
        bttnAdd = (Button) findViewById(R.id.btnAdd);
        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = shFirstName.getText().toString();
                String lName = shLastName.getText().toString();
                String fFood = shFavFood.getText().toString();
                if(fName.length() != 0 && lName.length() != 0 && fFood.length() != 0){
                    AddData(fName,lName, fFood);
                    shFavFood.setText("");
                    shLastName.setText("");
                    shLastName.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });
        bttnView = (Button) findViewById(R.id.btnView);
        bttnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
    public void AddData(String firstName,String lastName, String favFood ){
        boolean insertData = true;//myDB.addData(firstName,lastName,favFood);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

}
