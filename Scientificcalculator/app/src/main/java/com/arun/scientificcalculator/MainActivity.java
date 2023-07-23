package com.arun.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
private TextView previousresult;
private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousresult=findViewById(R.id.previousresultView);
        display=findViewById(R.id.displayedittext);
        display.setShowSoftInputOnFocus(false);

    }
    private void updateText(String strToAdd){
        String oldstr=display.getText().toString();//to take values more than one characters
        int cursorPos=display.getSelectionStart();//to find current position of a cursor
        String leftstr=oldstr.substring(0,cursorPos);
        String rightstr=oldstr.substring(cursorPos);//no need to shift
        display.setText(String.format("%s%s%s",leftstr,strToAdd,rightstr));
        display.setSelection(cursorPos+strToAdd.length());
    }
    public void ZerobtnPush(View v){
        updateText("0");

    }
    public void onebtnPush(View v){
        updateText("1");

    }
    public void twobtnPush(View v){
        updateText("2");

    }
    public void threebtnPush(View v){
        updateText("3");

    }
    public void fourbtnPush(View v){
        updateText("4");

    }
    public void fivebtnPush(View v){
        updateText("5");

    }
    public void sixbtnPush(View v){
        updateText("6");

    }
    public void sevenbtnPush(View v){
        updateText("7");

    }
    public void eightbtnPush(View v){
        updateText("8");

    }
    public void ninebtnPush(View v){
        updateText("9");

    }
    public void AddbtnPush(View v){
        updateText("+");

    }
    public void substractbtnPush(View v){
        updateText("-");

    }
    public void multiplybtnPush(View v){
        updateText("*");

    }
    public void devidebtnPush(View v){
        updateText("/");

    }
    public void decimalbtnPush(View v){
        updateText(".");

    }
    public void equalbtnPush(View v){
        String userExp=display.getText().toString();
        previousresult.setText(userExp);

        userExp =userExp.replaceAll(getResources().getString(R.string.DivideText),"/");
        userExp =userExp.replaceAll(getResources().getString(R.string.MultiplyText),"*");

        Expression exp=new Expression(userExp);
        double result = exp.calculate();
        if(Double.isNaN(result)){
            display.setText("Error");
        }
        else {
            String resultstr=String.valueOf(result);
            display.setText(resultstr);
            display.setSelection(resultstr.length());
        }
    }
    public void openbracketsbtnPush(View v){
        updateText("(");

    }
    public void closebracketsbtnPush(View v){
        updateText(")");

    }

    public void clearbtnPush(View v){
       display.setText("");
       previousresult.setText("");

    }
    public void backspacebtnPush(View v){
        int cursorPos=display.getSelectionStart();
        int textlen=display.getText().length();

        if(cursorPos!=0 && textlen!=0){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }

    }
    public void sinbtnpush(View v){
        updateText("sin(");
        
    }
    public void cosbtnpush(View v){
    updateText("cos(");
    }
    public void tanbtnpush(View v){
    updateText("tan(");
    }
    public void Arcsinbtnpush(View v){
        updateText("arcSin(");
    }
    public void Arccosbtnpush(View v){
    updateText("arccos(");
    }
    public void Arctanbtnpush(View v){
    updateText("arctan(");
    }
    public void logbtnpush(View v){
    updateText(("log("));
    }
    public void naturallogbtnpush(View v){
    updateText("ln(");
    }
    public void squarerootbtnpush(View v){
    updateText(("Sqrt("));
    }
    public void ebtnpush(View v){
    updateText("e");
    }
    public void pibtnpush(View v){
    updateText("pi");
    }
    public void absoloutebtnpush(View v){
    updateText("abs(");
    }
    public void isprimebtnpush(View v){
    updateText("ispr(");
    }
    public void xpowerbtnpush(View v){
updateText("^(2)");
    }
    public void xpowerybtnpush(View v){
updateText("^(");
    }


}