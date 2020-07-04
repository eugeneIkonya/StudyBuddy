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

public class UnitsActivity extends AppCompatActivity {
    private static final String UNIT_URL="http://192.168.1.5/MyApi/api.php";
    RecyclerView recyclerView;
    UnitAdapter unitAdapter;

    List<Unit> unitList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);


        unitList=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadUnits();



    }

    private void loadUnits()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, UNIT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray units= new JSONArray(response);
                    for(int i=0; i<units.length(); i++)
                    {
                        JSONObject unitObject=units.getJSONObject(i);

                        String unit_name=unitObject.getString("unit_name");
                        String lecturer=unitObject.getString("lecturer");
                        String lecturer_email=unitObject.getString("lecturer_email");
                        int unit_progress=unitObject.getInt("unit_progress");
                        String unit_objectives=unitObject.getString("unit_objectives");

                        Unit unit=new Unit(unit_name ,lecturer ,lecturer_email ,unit_progress ,unit_objectives);
                        unitList.add(unit);
                    }
                    unitAdapter=new UnitAdapter(UnitsActivity.this ,unitList);
                    recyclerView.setAdapter(unitAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UnitsActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
