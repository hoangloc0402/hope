package com.sunset.hope.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunset.hope.R;
import com.sunset.hope.activities.ActivityPostDetail;
import com.sunset.hope.activities.MainActivity;
import com.sunset.hope.adapters.AdapterRCVPost;
import com.sunset.hope.entities.Post;

import java.io.Serializable;

public class FragmentDonate extends Fragment {
    View myView;
    RecyclerView recyclerView;
    AdapterRCVPost adapterRCV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =  inflater.inflate(R.layout.fragment_donate, container, false);
        recyclerView = myView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapterRCV= new AdapterRCVPost(true);
        recyclerView.setAdapter(adapterRCV);

        adapterRCV.setItemClickListener((view, position) -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Option");
            builder.setItems(R.array.listOption, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case 0:
                                    Post post = MainActivity.postData.get(position);
                                    Intent intent = new Intent(getContext(), ActivityPostDetail.class);
                                    intent.putExtra("post", position);
                                    startActivity(intent);
                                    break;
                                case 1: break;

                                case 2:
                                    Intent intent2 = new Intent(Intent. ACTION_DIAL, Uri.parse("tel:" + "0326633637"));
                                    startActivity(intent2);
                                    break;
                                default:break;
                            }
                        }
                    });
            builder.setCancelable(true);
            builder.create();
            builder.show();
        });
        return myView;
    }
}
