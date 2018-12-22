package com.test.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

public class AtyTaskOne extends Activity {


    private LinearLayout linearLayout;

    private ListView listView;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("AtyTask", "AtyTaskOne onNewIntent -->" + getTaskId());

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_task_one_layout);

        Log.e("AtyTask", "AtyTaskOne onCreate  -->" + getTaskId());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intOne = new Intent(AtyTaskOne.this, AtyTaskTwo.class);
                AtyTaskOne.this.startActivity(intOne);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AtyTask", "AtyTaskOne onDestroy  -->" + getTaskId());
    }
}
