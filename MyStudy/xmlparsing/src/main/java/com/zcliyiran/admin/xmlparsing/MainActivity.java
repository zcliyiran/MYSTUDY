package com.zcliyiran.admin.xmlparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);







    }

    public void onClick(View view) {
        Intent  intent=new Intent();

        switch (view.getId()) {
            case R.id.btn1:
                intent.setClass(this,DomActivity.class);

                break;
            case R.id.btn2:

                intent.setClass(this,PullActivity.class);


                break;
            case R.id.btn3:
                intent.setClass(this,SaxActivity.class);

                break;


            default:

        }

        startActivity(intent);
    }
}
