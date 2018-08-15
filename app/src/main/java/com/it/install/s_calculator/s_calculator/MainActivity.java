package com.it.install.s_calculator.s_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double _result;
    private String _operandScreen;
    private TextView _screenOperandView;
    private OperandPair _operandPair;

    // constructor
    public MainActivity() {
        this.clearResult();
    }

    private void clearResult() {
        this._operandScreen = "";
        this._operandPair = new OperandPair();
        this._result = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void oneButtonOnClick(View view) {
        this.setOperands("1");
    }

    public void twoButtonOnClick(View view) {
        this.setOperands("2");
    }

    public void threeButtonOnClick(View view) {
        this.setOperands("3");
    }

    public void fourButtonOnClick(View view) {
        this.setOperands("4");
    }

    public void fiveButtonOnClick(View view) {
        this.setOperands("5");
    }

    public void sixButtonOnClick(View view) {
        this.setOperands("6");
    }

    public void sevenButtonOnClick(View view) {
//Toast.makeText(getApplicationsContext(), "This is number 7", Toast.LE
        this.setOperands("7");

    }

    public void eightButtonOnClick(View view) {
        this.setOperands("8");

    }

    public void nineButtonOnClick(View view) {
        this.setOperands("9");
    }

    public void zeroButtonOnClick(View view) {
        this.setOperands("0");
    }

    public void decimalButtonOnClick(View view) {
        if (this._operandPair.OperatorType.equals("")) {
            this._operandPair.FirstOperand += ".";

            this._operandScreen = this._operandPair.FirstOperand;

            this._screenOperandView = (TextView) findViewById(R.id.screenOperands);

            this._screenOperandView.setText(this._operandScreen);

        } else {
            this._operandPair.SecondOperand += ".";
        }

    }


    public void equalButtonOnClick(View view) {
        this.calculateResult(view);
    }

    public void multiplyButtonOnClick(View view) {
        this._operandPair.OperatorType = "*";
    }


    public void divideButtonOnClick(View view) {
        this._operandPair.OperatorType = "/";
    }


    public void plusButtonOnClick(View view) {
        this._operandPair.OperatorType = "+";

        this._operandScreen += " + ";

        this._screenOperandView = (TextView) findViewById(R.id.screenOperands);

        this._screenOperandView.setText(this._operandScreen);
    }

    private void setOperands(String digit) {
        if (this._operandPair.OperatorType.equals("")) {
            this._operandPair.FirstOperand += digit;

            this._operandScreen = this._operandPair.FirstOperand;
        } else {
            this._operandPair.SecondOperand += digit;

            this._operandScreen = this._operandPair.FirstOperand + " " +
                    this._operandPair.OperatorType + " " + this._operandPair.SecondOperand;
        }

        this._screenOperandView = (TextView) findViewById(R.id.screenOperands);

        this._screenOperandView.setText(this._operandScreen);
    }

    private void calculateResult(View view) {
        switch (this._operandPair.OperatorType) {
            case "+":

//                Toast.makeText(getApplicationContext(), "This is _firstOperand:" +
//                                this._firstOperand + " and this is second: " + this._secondOperand,
//                        Toast.LENGTH_LONG).show();

                this._result = Double.valueOf(this._operandPair.FirstOperand) +
                        Double.valueOf(this._operandPair.SecondOperand);

                break;

            case "-":
                this._result = Double.valueOf(this._operandPair.FirstOperand) -
                        Double.valueOf(this._operandPair.SecondOperand);

                break;

            case "*":
                this._result = Double.valueOf(this._operandPair.FirstOperand) *
                        Double.valueOf(this._operandPair.SecondOperand);

                break;

            case "/":
                try {
                    if (this._operandPair.SecondOperand.equals(0) == false) {
                        this._result = Double.valueOf(this._operandPair.FirstOperand) /
                                Double.valueOf(this._operandPair.SecondOperand);
                    }

                } catch (ArithmeticException excp) {

                    return;
                }

                break;
        }

        final TextView screenResultView = (TextView) findViewById(R.id.screenResult);

        screenResultView.setText("" + this._result);

//        Toast.makeText(getApplicationContext(), "This equals " + this._result, Toast.LENGTH_LONG).show();

        this.clearResult();
    }
}