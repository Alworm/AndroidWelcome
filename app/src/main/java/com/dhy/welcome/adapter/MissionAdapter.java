package com.dhy.welcome.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhy.welcome.R;
import com.dhy.welcome.bean.Information;
import com.dhy.welcome.bean.Mission;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.ViewHolder>{
    private Context context;
    private List<Mission> list;

    public MissionAdapter(List<Mission> list,Context context){
        this.context =context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.activity_item_mission,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mission mission = list.get(position);
        if ("未完成".equals(mission.status)){
            holder.statusTextView.setTextColor(android.graphics.Color.RED);
        }
        holder.statusTextView.setText(mission.status);
        holder.timeTextView.setText(mission.time);
        holder.nameTextView.setText(mission.username);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView timeTextView;
        private TextView statusTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.txt_mission_username);
            timeTextView = itemView.findViewById(R.id.txt_mission_time);
            statusTextView = itemView.findViewById(R.id.txt_mission_status);
        }
    }
}
