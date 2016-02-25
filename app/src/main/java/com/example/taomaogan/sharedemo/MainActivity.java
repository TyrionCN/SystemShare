package com.example.taomaogan.sharedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mTestTextBtn;
    private Button mTestImageBtn;
    private Button mTestMultiImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTestTextBtn = (Button) findViewById(R.id.test_text_btn);
        mTestImageBtn = (Button) findViewById(R.id.test_image_btn);
        mTestMultiImageBtn = (Button) findViewById(R.id.test_multi_image_btn);
        mTestTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText();
            }
        });
        mTestImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });
        mTestMultiImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareMultiImage();
            }
        });
    }

    private void shareText() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "我是全世界最聪明的人！");
        intent.setType("text/plain");
        startActivity(intent);
    }

    private void shareImage() {
        Uri uri = Uri.parse("content://notes/data/media/20");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setType("image/*");
        startActivity(intent);
    }

    private void shareMultiImage() {
        ArrayList<Uri> uris = new ArrayList<>();
        uris.add(Uri.parse("content://notes/data/media/20"));
        uris.add(Uri.parse("content://notes/data/media/21"));
        uris.add(Uri.parse("content://notes/data/media/22"));
        uris.add(Uri.parse("content://notes/data/media/23"));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putExtra(Intent.EXTRA_STREAM, uris);
        intent.setType("image/*");
        startActivity(intent);
    }
}
