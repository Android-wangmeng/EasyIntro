package com.wm.intro.type;

/**
 * 指示器动画类型
 */
public enum IndicatorOneType {
    NORMAL,SMOOTH,WORM,COLOR;
    public static IndicatorOneType getType(String type){
        switch (type){
            case "SMOOTH":
                return SMOOTH;
            case "WORM":
                return WORM;
            case "COLOR":
                return COLOR;
            default:
                return NORMAL;
        }
    }
}
