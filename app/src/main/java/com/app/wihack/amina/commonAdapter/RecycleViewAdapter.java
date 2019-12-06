package com.app.wihack.amina.commonAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wihack.amina.commonAdapter.IBind;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<?> mData = new ArrayList();


    private int recycleViewRes;


    public void setRecycleViewRes(int recycleViewRes) {
        this.recycleViewRes = recycleViewRes;
    }

    public void setData(List<?> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(recycleViewRes, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).bind(mData.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //

        View customView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            customView = itemView;

        }

        public void bind(Object o, int position) {

            if (customView instanceof IBind) {
                ((IBind) customView).bind(o, position);
            }
        }
    }
}
