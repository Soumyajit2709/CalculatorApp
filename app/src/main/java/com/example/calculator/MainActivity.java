package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String ans="";
    ArrayList <Integer> a = new ArrayList<Integer>();

    Button number0;
    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button openbrac;
    Button closebrac;
    Button percentage;
    Button division;
    Button multiplication;
    Button addition;
    Button substraction;
    Button equal;
    Button dot;
    Button clear;

    TextView resultTextView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
    }

    private void initControlListener() {
        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="0";
                textView.setText(textView.getText() + "0");
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="1";
                textView.setText(textView.getText() + "1");
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="2";
                textView.setText(textView.getText() + "2");
            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="3";
                textView.setText(textView.getText() + "3");
            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="4";
                textView.setText(textView.getText() + "4");
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="5";
                textView.setText(textView.getText() + "5");
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="6";
                textView.setText(textView.getText() + "6");
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="7";
                textView.setText(textView.getText() + "7");
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="8";
                textView.setText(textView.getText() + "8");
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans+="9";
                textView.setText(textView.getText() + "9");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans="";
                textView.setText(null);
                resultTextView.setText(null);
                a.clear();
            }
        });
        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="-";
                        textView.setText(textView.getText() + "-");
                    }
                }
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="+";
                        textView.setText(textView.getText() + "+");
                    }
                }
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="*";
                        textView.setText(textView.getText() + "*");
                    }


                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="/";
                        textView.setText(textView.getText() + "/");
                    }
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = ans;
                    char ch = s.charAt(s.length() - 1);
                    if (ch == '+' || ch == '-' || ch == '%' || ch == '*' || ch == '/' || ch=='.')
                    {
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        a.add(s.length()-1);
                        s+= "=";

                        double res=Double.parseDouble(s.substring(0,a.get(0)+1));

                        for(int i=0;i<a.size()-1;i++)
                        {
                            double answ = Double.parseDouble(s.substring(a.get(i)+2,a.get(i+1)+1));
                            if(s.charAt(a.get(i)+1)=='+')
                            {
                                res+=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='-')
                            {
                                res-=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='/')
                            {
                                res/=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='*')
                            {
                                res*=answ;
                            }
                            else if(s.charAt(a.get(i)+1)=='%')
                            {
                                res=(res)*(answ)/10000;
                            }
                        }

                        String answer = String.valueOf(res);
                        a.clear();

                        resultTextView.setText(answer );
                        ans=answer;
                    }


                }
            }
        });


        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.')
                    {
                        ans+=".";
                        textView.setText(textView.getText() + ".");
                    }

                }


            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.')
                    {
                        a.add(s.length()-1);
                        ans+="%";
                        textView.setText(textView.getText() + "%");
                    }


                }
            }
        });

        openbrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans += "*";
                        textView.setText(textView.getText() + "(");
                    }
                }
            }
        });

        closebrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty())
                {
                    String s = textView.getText().toString();
                    char ch=s.charAt(s.length()-1);
                    if(ch!='+' && ch!='-' && ch!='%' && ch!='*' && ch!='/' && ch!='.') {
                        a.add(s.length()-1);
                        ans+="*";
                        textView.setText(textView.getText() + ")");
                    }
                }
            }
        });


    }


    private void initControl() {
        number0 = (Button)findViewById(R.id.number0);
        number1 = (Button)findViewById(R.id.number1);
        number2 = (Button)findViewById(R.id.number2);
        number3 = (Button)findViewById(R.id.number3);
        number4 = (Button)findViewById(R.id.number4);
        number5 = (Button)findViewById(R.id.number5);
        number6 = (Button)findViewById(R.id.number6);
        number7 = (Button)findViewById(R.id.number7);
        number8 = (Button)findViewById(R.id.number8);
        number9 = (Button)findViewById(R.id.number9);

        addition = (Button)findViewById(R.id.addition);
        clear = (Button)findViewById(R.id.clear);
        substraction = (Button)findViewById(R.id.substraction);
        multiplication = (Button)findViewById(R.id.multiplication);
        division = (Button)findViewById(R.id.division);
        equal = (Button)findViewById(R.id.equal);

        dot = (Button)findViewById(R.id.dot);
        openbrac = (Button)findViewById(R.id.openbrackets);
        percentage = (Button)findViewById(R.id.percentage);
        closebrac = (Button)findViewById(R.id.closebrackets);

        resultTextView = (TextView)findViewById(R.id.output);
        textView = (TextView)findViewById(R.id.data);
    }
}