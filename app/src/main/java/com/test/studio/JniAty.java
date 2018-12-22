package com.test.studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.studio.ui.WebViewAty;

public class JniAty extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_jnilayout);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(JniAty.this, JniUtli.sayHellow(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(JniAty.this, WebViewAty.class);
                intent.putExtra("email", "huazai_147@126.com");
                startActivity(intent);
            }
        });
    }


}
