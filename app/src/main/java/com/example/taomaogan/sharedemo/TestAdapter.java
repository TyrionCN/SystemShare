package com.example.taomaogan.sharedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: maxiaoyu
 * email: taomaogan@meizu.com
 * date: 2017/08/08
 * desc:
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.BaseVH> {
    private List<AppInfoVo> appInfoVos;
    private LayoutInflater inflater;

    public TestAdapter(Context context) {
        appInfoVos = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void addItems(List<AppInfoVo> appInfoVos) {
        this.appInfoVos.addAll(appInfoVos);
        notifyDataSetChanged();
    }

    @Override
    public BaseVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseVH(inflater.inflate(R.layout.test_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseVH holder, int position) {
        holder.update(appInfoVos.get(position));
    }

    @Override
    public int getItemCount() {
        return appInfoVos.size();
    }

    class BaseVH extends RecyclerView.ViewHolder {
        private ImageView testIv;
        private TextView testTv;

        public BaseVH(View itemView) {
            super(itemView);
            testIv = (ImageView) itemView.findViewById(R.id.test_iv);
            testTv = (TextView) itemView.findViewById(R.id.test_tv);
        }

        public void update(AppInfoVo appInfoVo) {
            testIv.setImageDrawable(appInfoVo.icon);
            testTv.setText(appInfoVo.appName);
        }
    }
}
