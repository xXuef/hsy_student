package com.example.mytestmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IFIsShowView, View.OnClickListener {

    private TextView tv;
    private Button bt;
    private Presenter ipesenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);

        ipesenter = new Presenter(this);
    }

    @Override
    public void show(String str) {
        tv.setText(str);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt:
                ipesenter.show();
                break;
        }
    }
}
