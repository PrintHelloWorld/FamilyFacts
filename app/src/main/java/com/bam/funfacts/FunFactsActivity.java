package com.bam.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";

    private TextView mFactTextView;
    private Button mNewFactButton;
    private RelativeLayout mRelativeLayout;

    private String mFact = FactBook.getFact();
    private int mColor = ColorWheel.getColor();

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
                mFact = FactBook.getFact();
                mFactTextView.setText(mFact);

                mColor = ColorWheel.getColor();
                mRelativeLayout.setBackgroundColor(mColor);
                mNewFactButton.setTextColor(mColor);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mFactTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mRelativeLayout.setBackgroundColor(mColor);
        mNewFactButton.setTextColor(mColor);
    }
}
