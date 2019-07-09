package com.example.linechartlibrary;




public class SimpleAxisValueFormatter implements AxisValueFormatter {

    private ValueFormatterHelper valueFormatterHelper = new ValueFormatterHelper();

    public SimpleAxisValueFormatter() {
        valueFormatterHelper.determineDecimalSeparator();
    }

    public SimpleAxisValueFormatter(int decimalDigitsNumber) {
        this();
        valueFormatterHelper.setDecimalDigitsNumber(decimalDigitsNumber);
    }

    @Override
    public int formatValueForManualAxis(char[] formattedValue, AxisValue axisValue) {
        final int charsNumber = valueFormatterHelper.formatFloatValueWithPrependedAndAppendedText(formattedValue,
                axisValue.getValue(), axisValue.getLabelAsChars());
        return charsNumber;
    }

    @Override
    public int formatValueForAutoGeneratedAxis(char[] formattedValue, float value, int autoDecimalDigits) {
        final int charsNumber = valueFormatterHelper.formatFloatValueWithPrependedAndAppendedText(formattedValue,
                value, autoDecimalDigits);
        return charsNumber;
    }

    public int getDecimalDigitsNumber() {
        return valueFormatterHelper.getDecimalDigitsNumber();
    }

    public SimpleAxisValueFormatter setDecimalDigitsNumber(int decimalDigitsNumber) {
        valueFormatterHelper.setDecimalDigitsNumber(decimalDigitsNumber);
        return this;
    }

    public char[] getAppendedText() {
        return valueFormatterHelper.getAppendedText();
    }

    public SimpleAxisValueFormatter setAppendedText(char[] appendedText) {
        valueFormatterHelper.setAppendedText(appendedText);
        return this;
    }

    public char[] getPrependedText() {
        return valueFormatterHelper.getPrependedText();
    }

    public SimpleAxisValueFormatter setPrependedText(char[] prependedText) {
        valueFormatterHelper.setPrependedText(prependedText);
        return this;
    }

    public char getDecimalSeparator() {
        return valueFormatterHelper.getDecimalSeparator();
    }

    public SimpleAxisValueFormatter setDecimalSeparator(char decimalSeparator) {
        valueFormatterHelper.setDecimalSeparator(decimalSeparator);
        return this;
    }

}
