package com.example.calculator_mvp_j.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator_mvp_j.Interfaces.InterfaceCalculator;
import com.example.calculator_mvp_j.Presenters.PresenterCalculator;
import com.example.calculator_mvp_j.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCalculator.View {

    Button button_addition, button_multiplication, button_division, button_subtraction,button_clear, button_dot,
            button_equals, button_number_one, button_number_two,button_number_three,button_number_four,button_number_five,
            button_number_six,button_number_seven,button_number_eight,button_number_nine,button_number_zero;
    TextView tv_Result;
        InterfaceCalculator.Presenter presenter;
        int addition = 1, subtraction = 2, multiplication = 3, division = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findElements();
        presenter = new PresenterCalculator(this,tv_Result,button_addition,
                button_multiplication, button_division, button_subtraction);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.buttonZero) {
            this.presenter.pressedNumber(getString(R.string.zero));
        }
        if (id == R.id.buttonOne){
            this.presenter.pressedNumber(getString(R.string.one));
        }
        if (id == R.id.buttonTwo){
            this.presenter.pressedNumber(getString(R.string.two));
        }
        if (id == R.id.buttonThree) {
            this.presenter.pressedNumber(getString(R.string.three));
        }
        if (id == R.id.buttonFour) {
            this.presenter.pressedNumber(getString(R.string.four));
        }
        if (id == R.id.buttonFive) {
            this.presenter.pressedNumber(getString(R.string.five));
        }
        if (id == R.id.buttonSix) {
            this.presenter.pressedNumber(getString(R.string.six));
        }
        if (id == R.id.buttonSeven) {
            this.presenter.pressedNumber(getString(R.string.seven));
        }
        if (id == R.id.buttonEight) {
            this.presenter.pressedNumber(getString(R.string.eight));
        }
        if (id == R.id.buttonNine){
            this.presenter.pressedNumber(getString(R.string.nine));
        }
        if (id == R.id.button_dot) {
            this.presenter.validateDot(getString(R.string.dot));
        }
        if (id == R.id.buttonAddition) {
            this.presenter.selectedOperation(addition);
        }
        if (id == R.id.buttonSubtraction){
            this.presenter.selectedOperation(subtraction);
        }
        if (id == R.id.buttonMultiplication){
            this.presenter.selectedOperation(multiplication);
        }
        if (id == R.id.buttonDivision){
            this.presenter.selectedOperation(division);
        }
        if (id == R.id.buttonClean){
            this.presenter.clearAll();
        }
        if (id == R.id.buttonEquals){
            this.presenter.solveOperation();
        }

    }

    @Override
    public void findElements() {
        tv_Result = findViewById(R.id.tv_Result);
        tv_Result.setOnClickListener(this);
        //operaciones
        button_addition = findViewById(R.id.buttonAddition);
        button_addition.setOnClickListener(this);
        button_multiplication = findViewById(R.id.buttonMultiplication);
        button_multiplication.setOnClickListener(this);
        button_division = findViewById(R.id.buttonDivision);
        button_division.setOnClickListener(this);
        button_subtraction = findViewById(R.id.buttonSubtraction);
        button_subtraction.setOnClickListener(this);
        button_clear = findViewById(R.id.buttonClean);
        button_clear.setOnClickListener(this);
        button_equals = findViewById(R.id.buttonEquals);
        button_equals.setOnClickListener(this);
        button_dot = findViewById(R.id.button_dot);
        button_dot.setOnClickListener(this);
        //numeros
        button_number_one = findViewById(R.id.buttonOne);
        button_number_one.setOnClickListener(this);
        button_number_two = findViewById(R.id.buttonTwo);
        button_number_two.setOnClickListener(this);
        button_number_three = findViewById(R.id.buttonThree);
        button_number_three.setOnClickListener(this);
        button_number_four = findViewById(R.id.buttonFour);
        button_number_four.setOnClickListener(this);
        button_number_five = findViewById(R.id.buttonFive);
        button_number_five.setOnClickListener(this);
        button_number_six = findViewById(R.id.buttonSix);
        button_number_six.setOnClickListener(this);
        button_number_seven = findViewById(R.id.buttonSeven);
        button_number_seven.setOnClickListener(this);
        button_number_eight = findViewById(R.id.buttonEight);
        button_number_eight.setOnClickListener(this);
        button_number_nine = findViewById(R.id.buttonNine);
        button_number_nine.setOnClickListener(this);
        button_number_zero = findViewById(R.id.buttonZero);
        button_number_zero.setOnClickListener(this);
    }


    @Override
    public void showResults(String result) {
        tv_Result.setText(result);
    }
}