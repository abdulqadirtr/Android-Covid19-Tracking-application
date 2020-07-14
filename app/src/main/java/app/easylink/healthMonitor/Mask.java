package app.easylink.healthMonitor;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mask extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
