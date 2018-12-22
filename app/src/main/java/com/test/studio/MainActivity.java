package com.test.studio;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author fenghj
 */
public class MainActivity extends AppCompatActivity {

    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;

    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface WeekDays {
    }


    @WeekDays
    int currentDay = SUNDAY;

    String TAG = "MainAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentDay(WEDNESDAY);

        @WeekDays
        int today = getCurrentDay();

        switch (today) {
            case SUNDAY:
                Log.e("fk", "SUNDAY = " + SUNDAY);
                break;
            case MONDAY:
                Log.e("fk", "MONDAY = " + MONDAY);
                break;
            case TUESDAY:
                Log.e("fk", "TUESDAY = " + TUESDAY);
                break;
            case WEDNESDAY:
                Log.e("fk", "WEDNESDAY = " + WEDNESDAY);
                break;
            case THURSDAY:
                Log.e("fk", "THURSDAY = " + THURSDAY);
                break;
            case FRIDAY:
                Log.e("fk", "FRIDAY = " + FRIDAY);
                break;
            default:
                Log.e("fk", "DEFAULT = default");
                break;
        }

        Button btn =findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Flowable.create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                        // 发送 129个事件
                        for (int i = 0; i < 150; i++) {
                            Log.d(TAG, "发送了事件" + i);
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                }, BackpressureStrategy.DROP) // 设置背压模式 = BackpressureStrategy.ERROR
                        .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                        .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                        .subscribe(new Subscriber<Integer>() {
                            @Override
                            public void onSubscribe(Subscription s) {
                                Log.d(TAG, "onSubscribe");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d(TAG, "接收到了事件" + integer);
                            }

                            @Override
                            public void onError(Throwable t) {
                                Log.w(TAG, "onError: ", t);
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete");
                            }
                        });
            }
        });


    }

    public void setCurrentDay(@WeekDays int currentDta) {
        this.currentDay = currentDta;
    }

    @WeekDays
    public int getCurrentDay() {
        return this.currentDay;
    }
}
