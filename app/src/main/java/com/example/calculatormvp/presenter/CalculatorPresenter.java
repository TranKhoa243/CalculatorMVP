package com.example.calculatormvp.presenter;



import android.util.Log;

import com.example.calculatormvp.model.Calculator;

public class CalculatorPresenter implements CalculatorContract.PresenterInterface {
    private static final String AC= "AC";
    private boolean isFirstNumber = true;
    private Calculator calculator;
    CalculatorContract.ViewInterface viewInterface;


    public CalculatorPresenter(CalculatorContract.ViewInterface viewInterface) {
        this.viewInterface=viewInterface;
        this.calculator=new Calculator();
    }

    @Override
    public void updateMethod(String method)
    {
        // calling this means firstequation has started and
        // entering number has ended
        calculator.enteredNumberIsComplete();
        switch(method)
        {
            case "+":
                calculator.setMethod(Calculator.Method.ADDITION);
                break;
            case "-":
                calculator.setMethod(Calculator.Method.SUBTRACTION);
                break;
            case "x":
                calculator.setMethod(Calculator.Method.MULTIPLICATION);
                break;
            case "÷":
                calculator.setMethod(Calculator.Method.DIVISION);
                break;
        }

        viewInterface.setTextOutput("");
        isFirstNumber = true;
    }

    @Override
    public void calculationProcessing(String n) {
        if(n.equals(AC))
        {
            viewInterface.setTextOutput("0");
            isFirstNumber = true;
            calculator.resetEquation();
            return;
        }

        // if it's first equation we set the textview's text.
        if(isFirstNumber)
        {
            viewInterface.setTextOutput(n);
            //then we toggle off the isFirstEquation so next
            isFirstNumber = false;
        }
        // if isFirstEquation is off then we assume that we'll
        //be appending.
        else
        {
            viewInterface.setAppendOutput(n);
        }

        calculator.updateEquation(n);

    }

    @Override
    public void showOutput()
    {
        calculator.enteredNumberIsComplete();
        calculator.calculate();
        String output = calculator.getOutput();
        viewInterface.setTextOutput(output);
    }
}
