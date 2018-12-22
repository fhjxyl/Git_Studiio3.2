package com.test.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class AtyTaskThird extends Activity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("AtyTask", "AtyTaskThird onNewIntent  -->" + getTaskId());
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_task_third_layout);

        Log.e("AtyTask", "AtyTaskThird onCreate  -->" + getTaskId());

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intOne = new Intent(AtyTaskThird.this, AtyTaskTwo.class);
                AtyTaskThird.this.startActivity(intOne);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AtyTask", "AtyTaskThird onDestroy  -->" + getTaskId());
    }
}
