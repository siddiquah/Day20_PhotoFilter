package tech.hamid.day20_photofilter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zomato.photofilters.SampleFilters;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static
    {
        System.loadLibrary("NativeImageProcessor");
    }

    ImageView imageView, filter1, filter2, filter3, filter4, filter5, filter6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        filter1 = findViewById(R.id.filter1);
        filter2 = findViewById(R.id.filter2);
        filter3 = findViewById(R.id.filter3);
        filter4 = findViewById(R.id.filter4);
        filter5 = findViewById(R.id.filter5);
        filter6 = findViewById(R.id.filter6);

        filter1.setOnClickListener(this);
        filter2.setOnClickListener(this);
        filter3.setOnClickListener(this);
        filter4.setOnClickListener(this);
        filter5.setOnClickListener(this);
        filter6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filter1:
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new BrightnessSubFilter(30));
                myFilter.addSubFilter(new ContrastSubFilter(1.1f));

                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap image = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(image);

                imageView.setImageBitmap(outputImage);
                break;

            case R.id.filter2:
                Filter fooFilter = SampleFilters.getBlueMessFilter();
                BitmapDrawable drawable2 = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap2 = drawable2.getBitmap();
                Bitmap image2 = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage2 = fooFilter.processFilter(image2);
                imageView.setImageBitmap(outputImage2);
                break;

            case R.id.filter3:
                Filter fooFilter2 = SampleFilters.getStarLitFilter();
                BitmapDrawable drawable3 = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap3 = drawable3.getBitmap();
                Bitmap image3 = bitmap3.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage3 = fooFilter2.processFilter(image3);
                imageView.setImageBitmap(outputImage3);
                break;

            case R.id.filter4:
                Filter fooFilter3 = SampleFilters.getLimeStutterFilter();
                BitmapDrawable drawable4 = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap4 = drawable4.getBitmap();
                Bitmap image4 = bitmap4.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage4 = fooFilter3.processFilter(image4);
                imageView.setImageBitmap(outputImage4);
                break;

            case R.id.filter5:
                Filter fooFilter4 = SampleFilters.getNightWhisperFilter();
                BitmapDrawable drawable5 = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap5 = drawable5.getBitmap();
                Bitmap image5 = bitmap5.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage5 = fooFilter4.processFilter(image5);
                imageView.setImageBitmap(outputImage5);
                break;

            case R.id.filter6:
                Filter fooFilter5 = SampleFilters.getAweStruckVibeFilter();
                BitmapDrawable drawable6 = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap6 = drawable6.getBitmap();
                Bitmap image6 = bitmap6.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage6 = fooFilter5.processFilter(image6);
                imageView.setImageBitmap(outputImage6);
                break;


        }
    }
}