package com.example.powiadomienia;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.ContextCompat.checkSelfPermission;
import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import static android.os.Build.VERSION.SDK_INT;

public class MainActivity extends AppCompatActivity {
    private static final String CHANEL_ID = "my_chanel_id";
    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        createNotificationChannel();

        btn1.setOnClickListener(view -> BigTextStyle());
        btn2.setOnClickListener(view -> BigPictureStyle());
        //btn3.setOnClickListener(view -> InboxStyle());





    }
    private void createNotificationChannel(){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            CharSequence name = "kanal_Powiadomien";
            String description = "Opis_kanalu_powiadomien";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel =  new NotificationChannel(CHANEL_ID,name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
    private void BigTextStyle(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},1);
                return;
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("3tp").setStyle(new NotificationCompat.BigTextStyle().bigText("vjuregvuirgetvuiyrtivyrtivyrtivyrt8ivyrtivyrtivyrtviyrti")).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notifcationmanager = NotificationManagerCompat.from(this);
            notifcationmanager.notify(1,builder.build());
        }
}
    private void BigPictureStyle(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},1);
                return;
            }
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dice1);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("3tp").setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notifcationmanager = NotificationManagerCompat.from(this);
            notifcationmanager.notify(1,builder.build());
        }
    }

}


