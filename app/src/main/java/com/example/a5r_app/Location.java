package com.example.a5r_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Location extends AppCompatActivity {
    Button back;
    ArrayList<String> locations = new ArrayList<String>();
    ArrayList<Integer> locationIDs = new ArrayList<Integer>();
    LinearLayout linearLayout;
    String zip;
    int productCode;
    TextView instructions;


    public void makeButtons(){

        instructions = new TextView(this);
        instructions.setText("Please Select a Nearby Location:");
        instructions.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        instructions.setGravity(Gravity.CENTER);
        instructions.setTextSize(20);
        linearLayout.addView(instructions);

        for (int i = 0; i < locations.size(); i++) {
            Button btnShow = new Button(this);
            btnShow.setText(locations.get(i));
            btnShow.getBackground().setColorFilter(Color.rgb(0x4C, 0xBB, 0x17), PorterDuff.Mode.SRC_ATOP);
            btnShow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            btnShow.setId(i);
            final int finalI = i;
            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MyApplication) getApplication()).setLocCode(locationIDs.get(finalI));
                    Intent infoIntent = new Intent(Location.this, FinalInfo.class);
                    startActivity(infoIntent);
                }
            });

            linearLayout.addView(btnShow);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempIntent = new Intent(Location.this, FinalProduct.class);
                startActivity(tempIntent);
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        RequestQueue queue= Volley.newRequestQueue(Location.this);

        String zip = ((MyApplication) getApplication()).getZipText();
        int productCode = ((MyApplication) getApplication()).getProductCode();
        String url="http://67.249.71.109:3001/" + zip + "/" + productCode; //put backend server here

        linearLayout = findViewById(R.id.productListContainer);

        //do the get request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String name = jsonObject.getString("name");
                                int id = jsonObject.getInt("locID");
                                locations.add(name);
                                locationIDs.add(id);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        makeButtons();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);


    //END OF ONCREATE()
    }



}



