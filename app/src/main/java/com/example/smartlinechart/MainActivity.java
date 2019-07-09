package com.example.smartlinechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.linechartlibrary.Axis;
import com.example.linechartlibrary.AxisValue;
import com.example.linechartlibrary.CommonUtils;
import com.example.linechartlibrary.ContainerScrollType;
import com.example.linechartlibrary.Line;
import com.example.linechartlibrary.LineChartData;
import com.example.linechartlibrary.LineChartView;
import com.example.linechartlibrary.PointValue;
import com.example.linechartlibrary.ValueShape;
import com.example.linechartlibrary.Viewport;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChartView lineChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        drawLine();
    }

    private void initView() {
        lineChartView = (LineChartView) findViewById(R.id.lineView);
    }

    private void drawLine() {
        String[] lineLabels = {"09-12", "09-11", "09-10", "09-09", "09-08", "09-07", "09-06", "09-09", "09-08", "09-07", "09-06"};
        int[] chartColors = new int[]{getResources().getColor(R.color.color_FE5E63), getResources().getColor(R.color.color_6CABFA),
                getResources().getColor(R.color.color_FBE382),getResources().getColor(R.color.color_646464)};
        int maxNumberOfLines = 3;
        int numberOfPoints = lineLabels.length;
        ValueShape shape = ValueShape.SQUARE;
        float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }


        List<Line> lines = new ArrayList<Line>();
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (int i = 0; i < maxNumberOfLines; ++i) {
            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]).setLabelColor(getResources().getColor(R.color.color_FE5E63))
                        .setLabelTextsize(CommonUtils.dp2px(this, 15)));
            }
            Line line = new Line(values);
            line.setColor(chartColors[i]);
            line.setShape(shape);
            line.setPointRadius(3);
            line.setStrokeWidth(1);
            line.setCubic(false);
            line.setFilled(false);
            line.setHasLabels(false);
            line.setHasLabelsOnlyForSelected(true);
            line.setHasLines(true);
            line.setHasPoints(true);
            //line.setPointColor(R.color.transparent);
            line.setHasGradientToTransparent(true);
//            if (pointsHaveDifferentColor){
//                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
//            }
            lines.add(line);

        }

        LineChartData data = new LineChartData(lines);
        for (int i = 0; i < numberOfPoints; i++) {
            axisValues.add(new AxisValue(i).setLabel(lineLabels[i]));
        }
        Axis axisX = new Axis(axisValues).setMaxLabelChars(5);
        axisX.setTextColor(getResources().getColor(R.color.color_969696))
                .setTextSize(10).setLineColor(getResources().getColor(R.color.color_e6e6e6))
                .setHasSeparationLineColor(getResources().getColor(R.color.color_e6e6e6)).setHasTiltedLabels(true);
        data.setAxisXBottom(axisX);
        Axis axisY = new Axis().setHasLines(true).setHasSeparationLine(false).setMaxLabelChars(3);
        axisY.setTextColor(getResources().getColor(R.color.color_969696));
        axisY.setTextSize(10);
        data.setAxisYLeft(axisY);
        data.setBaseValue(Float.NEGATIVE_INFINITY);


        lineChartView.setZoomEnabled(false);
        lineChartView.setScrollEnabled(true);
        lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChartView.setValueSelectionEnabled(true);//点击折线点可以显示label
        lineChartView.setLineChartData(data);
        // Reset viewport height range to (0,100)
        lineChartView.setViewportCalculationEnabled(false);
        //让布局能够水平滑动要设置setCurrentViewport比setMaximumViewport小
        final Viewport v = new Viewport(lineChartView.getMaximumViewport());
        v.bottom = 0;
        v.top = 105;
        v.left = 0;
        v.right = numberOfPoints - 1 + 0.5f;
        lineChartView.setMaximumViewport(v);
        v.left = 0;
        v.right = Math.min(6, numberOfPoints - 1 + 0.5f);
        lineChartView.setCurrentViewport(v);

    }
}
