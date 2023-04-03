package com.example.paymentrestfulclient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.paymentrestfulclient.model.CreditCard;
import com.example.paymentrestfulclient.model.ProcessPayment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MakePayment extends AppCompatActivity {
    String api = "http://192.168.1.29:8080/api/calculate-fee";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        EditText holdername = (EditText) findViewById(R.id.card_holder_name1);
        EditText cardtype = (EditText) findViewById(R.id.card_type1);
        EditText cardnumber = (EditText) findViewById(R.id.card_number1);
        EditText cardcvc = findViewById(R.id.card_cvc1);
        EditText year = findViewById(R.id.expiration_year1);
        EditText month = findViewById(R.id.expiration_month1);
        EditText num = findViewById(R.id.number_of_people);
        TextView fee = findViewById(R.id.fee);
        Button calulate = (Button) findViewById(R.id.button_calculate);
        calulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= holdername.getText().toString();
                String type = cardtype.getText().toString();
                String number = cardnumber.getText().toString();
                int tmp = 0;
                if (!"".equals(cardcvc.getText().toString())){
                    tmp=Integer.parseInt(cardcvc.getText().toString());
                }
                int cvc =tmp;
                String expyr = year.getText().toString();
                String expmth = month.getText().toString();
                int tmp1=0;
                if (!"".equals(num.getText().toString())){
                    tmp1=Integer.parseInt(num.getText().toString());
                }
                int num_of_people=tmp1;
                CreditCard creditCard = new CreditCard(name, type, number, cvc, expyr, expmth);
                ProcessPayment processPayment = new ProcessPayment(creditCard,num_of_people);
                try {
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    JSONObject jsonbody = new JSONObject();
                    jsonbody.put("creditCard",creditCard);
                    jsonbody.put("number_of_people",num_of_people);

                    final String requestBody = jsonbody.toString();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST,api,new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("VOLLEY", response);
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

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                return requestBody == null ? null : requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                return null;
                            }
                        }


                    };
                    queue.add(stringRequest);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}