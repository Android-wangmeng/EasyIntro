package com.wm.intro.type;

public enum IndicatorTwoType {
    NONE, COLOR, SCALE, WORM, SLIDE, FILL, THIN_WORM, DROP, SWAP, SCALE_DOWN;

    public static IndicatorTwoType getType(String type) {
        switch (type) {
            case "COLOR":
                return COLOR;
            case "SCALE":
                return SCALE;
            case "WORM":
                return WORM;
            case "SLIDE":
                return SLIDE;
            case "FILL":
                return FILL;
            case "THIN_WORM":
                return THIN_WORM;
            case "DROP":
                return DROP;
            case "SWAP":
                return SWAP;
            case "SCALE_DOWN":
                return SCALE_DOWN;
            default:
                return NONE;
        }
    }
}
