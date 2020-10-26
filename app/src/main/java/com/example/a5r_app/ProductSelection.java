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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//[Activity(Label = "ProductSelection", Theme = "@style/AppTheme.NoActionBar")]
public class ProductSelection extends AppCompatActivity {

    private TextView get_response_text,post_response_text;
    Button back;
    private Spinner metalsSpinner;
    private Spinner plasticsSpinner;
    private Spinner electronicsSpinner;
    private Spinner glassSpinner;

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
        Electronics.add("Computer Equipment");
        Electronics.add("Power Tools");
        Electronics.add("Batteries");
        Electronics.add("Entertainment & Gaming");

        ArrayAdapter<String> entertainmentGaming;
        entertainmentGaming = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Electronics);
        entertainmentGaming.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electronicsSpinner.setAdapter(entertainmentGaming);
        electronicsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Electronics")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Computer Equipment")) {
                        Intent compEquipmentIntent = new Intent(ProductSelection.this, ComputerEquipment.class);
                        startActivity(compEquipmentIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Power Tools")){
                        Intent toolsIntent = new Intent(ProductSelection.this, PowerTools.class);
                        startActivity(toolsIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Batteries")){
                        Intent batteryIntent = new Intent(ProductSelection.this, Batteries.class);
                        startActivity(batteryIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Entertainment & Gaming")){
                        Intent gamingIntent = new Intent(ProductSelection.this, EntertainmentGaming.class);
                        startActivity(gamingIntent);
                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        glassSpinner = findViewById(R.id.spinner5);
        List<String> glass = new ArrayList<>();
        glass.add(0, "Glass");
        glass.add("Blue Glass");
        glass.add("Clear Glass");
        glass.add("Green Glass");
        glass.add("Brown Glass");
        glass.add("Treated Glass");
        ArrayAdapter<String> dataAdapter4;
        dataAdapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, glass);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        glassSpinner.setAdapter(dataAdapter4);
        glassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Glass")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Blue Glass")){
                        Intent blueIntent = new Intent(ProductSelection.this, BlueGlass.class);
                        startActivity(blueIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Clear Glass")){
                        Intent clearIntent = new Intent(ProductSelection.this, ClearGlass.class);
                        startActivity(clearIntent);
                    }

                    if(parent.getItemAtPosition(position).equals("Green Glass")){
                        Intent greenIntent = new Intent(ProductSelection.this, GreenGlass.class);
                        startActivity(greenIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Brown Glass")){
                        Intent brownIntent = new Intent(ProductSelection.this, BrownGlass.class);
                        startActivity(brownIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Treated Glass")){
                        Intent treatedIntent = new Intent(ProductSelection.this, TreatedGlass.class);
                        startActivity(treatedIntent);
                    }




                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        metalsSpinner = findViewById(R.id.spinner);
        List<String> Metals = new ArrayList<>();
        Metals.add(0, "Metals");
        Metals.add("Aluminum");
        Metals.add("Steel");
        Metals.add("Scrap Metal");
        Metals.add("Copper");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Metals);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        metalsSpinner.setAdapter(dataAdapter);

        metalsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Metals")){

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();

                    if(parent.getItemAtPosition(position).equals("Aluminum")){
                        Intent aluminumIntent= new Intent(ProductSelection.this, Aluminum.class);
                        startActivity(aluminumIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Steel")){
                        Intent steelIntent = new Intent(ProductSelection.this, Steel.class);
                        startActivity(steelIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Scrap Metal")){
                        Intent scrapIntent = new Intent (ProductSelection.this, ScrapMetal.class);
                        startActivity(scrapIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Copper")){
                        Intent copperIntent = new Intent(ProductSelection.this, Copper.class);
                        startActivity(copperIntent);
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
        Plastics.add("Plastic Bags, Films & Wraps");
        Plastics.add("Plastic Cups");
        Plastics.add("Plastic Containers");
        Plastics.add("Plastic Drink Bottles");

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
                    if(parent.getItemAtPosition(position).equals("Plastic Bags, Films & Wraps")){
                        Intent bagIntent= new Intent(ProductSelection.this, PlasticBags.class);
                        startActivity(bagIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Cups")){
                        Intent cupIntent = new Intent(ProductSelection.this, PlasticCups.class);
                        startActivity(cupIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Containers")){
                        Intent jugIntent = new Intent(ProductSelection.this, PlasticContainers.class);
                        startActivity(jugIntent);
                    }
                    if(parent.getItemAtPosition(position).equals("Plastic Drink Bottles")){
                        Intent bottleIntent = new Intent(ProductSelection.this, GreenGlass.class);
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
        ActionBar actionBar = getSupportActionBar();
        /*
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        */

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

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