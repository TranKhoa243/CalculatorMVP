package com.example.calculatormvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatormvp.R;
import com.example.calculatormvp.presenter.CalculatorContract;
import com.example.calculatormvp.presenter.CalculatorPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,CalculatorContract.ViewInterface{

    private TextView tvOutput;
    private Button btnAc, btnDivide,
            btn7, btn8, btn9, btnMultiply,
            btn4, btn5, btn6, btnMinus,
            btn1, btn2, btn3, btnPlus,
            btn0, btnPeriod, btnEquals;
    private CalculatorPresenter calculatorPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        calculatorPresenter=new CalculatorPresenter(this);
    }

    private void initializeComponents() {
        tvOutput = findViewById(R.id.tv_output);

        btnAc = findViewById(R.id.btn_ac);
        btnDivide = findViewById(R.id.btn_divide);
        btn7 = findViewById(R.id.btn_seven);
        btn8 = findViewById(R.id.btn_eight);
        btn9 = findViewById(R.id.btn_nine);
        btnMultiply = findViewById(R.id.btn_multiply);
        btn4 = findViewById(R.id.btn_four);
        btn5 = findViewById(R.id.btn_five);
        btn6 = findViewById(R.id.btn_six);
        btnMinus = findViewById(R.id.btn_minus);
        btn1 = findViewById(R.id.btn_one);
        btn2 = findViewById(R.id.btn_two);
        btn3 = findViewById(R.id.btn_three);
        btnPlus = findViewById(R.id.btn_plus);
        btn0 = findViewById(R.id.btn_zero);
        btnPeriod = findViewById(R.id.btn_period);
        btnEquals = findViewById(R.id.btn_equals);


        btnAc.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPeriod.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_ac:
                calculatorPresenter.calculationProcessing(getTextButton(btnAc));
                break;
            case R.id.btn_divide:
                calculatorPresenter.updateMethod(getTextButton(btnDivide));
                break;
            case R.id.btn_seven:
                calculatorPresenter.calculationProcessing(getTextButton(btn7));
                break;
            case R.id.btn_eight:
                calculatorPresenter.calculationProcessing(getTextButton(btn8));
                break;
            case R.id.btn_nine:
                calculatorPresenter.calculationProcessing(getTextButton(btn9));
                break;
            case R.id.btn_multiply:
                calculatorPresenter.updateMethod(getTextButton(btnMultiply));
                break;
            case R.id.btn_four:
                calculatorPresenter.calculationProcessing(getTextButton(btn4));
                break;
            case R.id.btn_five:
                calculatorPresenter.calculationProcessing(getTextButton(btn5));
                break;
            case R.id.btn_six:
                calculatorPresenter.calculationProcessing(getTextButton(btn6));
                break;
            case R.id.btn_minus:
                calculatorPresenter.updateMethod(getTextButton(btnMinus));
                break;
            case R.id.btn_one:
                calculatorPresenter.calculationProcessing(getTextButton(btn1));
                break;
            case R.id.btn_two:
                calculatorPresenter.calculationProcessing(getTextButton(btn2));
                break;
            case R.id.btn_three:
                calculatorPresenter.calculationProcessing(getTextButton(btn3));
                break;
            case R.id.btn_plus:
                calculatorPresenter.updateMethod(getTextButton(btnPlus));
                break;
            case R.id.btn_zero:
                calculatorPresenter.calculationProcessing(getTextButton(btn0));
                break;
            case R.id.btn_period:
                calculatorPresenter.calculationProcessing(getTextButton(btnPeriod));
                break;
            case R.id.btn_equals:
                calculatorPresenter.showOutput();
                break;
        }
    }

    public String getTextButton(Button button){
        return button.getText()+"";
    }

    @Override
    public void setTextOutput(String textInput) {
        tvOutput.setText(textInput);
    }

    @Override
    public void setAppendOutput(String textInput) {
        tvOutput.append(textInput);
    }
}