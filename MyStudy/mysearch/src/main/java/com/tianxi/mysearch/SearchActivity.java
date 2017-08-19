package com.tianxi.mysearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.toobar)
    Toolbar toolbar;
//    @BindView(R.id.ed)
//    EditText editText;
//    @BindView(R.id.image)
//    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

//        Bundle bundle;
//        if ((bundle =getIntent().getExtras())!= null) {
//            A a= (A) bundle.getSerializable("a");
//            assert a.getC()!=null;
//
//           editText.setText(a.getC()+"aaa");
//
//        }
    }



}
