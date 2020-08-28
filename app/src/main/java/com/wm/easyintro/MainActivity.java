package com.wm.easyintro;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.flag.FlagMode;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.wm.easyintro.utils.Utils;
import com.wm.easyintro.view.CustomFlag;
import com.wm.easyintro.view.SpinnerView;
import com.wm.intro.indicator.IndicatorInfo;
import com.wm.intro.type.IndicatorOneStyle;
import com.wm.intro.type.IndicatorOneType;
import com.wm.intro.type.IndicatorTwoType;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnSpinnerItemSelectedListener {
    /**
     * 选中颜色、未选中颜色
     */
    private ImageView mSelectColorIv, mUnSelectColorIv;
    /**
     * 指示器款式 指款器Type 指款器Style 滑动动画
     */
    private SpinnerView indicatorSpinner, indicatorTypeSpinner, indicatorTwoTypeSpinner, indicatorStyleSpinner, transformerSpinner;
    //设置的指示器信息
    private IndicatorInfo indicatorInfo;
    private Button startBtn;
    /**
     * 指示器款式
     */
    private String style = "INDICATOR_ONE";

    /**
     *滑动动画
     */
    private String transformerType = "DEFAULT";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorInfo = new IndicatorInfo();
        initView();
        initData();
        initListener();
    }

    private void initView() {
        mSelectColorIv = findViewById(R.id.select_color);
        mUnSelectColorIv = findViewById(R.id.unSelect_color);
        indicatorSpinner = findViewById(R.id.indicator_spinner);
        indicatorTypeSpinner = findViewById(R.id.indicator_type_spinner);
        indicatorStyleSpinner = findViewById(R.id.indicator_style_spinner);
        transformerSpinner = findViewById(R.id.transformer_spinner);
        indicatorTwoTypeSpinner = findViewById(R.id.indicator_two_type_spinner);
        startBtn = findViewById(R.id.start);
    }

    private void initData() {
        indicatorSpinner.setSpinnerData(Utils.getEasyIndicatorStyle());
        indicatorTypeSpinner.setSpinnerData(Utils.getIndicatorOneType());
        indicatorTwoTypeSpinner.setSpinnerData(Utils.getIndicatorTwoType());
        indicatorStyleSpinner.setSpinnerData(Utils.getIndicatorStyle());
        transformerSpinner.setSpinnerData(Utils.getTransformer());
    }

    private void initListener() {
        mSelectColorIv.setOnClickListener(this);
        mUnSelectColorIv.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        indicatorSpinner.setOnSpinnerItemSelectedListener(this);
        indicatorTypeSpinner.setOnSpinnerItemSelectedListener(this);
        indicatorTwoTypeSpinner.setOnSpinnerItemSelectedListener(this);
        indicatorStyleSpinner.setOnSpinnerItemSelectedListener(this);
        transformerSpinner.setOnSpinnerItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_color:
                showColorDialog(mSelectColorIv, true);
                break;
            case R.id.unSelect_color:
                showColorDialog(mUnSelectColorIv, false);
                break;
            case R.id.start:
                MyIntroActivity.start(this,indicatorInfo,style,transformerType);
                break;
        }
    }

    private void showColorDialog(final ImageView imageView, final boolean isSelect) {
        ColorPickerDialog.Builder builder = new ColorPickerDialog.Builder(this)
                .setPreferenceName("Test")
                .setPositiveButton("确定",
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                imageView.setBackgroundColor(envelope.getColor());
                                if (isSelect) {
                                    indicatorInfo.setSelectedColor(envelope.getColor());
                                } else {
                                    indicatorInfo.setUnSelectedColor(envelope.getColor());
                                }
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .setTitle("选中颜色")
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(false)  //默认值为true。
                .setBottomSpace(12);// set a bottom space between the last slidebar and buttons.
        CustomFlag bubbleFlag = new CustomFlag(this, R.layout.layout_flag);
        bubbleFlag.setFlagMode(FlagMode.LAST);
        builder.getColorPickerView().setFlagView(bubbleFlag);
        builder.show();
    }

    @Override
    public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
        String str = (String) parent.getItemAtPosition(position);
        if (parent == indicatorSpinner.getSpinner()) {
            style = str;
            if (str.equals("INDICATOR_ONE")) {
                indicatorStyleSpinner.setVisibility(View.VISIBLE);
                indicatorTypeSpinner.setVisibility(View.VISIBLE);
                indicatorTwoTypeSpinner.setVisibility(View.GONE);
            } else {
                indicatorStyleSpinner.setVisibility(View.GONE);
                indicatorTypeSpinner.setVisibility(View.GONE);
                indicatorTwoTypeSpinner.setVisibility(View.VISIBLE);
            }
        } else if (parent == indicatorTypeSpinner.getSpinner()) {
            indicatorInfo.setIndicatorOneType(IndicatorOneType.getType(str));
        } else if (parent == indicatorStyleSpinner.getSpinner()) {
            indicatorInfo.setIndicatorOneStyle(IndicatorOneStyle.getStyle(str));
        } else if (parent == indicatorTwoTypeSpinner.getSpinner()) {
            indicatorInfo.setIndicatorTwoType(IndicatorTwoType.getType(str));
        } else if (parent == transformerSpinner.getSpinner()) {
            transformerType = str;
        }
    }
}
