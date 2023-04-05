package com.example.paymentrestfulclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.paymentrestfulclient.adapter.CreditCardAdapter;
import com.example.paymentrestfulclient.model.CreditCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GetCreditCardList extends AppCompatActivity {
    private CreditCardAdapter creditCardAdapter;
    private RecyclerView recyclerView;
    private List<CreditCard> creditCardList;
    String api = "http://192.168.1.29:8080/api/getAllCreditCard";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card_list);
        recyclerView = findViewById(R.id.creditcardlist);
        creditCardList = new ArrayList<>();
        creditCardList.add(new CreditCard("Nguye","sfa","sdsa",2423,"2024","2"));
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,api,null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject creditcard = response.getJSONObject(i);
                        String name = creditcard.getString("cardHolderName");
                        String type = creditcard.getString("cardType");
                        String number = creditcard.getString("cardNumber");
                        int cvc = creditcard.getInt("cardCvc");
                        String year = creditcard.getString("expirationYear");
                        String month = creditcard.getString("expirationMonth");
                        creditCardList.add(new CreditCard(name, type, number, cvc, year, month));
                        creditCardAdapter.setData(creditCardList);
                    }
                    catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };
        queue.add(stringRequest);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        creditCardAdapter = new CreditCardAdapter(this,creditCardList);
//        creditCardAdapter.setData(creditCardList);
        recyclerView.setAdapter(creditCardAdapter);
    }

}