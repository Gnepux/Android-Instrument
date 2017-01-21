package com.gnepux.instrument.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gnepux.instrument.R;

/**
 * Created by xupeng on 17/1/21.
 */

public class OriginRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public TextView titleTv;

    public TextView descTv;

    public OriginRecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
        titleTv = (TextView) itemView.findViewById(R.id.tv_title);
        descTv = (TextView) itemView.findViewById(R.id.tv_desc);
    }

}
