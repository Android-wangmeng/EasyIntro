package com.wm.intro.indicator;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.wm.intro.R;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

import androidx.viewpager.widget.ViewPager;

public class IndicatorControllerOne extends BaseIndicator  {


    private IndicatorView pageIndicatorView;

    public IndicatorControllerOne(Context context,IndicatorInfo indicatorInfo) {
        super(indicatorInfo);
        pageIndicatorView = new IndicatorView(context);
    }
    @Override
    public int getSelectedIndicatorColor() {
        return 0;
    }

    @Override
    public void setSelectedIndicatorColor(int i) {
    }

    @Override
    public int getUnselectedIndicatorColor() {
        return 0;
    }

    @Override
    public void setUnselectedIndicatorColor(int i) {

    }

    @Override
    public void initialize(int i) {
        pageIndicatorView.setSliderColor(indicatorInfo.getUnSelectedColor(), indicatorInfo.getSelectedColor());
        ViewPager viewPager = ActivityUtils.getTopActivity().findViewById(R.id.view_pager);
        pageIndicatorView.setupWithViewPager(viewPager);
        if(indicatorInfo.getWidthDP() > 0) {
            pageIndicatorView.setSliderWidth(ConvertUtils.dp2px(indicatorInfo.getWidthDP()));
            //pageIndicatorView.setSliderGap(width / 2 + 2);
        }
        if(indicatorInfo.getHeightDP() > 0) {
            pageIndicatorView.setSliderHeight(ConvertUtils.dp2px(indicatorInfo.getHeightDP()));
        }
    }

    @Override
    public View newInstance(Context context) {
        pageIndicatorView.setIndicatorStyle(getStyle());
        pageIndicatorView.setSlideMode(getType());
        return pageIndicatorView;
    }

    private int getStyle() {
        switch (indicatorInfo.getIndicatorOneStyle()) {
            case DASH:
                return IndicatorStyle.DASH;
            case ROUND_RECT:
                return IndicatorStyle.ROUND_RECT;
            default:
                return IndicatorStyle.CIRCLE;
        }
    }

    private int getType() {
        switch (indicatorInfo.getIndicatorOneType()) {
            case COLOR:
                return IndicatorSlideMode.COLOR;
            case WORM:
                return IndicatorSlideMode.WORM;
            case SMOOTH:
                return IndicatorSlideMode.SMOOTH;
            default:
                return IndicatorSlideMode.NORMAL;
        }
    }

    @Override
    public void selectPosition(int index) {
        pageIndicatorView.onPageSelected(index);
    }
}
