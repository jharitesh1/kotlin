package com.example.kotlinsample.coroutines.session1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlinsample.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            String dateFormat = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

//            Date date1 = sdf.parse(System.currentTimeMillis());
            Date date2 = simpleDateFormat.parse("28-08-2020");


            Date currentDate = new Date(System.currentTimeMillis());
            String currentFormattedDate = simpleDateFormat.format(currentDate.getTime());
            Log.i("testing", " date : " + currentFormattedDate);
            Log.i("testing", " date2 : " + simpleDateFormat.format(date2.getTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("ritesh", "  : ");
    }
}
