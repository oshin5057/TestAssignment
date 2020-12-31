package com.example.android.testassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.testassignment.R;
import com.example.android.testassignment.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> itemList;
    private int type;
    private Context mContext;

    public ItemAdapter(List<Item> items, int viewType, Context mContext) {
        this.itemList = items;
        this.type = viewType;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(type == 0) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_type_one, parent, false);
            return new DataViewHolderType1(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_type_two, parent, false);
            return new DataViewHolderType2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        if(type == 0) {
            DataViewHolderType1 viewHolder = (DataViewHolderType1)holder;
            Picasso.with(mContext)
                    .load(item.getImage())
                    .into(viewHolder.mImageView);
            viewHolder.mTitle.setText(item.getTitle());
        }
        else  {
            DataViewHolderType2 viewHolder = (DataViewHolderType2)holder;
            Picasso.with(mContext)
                    .load(item.getImage())
                    .into(viewHolder.mImageView);
            viewHolder.mTitle.setText(item.getTitle());
            viewHolder.mSubtitle.setText(item.getSubTitle());
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class DataViewHolderType1 extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTitle;

        public DataViewHolderType1(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_image);
            mTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public static class DataViewHolderType2 extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTitle;
        TextView mSubtitle;

        public DataViewHolderType2(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_image_type2);
            mTitle = itemView.findViewById(R.id.tv_title_type2);
            mSubtitle = itemView.findViewById(R.id.tv_subtitle);
        }
    }
}
