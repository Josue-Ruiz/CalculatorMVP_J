package com.example.calculator_mvp_j.Models;

import com.example.calculator_mvp_j.Interfaces.InterfaceCalculator;
import com.example.calculator_mvp_j.Presenters.PresenterCalculator;

public class ModelCalculator implements InterfaceCalculator.Model{
    InterfaceCalculator.Presenter presenter;
    public ModelCalculator(PresenterCalculator presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addition(float first_number, float second_number) {
        this.presenter.sendResultOperation(first_number + second_number);
    }

    @Override
    public void subtraction(float first_number, float second_number) {
        this.presenter.sendResultOperation(first_number - second_number);
    }

    @Override
    public void multiplication(float first_number, float second_number) {
        this.presenter.sendResultOperation(first_number * second_number);
    }

    @Override
    public void division(float first_number, float second_number) {
        this.presenter.sendResultOperation(first_number / second_number);
    }
}
