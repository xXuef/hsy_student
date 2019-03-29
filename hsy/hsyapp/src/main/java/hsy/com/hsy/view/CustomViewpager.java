package hsy.com.hsy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import hsy.com.hsy.util.DpToPx;


/**
 * 为解决viewpager上下滑动不给力 重写  自定义一个
 */
public class CustomViewpager extends VerticalViewPager {

    private float xPosition;// 手指触摸点的x轴坐标
    private final float MINIMUM_DISTANCE = 2;// 手指移动的最小距离
    private int distance;// 根据屏幕密度计算出来的，手指移动的最小距离

    public CustomViewpager(Context context) {
        super(context);
        distance = (int) DpToPx.dip2px(MINIMUM_DISTANCE);
    }

    public CustomViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        distance = (int) DpToPx.dip2px(MINIMUM_DISTANCE);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 先保存手指按下的x轴的坐标
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            xPosition = ev.getY();
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            /*
             计算手指移动时的坐标跟按下的坐标之间的绝对值，如果超过给定的值，
             就认为viewpager需要滚动。通过调节distance的大小，可以改变滑动
             灵敏度
              */
            if (Math.abs(ev.getY() - xPosition) < distance)
                return false;
            else// 意思就是：touch事件已经被PeopleViewPager自己消费了，不会传递到子控件
                return true;
        }
        // 其他情况，依旧保持默认的处理方法
        return super.onInterceptTouchEvent(ev);
    }
}
