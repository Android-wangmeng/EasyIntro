package com.wm.easyintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.wm.intro.EasyIntro;
import com.wm.intro.indicator.IndicatorInfo;
import com.wm.intro.type.EasyIndicatorStyle;
import com.wm.intro.type.TransformerType;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class MyIntroActivity extends EasyIntro {

    public final static String EXTRA_PARAM_INDICATOR_INFO = "EXTRA_PARAM_INDICATOR_INFO";
    public final static String EXTRA_PARAM_INDICATOR_STYLE = "EXTRA_PARAM_INDICATOR_STYLE";
    public final static String EXTRA_PARAM_TRANSFORMER = "EXTRA_PARAM_TRANSFORMER";
    private IndicatorInfo info;
    private EasyIndicatorStyle style;
    private TransformerType transformerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        info = (IndicatorInfo) getIntent().getSerializableExtra(EXTRA_PARAM_INDICATOR_INFO);
        style = EasyIndicatorStyle.getStyle(getIntent().getStringExtra(EXTRA_PARAM_INDICATOR_STYLE));
        transformerType = TransformerType.getType(getIntent().getStringExtra(EXTRA_PARAM_TRANSFORMER));
        super.onCreate(savedInstanceState);
    }

    public static void start(Activity activity, IndicatorInfo info, String indicatorStyle, String transformer){
        Intent intent = new Intent(activity, MyIntroActivity.class);
        intent.putExtra(EXTRA_PARAM_INDICATOR_STYLE,indicatorStyle);
        intent.putExtra(EXTRA_PARAM_TRANSFORMER,transformer);
        intent.putExtra(EXTRA_PARAM_INDICATOR_INFO,info);
        ActivityCompat.startActivity(activity,intent,null);
    }
    @Override
    protected int[] getSlide() {
        return new int[]{R.mipmap.guide_page_1,R.mipmap.guide_page_2,R.mipmap.guide_page_3,R.mipmap.guide_page_4};
    }

    /**
     * 获取指示器信息
     *
     * @return
     */
    protected IndicatorInfo getIndicatorInfo() {
        return info;
    }

    @Override
    protected EasyIndicatorStyle getIndicatorStyle() {
        return style;
    }


    @Override
    protected TransformerType getTransformer() {
        return transformerType;
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }
}