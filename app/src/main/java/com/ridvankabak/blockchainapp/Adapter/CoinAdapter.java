package com.ridvankabak.blockchainapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ridvankabak.blockchainapp.ui.DetailActivity.DetailActivity;
import com.ridvankabak.blockchainapp.Model.Base;
import com.ridvankabak.blockchainapp.Model.Coin;
import com.ridvankabak.blockchainapp.R;

import java.text.DecimalFormat;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CardViewTasarimTutucu> {
    private Context context;
    private List<Coin> allCoins;
    public static Base base;

    public CoinAdapter(Context context, List<Coin> allCoins){
        this.context = context;
        this.allCoins = allCoins;
    }

    @NonNull
    @Override
    public CardViewTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);

        return new CardViewTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucu holder, int position) {
        Coin coin = allCoins.get(position);
        SvgLoader.pluck()
                .with((Activity) context)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(coin.getIconUrl(), holder.imageViewIcon);

        holder.textViewSymbol.setText(coin.getSymbol());

        Double price = Double.valueOf(coin.getPrice());
        holder.textViewPrice.setText(new DecimalFormat("##.##").format(price)+" "+base.getSign());

        String color = coin.getColor();
        if(color == null || color.isEmpty()){

            holder.textViewSymbol.setTextColor(Color.BLACK);
            holder.textViewPrice.setTextColor(Color.BLACK);
        } else if(color.equals("#000")){
            holder.textViewSymbol.setTextColor(Color.GRAY);
            holder.textViewPrice.setTextColor(Color.GRAY);
        }
        else{
            int a = Color.parseColor(color);
            holder.textViewSymbol.setTextColor(a);
            holder.textViewPrice.setTextColor(a);
        }

        holder.coinCard.setOnClickListener(view -> {
            Intent i = new Intent(context, DetailActivity.class);
            DetailActivity.coin = coin;
            DetailActivity.base = base;
            DetailActivity.allTimeHigh = coin.getAllTimeHigh();
            context.startActivity(i);

        });

    }

    @Override
    public int getItemCount() {
        return allCoins.size();
    }

    public class CardViewTasarimTutucu extends RecyclerView.ViewHolder{
        public CardView coinCard;
        public ImageView imageViewIcon;
        public TextView textViewSymbol, textViewPrice;

        public CardViewTasarimTutucu(@NonNull View view) {
            super(view);
            coinCard = view.findViewById(R.id.coin_card);
            imageViewIcon = view.findViewById(R.id.imageViewIcon);
            textViewSymbol = view.findViewById(R.id.textViewSymbol);
            textViewPrice = view.findViewById(R.id.textViewPrice);

        }
    }
}
