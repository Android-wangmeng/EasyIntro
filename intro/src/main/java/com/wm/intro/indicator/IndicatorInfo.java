package com.wm.intro.indicator;

import android.graphics.Color;

import com.blankj.utilcode.util.ColorUtils;
import com.wm.intro.type.IndicatorOneStyle;
import com.wm.intro.type.IndicatorOneType;
import com.wm.intro.type.IndicatorTwoType;

import java.io.Serializable;

public class IndicatorInfo implements Serializable {
    /**
     * 指示器宽度,IndicatorOneStyle.ROUND_RECT和IndicatorOneStyle.DASH是长度、IndicatorOneStyle.CIRCLE和IndicatorTwoType是圆圈的半径
     */
    private float widthDP;
    /**
     * 指示器高度，IndicatorOneStyle.DASH和IndicatorOneStyle.ROUND_RECT可设置高度
     */
    private float heightDP;
    /**
     * 指示器样式(IndicatorControllerOne使用的样式)
     */
    private IndicatorOneStyle indicatorStyle = IndicatorOneStyle.CIRCLE;
    /**
     * 指示器类型(IndicatorControllerOne使用的类型)
     */
    private IndicatorOneType indicatorOneType = IndicatorOneType.NORMAL;
    /**
     * 指示器类型(IndicatorControllerTwo使用的类型)
     */
    private IndicatorTwoType indicatorTwoType = IndicatorTwoType.NONE;
    /**
     * 选中颜色
     */
    private int selectedColor = Color.WHITE;
    /**
     * 未选中颜色
     */
    private int unSelectedColor = ColorUtils.setAlphaComponent(Color.BLACK,0.5f);

    public float getWidthDP() {
        return widthDP;
    }

    public void setWidthDP(float widthDP) {
        this.widthDP = widthDP;
    }

    public float getHeightDP() {
        return heightDP;
    }

    public void setHeightDP(float heightDP) {
        this.heightDP = heightDP;
    }

    public IndicatorOneStyle getIndicatorOneStyle() {
        if(indicatorStyle == null){
            return IndicatorOneStyle.CIRCLE;
        }
        return indicatorStyle;
    }

    public void setIndicatorOneStyle(IndicatorOneStyle indicatorStyle) {
        this.indicatorStyle = indicatorStyle;
    }

    public IndicatorOneType getIndicatorOneType() {
        if(indicatorStyle == null){
            return IndicatorOneType.NORMAL;
        }
        return indicatorOneType;
    }

    public void setIndicatorOneType(IndicatorOneType indicatorOneType) {
        this.indicatorOneType = indicatorOneType;
    }

    public IndicatorTwoType getIndicatorTwoType() {
        return indicatorTwoType;
    }

    public void setIndicatorTwoType(IndicatorTwoType indicatorTwoType) {
        this.indicatorTwoType = indicatorTwoType;
    }

    public int getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
    }

    public int getUnSelectedColor() {
        return unSelectedColor;
    }

    public void setUnSelectedColor(int unSelectedColor) {
        this.unSelectedColor = unSelectedColor;
    }
}
