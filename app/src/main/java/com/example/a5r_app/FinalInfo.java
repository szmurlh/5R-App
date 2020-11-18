package com.example.a5r_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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

public class FinalInfo extends AppCompatActivity {
    Button back;
    LinearLayout linearLayout;

    //Location Info
    String classification;
    String name;
    String state;
    String city;
    int zip;
    int residency;
    String resString;
    String phone;
    String website;
    String notes;

    TextView classificationTV;
    TextView nameTV;
    TextView stateTV;
    TextView cityTV;
    TextView zipTV;
    TextView residencyTV;
    TextView phoneTV;
    TextView websiteTV;
    TextView notesTV;



    public void displayInfo(){

        nameTV = new TextView(this);
        nameTV.setText(name);
        nameTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        nameTV.setGravity(Gravity.LEFT);
        nameTV.setTextSize(20);
        linearLayout.addView(nameTV);

        classificationTV = new TextView(this);
        classificationTV.setText("Classification: " + classification);
        classificationTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        classificationTV.setGravity(Gravity.LEFT);
        classificationTV.setTextSize(15);
        linearLayout.addView(classificationTV);

        residencyTV = new TextView(this);
        residencyTV.setText("Residency Required?: " + resString);
        residencyTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        residencyTV.setGravity(Gravity.LEFT);
        residencyTV.setTextSize(15);
        linearLayout.addView(residencyTV);

        cityTV = new TextView(this);
        cityTV.setText("City: " + city + ", " + state);
        cityTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        cityTV.setGravity(Gravity.LEFT);
        cityTV.setTextSize(15);
        linearLayout.addView(cityTV);

        zipTV = new TextView(this);
        zipTV.setText("ZIP Code: " + zip);
        zipTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        zipTV.setGravity(Gravity.LEFT);
        zipTV.setTextSize(15);
        linearLayout.addView(zipTV);

        phoneTV = new TextView(this);
        phoneTV.setText("Phone: " + phone);
        phoneTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        phoneTV.setGravity(Gravity.LEFT);
        phoneTV.setTextSize(15);
        linearLayout.addView(phoneTV);

        websiteTV = new TextView(this);

        if (website == "N/A"){
            websiteTV.setText("N/A");
        }
        else{
            websiteTV.setClickable(true);
            websiteTV.setMovementMethod(LinkMovementMethod.getInstance());
            String webURL = "Website Link: <a href='" + website +"'>" + website + "</a>";
            websiteTV.setText(Html.fromHtml(webURL));
        }
        websiteTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        websiteTV.setGravity(Gravity.LEFT);
        websiteTV.setTextSize(15);
        linearLayout.addView(websiteTV);

        notesTV = new TextView(this);
        notesTV.setText(notes);
        notesTV.setTextColor((Color.rgb(0x00, 0x00, 0x00)));
        notesTV.setGravity(Gravity.LEFT);
        notesTV.setTextSize(15);
        linearLayout.addView(notesTV);

        /*
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
                    Intent infoIntent = new Intent(FinalInfo.this, FinalInfo.class);
                    startActivity(infoIntent);
                }
            });

            linearLayout.addView(btnShow);
        }
         */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempIntent = new Intent(FinalInfo.this, Location.class);
                startActivity(tempIntent);
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        RequestQueue queue= Volley.newRequestQueue(FinalInfo.this);

        int locCode = ((MyApplication) getApplication()).getLocCode();
        String url="http://67.249.71.109:3001/location/" + locCode; //put get request url here

        linearLayout = findViewById(R.id.productListContainer);

        //do the get request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                name = jsonObject.getString("name");
                                classification = jsonObject.getString("RET/PRI/PUB");
                                state = jsonObject.getString("State");
                                city = jsonObject.getString("City");
                                zip = jsonObject.getInt("zip");
                                residency = jsonObject.getInt("residency");
                                if (residency == 0){
                                    resString = "No";
                                }
                                else{
                                    resString = "Yes";
                                }
                                phone = jsonObject.getString("phone");
                                website = jsonObject.getString("website");
                                notes = jsonObject.getString("notes");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        displayInfo();

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



