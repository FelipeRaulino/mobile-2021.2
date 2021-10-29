package com.example.componentesbasicos;

public class NumbersView {
    private int ivNumbersImageId;
    private String mNumberInDigit;
    private String mNumbersInText;

    public NumbersView(int NumbersImageId, String NumberInDigit, String NumbersInText) {
        ivNumbersImageId = NumbersImageId;
        mNumberInDigit = NumberInDigit;
        mNumbersInText = NumbersInText;
    }

    public int getNumbersImageId() {
        return ivNumbersImageId;
    }

    public String getNumberInDigit() {
        return mNumberInDigit;
    }

    public String getNumbersInText() {
        return mNumbersInText;
    }
}
