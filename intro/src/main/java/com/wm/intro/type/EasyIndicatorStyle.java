package com.wm.intro.type;

/**
 * 指式器样式
 */
public enum EasyIndicatorStyle {
    INDICATOR_ONE,INDICATOR_TWO;
    public static EasyIndicatorStyle getStyle(String style){
        switch (style){
            default:
            case "INDICATOR_ONE":
                return INDICATOR_ONE;
            case "INDICATOR_TWO":
                return INDICATOR_TWO;
        }
    }
}
