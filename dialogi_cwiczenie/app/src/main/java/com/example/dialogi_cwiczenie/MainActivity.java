package com.example.dialogi_cwiczenie;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final  String ilosc_k="ilosc";

    private TextView ilosc;
    private int licznik=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn_delete=findViewById(R.id.delete_btn);
        Button btn_reset=findViewById(R.id.reset);

        ilosc=findViewById(R.id.ilosc);

        if(savedInstanceState!=null){
            licznik=savedInstanceState.getInt(ilosc_k);
        }
        ustawianie();
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                licznik=0;
                ilosc.setText("Dane usunięto: "+licznik+" razy");
            }
        });

        btn_delete.setOnClickListener(view -> AlterDialog());

    }
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ilosc_k,licznik);
    }
    private void ustawianie(){
        ilosc.setText("Dane usunięto: "+licznik+" razy");
    }
    private void AlterDialog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);

        builder.setTitle("Potwierdzenie!");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");


        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                licznik++;
                ustawianie();
                Toast.makeText(MainActivity.this,"Dane zostały usunięte",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}