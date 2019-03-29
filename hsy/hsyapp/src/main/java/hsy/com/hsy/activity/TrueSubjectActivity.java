package hsy.com.hsy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import hsy.com.hsy.R;

public class TrueSubjectActivity extends AppCompatActivity {


    final float mSeriesMax = 100f;
    final private int COLOR_BLUE = Color.parseColor("#1D76D2");
    final private int COLOR_PINK = Color.parseColor("#FF4081");
    final private int COLOR_YELLOW = Color.parseColor("#FFC107");
    final private int COLOR_EDGE = Color.parseColor("#22000000");
    final private int COLOR_BACK = Color.parseColor("#0166BB66");
    private DecoView decoView;
    private int mSeries1Index;
    private int mSeries2Index;
    private int mSeries3Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_subject);

//        AnimationCirPre animationCirPre = findViewById(R.id.ac);
//animationCirPre.setNum(100f,100f,50f,60f,50f,0);

        decoView = findViewById(R.id.ac);
        SeriesItem series1Item = new SeriesItem.Builder(COLOR_BLUE)
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .setLineWidth(getDimension(46))
                .setSeriesLabel(new SeriesLabel.Builder("及格").build())
                .setCapRounded(false)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_INNER, COLOR_EDGE, 0.3f))
                .setShowPointWhenEmpty(false)
                .build();

        mSeries1Index = decoView.addSeries(series1Item);

        SeriesItem series2Item = new SeriesItem.Builder(COLOR_PINK)
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .setLineWidth(getDimension(46))
                .setSeriesLabel(new SeriesLabel.Builder("优秀").build())
                .setCapRounded(false)
                //.setChartStyle(SeriesItem.ChartStyle.STYLE_PIE)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_INNER, COLOR_EDGE, 0.3f))
                .setShowPointWhenEmpty(false)
                .build();

        mSeries2Index = decoView.addSeries(series2Item);

        SeriesItem series3Item = new SeriesItem.Builder(COLOR_YELLOW)
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .setLineWidth(getDimension(46))
                .setSeriesLabel(new SeriesLabel.Builder("不及格").build())
                .setCapRounded(false)
                //.setChartStyle(SeriesItem.ChartStyle.STYLE_PIE)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_INNER, COLOR_EDGE, 0.3f))
                .setShowPointWhenEmpty(false)
                .build();

        mSeries3Index = decoView.addSeries(series3Item);

        addAnimation(decoView, mSeries3Index, 10, 3000, COLOR_BLUE);
        addAnimation(decoView, mSeries2Index, 60, 3500, COLOR_PINK);
        addAnimation(decoView, mSeries1Index, 100, 4000, COLOR_PINK);

    }


    private void addAnimation(final DecoView arcView,
                              int series, float moveTo, int delay,
                              final int color) {
        DecoEvent.ExecuteEventListener listener = new DecoEvent.ExecuteEventListener() {
            @Override
            public void onEventStart(DecoEvent event) {

                arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_COLOR_CHANGE, color)
                        .setDuration(2000)
                        .build());
            }

            @Override
            public void onEventEnd(DecoEvent event) {
                arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_COLOR_CHANGE, COLOR_BACK)
                        .setDuration(2000)
                        .build());
            }
        };

        arcView.addEvent(new DecoEvent.Builder(moveTo)
                .setIndex(series)
                .setDelay(delay)
                .setDuration(5000)
                .setListener(listener)
                .build());
    }


    protected float getDimension(float base) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, base, getResources().getDisplayMetrics());
    }



}
