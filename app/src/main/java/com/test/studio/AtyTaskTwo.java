package com.test.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class AtyTaskTwo extends Activity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("AtyTask", "AtyTaskTwo onNewIntent  -->" + getTaskId());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_task_two_layout);

        Log.e("AtyTask", "AtyTaskTwo onCreate  -->" + getTaskId());

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intOne = new Intent(AtyTaskTwo.this, AtyTaskThird.class);
                AtyTaskTwo.this.startActivity(intOne);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AtyTask", "AtyTaskTwo onDestroy  -->" + getTaskId());
    }
}
