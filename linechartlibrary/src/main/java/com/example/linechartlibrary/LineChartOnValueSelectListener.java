package com.example.linechartlibrary;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {
    public void onValueSelected(int lineIndex, int pointIndex, PointValue value);
}
