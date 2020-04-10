package com.example.mygalleryca2.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mygalleryca2.R;

public class fragment2 extends Fragment {
    ImageView imgview;
    Uri image;
    TextView textView;
    String text;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pager2,container,false);

        imgview=(ImageView)view.findViewById(R.id.timg2);

        if(getArguments()!=null){

            image=Uri.parse(getArguments().getString("img"));
            imgview.setImageURI(image);
        }



        return view;
    }
}
