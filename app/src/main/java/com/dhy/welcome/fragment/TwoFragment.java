package com.dhy.welcome.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhy.welcome.R;
import com.dhy.welcome.adapter.CommentAdapter;
import com.dhy.welcome.bean.Information;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class TwoFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CommentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two,null);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new CommentAdapter(getList(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public List<Information> getList(){
        List<Information> list = new ArrayList<>();

        Information information = new Information();
        information.content="老师傅牛逼";
        information.time = "2020/7/1";
        list.add(information);

        Information information1 = new Information();
        information1.content="老师傅强啊";
        information1.time = "2020/7/1";
        list.add(information1);

        Information information2 = new Information();
        information2.content="老师傅无敌了";
        information2.time = "2020/7/1";
        list.add(information2);


        return list;
    }

}
