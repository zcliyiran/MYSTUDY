package com.tianxi.vpsixteenanimation;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    String  text;
    public BlankFragment() {
        // Required empty public constructor

    }

    public static BlankFragment newInstance(String text) {

        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        BlankFragment myOrderFra = new BlankFragment();
        myOrderFra.setArguments(bundle);
        return myOrderFra;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        text=getArguments().getString("text");
        textView.setTextSize(29);
        textView.setBackgroundColor(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        textView.setText(text);
        return textView;
    }

}
