package com.example.tc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int flag=0;
    String value1=" ",value2=" ",action=" ",total,res=" ";
    public void Append(View view)
    {
        int id=view.getId();
        if (flag == 0 || flag==2)
        {
            flag=0;
            if (id == R.id.one)
                value1=value1+"1";
            if (id == R.id.two)
                value1=value1+"2";
            if (id == R.id.three)
                value1=value1+"3";
            if (id == R.id.four)
                value1=value1+"4";
            if (id == R.id.five)
                value1=value1+"5";
            if (id == R.id.six)
                value1=value1+"6";
            if (id == R.id.seven)
                value1=value1+"7";
            if (id == R.id.eight)
                value1=value1+"8";
            if (id == R.id.nine)
                value1=value1+"9";
            if (id == R.id.zero)
                value1=value1+"0";
            if (id == R.id.decimal)
                value1=value1+".";
        }
        else if (flag == 1)
        {
            if (id == R.id.one)
                value2=value2+"1";
            if (id == R.id.two)
                value2=value2+"2";
            if (id == R.id.three)
                value2=value2+"3";
            if (id == R.id.four)
                value2=value2+"4";
            if (id == R.id.five)
                value2=value2+"5";
            if (id == R.id.six)
                value2=value2+"6";
            if (id == R.id.seven)
                value2=value2+"7";
            if (id == R.id.eight)
                value2=value2+"8";
            if (id == R.id.nine)
                value2=value2+"9";
            if (id == R.id.zero)
                value2=value2+"0";
            if (id == R.id.decimal)
                value2=value2+".";
        }
        TextView textView=findViewById(R.id.result);
        total=value1 + action + value2;
        textView.setText(total);
    }
    public void Action(View view)
    {
        if(flag==2)
        {
            value1=res;
            value2=" ";
            flag=1;
        }
        else
            flag=1;
        int id=view.getId();
        if (id==R.id.subtract && action != " ")
            value2=value2+"-";
        if (id == R.id.add)
            action="+";
        if (id == R.id.subtract && value1.length()>1 && action==" ")
            action="-";
        if (id == R.id.subtract && value1.length()==1)
        {
            value1 = value1 + "-";
            flag=0;
        }
        if (id == R.id.multiply)
            action="*";
        if (id == R.id.divide)
            action="÷";
        TextView textView=findViewById(R.id.result);
        total=value1 + action + value2;
        textView.setText(total);
    }
    public void Result(View view)
    {
        flag=2;
        double n1=Double.parseDouble(value1);
        double n2=Double.parseDouble(value2);
        if (action == "+")
            res=Double.toString(n1+n2);
        if (action == "-")
            res=Double.toString(n1-n2);
        if (action == "÷")
            res=Double.toString(n1/n2);
        if (action == "*")
            res=Double.toString(n1*n2);
        if (action == " ")
            res=" ";
        value2=" ";
        action=" ";
        value1=" ";
        TextView textView=findViewById(R.id.result);
        textView.setText(res);
        Button button=findViewById(R.id.delete);
        button.setText("CLR");
    }
    public void Trim(View view)
    {
        switch (flag)
        {
            case 0:
                if (value1.length()>1)
                {
                    value1= value1.substring(0,value1.length()-1);
                    total=value1 + action + value2;
                }
                break;
            case 1:
                if (value2.length()>1)
                {
                    value2 = value2.substring(0, value2.length() - 1);
                    total = value1 + action + value2;
                }
                else
                {
                    action = " ";
                    flag=0;
                    total=value1+action+value2;
                }
                break;
            default:
                total=" ";
                value2=" ";
                action=" ";
                value1=" ";
                flag=0;
        }
        TextView textView=findViewById(R.id.result);
        textView.setText(total);
        Button button=findViewById(R.id.delete);
        button.setText("DEL");
    }
}