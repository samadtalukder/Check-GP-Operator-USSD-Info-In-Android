package com.samad.checkyourbalanceinandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GPActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnBalanceCheck,btnSimNumberCheck,btnPackageCheck,btnMinuteCheck,btnSmsCheck,btnDataCheck;
    String encodeHash= Uri.encode("#");
    String gpUSSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp);
        //
        btnBalanceCheck = findViewById(R.id.btnBalanceCheck);
        btnSimNumberCheck = findViewById(R.id.btnSimNumberCheck);
        btnPackageCheck = findViewById(R.id.btnPackageCheck);
        btnMinuteCheck = findViewById(R.id.btnMinuteCheck);
        btnSmsCheck = findViewById(R.id.btnSmsCheck);
        btnDataCheck = findViewById(R.id.btnDataCheck);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBalanceCheck:
                gpUSSD = "*"+"566"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;
            case R.id.btnSimNumberCheck:
                gpUSSD = "*"+"2"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;
            case R.id.btnPackageCheck:
                gpUSSD = "*"+"121"+"*"+"1"+"*"+"6"+"*"+"4"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;
            case R.id.btnMinuteCheck:
                gpUSSD = "*"+"566"+"*"+"20"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;
            case R.id.btnSmsCheck:
                gpUSSD = "*"+"566"+"*"+"2"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;
             case R.id.btnDataCheck:
                gpUSSD = "*"+"566"+"*"+"10"+encodeHash;
                startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:"+gpUSSD)),1);
                break;

        }
    }
}
