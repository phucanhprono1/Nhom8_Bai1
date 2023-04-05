package com.example.paymentrestfulclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentrestfulclient.R;
import com.example.paymentrestfulclient.model.CreditCard;

import java.util.List;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.MyViewHolder> {

    private List<CreditCard> creditCards;
    private Context context;
    public CreditCardAdapter(Context context,List<CreditCard> creditCards) {
        this.creditCards = creditCards;
        this.context = context;
        notifyDataSetChanged();
    }
    public void setData(List<CreditCard> Cards) {
        this.creditCards = Cards;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CreditCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditCardAdapter.MyViewHolder holder, int position) {
        holder.name.setText("Name "+creditCards.get(position).getCardHolderName());
        holder.type.setText("card type: "+creditCards.get(position).getCardType());
        holder.number.setText("card number: "+creditCards.get(position).getCardNumber());
        holder.cvc.setText("CVC: "+String.valueOf(creditCards.get(position).getCardCvc()));
        holder.year.setText("Exp year: "+creditCards.get(position).getExpirationYear());
        holder.month.setText("Exp month "+creditCards.get(position).getExpirationMonth());

    }

    @Override
    public int getItemCount() {
        return creditCards.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,type,number,cvc,year,month;
        public MyViewHolder(View view){
            super(view);
            name= view.findViewById(R.id.card_holder_name2);
            type = view.findViewById(R.id.cardtype1);
            number = view.findViewById(R.id.cardnumber1);
            cvc = view.findViewById(R.id.cardcvc1);
            year = view.findViewById(R.id.year1);
            month = view.findViewById(R.id.month1);
        }
    }
}
