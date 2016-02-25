package com.example.taomaogan.sharedemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taomaogan on 2016/2/25.
 */
public class ShareActivity extends Activity {
    private TextView mShareTv;
    private ImageView mShareIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mShareTv = (TextView) findViewById(R.id.share_tv);
        mShareIv = (ImageView) findViewById(R.id.share_iv);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (action.equals(Intent.ACTION_SEND) && type != null) {
            if (type.equals("text/plain")) {
                handleSendText(intent);
            } else if (type.startsWith("image/")) {
                handleSendImage(intent);
            }
        } else if (action.equals(Intent.ACTION_SEND_MULTIPLE) && type != null) {
            if (type.startsWith("image/")) {
                handleSendMultiImage(intent);
            }
        } else {
            //do nothing.
        }
    }

    private void handleSendText(Intent intent) {
        String shareText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (!TextUtils.isEmpty(shareText)) {
            mShareTv.setText(shareText);
        }
    }

    private void handleSendImage(Intent intent) {
        Uri shareUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (shareUri != null) {
            mShareIv.setImageURI(shareUri);
        }
    }

    private void handleSendMultiImage(Intent intent) {
        ArrayList<Uri> uris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (uris != null && uris.size() > 0) {
            mShareIv.setImageURI(uris.get(0));
        }
    }
}
