package com.example.a5r_app;

//max imports
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

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

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ProductSelection extends AppCompatActivity {

    private TextView get_response_text,post_response_text;
    Button back;
    private Spinner batterySpinner;
    private Spinner plasticsSpinner;
    private Spinner electronicsSpinner;
    private Spinner bottlesSpinner;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductSelection.this, MainActivity.class));
            }
        });

        electronicsSpinner = findViewById(R.id.spinner4);
        List<String> Electronics = new ArrayList<>();
        Electronics.add(0, "Electronics");
        Electronics.add("Calculators");
        Electronics.add("Cell Phones");
        Electronics.add("Laptops");
        Electronics.add("Gaming Consoles");

        ArrayAdapter<String> dataAdapter3;
        dataAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Electronics);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electronicsSpinner.setAdapter(dataAdapter3);
        electronicsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Electronics")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Calculators")) {
                        Intent calcIntent = new Intent(ProductSelection.this, Calculators.class);
                        startActivity(calcIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Cell Phones")){
                        Intent phoneIntent = new Intent(ProductSelection.this, CellPhones.class);
                        startActivity(phoneIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Laptops")){
                        Intent laptopIntent = new Intent(ProductSelection.this, Laptops.class);
                        startActivity(laptopIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Gaming Consoles")){
                        Intent gamingIntent = new Intent(ProductSelection.this, GamingConsoles.class);
                        startActivity(gamingIntent);
                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bottlesSpinner = findViewById(R.id.spinner5);
        List<String> bottlesAndCans = new ArrayList<>();
        bottlesAndCans.add(0, "Bottles & Cans");
        bottlesAndCans.add("Aluminum Cans");
        bottlesAndCans.add("Plastic Bottles");
        bottlesAndCans.add("Glass Bottles");
        ArrayAdapter<String> dataAdapter4;
        dataAdapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bottlesAndCans);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bottlesSpinner.setAdapter(dataAdapter4);
        bottlesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Bottles & Cans")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Aluminum Cans")){
                        Intent aluminumIntent = new Intent(ProductSelection.this, AluminumCans.class);
                        startActivity(aluminumIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Bottles")){
                        Intent bottleIntent = new Intent(ProductSelection.this, PlasticBottles.class);
                        startActivity(bottleIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Glass Bottles")){
                        Intent glassIntent = new Intent(ProductSelection.this, GlassBottles.class);
                        startActivity(glassIntent);
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        batterySpinner = findViewById(R.id.spinner);
        List<String> Batteries = new ArrayList<>();
        Batteries.add(0, "Batteries");
        Batteries.add("Alkaline Batteries");
        Batteries.add("Cell Phone Batteries");
        Batteries.add("Automotive Batteries");
        Batteries.add("E-Cigarette Batteries");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Batteries);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        batterySpinner.setAdapter(dataAdapter);

        batterySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Batteries")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();

                    if(parent.getItemAtPosition(position).equals("Alkaline Batteries")){
                        Intent alkalineIntent= new Intent(ProductSelection.this, AlkalineBattery.class);
                        startActivity(alkalineIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Cell Phone Batteries")){
                        Intent cellBatteryIntent = new Intent(ProductSelection.this, CellPhoneBattery.class);
                        startActivity(cellBatteryIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Automotive Batteries")){
                        Intent autoIntent = new Intent (ProductSelection.this, AutomotiveBattery.class);
                        startActivity(autoIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("E-Cigarette Batteries")){
                        Intent cigBatteryIntent = new Intent(ProductSelection.this, ECigaretteBattery.class);
                        startActivity(cigBatteryIntent);
                    }


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        plasticsSpinner = findViewById(R.id.spinner3);
        List<String>Plastics = new ArrayList<>();
        Plastics.add(0, "Plastics");
        Plastics.add("Plastic Bags");
        Plastics.add("Plastic Cups");
        Plastics.add("Plastic Jugs");
        Plastics.add("Plastic Bottles");

        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Plastics);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plasticsSpinner.setAdapter(dataAdapter2);
        plasticsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Plastics")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected " + item, Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Plastic Bags")){
                        Intent bagIntent= new Intent(ProductSelection.this, PlasticBags.class);
                        startActivity(bagIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Cups")){
                        Intent cupIntent = new Intent(ProductSelection.this, PlasticCups.class);
                        startActivity(cupIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Jugs")){
                        Intent jugIntent = new Intent(ProductSelection.this, PlasticJugs.class);
                        startActivity(jugIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Bottles")){
                        Intent bottleIntent = new Intent(ProductSelection.this, PlasticBottles.class);
                        startActivity(bottleIntent);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });






        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button get_request_button=findViewById(R.id.get_data);
        //Button post_request_button=findViewById(R.id.post_data);

        //This is the TextView where the response will be displayed
        get_response_text=findViewById(R.id.get_response_data);
        //post_response_text=findViewById(R.id.post_respone_data);


        get_request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendGetRequest();
            }
        });

        /*
        post_request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRequest();
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/*
    private void postRequest() {
        RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);
        String url="urlhere";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //let's parse json data
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    post_response_text.setText("Data 1 : " + jsonObject.getString("data_1_post")+"\n");
                    post_response_text.append("Data 2 : " + jsonObject.getString("data_2_post")+"\n");
                    post_response_text.append("Data 3 : " + jsonObject.getString("data_3_post")+"\n");
                    post_response_text.append("Data 4 : " + jsonObject.getString("data_4_post")+"\n");
                }
                catch (Exception e){
                    e.printStackTrace();
                    post_response_text.setText("POST DATA : unable to Parse Json");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post_response_text.setText("Post Data : Response Failed");
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params=new HashMap<String, String>();
                params.put("data_1_post","Value 1 Data");
                params.put("data_2_post","Value 2 Data");
                params.put("data_3_post","Value 3 Data");
                params.put("data_4_post","Value 4 Data");
                return params;
            }

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                Map<String,String> params=new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };

        requestQueue.add(stringRequest);

    }
*/
private void sendGetRequest() {
    //get_response_text is the TextView containing response data
    RequestQueue queue= Volley.newRequestQueue(ProductSelection.this);
    String url="https://jsonblob.com/api/5d1815da-02a9-11eb-9f82-2f0342b0cfd0";

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            String firstName = jsonObject.getString("firstName");
                            String lastName = jsonObject.getString("lastName");
                            int zip = jsonObject.getInt("zip");

                            get_response_text.setText(get_response_text.getText() + firstName + lastName + zip);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    queue.add(jsonArrayRequest);
}
}