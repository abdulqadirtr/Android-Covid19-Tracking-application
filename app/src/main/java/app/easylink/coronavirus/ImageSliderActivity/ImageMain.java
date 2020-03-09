package app.easylink.coronavirus.ImageSliderActivity;

import android.animation.ArgbEvaluator;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import app.easylink.coronavirus.R;


public class ImageMain extends AppCompatActivity {

    ViewPager viewPager;
    CustomAdapter myAdapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.water1, R.drawable.washandetail, "Wash Your Hands with alcohol-based hand rub or Soap", "Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water." +
                "\n\n" +
                "Wash your hands with soap or using alcohol-based hand rub to kills viruses that may be on your hands."));
        models.add(new Model(R.drawable.distance,  R.drawable.distance1, "Maintain social distance of atleast 1M", "Maintain at least 1 metre (3 feet) distance between yourself and anyone who is coughing or sneezing.\n\n" +
                "Why? When someone coughs or sneezes they spray small liquid droplets from their nose or mouth which may contain virus. " +
                "\n\nIf you are too close, you can breathe in the droplets, including the COVID-19 virus if the person coughing has the disease."));
        models.add(new Model(R.drawable.foodsafety, R.drawable.foodsafty2, "Food Safety", "Wash your hands and food stuff properly before cooking." +
                "\n"+"Don't sneeze or cough without a tissue paper or use your elbow to cover your mouth and nose." +
                "\n"+"Try to cover your hands with disposable gloves"));
        models.add(new Model(R.drawable.mask, R.drawable.mask2, "Why Using Mask for Coronavirus", "If you are healthy, you only need to wear a mask if you are taking care of a person with suspected 2019-nCoV infection.\n" +
                "Wear a mask if you are coughing or sneezing.\n" +
                "Masks are effective only when used in combination with frequent hand-cleaning with alcohol-based hand rub or soap and water.\n" +
                "If you wear a mask, then you must know how to use it and dispose of it properly."));
        models.add(new Model(R.drawable.medical, R.drawable.medical, "Seek Medical Care if you have fever, cough and sneezing", "If you have a fever, cough and difficulty breathing, seek medical attention and call in advance. " +
                "\n Follow the directions of your local health authority."));
        myAdapter = new CustomAdapter(models,this);
 //      adapter = new CustomAdapter(models, ImageMain.this);

    viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2)
        };

        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (myAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });

    }
    }