package com.tianxi.vpsixteenanimation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tianxi.vpsixteenanimation.animationlibrary.AccordionTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.BackgroundToForegroundTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.CubeInTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.CubeOutTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.DepthPageTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.FlipHorizontalTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.FlipVerticalTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.ForegroundToBackgroundTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.RotateDownTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.ScaleInOutTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.StackTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.TabletTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.ZoomInTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.ZoomOutSlideTransformer;
import com.tianxi.vpsixteenanimation.animationlibrary.ZoomOutTranformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tianxi.vpsixteenanimation.R.id.vp;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    @BindView(vp)
    ViewPager Vp;
    VpAdapter adapter;
    /**
     * 0.左右黏合滑动
     1.快速消失切入
     2.3D向前飞出屏幕
     3.3D箱子旋转
     4.平移
     5.卡片左右翻页
     6.卡片上下翻页
     7.等比放大缩小
     8左右带角度平移1
     9左右带角度平移2
     10.好像没有写case10.
     11.遮盖翻页
     12.内旋3D翻页
     13.不翻页中心缩小
     14.左右半透明平移
     15.改变透明度变换
     16.左右黏贴平移
     */
    String[] info= {"自然","demo","1.左右黏合滑动","2.快速消失切入","3.3D箱子旋转","4.平移"
            ,"5.卡片左右翻页","6.卡片上下翻页", " 7.等比放大缩小","8.左右带角度平移1"
            , " 9左右带角度平移2","好像没有写case10."," 11.遮盖翻页","12.内旋3D翻页"
            ,"13.不翻页中心缩小"," 14.左右半透明平移","  15.改变透明度变换","16.左右黏贴平移"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            list.add(BlankFragment.newInstance(info[i]));

        }
        adapter= new VpAdapter(getSupportFragmentManager(), list);
        Vp.setAdapter(adapter);
        Vp.setOnPageChangeListener(this);
        Vp.setCurrentItem(0);
//        Vp.setPageTransformer(true, new );
        //缩放  缩放中心为view的中心
        Vp.setPageTransformer(true ,new ZoomInTransform());


//                Vp.setPageTransformer(true,
//                        new AccordionTransformer());
//                Vp.setPageTransformer(true,
//                        new BackgroundToForegroundTransformer());
//
//                Vp.setPageTransformer(true,
//                        new CubeInTransformer());
//                Vp.setPageTransformer(true,
//                        new CubeOutTransformer());
//                Vp.setPageTransformer(true,
//                        new DepthPageTransformer());
//                Vp.setPageTransformer(true,
//                        new FlipHorizontalTransformer());
//                Vp.setPageTransformer(true,
//                        new FlipVerticalTransformer());
//                Vp.setPageTransformer(true,
//                        new ForegroundToBackgroundTransformer());
//                Vp.setPageTransformer(true,
//                        new RotateDownTransformer());
//                Vp.setPageTransformer(true,
//                        new ScaleInOutTransformer());
//                Vp.setPageTransformer(true,
//                        new StackTransformer());
//                Vp.setPageTransformer(true,
//                        new TabletTransformer());
//                Vp.setPageTransformer(true,
//                        new ZoomInTransformer());
//                Vp.setPageTransformer(true,
//                        new ZoomOutSlideTransformer());
//                Vp.setPageTransformer(true,
//                        new ZoomOutTranformer());


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        /**
         * 0.左右黏合滑动
         1.快速消失切入
         2.3D向前飞出屏幕
         3.3D箱子旋转
         4.平移
         5.卡片左右翻页
         6.卡片上下翻页
         7.等比放大缩小
         8左右带角度平移1
         9左右带角度平移2
         10.好像没有写case10.
         11.遮盖翻页
         12.内旋3D翻页
         13.不翻页中心缩小
         14.左右半透明平移
         15.改变透明度变换
         16.左右黏贴平移
         */

        switch (position) {
            case 1:
                Vp.setPageTransformer(true,
                        new AccordionTransformer());
                break;
            case 2:
                Vp.setPageTransformer(true,
                        new BackgroundToForegroundTransformer());

                break;
            case 3:
                Vp.setPageTransformer(true,
                        new CubeInTransformer());
                break;
            case 4:
                Vp.setPageTransformer(true,
                        new CubeOutTransformer());
                break;
            case 5:
                Vp.setPageTransformer(true,
                        new DepthPageTransformer());
                break;
            case 6:
                Vp.setPageTransformer(true,
                        new FlipHorizontalTransformer());
                break;
            case 7:
                Vp.setPageTransformer(true,
                        new FlipVerticalTransformer());
                break;
            case 8:
                Vp.setPageTransformer(true,
                        new ForegroundToBackgroundTransformer());
                break;
            case 9:
                Vp.setPageTransformer(true,
                        new RotateDownTransformer());
                break;
            case 11:
                Vp.setPageTransformer(true,
                        new ScaleInOutTransformer());
                break;
            case 12:
                Vp.setPageTransformer(true,
                        new StackTransformer());
                break;
            case 13:
                Vp.setPageTransformer(true,
                        new TabletTransformer());
                break;
            case 14:
                Vp.setPageTransformer(true,
                        new ZoomInTransformer());
                break;
            case 15:
                Vp.setPageTransformer(true,
                        new ZoomOutSlideTransformer());
                break;
            case 16:
                Vp.setPageTransformer(true,
                        new ZoomOutTranformer());
                break;

            default:
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
