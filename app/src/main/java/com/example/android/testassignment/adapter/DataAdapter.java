package com.example.android.testassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.testassignment.R;
import com.example.android.testassignment.model.Response;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<Response> responseList;

    private Context mContext;

    public DataAdapter(Context context, List<Response> responseList) {
        this.mContext = context;
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_type, parent, false);
        return new DataAdapter.DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        Response response = responseList.get(position);
        holder.mCategory.setText(response.getTitle());
        holder.mTypeList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        if (response.getType().equals("type1")) {
            holder.mTypeList.setAdapter(new ItemAdapter(response.getItems(), 0, mContext));
        }
        else {
            holder.mTypeList.setAdapter(new ItemAdapter(response.getItems(), 1, mContext));
        }
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView mCategory;
        RecyclerView mTypeList;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            mTypeList = itemView.findViewById(R.id.rv_type);
            mCategory = itemView.findViewById(R.id.tv_type_category);
        }
    }
}
