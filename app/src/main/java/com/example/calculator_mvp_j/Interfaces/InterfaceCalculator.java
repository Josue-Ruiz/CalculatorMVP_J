package com.example.calculator_mvp_j.Interfaces;

public interface InterfaceCalculator {
    interface View{
        void findElements();
        void showResults(String result);
    }

    interface Presenter{
        void pressedNumber(String value);
        void validateDot(String dot);
        void clearAll();
        void selectedOperation(int operation);
        void solveOperation();
        void sendResultOperation(float result);
    }

    interface Model{
        void addition(float first_number, float second_number);
        void subtraction(float first_number, float second_number);
        void multiplication(float first_number, float second_number);
        void division(float first_number, float second_number);
    }
}
