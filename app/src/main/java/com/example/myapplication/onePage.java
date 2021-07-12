package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class onePage extends ConstraintLayout {
    RecyclerView recyclerView;
    recycler recycler;
    RequestQueue requestQueue;
    String myUrl ="https://quality.data.gov.tw/dq_download_json.php?nid=6730&md5_url=a937a1dee74f4eed870dfc36a6bdc43e";

    public onePage(@NonNull final Context context, int pageNumber, final List<String> list, final List<String>list2, final List<String>list3, final List<String>list4) {
        super(context);

        LayoutInflater inflater=LayoutInflater.from(context);
        final View viewaa=inflater.inflate(R.layout.pages,null);
        TextView textView = viewaa.findViewById(R.id.showPage);
        final TextView textsearch = viewaa.findViewById(R.id.showPage2);
        final EditText txEd = viewaa.findViewById(R.id.editTextTextPersonName3);
        Button bt =viewaa.findViewById(R.id.buttonS);

        if(pageNumber != 14){

            textsearch.setVisibility(GONE);
            txEd.setVisibility(GONE);
            bt.setVisibility(GONE);

            textView.setText("總共有：" + list.size()+"項");

            recyclerView = viewaa.findViewById(R.id.show2);
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));
            recycler = new recycler(list,list2,list3,list4);
            recyclerView.setAdapter(recycler);
        }else{
            textView.setVisibility(GONE);
            textsearch.setVisibility(VISIBLE);
            txEd.setVisibility(VISIBLE);
            bt.setVisibility(VISIBLE);
            bt.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (txEd.getText() != null){
                        List<String> listBook2= new ArrayList<String>();
                        List<String> listPeople2= new ArrayList<String>();
                        List<String> listCompany2= new ArrayList<String>();
                        List<String> listTime2= new ArrayList<String>();

                        for(int i=0;i<list.size();i++){
                            String searchSt = txEd.getText().toString();

                            if(list.get(i).indexOf(searchSt) != -1){
                                //Log.d("listcheck",list.toString());
                                listBook2.add(list.get(i));
                                listPeople2.add(list2.get(i));
                                listCompany2.add(list3.get(i));
                                listTime2.add(list4.get(i));
                            }
                        }







                        recyclerView = viewaa.findViewById(R.id.show2);
                        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
                        recycler = new recycler(listBook2,listPeople2,listCompany2,listTime2);
                        recyclerView.setAdapter(recycler);
                    }



                }
            });

        }



        addView(viewaa, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

    }
}
