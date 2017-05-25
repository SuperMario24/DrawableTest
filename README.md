# DrawableTest
for image or background


1.BitmapDrawable:
(1)antialias---抗锯齿，dither ----抖动效果，不失真，filter-----过滤效果。 三者应该设为true


2.shapeDrawable:
(1)gradient-----渐变，angle---渐变的角度，centerX,centerY-----渐变中心点的坐标，gradientRadius----渐变半径，
type---渐变类型（linear，radial，sweep）
(2)stroke-------描边，dashWidth----虚线线段的宽度，dashGap----虚线线段的间隔

3.LayerDrawable(Layer-list):
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape android:shape="rectangle">
            <solid android:color="#0ac39e"/>
        </shape>
    </item>
    <item
        android:bottom="6dp"
        >
        <shape android:shape="rectangle">
            <solid android:color="#ffffff"/>
        </shape>
    </item>
    <item android:left="1dp"
        android:right="1dp"
        android:bottom="1dp">

        <shape android:shape="rectangle">
            <solid android:color="#ffffff"/>
        </shape>
    </item>
</layer-list>

(1)可以有多个item，下面的item会覆盖上面的item
(2)top,legt,righr,bottom----Drawable相对于View的上下左右偏移量。


4.StateListDrawable(selector选择器):
(1)伪代码：<selector>
<item
state_pressed="true"
drawable="..."/>
<item
drawable = "...">
</selector>
(2)如果前面写了state_pressed="true"，后面没写，那么除了这个状态外，所有drawable都匹配下一个。

5.LevelListDrawable(level-list):
(1)<level-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@color/colorPrimaryDark"
        android:minLevel="0"
        android:maxLevel="1"
        ></item>
    <item
    android:drawable="@color/colorAccent"
    android:minLevel="2"
    android:maxLevel="3"
    ></item>
    <item
        android:drawable="@color/colorPrimary"
        android:minLevel="4"
        android:maxLevel="5"
        ></item>
</level-list>
(2)//不同的等级显示不同的drawable
   int level = new Random().nextInt(6);
   btnLevelList.getBackground().setLevel(level);
   
   
 6.TransitionDrawable(<transition>):实现淡入淡出的动画效果
(1)<transition xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@color/colorPrimaryDark"
        ></item>
    <item
        android:drawable="@color/colorAccent"
        ></item>
</transition>

(2)代码设置
TextView textView = (TextView) findViewById(R.id.tv_transition_drawable);
TransitionDrawable drawable = (TransitionDrawable) textView.getBackground();
drawable.startTransition(2000);


7.InsetDrawable(<inset>):
(1)将其他drawable内嵌到自己当中，并可以在四周留出一定间距
(2)
<inset xmlns:android="http://schemas.android.com/apk/res/android"
    drawable="..."
    android:insetBottom="10dp"
    android:insetTop="10dp"
    android:insetLeft="10dp"
    android:insetRight="10dp"
    >
<shape android:shape="rectangle">
    <solid android:color="#ff0000"></solid>
</shape>
</inset>


8.ScaleDrawable(<scale>):
(1)
<scale xmlns:android="http://schemas.android.com/apk/res/android"
    android:drawable="@color/colorAccent"
    android:scaleHeight="70%"  //是原来的30%
    android:scaleWidth="70%"
    android:scaleGravity="center"
    >
</scale>
(2)//scaleDrawable实现缩放效果
View view = findViewById(R.id.scale_drawable);
ScaleDrawable scaleDrawable = (ScaleDrawable) view.getBackground();
scaleDrawable.setLevel(1);//必须大于0且小于等于10000


9.ClipDrawable(<Clip>)
（1）根据当前的等级（level）裁剪另一个Drawable
（2）
<clip xmlns:android="http://schemas.android.com/apk/res/android"
    android:clipOrientation="vertical"
    android:drawable="@color/colorAccent"
    android:gravity="bottom"
    >
</clip>
（3）clipOrientation----裁剪方向，gravity----如果是bottom，就是从顶部开始裁剪
（4）//ClipDrawable实现裁剪表示进度
TextView tvClipDrawable = (TextView) findViewById(R.id.tv_clip_drawable);
ClipDrawable clipDrawable = (ClipDrawable) tvClipDrawable.getBackground();
clipDrawable.setLevel(5000);//设置当前等级，0-10000之间。















