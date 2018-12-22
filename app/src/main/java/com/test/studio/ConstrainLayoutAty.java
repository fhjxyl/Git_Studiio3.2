package com.test.studio;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ConstrainLayoutAty extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_constrain_layout);
        Thread.currentThread().getName();

    }
}
