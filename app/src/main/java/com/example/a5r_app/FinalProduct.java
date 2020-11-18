package com.example.a5r_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FinalProduct extends AppCompatActivity {
    Button back;
    EditText zipTextEdit;
    ArrayList<String> prodNames = new ArrayList<String>();
    ArrayList<Integer> prodIds = new ArrayList<Integer>();
    TextView get_response_text;
    TextView instructions;
    LinearLayout linearLayout;


    public void makeButtons(){

        instructions = new TextView(this);
        instructions.setText("Please enter a ZIP code and select a product to search for recycling locations.");
        instructions.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        instructions.setGravity(Gravity.CENTER);
        instructions.setTextSize(20);
        linearLayout.addView(instructions);


        //create zip code text field
        zipTextEdit = new EditText(this);
        zipTextEdit.setHint("Enter 5-Digit ZIP Code Here");
        if (((MyApplication) getApplication()).getZipText() != null){
            zipTextEdit.setText(((MyApplication) getApplication()).getZipText());
        }
        zipTextEdit.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        zipTextEdit.getBackground().setColorFilter(Color.rgb(0x4C, 0xBB, 0x17), PorterDuff.Mode.SRC_ATOP);
        linearLayout.addView(zipTextEdit);

        //dynamic buttons generated
        for (int i = 0; i < prodNames.size(); i++) {
            Button btnShow = new Button(this);
            btnShow.setText(prodNames.get(i));
            btnShow.getBackground().setColorFilter(Color.rgb(0x4C, 0xBB, 0x17), PorterDuff.Mode.SRC_ATOP);
            btnShow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            btnShow.setId(i);
            final int finalI = i;
            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //possible check for zip code could go here

                    //set zip and product in global vars
                    ((MyApplication) getApplication()).setZipText(zipTextEdit.getText().toString());
                    ((MyApplication) getApplication()).setProductCode(prodIds.get(finalI));

                    //launch next activity
                    Intent locationIntent = new Intent(FinalProduct.this, Location.class);
                    startActivity(locationIntent);
                }
            });

            linearLayout.addView(btnShow);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempIntent = new Intent(FinalProduct.this, ProductSelection.class);
                startActivity(tempIntent);
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        RequestQueue queue= Volley.newRequestQueue(FinalProduct.this);

        String subCode = ((MyApplication)getApplication()).getSubCode();
        String url="http://67.249.71.109:3001/product/" + subCode; //put get request url here

        linearLayout = findViewById(R.id.productListContainer);

        //do the get request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String name = jsonObject.getString("productName");
                                int id = jsonObject.getInt("ID");
                                prodNames.add(name);
                                prodIds.add(id);

                                //get_response_text.setText(get_response_text.getText() + name);

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



