package com.nightfarmer.commonutil.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.nightfarmer.commonutil.ClipboardUtil;

public class MainActivity extends AppCompatActivity {

    TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        console = (TextView) findViewById(R.id.console);

    }

    int count = 0;

    public void a1(View v) {
//        ClipboardUtil.INSTANCE.copyToClipboard(this, "a");
        ClipboardUtil.INSTANCE.append(this, "a" + (++count));
    }

    public void a2(View v) {
        Log.i("1", "" + ClipboardUtil.INSTANCE.getItemCount(this));
    }

    public void a3(View v) {
        Log.i("1", "" + ClipboardUtil.INSTANCE.getText(this, 0));
    }

    public void a4(View v) {
        Log.i("1", "" + ClipboardUtil.INSTANCE.getLatestText(this));
    }
}
