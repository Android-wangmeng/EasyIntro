# EasyIntro
一款简单使用的APP介绍页，只需要提供图片

### 演示
![](screenshots/easy_intro.gif)


### [Demo下载](https://github.com/Android-wangmeng/EasyIntro/releases/download/1.0.1/app-release.apk)

### 添加如下配置将EasyDialog引入到你的项目当中：
```groovv
dependencies {
    implementation 'com.intro.wm:easyintro:1.0.1'
}
```

### 基本用法
要使用EasyIntro，您只需创建一个新的Activity即可扩展EasyIntro，如下所示：
```java
public class MyIntroActivity extends EasyIntro {

    /**
     * 设置布局(如果对布局不满意，可以自定义布局(参考layout_my_appintro)，但是里面的控件ID不能变)
     */
    @Override
    protected int getLayoutId() {
        return super.getLayoutId();
    }

    /**
     * 需要展示的图片数组(必须重写)
     */
    @Override
    protected int[] getSlide() {
        return new int[]{R.mipmap.guide_page_1,R.mipmap.guide_page_2,R.mipmap.guide_page_3,R.mipmap.guide_page_4};
    }

    /**
     * 设置指示器信息(指示器样式配置在这,详见下面说明)
     */
    @Override
    protected IndicatorInfo getIndicatorInfo() {
        return super.getIndicatorInfo();
    }

    /**
     * 设置指示器款式（一共两种款式：EasyIndicatorStyle.INDICATOR_ONE(黑夜)和EasyIndicatorStyle.INDICATOR_TWO）
     *
     * @return
     */
    @Override
    protected EasyIndicatorStyle getIndicatorStyle() {
        return super.getIndicatorStyle();
    }

    /**
     * 设置页面滑动动画（默认：TransformerType.ACCORDION）
     * @return
     */
    protected TransformerType getTransformer(){
        return super.getTransformer();
    }
}
```
请注意，您不需要调用setContentView,EasyIntro会调用它。
最后，在AndroidManifest.xml中声明Activity,如下所示：
```
<activity android:name=".MyIntroActivity"
    android:label="My Custom EasyIntro" />
```
建议不要声明MyEasyIntro为您的第一个Activity，除非您希望每次应用启动时都启动该简介。
理想情况下，您只应向用户显示一次，并在完成后将其隐藏（您可以在中使用一个标志SharedPreferences）

### 相关说明
- `指示器配置类（IndicatorInfo）`
| Method | Description | Default |
|--|--|--|
| setWidthDP(float widthDP) | 设置宽度 | 5dp |
| setHeightDP(float heightDP) | 设置高度 | 5dp |
| setIndicatorOneType(IndicatorOneType indicatorOneType) | 设置款式1类型| IndicatorOneType.NORMAL |
| setIndicatorTwoType(IndicatorTwoType indicatorTwoType) | 设置款式2类型| IndicatorTwoType.NONE |
| setSelectedColor(int selectedColor) | 设置选中颜色 | Color.WHITE |
| setUnSelectedColor(int unSelectedColor) | 设置未选中颜色| Color.BLACK |

- `指示器款示1`

| 属性 | IndicatorOneStyle.CIRCLE | IndicatorOneStyle.DASH | IndicatorOneStyle.ROUND_RECT |
|--|--|--|--|
| IndicatorOneType.NORMAL| ![CIRCLE_NORMAL](screenshots/slide_circle_normal.gif) | ![DASH_NORMAL](screenshots/style_dash_normal.gif) | ![ROUND_RECT_NORMAL](screenshots/style_round_rect_normal.gif) |
| IndicatorOneType.SMOOTH| ![CIRCLE_SMOOTH](screenshots/slide_circle_smooth.gif) | ![DASH_SMOOTH](screenshots/style_dash_smooth.gif) | ![ROUND_RECT_SMOOTH](screenshots/style_round_rect_smooth.gif) |
| IndicatorOneType. WORM| ![CIRCLE_WORM](screenshots/slide_circle_worm.gif) | ![DASH_WORM](screenshots/style_dash_worm.gif) | ![ROUND_WORM](screenshots/style_round_rect_worm.gif) |
| IndicatorOneType.COLOR| ![CIRCLE_COLOR](screenshots/slide_circle_color.gif) | ![DASH_COLOR](screenshots/style_dash_color.gif) | ![ROUND_COLOR](screenshots/style_round_rect_color.gif) |
| IndicatorOneType.SCALE| ![CIRCLE_SCALE](screenshots/slide_circle_scale.gif) | ![DASH_SCALE](screenshots/style_dash_scale.gif) | ![ROUND_SCALE](screenshots/style_round_rect_scale.gif) |

- `指示器款示2`

Name | Preview
-------- | ---
`IndicatorTwoType.NONE`|![anim_none](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_none.gif)
`IndicatorTwoType.COLOR`|![anim_color](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_color.gif)
`IndicatorTwoType.SCALE`|![anim_scale](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_scale.gif)
`IndicatorTwoType.SLIDE`|![anim_slide](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_slide.gif)
`IndicatorTwoType.WORM`|![anim_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_worm.gif)
`IndicatorTwoType.FILL`|![anim_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_fill.gif)
`IndicatorTwoType.THIN_WORM`|![anim_thin_worm](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_thin_worm.gif)
`IndicatorTwoType.DROP`|![anim_drop](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_drop.gif)
`IndicatorTwoType.SWAP`|![anim_swap](https://raw.githubusercontent.com/romandanylyk/PageIndicatorView/master/assets/anim_swap.gif)

### 滑动动画

|TransformerType.DEFAULT|TransformerType.ACCORDION|
|:---:|:---:|
|![](screenshots/transformer_default.gif)|![](screenshots/transformer_accordion.gif)|

|TransformerType.BACKGROUND_TO_FOREGROUND|TransformerType.DEPTH_PAGE|
|:---:|:---:|
|![](screenshots/transformer_background_to_reground.gif)|![](screenshots/transformer_depth_page.gif)|

|TransformerType.CUBE_IN|TransformerType.CUBE_OUT|
|:---:|:---:|
|![](screenshots/transformer_cube_in.gif)|![](screenshots/transformer_cube_out.gif)|

|TransformerType.DRAW_FROM_BACK|TransformerType.FLIP_HORIZONTAL|
|:---:|:---:|
|![](screenshots/transformer_draw_from_back.gif)|![](screenshots/transformer_flip_horizontal.gif)|

|TransformerType.FLIP_VERTICAL|TransformerType.ROTATE_UP|
|:---:|:---:|
|![](screenshots/transformer_flip_vertical.gif)|![](screenshots/transformer_rotate_up.gif)|

|TransformerType.FOREGROUND_TO_BACKGROUND|TransformerType.ROTATE_DOWN|
|:---:|:---:|
|![](screenshots/transformer_foreground_to_background.gif)|![](screenshots/transformer_rotate_down.gif)|

|TransformerType.ZOOM_IN|TransformerType.ZOOM_OUT|
|:---:|:---:|
|![](screenshots/transformer_rotate_zoom_in.gif)|![](screenshots/transformer_rotate_zoom_out.gif)

|TransformerType.STACK|TransformerType.TABLET|
|:---:|:---:|
|![](screenshots/transformer_rotate_stack.gif)|![](screenshots/transformer_rotate_tablet.gif)|

|TransformerType.ZOOM_OUT_SLIDE|
|:---:|
|![](screenshots/transformer_rotate_zoom_out_slide.gif)|

### License
```
Copyright (C)  wangmeng, EasyIntro Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



