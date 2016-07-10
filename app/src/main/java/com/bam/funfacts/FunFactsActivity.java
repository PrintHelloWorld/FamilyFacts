package com.bam.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    private TextView mFactTextView;
    private Button mNewFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mNewFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        mNewFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFactTextView.setText(FactBook.getFact());

                int color = ColorWheel.getColor();
                mRelativeLayout.setBackgroundColor(color);
                mNewFactButton.setTextColor(color);
            }
        });
    }
}
