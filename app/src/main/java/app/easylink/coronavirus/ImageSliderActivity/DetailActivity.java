package app.easylink.coronavirus.ImageSliderActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import app.easylink.coronavirus.R;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("param"));
        int id = getIntent().getIntExtra("img", -1);
        imageView.setImageResource(id);




    }


}
