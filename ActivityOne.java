package com.example.kirill.p5;

import com.example.kirill.p5.ActivityOne_F2.onSomeEventListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ActivityOne extends Activity implements onSomeEventListener{

    ActivityOne_F1 frag1;
    ActivityOne_F2 frag2;
    FragmentTransaction fTrans;
    CheckBox chbStack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Fragment frag2 = new ActivityOne_F2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment2, frag2);
        ft.commit();
    }

    public void onClick(View v) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView1))
                .setText("Access to Fragment 1 from Activity");

        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView) frag2.getView().findViewById(R.id.textView2))
                .setText("Access to Fragment 2 from Activity");
    }

    @Override
    public void someEvent(String s) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView)frag1.getView().findViewById(R.id.textView1)).setText("Text from Fragment 2:" + s);
    }
}