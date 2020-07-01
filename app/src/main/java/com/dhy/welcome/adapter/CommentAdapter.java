package com.dhy.welcome.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhy.welcome.R;
import com.dhy.welcome.bean.Information;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<Information> list;

    public CommentAdapter(List<Information> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.activity_item_comment,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Information information = list.get(position);
        holder.commentTime.setText(information.time);
        holder.commentContent.setText(information.content);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView commentContent;
        private TextView commentTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentContent = itemView.findViewById(R.id.txt_comment_content);
            commentTime = itemView.findViewById(R.id.txt_comment_time);
        }
    }
}
