package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> listNumber= new ArrayList<>();
    List<String> listBook = new ArrayList<>();
    List<String> listPeople = new ArrayList<>();
    List<String> listCompany = new ArrayList<>();
    List<String> listTime = new ArrayList<>();

    List<String> number= Arrays.asList("心理","理財","投資","英語","數學","設計","科學","傳記","成功","電腦程式","醫學","期刊","文集","其他");

    RequestQueue requestQueue;
    String myUrl ="https://quality.data.gov.tw/dq_download_json.php?nid=6730&md5_url=a937a1dee74f4eed870dfc36a6bdc43e";
    TextView st1,st2,st3,st4,st5,st6;
    ViewPager viewPager;
    TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.mViewPager);
        tab=findViewById(R.id.mTab);
        st1 = findViewById(R.id.startext1);
        st2 = findViewById(R.id.startext2);
        st3 = findViewById(R.id.startext3);
        st4 = findViewById(R.id.startext4);
        //st5 = findViewById(R.id.startext5);
        st6 = findViewById(R.id.startext6);

        //1.建立連線
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        //2.建立連線內容

        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, myUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d("response",response.toString());
                        ;
                        try {
                            String data1, data2= "";
                            for(int i=0;i<response.length();i++){
                                JSONObject ja = response.getJSONObject(i);

                                String title=ja.getString("標題");

                                int indx=13;

                                for(int j=0;j<13;j++){
                                    if(title.indexOf(number.get(j)) != -1){
                                        indx=j;
                                        break;
                                    }
                                }
                                listNumber.add(indx);

                                listBook.add(ja.getString("書名")+" ");
                                listPeople.add("作者："+ja.getString("作者")+" ");
                                listCompany.add("出版單位："+ja.getString("出版單位")+" ");
                                listTime.add("出版年月："+ja.getString("出版年月")+" ");


                                Log.d("all",ja.toString());
                                Log.d("title",listNumber.get(i)+"");
                                Log.d("asd",indx+"");


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("錯誤",e.toString());

                        }
                    }

                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                //tx1.setText(""+error);
            }

        });
        requestQueue.add(jar);

        requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<String>() {
            @Override
            public void onRequestFinished(Request<String> request) {
                st1.setVisibility(View.GONE);
                st2.setVisibility(View.GONE);
                st3.setVisibility(View.GONE);
                st4.setVisibility(View.GONE);
                //st5.setVisibility(View.GONE);
                st6.setVisibility(View.GONE);
                tab.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);

                //source
                ArrayList<View> mPages=new ArrayList<>();

                for (int i=0; i<15; i++){
                    List<String> listBook2= new ArrayList<String>();
                    List<String> listPeople2= new ArrayList<String>();
                    List<String> listCompany2= new ArrayList<String>();
                    List<String> listTime2= new ArrayList<String>();

                    if(i != 14){
                        for(int k=0;k<listNumber.size();k++){

                            if(listNumber.get(k)==i){
                                listBook2.add(listBook.get(k));
                                listPeople2.add(listPeople.get(k));
                                listCompany2.add(listCompany.get(k));
                                listTime2.add(listTime.get(k));
                            }

                        }
                        mPages.add(new onePage(MainActivity.this,(i),listBook2,listPeople2,listCompany2,listTime2));


                    }else{
                        mPages.add(new onePage(MainActivity.this,(i),listBook,listPeople,listCompany,listTime));

                    }

                }

                //adapter
                MyPageAdapter myPageAdapter=new MyPageAdapter(mPages);

                //link
                tab.setupWithViewPager(viewPager);
                viewPager.setAdapter(myPageAdapter);
                viewPager.setCurrentItem(0);
            }
        });
    }

    public void classification() {


    }
}