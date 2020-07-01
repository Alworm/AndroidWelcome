package com.dhy.welcome.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhy.welcome.R;
import com.dhy.welcome.adapter.MissionAdapter;
import com.dhy.welcome.bean.Information;
import com.dhy.welcome.bean.Mission;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ThreeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView2;
    private MissionAdapter missionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_three,null);
        recyclerView2 = view.findViewById(R.id.recycler_view_mission);
        missionAdapter = new MissionAdapter(getList(),getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(missionAdapter);
        return view;
    }

    public List<Mission> getList(){
        List<Mission> list = new ArrayList<>();
        Mission mission = new Mission();
        mission.time = "2020/7/1";
        mission.username = "Alworm";
        mission.status = "已完成";
        list.add(mission);

        Mission mission1 = new Mission();
        mission1.time = "2020/7/1";
        mission1.username = "admin";
        mission1.status = "已完成";
        list.add(mission1);

        Mission mission2 = new Mission();
        mission2.time = "2020/7/1";
        mission2.username = "小明";
        mission2.status = "未完成";
        list.add(mission2);
        return list;
    }

}
