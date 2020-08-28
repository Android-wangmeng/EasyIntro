package com.wm.intro.type;

/**
 * 指示器动画样式
 */
public enum IndicatorOneStyle {
    CIRCLE,DASH,ROUND_RECT;
    public static IndicatorOneStyle getStyle(String type){
        switch (type){
            default:
            case "CIRCLE":
                return CIRCLE;
            case "DASH":
                return DASH;
            case "ROUND_RECT":
                return ROUND_RECT;
        }
    }
}
