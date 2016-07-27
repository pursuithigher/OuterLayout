package com.example.qzzhu.outerlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by QZhu on 16-7-27.
 */
public class OuterLayout extends FrameLayout{

    public final static String LEFT = "left";
    public final static String RIGHT = "right";
    public final static String TOP = "top";
    public final static String BOTTOM = "bottom";
    public final static String CENTER = "center";

    public enum POSITION{
        LEFT,RIGHT,TOP,BOTTOM
    }

    private int width = 0;
    private int height = 0;

    private View sleft,sright,sheader,sfooter,scenter;

    public OuterLayout(Context context) {
        this(context,null);
    }

    public OuterLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public OuterLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        initialChild();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        alignChildPosition();
    }

    private void initialChild(){
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if(child.getContentDescription() == null)
            {
                continue;
            }
            String contentDes = child.getContentDescription().toString();

            if(contentDes.equals(LEFT)) {
                FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.gravity = Gravity.START;
                child.setLayoutParams(lp);
                sleft = child;
            }
            if(contentDes.equals(RIGHT)){
                FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.gravity = Gravity.END;
                child.setLayoutParams(lp);
                sright = child;
            }
            if(contentDes.equals(TOP)){
                FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.gravity = Gravity.TOP;
                child.setLayoutParams(lp);
                sheader = child;
            }
            if(contentDes.equals(BOTTOM)){
                FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.gravity = Gravity.BOTTOM;
                child.setLayoutParams(lp);
                sfooter = child;
            }
            if(contentDes.equals(CENTER)){
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                lp.gravity = Gravity.CENTER;
                child.setLayoutParams(lp);
                scenter = child;
            }
        }
    }

    private void alignChildPosition(){
        if(sleft != null)
        {
            sleft.setX(0 - sleft.getMeasuredWidth());
        }
        if(sright != null)
        {
            sright.setX(width + sright.getMeasuredWidth());
        }
        if(sheader != null)
        {
            sheader.setY(0 - sheader.getMeasuredHeight());
        }
        if(sfooter != null)
        {
            if(scenter != null)
                sfooter.setY(sfooter.getMeasuredHeight() + scenter.getMeasuredHeight());
        }
    }

    public View getLoatedView(POSITION position){
        if(position == POSITION.BOTTOM)
        {
            return sfooter;
        }
        if(position == POSITION.LEFT)
        {
            return sleft;
        }
        if(position == POSITION.TOP)
        {
            return sheader;
        }
        if(position == POSITION.RIGHT)
        {
            return sright;
        }
        return null;
    }
}
