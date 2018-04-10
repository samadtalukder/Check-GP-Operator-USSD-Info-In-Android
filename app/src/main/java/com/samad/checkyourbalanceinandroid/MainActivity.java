package com.samad.checkyourbalanceinandroid;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRobi, btnAirtel, btnBanglalink, btnGP, btnTT;
    String encodeHash = Uri.encode("#");
    String ussd;
    private static final int REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        btnRobi = findViewById(R.id.btnRobi);
        btnAirtel = findViewById(R.id.btnAirtel);
        btnBanglalink = findViewById(R.id.btnBanglalink);
        btnGP = findViewById(R.id.btnGrameen);
        btnTT = findViewById(R.id.btnTeletalk);
        //
        btnGP.setOnClickListener(this);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        }
        else {
            switch (v.getId()) {
                case R.id.btnRobi:
                    ussd = "*" + "222"+encodeHash;
                    //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussd)));
                    startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+ussd)),1);
                    break;

                case R.id.btnBanglalink:
                    ussd = "*"+"124"+encodeHash;
                    startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+ussd)),1);
                    break;
                case R.id.btnGrameen:
                    startActivity(new Intent(MainActivity.this,GPActivity.class));
                    //ussd = "*"+"566"+encodeHash;
                    //startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussd)),1);
                    //startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+ussd)),1);
                    break;
                case R.id.btnTeletalk:
                    ussd = "*"+"152"+encodeHash;
                    startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+ussd)),1);
                    break;
                case R.id.btnAirtel:
                    ussd = "*"+"778"+encodeHash;
                    startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+ussd)),1);
                    break;
            }
        }

    }
}
