package com.example.dialogi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);

        btn.setOnClickListener(v -> showAlertDialog());
        btn2.setOnClickListener(v -> showistDialog());
        btn3.setOnClickListener(v -> showDataPickerDialog());
        btn4.setOnClickListener(v -> showTimePickerDialog());
        btn5.setOnClickListener(v -> showCustomDialog());
    }


    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prosty Alertdialog");
        builder.setMessage("Przykładowa wiadomość");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "kliknięto OK", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Kilkinięto Anuluj", Toast.LENGTH_SHORT).show();

            }
        });
        builder.create().show();
    }

    private void showistDialog() {
        final String[] items = {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz opcje");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Wybrano:" + items[which], Toast.LENGTH_SHORT).show();

            }
        });
        builder.create().show();
    }

    private void showDataPickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
                Toast.makeText(MainActivity.this, "wybrano date: " + dayofMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
            }


        }, year, month, day);
        datePickerDialog.show();


    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                Toast.makeText(MainActivity.this, "wybrano czas: " + hour + ":" + minute,Toast.LENGTH_SHORT).show();


            }
        }, hour, minute,true);
        timePickerDialog.show();

    }
    private void showCustomDialog(){
        final android.app.Dialog dialog  = new android.app.Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        
        Button btn6 = dialog.findViewById(R.id.button6);
        EditText text = dialog.findViewById(R.id.atInput);
        
        btn6.setOnClickListener(v->{
            Toast.makeText(MainActivity.this, "napisano: "+text.getText().toString().trim(),Toast.LENGTH_LONG).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}