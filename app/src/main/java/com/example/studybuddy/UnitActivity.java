package com.example.studybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UnitActivity extends AppCompatActivity {
    private static final String PRODUCT_URL="http://170.20.10.3/MyAPI/api.php";
    RecyclerView recyclerView;
    UnitAdapter adapter;

    List<Units> unitList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        unitList= new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadUnits();




    }
    private void loadUnits()
    {
        StringRequest stringRequest= new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray units=new JSONArray(response);
                    for (int i=0;i<units.length();i++)
                    {
                        JSONObject unitObject=units.getJSONObject(i);
                        String unit_name=unitObject.getString("unit_name");
                        String lecturer=unitObject.getString("lecturer");
                        String lecturer_email=unitObject.getString("lecturer_email");
                        String unit_progress=unitObject.getString("unit_progress");
                        String image=unitObject.getString("image");

                        Units unit =new Units(unit_name,lecturer,lecturer_email,unit_progress,image);
                        unitList.add(unit);

                    }
                    adapter=new UnitAdapter(UnitActivity.this,unitList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UnitActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
