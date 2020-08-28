package com.wm.intro;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.wm.intro.indicator.BaseIndicator;
import com.wm.intro.indicator.IndicatorControllerOne;
import com.wm.intro.indicator.IndicatorControllerTwo;
import com.wm.intro.indicator.IndicatorInfo;
import com.wm.intro.type.EasyIndicatorStyle;
import com.wm.intro.type.TransformerType;

public abstract class EasyIntro extends AppIntro {
    /**
     * 跳过、完成按扭
     */
    private LinearLayout skipLayout, doneLayout;

    private BaseIndicator baseIndicator;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_my_appintro;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        initView();
        initIndicator();
    }

    /**
     * 初始化View
     */
    private void initView() {
        skipLayout = findViewById(R.id.skip_layout);
        doneLayout = findViewById(R.id.done_layout);
        skipLayout.setVisibility(isShowSkip() ? View.VISIBLE : View.GONE);
        doneLayout.setVisibility(isShowSkip() ? View.VISIBLE : View.GONE);
        if(getSlide() != null) {
            for (int it : getSlide()) {
                addSlide(AppIntroFragment.newInstance(null,null,0,0,0,0,0,0,it));
            }
            setCustomTransformer(getTransformer().getAnimator());
        }
    }

    /**
     * 初始化指示器
     */
    private void initIndicator() {
        if (getIndicatorStyle() == EasyIndicatorStyle.INDICATOR_ONE) {
            baseIndicator = new IndicatorControllerOne(this,getIndicatorInfo());
        } else {
            baseIndicator = new IndicatorControllerTwo(this,getIndicatorInfo());
        }
        setIndicatorController(baseIndicator);
    }

    /**
     * 需要展示的图片
     */
    protected abstract int[] getSlide();

    /**
     * 是否显示跳过按扭
     *
     * @return true:显示  false:不显示
     */
    protected boolean isShowSkip() {
        return true;
    }

    /**
     * 是否显示完成按扭
     *
     * @return true:显示 false:不显示
     */
    protected boolean setDoneEnable() {
        return true;
    }

    /**
     * 获取指示器信息
     *
     * @return
     */
    protected IndicatorInfo getIndicatorInfo() {
        return null;
    }

    /**
     * 获取指示器样式
     *
     * @return
     */
    protected EasyIndicatorStyle getIndicatorStyle() {
        return EasyIndicatorStyle.INDICATOR_ONE;
    }

    /**
     * 获取滑动动画
     * @return
     */
    protected TransformerType getTransformer(){
        return TransformerType.ACCORDION;
    }
}
