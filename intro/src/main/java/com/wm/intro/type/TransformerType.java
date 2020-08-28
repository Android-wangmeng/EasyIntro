package com.wm.intro.type;

import com.wm.intro.transformers.AccordionTransformer;
import com.wm.intro.transformers.BackgroundToForegroundTransformer;
import com.wm.intro.transformers.BaseTransformer;
import com.wm.intro.transformers.CubeInTransformer;
import com.wm.intro.transformers.CubeOutTransformer;
import com.wm.intro.transformers.DefaultTransformer;
import com.wm.intro.transformers.DepthPageTransformer;
import com.wm.intro.transformers.DrawFromBackTransformer;
import com.wm.intro.transformers.FlipHorizontalTransformer;
import com.wm.intro.transformers.FlipVerticalTransformer;
import com.wm.intro.transformers.ForegroundToBackgroundTransformer;
import com.wm.intro.transformers.RotateDownTransformer;
import com.wm.intro.transformers.RotateUpTransformer;
import com.wm.intro.transformers.StackTransformer;
import com.wm.intro.transformers.TabletTransformer;
import com.wm.intro.transformers.ZoomInTransformer;
import com.wm.intro.transformers.ZoomOutSlideTransformer;
import com.wm.intro.transformers.ZoomOutTranformer;

public enum TransformerType {
    ACCORDION(AccordionTransformer.class),
    BACKGROUND_TO_FOREGROUND(BackgroundToForegroundTransformer.class),
    CUBE_IN(CubeInTransformer.class),
    CUBE_OUT(CubeOutTransformer.class),
    DEFAULT(DefaultTransformer.class),
    DEPTH_PAGE(DepthPageTransformer.class),
    DRAW_FROM_BACK(DrawFromBackTransformer.class),
    FLIP_HORIZONTAL(FlipHorizontalTransformer.class),
    FLIP_VERTICAL(FlipVerticalTransformer.class),
    FOREGROUND_TO_BACKGROUND(ForegroundToBackgroundTransformer.class),
    ROTATE_DOWN(RotateDownTransformer.class),
    ROTATE_UP(RotateUpTransformer.class),
    STACK(StackTransformer.class),
    TABLET(TabletTransformer.class),
    ZOOM_IN(ZoomInTransformer.class),
    ZOOM_OUT(ZoomOutTranformer.class),
    ZOOM_OUT_SLIDE(ZoomOutSlideTransformer.class);

    private Class transformerClazz;

    private TransformerType(Class cla) {
        this.transformerClazz = cla;
    }

    public BaseTransformer getAnimator() {
        try {
            return (BaseTransformer) transformerClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }

    public static TransformerType getType(String type) {
        switch (type) {
            default:
            case "DEFAULT":
                return DEFAULT;
            case "ACCORDION":
                return ACCORDION;
            case "BACKGROUND_TO_FOREGROUND":
                return BACKGROUND_TO_FOREGROUND;
            case "CUBE_IN":
                return CUBE_IN;
            case "CUBE_OUT":
                return CUBE_OUT;
            case "DEPTH_PAGE":
                return DEPTH_PAGE;
            case "DRAW_FROM_BACK":
                return DRAW_FROM_BACK;
            case "FLIP_HORIZONTAL":
                return FLIP_HORIZONTAL;
            case "FLIP_VERTICAL":
                return FLIP_VERTICAL;
            case "FOREGROUND_TO_BACKGROUND":
                return FOREGROUND_TO_BACKGROUND;
            case "ROTATE_DOWN":
                return ROTATE_DOWN;
            case "ROTATE_UP":
                return ROTATE_UP;
            case "STACK":
                return STACK;
            case "TABLET":
                return TABLET;
            case "ZOOM_IN":
                return ZOOM_IN;
            case "ZOOM_OUT":
                return ZOOM_OUT;
            case "ZOOM_OUT_SLIDE":
                return ZOOM_OUT_SLIDE;
        }
    }
}
