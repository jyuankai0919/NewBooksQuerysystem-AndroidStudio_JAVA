package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;

import java.util.List;

public class recycler extends RecyclerView.Adapter<recycler.ViewHolder> {

    List<String> mListString;
    List<String> mListString2;
    List<String> mListString3;
    List<String> mListString4;


    public recycler(List<String>list, List<String>list2, List<String>list3, List<String>list4){
        mListString = list;
        mListString2 = list2;
        mListString3 = list3;
        mListString4 = list4;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.care, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTx1.setText(mListString.get(position));
        holder.mTx2.setText(mListString2.get(position));
        holder.mTx3.setText(mListString3.get(position));
        holder.mTx4.setText(mListString4.get(position));


    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener {
        TextView mTx1,mTx2,mTx3,mTx4;
        RequestQueue requestQueue;
        String myputUrl = "http://140.131.82.10/student/abc2.php";

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTx1 = itemView.findViewById(R.id.item1);
            mTx2 = itemView.findViewById(R.id.item2);
            mTx3 = itemView.findViewById(R.id.item3);
            mTx4 = itemView.findViewById(R.id.item4);
            //tx1 = itemView.findViewById(R.id.TX1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            /*

            requestQueue = Volley.newRequestQueue(view.getContext());

            StringRequest stringRequest =new StringRequest(Request.Method.POST,myputUrl , new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("aaa",response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    tx1.setText(error.toString());

                }
            }){
                @Override
                protected Map<String,String> getParams() throws AuthFailureError {
                    Map<String,String> myMap = new HashMap<String,String>();
                    myMap.put("id", "10710251");
                    myMap.put("aa",mListString.get(getAdapterPosition()));


                    return myMap;
                }
            };

            requestQueue.add(stringRequest);

            TextView abc = new TextView(view.getContext());
            abc.setText("所選取的產品 ");
            abc.setGravity(Gravity.CENTER);
            abc.setPadding(10,10,10,10);
            abc.setTextSize(26);

            TextView msg = new TextView(view.getContext());
            msg.setText(mListString.get(getAdapterPosition()));
            msg.setPadding(10, 50, 10, 10);
            msg.setGravity(Gravity.CENTER_HORIZONTAL);
            msg.setTextSize(18);


            AlertDialog.Builder aa = new AlertDialog.Builder(view.getContext());
            aa.setCustomTitle(abc);
            aa.setView(msg);

            aa.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            aa.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast toast = Toast.makeText(view.getContext(),"訂購成功",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0, 0);
                    toast.show();

                }
            });


            aa.show();
        */
        }


    }
}
