package com.wm.easyintro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wm.easyintro.R;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.List;

import androidx.annotation.Nullable;

public class SpinnerView extends LinearLayout{
    private Context mContext;
    private NiceSpinner mSpinner;
    private TextView mTitle;
    public SpinnerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView(attrs);
    }

    private void initView(AttributeSet attrs){
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_spinner,this);
        mSpinner = v.findViewById(R.id.spinner);
        mTitle = v.findViewById(R.id.spinner_title);
        TypedArray attributes = mContext.obtainStyledAttributes(attrs, R.styleable.SpinnerView);
        float width = attributes.getDimension(R.styleable.SpinnerView_width,0);
        if(width > 0){
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)mSpinner.getLayoutParams();
            params.width = (int)width;
            mSpinner.setLayoutParams(params);
        }
        String title = attributes.getString(R.styleable.SpinnerView_title);
        if(!TextUtils.isEmpty(title)){
            mTitle.setText(title);
        }
    }

    public NiceSpinner getSpinner(){
        return mSpinner;
    }

    public void setSpinnerData(List<String> list){
        mSpinner.attachDataSource(list);
    }

    public void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener onSpinnerItemSelectedListener){
        mSpinner.setOnSpinnerItemSelectedListener(onSpinnerItemSelectedListener);
    }
}
