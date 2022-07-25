package com.example.calculatormvp.presenter;


import android.view.View;
import android.widget.Button;


public class CalculatorContract {
    public interface ViewInterface{
        void setTextOutput(String textInput);
        void setAppendOutput(String textInput);
    }

    public interface PresenterInterface{
        void calculationProcessing(String n);
        void updateMethod(String method);
        void showOutput();
    }
}
