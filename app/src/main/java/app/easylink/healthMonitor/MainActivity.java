package app.easylink.healthMonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import app.easylink.healthMonitor.ImageSliderActivity.ImageMain;
import app.easylink.healthMonitor.Retrofit.RetrofitActivity;
import app.easylink.healthMonitor.firebaselogin.LoginActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    Button btn1;
    Button diagnoseBtn;
    Button btnProtect;
    Button btnRetrofit;
    Button map;
    Button btn_mask;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    TextView email_header;
    TextView name_header;
    ImageView image1_header;
    ImageView status_header;
    TextView health_status;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    // AIzaSyCG1t3phDWRoo3_h9lOo_dTcY3pyhYVmQw
/**
 * Developer : Abdul Qadir
 * CoronaVirus Simulator application
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dl = (DrawerLayout) findViewById(R.id.drawer);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);//this is the first part
        t.syncState();
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.nv);
        View header = navigationView.getHeaderView(0);
        email_header = (TextView) header.findViewById(R.id.email);
        name_header =  (TextView) header.findViewById(R.id.uid);
        image1_header = (ImageView) header.findViewById(R.id.imageView);
        health_status = (TextView) header.findViewById(R.id.status);
        status_header = (ImageView) header.findViewById(R.id.status_health);

       // text.setText("Hey welcome");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id== R.id.close){
                    System.exit(0);
                }

                else if(id== R.id.menu){
                    dl.closeDrawers();
                }
                else if(id== R.id.logout){
                    dl.closeDrawers();
                    FirebaseAuth.getInstance().signOut();
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                   startActivity(i);
                    MainActivity.this.finish();

                }

                return false;
            }
        });

        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String news = pref.getString("name", null); // getting String

        SharedPreferences pref1 = getApplicationContext().getSharedPreferences("infected", 0);
        String virus = pref1.getString("virus", null); // getting String

        if(virus == null){
            virus = "Diagnose yourself";
        }
        else if(virus.equals("No Virus Detected") || virus.equals("Alert! Cronavirus Symptom") || virus.equals("Alert! Cronavirus Symptom") || virus.equals("Warning, Infected") || virus.equals("Consult Your Doctor") ){
             status_header.setBackgroundResource(R.drawable.warning);
        }
       else
        {
            status_header.setBackgroundResource(R.drawable.safe);
        }

//if(virus != null)
        health_status.setText(virus);

    btn1 = (Button)findViewById(R.id.btn_prevention);
    diagnoseBtn = (Button)findViewById(R.id.btn_diagnose);
    btnProtect = (Button)findViewById(R.id.btn_protect);
        btnRetrofit = (Button)findViewById(R.id.retrofit);
        btn_mask = (Button)findViewById(R.id.mymask);
        map = (Button)findViewById(R.id.virus_Map);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageMain.class);
                startActivity(intent);            }
        });


        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                diagnoseBtn.setEnabled(true);
                diagnoseBtn.setBackgroundResource(R.drawable.diagnoseyourself);
            }
        }, 50000);
        diagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(final View v) {
                diagnoseBtn.setEnabled(false);
               diagnoseBtn.setBackgroundResource(R.drawable.mylock);

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

        btn_mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mask.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){

            GoogleSignInAccount account=result.getSignInAccount();
           email_header.setText(account.getDisplayName().toString());
           name_header.setText(account.getEmail().toString());



            try{
                Glide.with(this).load(account.getPhotoUrl()).into(image1_header);
            }catch (NullPointerException e){
                Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_LONG).show();
            }



        }else{
            Toast.makeText(getApplicationContext(),"Fail to get data", Toast.LENGTH_LONG).show();
           // gotoMainActivity();
        }
    }




}

