package com.example.tiki_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SendData{
    TextView tvThanhTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhTien = findViewById(R.id.tvThanhTien);
        Toast.makeText(MainActivity.this,"AAAA",Toast.LENGTH_LONG).show();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frmContainerBelow, BelowFragment.newInstance("141.800 d")).commit();
    }


    @Override
    public void SendingData(Integer s, Integer price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 d");
        tvThanhTien.setText(decimalFormat.format(s*price));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frmContainerBelow, BelowFragment.newInstance(decimalFormat.format(s*price))).commit();
    }
}