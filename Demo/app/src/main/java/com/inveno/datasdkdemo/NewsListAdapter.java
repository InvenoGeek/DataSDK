package com.inveno.datasdkdemo;

import java.util.List;

import com.bumptech.glide.Glide;
import com.inveno.datasdk.constant.OpenType;
import com.inveno.datasdk.model.Image;
import com.inveno.datasdk.model.News;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private List<News> newsList;

    public void replaceData(List<News> data) {
        newsList = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.news_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = newsList.get(position);

        List<Image> imageList = news.getImages();
        if (imageList != null && imageList.size() > 0) {
            Image image = imageList.get(0);
            Glide.with(holder.newsIV.getContext()).load(image.getImageUrl()).into(holder.newsIV);
        }

        holder.newsTV.setText(news.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(news.getShareUrl()));
                view.getContext().startActivity(intent);

                // 上报条目点击
                DataSDKWrapper.onItemClick(view.getContext(), news.getScenario(), news.getContentId(), news.getCpack(),
                                           OpenType.OUTSIDE_APP, null, null);
            }
        });

        // 上报条目展示
        DataSDKWrapper.onItemShow(holder.itemView.getContext(), news.getScenario(), news.getContentId(), news.getCpack(),
                                  news.getServerTime(), null, null);
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0 : newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newsIV;
        TextView  newsTV;

        public ViewHolder(final View itemView) {
            super(itemView);
            newsIV = (ImageView) itemView.findViewById(R.id.newsIV);
            newsTV = (TextView) itemView.findViewById(R.id.newsTV);
        }
    }
}
