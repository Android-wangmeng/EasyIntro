package com.wm.intro.indicator;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;
import com.wm.intro.R;
import com.wm.intro.type.IndicatorTwoType;

import androidx.viewpager.widget.ViewPager;

public class IndicatorControllerTwo extends BaseIndicator {
    private PageIndicatorView pageIndicatorView;

    public IndicatorControllerTwo(Context context, IndicatorInfo info) {
        super(info);
        pageIndicatorView = new PageIndicatorView(context);
    }

    @Override
    public int getSelectedIndicatorColor() {
        return 0;
    }

    @Override
    public void setSelectedIndicatorColor(int color) {
    }

    @Override
    public int getUnselectedIndicatorColor() {
        return 0;
    }

    @Override
    public void setUnselectedIndicatorColor(int color) {

    }

    @Override
    public void initialize(int slideCount) {
        pageIndicatorView.setCount(slideCount);
        pageIndicatorView.setUnselectedColor(this.indicatorInfo.getUnSelectedColor());
        pageIndicatorView.setSelectedColor(this.indicatorInfo.getSelectedColor());
        if(this.indicatorInfo.getWidthDP() > 0) {
            pageIndicatorView.setRadius(this.indicatorInfo.getWidthDP());
        }
    }

    @Override
    public View newInstance(Context context) {
        pageIndicatorView.setAnimationType(unwrapAnimationType(this.indicatorInfo.getIndicatorTwoType()));
        return pageIndicatorView;
    }

    @Override
    public void selectPosition(int position) {
        pageIndicatorView.setSelection(position);
    }

    private AnimationType unwrapAnimationType(IndicatorTwoType animationType) {
        switch (animationType) {
            default:
            case NONE:
                return AnimationType.NONE;
            case COLOR:
                return AnimationType.COLOR;
            case SCALE:
                return AnimationType.SCALE;
            case WORM:
                return AnimationType.WORM;
            case SLIDE:
                return AnimationType.SLIDE;
            case FILL:
                return AnimationType.FILL;
            case THIN_WORM:
                return AnimationType.THIN_WORM;
            case DROP:
                return AnimationType.DROP;
            case SWAP:
                return AnimationType.SWAP;
            case SCALE_DOWN:
                return AnimationType.SCALE_DOWN;
        }
    }
}
