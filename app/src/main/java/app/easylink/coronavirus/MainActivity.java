package app.easylink.coronavirus;

import androidx.appcompat.app.AppCompatActivity;
import app.easylink.coronavirus.ImageSliderActivity.ImageMain;
import app.easylink.coronavirus.Retrofit.RetrofitActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button diagnoseBtn;
    Button btnProtect;
    Button btnRetrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String news = pref.getString("name", null); // getting String

        Toast.makeText(getApplicationContext(), news, Toast.LENGTH_SHORT).show();

    btn1 = (Button)findViewById(R.id.btn_prevention);
    diagnoseBtn = (Button)findViewById(R.id.btn_diagnose);
    btnProtect = (Button)findViewById(R.id.btn_protect);
        btnRetrofit = (Button)findViewById(R.id.retrofit);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageMain.class);
                startActivity(intent);            }
        });

        diagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Diagnose.class);
                startActivity(intent);
            }

        });

        btnProtect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Protect.class);
                startActivity(intent);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RetrofitActivity.class);
                startActivity(intent);
            }
        });

        }
    }

