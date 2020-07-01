package com.dhy.welcome.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dhy.welcome.R;
import com.dhy.welcome.activity.AboutActivity;
import com.dhy.welcome.activity.LoginActivity;
import com.dhy.welcome.activity.MissionActivity;
import com.dhy.welcome.activity.MyInformationActivity;
import com.dhy.welcome.activity.PasswordActivity;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FourFragment extends Fragment {
    private View view;
    private TextView textInfor;
    private TextView textMission;
    private TextView textUpdate;
    private TextView textAbout;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_four, null);
        findView();
        return view;
    }

    private void findView() {
        textAbout = view.findViewById(R.id.id_about);
        textInfor = view.findViewById(R.id.id_info);
        textUpdate = view.findViewById(R.id.id_update);
        textMission = view.findViewById(R.id.id_mission);
        button = view.findViewById(R.id.id_exit);

        textInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyInformationActivity.class);
                startActivity(intent);
            }
        });

        textMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MissionActivity.class);
                startActivity(intent);
            }
        });

        textUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PasswordActivity.class);
                startActivity(intent);
            }
        });

        textAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().onBackPressed();
                startActivity(intent);
            }
        });

    }
}
