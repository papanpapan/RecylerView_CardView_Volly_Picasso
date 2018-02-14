package com.example.samim.json_recylerview_cardview;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.samim.json_recylerview_cardview.Adapter.MyAdapter;
import com.example.samim.json_recylerview_cardview.Item.ListItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {
    private static final String URL_DATA="https://api.androidhive.info/json/movies.json";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.RecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();

        loadRecylerViewData();


    }

    private void loadRecylerViewData() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loding data...");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();

                try{
                    JSONObject jsonObject=new JSONObject(s);
                    //changes
                    //from json array and object
                    //on a string value
                    JSONArray array=jsonObject.getJSONArray("genre");

                    for (int i=0;i<array.length();i++){
                        JSONObject o=array.getJSONObject(i);
                        ListItem item=new ListItem(
                                o.getString("title"),
                                o.getString("releaseYear"),
                                o.getString("image")

                                //changes end

                        );
                        listItems.add(item);
                    }
                    adapter=new MyAdapter(listItems,getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
