package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private TextView display2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display2=findViewById(R.id.Textview);
        display = findViewById(R.id.Edittext);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd) {
        String odlStr = display.getText().toString();
        int curPos = display.getSelectionStart();
        String leftStr = odlStr.substring(0, curPos);
        String rightStr = odlStr.substring(curPos);
        /*if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(lastPos);
        }
        else{ */
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(curPos + 1);

    }

    public void zeroBTN(View view){
        updateText("0");
    }
    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void cBTN(View view){
        display.setText("");
        display2.setText("");

    }
    public void equalBTN(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("x","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        display2.setText(result);


    }
    public void subBTN(View view){
        updateText("-");
    }
    public void plusBTN(View view){
        updateText("+");
    }
    public void multiBTN(View view){
        updateText("x");
    }
    public void divBTN(View view){
        updateText("/");
    }
    public void backspaceBTN(View view){
        int curPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(curPos!=0 && textLen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(curPos-1,curPos,"");
            display.setText(selection);
            display.setSelection(curPos-1);
        }
    }
    public void modBTN(View view){
        updateText("%");
    }


}