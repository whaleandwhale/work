package com.example.admin.myapplication;

import android.app.Activity;
import android.app.RemoteAction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.admin.myapplication.R.id.text;

public class MainActivity extends Activity implements View.OnClickListener {
    Button BtnRooting, BtnSquare, BtnReciprocal, BtnCE, BtnC, BtnBack, BtnDivide, Btn7, Btn8, Btn9, BtnMultiply, Btn4, Btn5, Btn6, BtnMinus, Btn1, Btn2, Btn3, BtnPlus, BtnSign, Btn0, BtnPoint, BtnEqual;
    TextView text;
    boolean clear;
    double a =0;
    String str,exp,s1,s2,op;
    double ss1,ss2;
    int space,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnRooting = (Button) findViewById(R.id.BtnRooting);
        BtnSquare = (Button) findViewById(R.id.BtnSquare);
        BtnReciprocal = (Button) findViewById(R.id.BtnReciprocal);
        BtnCE = (Button) findViewById(R.id.BtnCE);
        BtnC = (Button) findViewById(R.id.BtnC);
        BtnBack = (Button) findViewById(R.id.BtnBack);
        BtnDivide = (Button) findViewById(R.id.BtnDivide);
        Btn7 = (Button) findViewById(R.id.Btn7);
        Btn8 = (Button) findViewById(R.id.Btn8);
        Btn9 = (Button) findViewById(R.id.Btn9);
        BtnMultiply = (Button) findViewById(R.id.BtnMultiply);
        Btn4 = (Button) findViewById(R.id.Btn4);
        Btn5 = (Button) findViewById(R.id.Btn5);
        Btn6 = (Button) findViewById(R.id.Btn6);
        BtnMinus = (Button) findViewById(R.id.BtnMinus);
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn3 = (Button) findViewById(R.id.Btn3);
        BtnPlus = (Button) findViewById(R.id.BtnPlus);
        BtnSign = (Button) findViewById(R.id.BtnSign);
        Btn0 = (Button) findViewById(R.id.Btn0);
        BtnPoint = (Button) findViewById(R.id.BtnPoint);
        BtnEqual = (Button) findViewById(R.id.BtnEqual);
        text = (TextView) findViewById(R.id.text);
        BtnRooting.setOnClickListener(this);
        BtnSquare.setOnClickListener(this);
        BtnReciprocal.setOnClickListener(this);
        BtnCE.setOnClickListener(this);
        BtnC.setOnClickListener(this);
        BtnBack.setOnClickListener(this);
        BtnDivide.setOnClickListener(this);
        Btn7.setOnClickListener(this);
        Btn8.setOnClickListener(this);
        Btn9.setOnClickListener(this);
        BtnMultiply.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        Btn6.setOnClickListener(this);
        BtnMinus.setOnClickListener(this);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        BtnPlus.setOnClickListener(this);
        BtnSign.setOnClickListener(this);
        Btn0.setOnClickListener(this);
        BtnPoint.setOnClickListener(this);
        BtnEqual.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        str = text.getText().toString();
        switch (v.getId()) {
            case R.id.Btn1:
            case R.id.Btn2:
            case R.id.Btn3:
            case R.id.Btn4:
            case R.id.Btn5:
            case R.id.Btn6:
            case R.id.Btn7:
            case R.id.Btn8:
            case R.id.Btn9:
            case R.id.Btn0:
            case R.id.BtnPoint:
                if (clear) {
                    clear=false;
                    str = "";
                    text.setText("");
                }
                text.setText(str + ((Button) v).getText());
                break;
            case R.id.BtnPlus:
            case R.id.BtnDivide:
            case R.id.BtnMultiply:
            case R.id.BtnMinus:
                if (clear)
                {
                    clear=false;
                    str="";
                    text.setText("");
                }
                    text.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.BtnBack:
                if (clear)
                {
                    clear=false;
                    str="";
                    text.setText("");
                }
                else if (str != null && !str.equals(""))
                {
                    text.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.BtnCE:
                text.setText(s1+op);
                break;
            case R.id.BtnC:
                clear=false;
                str="";
                text.setText("");
                break;
            case R.id.BtnReciprocal:
                a=1/a;
                break;
            case R.id.BtnSquare:
                a=a*a;
                break;
            case R.id.BtnRooting:
                a=Math.sqrt(a);
                break;
            case R.id.BtnEqual:
                getResult();
                break;
            }
        }

    private void getResult(){
        exp = text.getText().toString();
        if (exp == null||exp.equals(""))
        {
            return;
        }
        if(!exp.contains(" "))
        {
            return;
        }
        if (clear)
        {
            clear = false ;
            return;
        }
        clear= true ;
        space=exp.indexOf(" ");
        s1 = exp.substring(0,space);
        op = exp.substring(space+1,space+2) ;
        s2 = exp.substring(space+3) ;
        if (!s1.equals(" ")&&!s2.equals(" ")){
            ss1 = Double.parseDouble(s1) ;
            ss2 = Double.parseDouble(s2) ;
            if (op.equals("＋")){
                a = ss1 + ss2 ;

            }else  if (op.equals("－")){
                a = ss1 - ss2 ;

            }else  if (op.equals("×")){
                a = ss1 * ss2 ;

            }else  if (op.equals("÷")){
                if(ss2 == 0){
                    text.setText("除数不能为零");
                }
                else
                {
                    a = ss1/ss2 ;
                }
            }
            if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷"))
            {
                result = (int) a;
                text.setText(result+"");
            }
            else
                {
                text.setText(a+"");

            }
        }
        else if (!s1.equals("")&&s2.equals(""))
        {
          text.setText(exp);
        }
        else if (s1.equals("")&&!s2.equals("")){
            ss2=Double.parseDouble(s2);
            if (op.equals("＋")){
                a = 0 + ss2 ;

            }else  if (op.equals("－")){
                a = 0 - ss2 ;

            }else  if (op.equals("×")){
                a = 0 ;

            }else  if (op.equals("÷")){
                a = 0 ;
            }
            if (s2.contains(".")) {
                result = (int)a;
                text.setText(result+"");
            }else {
                text.setText(a+"");
            }
        }else {
            text.setText("");

        }
        if (a!=0)
        {
            ss1 = a;
            if (op.equals("＋"))
            {
                a = ss1 + ss2 ;
            }
            else if (op.equals("－"))
            {
                a = ss1 - ss2 ;
            }else  if (op.equals("×"))
            {
                a = ss1 * ss2 ;
            }else  if (op.equals("÷"))
            {
                if(ss2 == 0)
                {
                    text.setText("除数不能为零");
                }
                else
                {
                    a = ss1/ss2 ;
                }
            }
            if (s1.contains(".")&&s2.contains("."))
            {
                result = (int) a;
                text.setText(result+"");
            }
            else
            {
                text.setText(a + "");
            }
        }
        else if (!s1.equals("")&&s2.equals(""))
        {
            text.setText(exp);
        }
        else if (s1.equals("")&&!s2.equals(""))
        {
            double d2 = Double.parseDouble(s2) ;
            if (op.equals("＋"))
            {
                a = 0 + d2 ;
            }
            else  if (op.equals("－"))
            {
                a = 0 - d2 ;
            }else  if (op.equals("×"))
            {
                a = 0 ;
            }
            else  if (op.equals("÷"))
            {
                a = 0 ;
            }
            if (s2.contains("."))
            {
                result = (int) a;
                text.setText(result+"");
            }
            else
            {
                text.setText(a+"");
            }
        }
        else
        {
            text.setText("");
        }
    }
}




