package com.wm.easyintro.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * 获取指示器样式
     * @return
     */
    public static List<String> getEasyIndicatorStyle() {
        List<String> list = new ArrayList<>();
        list.add("INDICATOR_ONE");
        list.add("INDICATOR_TWO");
        return list;
    }

    /**
     * 获取指款器Style
     * @return
     */
    public static List<String> getIndicatorStyle() {
        List<String> list = new ArrayList<>();
        list.add("CIRCLE");
        list.add("DASH");
        list.add("ROUND_RECT");
        return list;
    }

    /**
     * 获取指款器1Type
     * @return
     */
    public static List<String> getIndicatorOneType() {
        List<String> list = new ArrayList<>();
        list.add("NORMAL");
        list.add("WORM");
        list.add("SMOOTH");
        list.add("COLOR");
        return list;
    }

    /**
     * 获取指款器2Type
     * @return
     */
    public static List<String> getIndicatorTwoType() {
        List<String> list = new ArrayList<>();
        list.add("NONE");
        list.add("COLOR");
        list.add("SCALE");
        list.add("WORM");
        list.add("SLIDE");
        list.add("FILL");
        list.add("THIN_WORM");
        list.add("DROP");
        list.add("SWAP");
        list.add("SCALE_DOWN");
        return list;
    }

    /**
     * 获取滑动动画
     * @return
     */
    public static List<String> getTransformer() {
        List<String> list = new ArrayList<>();
        list.add("DEFAULT");
        list.add("ACCORDION");
        list.add("BACKGROUND_TO_FOREGROUND");
        list.add("CUBE_IN");
        list.add("CUBE_OUT");
        list.add("DEPTH_PAGE");
        list.add("DRAW_FROM_BACK");
        list.add("FLIP_HORIZONTAL");
        list.add("FLIP_VERTICAL");
        list.add("FOREGROUND_TO_BACKGROUND");
        list.add("ROTATE_DOWN");
        list.add("ROTATE_UP");
        list.add("STACK");
        list.add("TABLET");
        list.add("ZOOM_IN");
        list.add("ZOOM_OUT");
        list.add("ZOOM_OUT_SLIDE");
        return list;
    }
}
