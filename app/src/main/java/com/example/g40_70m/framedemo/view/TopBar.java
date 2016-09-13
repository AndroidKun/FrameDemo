package com.example.g40_70m.framedemo.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.g40_70m.framedemo.R;
import com.zhy.autolayout.AutoRelativeLayout;


/**
 * Created by XQY on 2016/5/8/008.
 * 功能描述:
 */
public class TopBar extends AutoRelativeLayout implements View.OnClickListener{

    private TextView titleText;
    private TextView leftText;
    private TextView rightText;
    private ImageButton imgBtn_left;
    private ImageButton imgBtn_right;

    String title = "";
    String leftString = "";
    String rightString = "";

    private TobBarButtonClickLinstener tobBarButtonClickLinstener;

    private Activity mContext;
    public TopBar(Context context) {
        super(context);
        mContext= (Activity) context;

    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }


    private void init(Context context, AttributeSet attrs, int defStyle) {
        mContext= (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.laout_topbar, this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TopBar, defStyle, 0);

        titleText= (TextView) findViewById(R.id.text_title);
        title = a.getString(R.styleable.TopBar_titleText);
        setTitle(title);

        leftText = (TextView) findViewById(R.id.leftText);
        leftString = a.getString(R.styleable.TopBar_leftText);
        setLeftText(leftString);

        rightText = (TextView) findViewById(R.id.rightText);
        rightString = a.getString(R.styleable.TopBar_rightText);
        setRightText(rightString);

        imgBtn_left = (ImageButton) findViewById(R.id.imgBtn_left);
        int leftSrc = a.getResourceId(R.styleable.TopBar_leftSrc, 0);
        setImageButtonLeftSrc(leftSrc);

        imgBtn_right = (ImageButton) findViewById(R.id.imgBtn_right);
        int rightSrc = a.getResourceId(R.styleable.TopBar_rightSrc, 0);
        setImageButtonRightSrc(rightSrc);

        int leftVisibility = a.getInt(R.styleable.TopBar_leftVisibility, 0x00000000);
        setImageButtonLeftVisibility(leftVisibility);

        int rightVisibility = a.getInt(R.styleable.TopBar_rightVisibility,  0x00000000);
        setImageButtonRightVisibility(rightVisibility);

        int rightTextColor = a.getColor(R.styleable.TopBar_rightTextColor,context.getResources().getColor(R.color.white));
        setRightTextColor(rightTextColor);

        int rightTextBackground = a.getResourceId(R.styleable.TopBar_rightTextBackground,0);
        setRightTextBackground(rightTextBackground);

        a.recycle();

        findViewById(R.id.line_left).setOnClickListener(this);
        findViewById(R.id.line_right).setOnClickListener(this);

    }

    public void setTitle(String str) {
        title = str;
        titleText.setText(title);
    }

    public void setLeftText(String str) {
        leftString = str;
        leftText.setText(leftString);
    }

    public void setRightText(String str) {
        rightString = str;
        rightText.setText(rightString);
    }

    public void setImageButtonLeftSrc(int resId){
        imgBtn_left.setImageResource(resId > 0 ? resId : R.mipmap.ic_launcher);
    }

    public void setImageButtonRightSrc(int resId){
        if(resId>0) imgBtn_right.setVisibility(View.VISIBLE);
        imgBtn_right.setImageResource(resId > 0 ?resId:R.mipmap.ic_launcher);
    }

    public void setImageButtonLeftVisibility(int visibility){
        imgBtn_left.setVisibility(visibility);
    }

    public void setImageButtonRightVisibility(int visibility){
        imgBtn_right.setVisibility(visibility);
    }

    public void setRightTextColor(int color){
        rightText.setTextColor(color);
    }

    public void setRightTextBackground(int background){
        rightText.setBackgroundResource(background);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.line_left:
                if(tobBarButtonClickLinstener!=null){
                    tobBarButtonClickLinstener.clickLeftBtn(v);
                }else{
                    if(imgBtn_left.getVisibility()==VISIBLE) {
                        mContext.finish();
                    }
                }
                break;
            case R.id.line_right:
                if(tobBarButtonClickLinstener!=null){
                    tobBarButtonClickLinstener.clickRightBtn(v);
                }
                break;
        }
    }


    public interface TobBarButtonClickLinstener{
        void clickLeftBtn(View view);
        void clickRightBtn(View view);
    }

    public void setTobBarButtonClickLinstener(TobBarButtonClickLinstener tobBarButtonClickLinstener) {
        this.tobBarButtonClickLinstener = tobBarButtonClickLinstener;
    }
}
