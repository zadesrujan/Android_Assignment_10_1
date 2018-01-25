package com.example.user.android_assignment_10_1;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment implements MainActivity.DataListener {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with Fragment which implements Parent class with object.

    TextView textView;
    //Intializing the variables
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_black, container, false);
        textView = view.findViewById(R.id.tv);
        //giving edit text and it will find the text from activity what ur giving.
        return view;
    }


    @Override
    public void sendData(String data) {
        textView.setText(data);
    }
}


