package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int[] idButton={R.id.button_CE,R.id.button_C,R.id.button_BS,R.id.button_divide,
            R.id.button_seven,R.id.button_eight,R.id.button_nine,R.id.button_mul,
            R.id.button_four,R.id.button_five,R.id.button_six,R.id.button_add,
            R.id.button_one,R.id.button_two,R.id.button_three,R.id.button_sub,
            R.id.button_pre,R.id.button_zero,R.id.button_dot,R.id.button_result,};
TextView textMath, textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
    }

    void connect(){
        textMath=(TextView) findViewById(R.id.textM);
        textResult=(TextView) findViewById(R.id.textR);
        for(int i=0;i<idButton.length;i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
        textMath.setText("|");
        textResult.setText("0");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_CE)
        {
            textMath.setText("|");
        }
        else if(v.getId()==R.id.button_C)
        {
            textMath.setText("|");
        }
        else if(v.getId()==R.id.button_BS)
        {
            int i=textMath.getText().length()-1;
            CharSequence text= textMath.getText().subSequence(0,i);
            textMath.setText(text);
        }
        else if(textMath.getText().toString().trim().equals("|"))
        {
            textMath.setText(((Button) findViewById(v.getId())).getText());
        }
        else if(v.getId()==R.id.button_result)
        {
            cal();
        }
        else
        {
            textMath.append(((Button) findViewById(v.getId())).getText());
        }
    }
    void cal() {
        {
            String math = textMath.getText().toString().trim();
            if (math.length() > 0) {
                Balan balan = new Balan();
                String result = balan.valueMath(math) + "";
                String error = balan.getError();

                // check error
                if (error != null) {
                    textResult.setText(error);
                } else { // show result
                    textResult.setText(result);
                }
            }
        }
    }
}