package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DiceEventListener extends AppCompatImageView {


    private Drawable defaultImage;
    private int onPressDie;



    public DiceEventListener(Context context) {
        super(context);
        selectNewName();
    }

    public DiceEventListener(Context context, AttributeSet attrs) {
        super(context, attrs);
        selectNewName();
    }

    public DiceEventListener(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        selectNewName();
    }

    private void selectNewName(){
        defaultImage = getDrawable();
    }

    public void setOnPressDie(int onPressDie){
        this.onPressDie = onPressDie;
    }

    @Override
    public void setImageResource(int resId){
        super.setImageResource(resId);

        if (resId != onPressDie)
            defaultImage = getResources().getDrawable(resId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int select = event.getActionMasked();

        switch (select){
            case (MotionEvent.ACTION_DOWN) :

                setImageResource(onPressDie);
                return true;

            case (MotionEvent.ACTION_UP) :
                setImageDrawable(defaultImage);
                return true;
        }


        return true;
    }



}
