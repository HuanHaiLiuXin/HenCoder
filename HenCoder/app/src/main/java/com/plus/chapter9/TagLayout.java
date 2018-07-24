package com.plus.chapter9;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/7/24 15:28
 */
public class TagLayout extends ViewGroup {
    private Rect[] childrenBounds;
    private int lineWidthUsed;      //单行已经使用的宽度
    private int lineWidth;          //单行总宽度
    private int tagLayoutWidth;     //TagLayout宽度
    private int lineHeight;         //单行高度
    private int tagLayoutHeight;    //TagLayout高度

    public TagLayout(Context context) {
        super(context);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() <= 0) {
            //不存在子View
            setMeasuredDimension(resolveSizeAndState(getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0), resolveSizeAndState(getPaddingTop() + getPaddingBottom(), heightMeasureSpec, 0));
        } else {
            //存在子View
            int childCount = getChildCount();
            if (childrenBounds == null) {
                childrenBounds = new Rect[childCount];
            } else if (childrenBounds.length < childCount) {
                childrenBounds = Arrays.copyOf(childrenBounds, childCount);
            }
            lineWidthUsed = 0;
            lineWidth = 0;
            tagLayoutWidth = 0;
            lineHeight = 0;
            tagLayoutHeight = 0;
            for (int i = 0; i < childCount; i++) {
                Rect childBounds = childrenBounds[i];
                if (childBounds == null) {
                    childBounds = childrenBounds[i] = new Rect();
                }
                View child = getChildAt(i);
                //测量子View的尺寸
                measureChildWithMargins(child, widthMeasureSpec, getPaddingLeft() + lineWidthUsed + getPaddingRight(), heightMeasureSpec, tagLayoutHeight);
                //判断是否需要折行()
                if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED && getPaddingLeft() + lineWidthUsed + child.getMeasuredWidth() + getPaddingRight() > MeasureSpec.getSize(widthMeasureSpec)) {
                    tagLayoutHeight += lineHeight;
                    lineHeight = 0;
                    lineWidthUsed = 0;
                    //重新测量子View
                    measureChildWithMargins(child, widthMeasureSpec, getPaddingLeft() + lineWidthUsed + getPaddingRight(), heightMeasureSpec, tagLayoutHeight);
                }
                childBounds.set(getPaddingLeft() + lineWidthUsed, getPaddingTop() + tagLayoutHeight, getPaddingLeft() + lineWidthUsed + child.getMeasuredWidth(), getPaddingTop() + tagLayoutHeight + child.getMeasuredHeight());
                lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
                lineWidthUsed += child.getMeasuredWidth();
                lineWidth = getPaddingLeft() + lineWidthUsed + getPaddingRight();
                tagLayoutWidth = Math.max(tagLayoutWidth, lineWidth);
            }
            tagLayoutHeight += lineHeight + getPaddingTop() + getPaddingBottom();
            setMeasuredDimension(resolveSizeAndState(tagLayoutWidth, widthMeasureSpec, 0), resolveSizeAndState(tagLayoutHeight, heightMeasureSpec, 0));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0 && childrenBounds.length > 0 && getChildCount() == childrenBounds.length) {
            for (int i = 0; i < childrenBounds.length; i++) {
                getChildAt(i).layout(childrenBounds[i].left, childrenBounds[i].top, childrenBounds[i].right, childrenBounds[i].bottom);
            }
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
