package com.example.myapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.R;


public class ConplaintFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private Button btn1;

    public ConplaintFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conplaint, container, false);

//        // Initialize the button
//        btn1 = view.findViewById(R.id.btn1);
//
//        // Set click listener for the button
//        btn1.setOnClickListener(v -> {
//            // Perform the desired action, e.g., open a new activity
//            Intent intent = new Intent(getActivity(), SecondActivity.class);
//            startActivity(intent);
//        });

        Button send = view.findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Successfuly submitted", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}