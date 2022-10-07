package com.example.calculator_mvp_j.Presenters;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator_mvp_j.Interfaces.InterfaceCalculator;
import com.example.calculator_mvp_j.Models.ModelCalculator;
import com.example.calculator_mvp_j.R;

import java.text.DecimalFormat;

public class PresenterCalculator implements InterfaceCalculator.Presenter {

    InterfaceCalculator.View view;
    InterfaceCalculator.Model model;

    TextView tv_Result;
    Button button_addition, button_multiplication, button_division, button_subtraction;
    int counterpointed = 0,operation;
    float num1 =0,num2=0;
    Context context;

    public PresenterCalculator(InterfaceCalculator.View view, TextView tv_Result,
                               Button button_addition, Button button_multiplication,
                               Button button_division, Button button_subtraction){
        this.tv_Result = tv_Result;
        this.button_addition = button_addition;
        this.button_subtraction = button_subtraction;
        this.button_multiplication= button_multiplication;
        this.button_division = button_division;
        this.view = view;
        this.model = new ModelCalculator(this);
    }

    @Override
    public void pressedNumber(String value) {
        if (tv_Result.getText().toString().equals("") && value.equals(getContext().getString(R.string.dot))){
            tv_Result.append(getContext().getString(R.string.zero));
        }
        tv_Result.append(value);
        if (operation != 0){
            num2 = Float.parseFloat( tv_Result.getText().toString());
        }
    }

    @Override
    public void validateDot(String dot) {
        if (counterpointed != 0){
            CharSequence text = getContext().getString(R.string.message);
            int duration = Toast.LENGTH_SHORT;
            makeToast(text, duration);
            return;
        }
        counterpointed = 1;
        pressedNumber(dot);
    }

    @Override
    public void clearAll() {
        tv_Result.setText("");
        counterpointed = 0;
        num1 = 0;
        num2 = 0;
        operation = 0;
    }

    @Override
    public void selectedOperation(int operation) {
        this.operation = operation;
        num1 = Float.parseFloat(tv_Result.getText().toString());
        tv_Result.setText("");
        counterpointed = 0;
        disableButtons();
    }

    @Override
    public void solveOperation() {
        if (operation == 1){
            setOperationAddition(num1, num2);
        }
        if (operation == 2){
            setOperationSubtraction(num1, num2);
        }
        if (operation == 3){
            setOperationMultiplication(num1, num2);
        }
        if (operation == 4){
            setOperationDivision(num1, num2);
        }
        operation = 0;
        resetButtons();
    }


    @Override
    public void sendResultOperation(float result) {
        this.view.showResults(setFormatNumber(result));
    }

    private void setOperationAddition(float first_number,float second_number){
        this.model.addition(first_number,second_number);
    }
    private void setOperationSubtraction(float first_number,float second_number) {
        this.model.subtraction(first_number,second_number);
    }
    private void setOperationMultiplication(float first_number,float second_number) {
        this.model.multiplication(first_number,second_number);
    }
    private void setOperationDivision(float first_number,float second_number) {
        this.model.division(first_number,second_number);
    }
    private String setFormatNumber(float number){
        DecimalFormat twoDigits = new DecimalFormat("#.00");
        counterpointed = 1;
        return twoDigits.format(number);
    }
    private void resetButtons(){
        button_addition.setEnabled(true);
        button_subtraction.setEnabled(true);
        button_multiplication.setEnabled(true);
        button_division.setEnabled(true);
    }
    private void disableButtons(){
        button_addition.setEnabled(false);
        button_subtraction.setEnabled(false);
        button_multiplication.setEnabled(false);
        button_division.setEnabled(false);
    }
    private void makeToast(CharSequence message,int duration){
        Toast toast = Toast.makeText(getContext(), message, duration);
        toast.show();
    }

    public Context getContext(){
        return context = (Context) this.view;
    }
}