package com.wm.intro.indicator;

import com.github.appintro.indicator.IndicatorController;

public abstract class BaseIndicator implements IndicatorController {
    protected IndicatorInfo indicatorInfo;
    protected BaseIndicator(IndicatorInfo info){
        if(info == null){
            indicatorInfo = new IndicatorInfo();
        } else {
            this.indicatorInfo = info;
        }
    }
}
