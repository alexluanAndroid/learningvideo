package com.example.luanalex.blgame.Activities.GameModule;


import android.app.Dialog;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.luanalex.blgame.R;
import com.example.luanalex.blgame.adapter.GiftGridViewAdapter;
import com.example.luanalex.blgame.entity.Gift;

import java.util.ArrayList;
import java.util.List;


public class FragmentGiftDialog extends DialogFragment {
    private Dialog dialog;
    private ViewPager vp;
    private ArrayList<View>gridViews;
    private LayoutInflater layoutInflater;
    private ArrayList<Gift> catogarys;
    private String[] catogary_names;
    private int[] catogary_resourceIds;
    private RadioGroup radio_group;

    public GiftGridViewAdapter.OnGridViewClickListener onGridViewClickListener ;

    public FragmentGiftDialog() {
        // Required empty public constructor
    }
    public static final FragmentGiftDialog newInstance(){
        FragmentGiftDialog fragment = new FragmentGiftDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_fragment_gift_dialog, null, false);
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        initDialogStyle(rootView);
        initView(rootView);
        return dialog;

    }
    private void initView(View rootView) {
        Bundle args=getArguments();
        if(args==null)
            return;
        catogary_names = getResources().getStringArray(R.array.catogary_names);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.catogary_resourceIds);
        catogary_resourceIds = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            catogary_resourceIds[i] = typedArray.getResourceId(i, 0);
        }
        layoutInflater = getActivity().getLayoutInflater();
        vp = (ViewPager) rootView.findViewById(R.id.view_pager);
        radio_group = (RadioGroup) rootView.findViewById(R.id.radio_group);

        RadioButton radioButton = (RadioButton)radio_group.getChildAt(0);
        radioButton.setChecked(true);

        catogarys = new ArrayList<Gift>();
        for (int i = 0; i < catogary_names.length; i++) {
            Gift catogary = new Gift();
            catogary.name = catogary_names[i];
            catogary.giftType = catogary_resourceIds[i];
            catogarys.add(catogary);
        }
        initViewPager();
    }
    public void initViewPager() {
        gridViews = new ArrayList<View>();
        ///定义第一个GridView
        GridView gridView1 =
                (GridView) layoutInflater.inflate(R.layout.grid_fragment_home, null);
        GiftGridViewAdapter myGridViewAdapter1 = new GiftGridViewAdapter(getActivity(),0, 8);
        gridView1.setAdapter(myGridViewAdapter1);
        myGridViewAdapter1.setGifts(catogarys);
        myGridViewAdapter1.setOnGridViewClickListener(new GiftGridViewAdapter.OnGridViewClickListener() {
            @Override
            public void click(Gift gift) {
                if (onGridViewClickListener!=null){
                    onGridViewClickListener.click(gift);
                }
            }
        });
        ///定义第二个GridView
        GridView gridView2 = (GridView)
                layoutInflater.inflate(R.layout.grid_fragment_home, null);
        GiftGridViewAdapter myGridViewAdapter2 = new GiftGridViewAdapter(getActivity(),1, 8);
        gridView2.setAdapter(myGridViewAdapter2);
        myGridViewAdapter2.setGifts(catogarys);
        myGridViewAdapter2.setOnGridViewClickListener(new GiftGridViewAdapter.OnGridViewClickListener() {
            @Override
            public void click(Gift gift) {
                if (onGridViewClickListener!=null){
                    onGridViewClickListener.click(gift);
                }
            }
        });
        ///定义第三个GridView
        GridView gridView3 = (GridView)
                layoutInflater.inflate(R.layout.grid_fragment_home, null);
        GiftGridViewAdapter myGridViewAdapter3 = new GiftGridViewAdapter(getActivity(),2, 8);
        gridView3.setAdapter(myGridViewAdapter3);
        myGridViewAdapter3.setGifts(catogarys);
        myGridViewAdapter3.setOnGridViewClickListener(new GiftGridViewAdapter.OnGridViewClickListener() {
            @Override
            public void click(Gift gift) {
                if (onGridViewClickListener!=null){
                    onGridViewClickListener.click(gift);
                }
            }
        });
        gridViews.add(gridView1);
        gridViews.add(gridView2);
        gridViews.add(gridView3);

        ///定义viewpager的PagerAdapter
        vp.setAdapter(new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return gridViews.size();
            }
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(gridViews.get(position));
                //super.destroyItem(container, position, object);
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(gridViews.get(position));
                return gridViews.get(position);
            }
        });
        ///注册viewPager页选择变化时的响应事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int position) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton)
                        radio_group.getChildAt(position);
                radioButton.setChecked(true);
            }
        });
    }
    private void initDialogStyle(View view){
        dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;

        window.setAttributes(lp);
    }


}
