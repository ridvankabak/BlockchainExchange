package com.ridvankabak.blockchainapp.ui.MainActivity;

import android.util.Log;

import com.ridvankabak.blockchainapp.Adapter.CoinAdapter;
import com.ridvankabak.blockchainapp.Model.Coin;
import com.ridvankabak.blockchainapp.Model.CoinResponse;
import com.ridvankabak.blockchainapp.Model.Data;
import com.ridvankabak.blockchainapp.Service.ApiUtils;
import com.ridvankabak.blockchainapp.Service.BlockchainDaoInterface;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityModel implements MainActivityContract.Model {
    private static String TAG = "MainActivityModel";

    @Override
    public void getAllCoins(OnFinishedListener onFinishedListener, int offset) {
        BlockchainDaoInterface blockchainDIF = ApiUtils.getBlockchainDaoInterface();


        blockchainDIF.allCoins(ApiUtils.BASE,String.valueOf(offset),ApiUtils.LIMIT).enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                Data data = response.body().getData();
                List<Coin> coins = data.getCoins();
                CoinAdapter.base = data.getBase();
                onFinishedListener.onFinished(coins);
            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                Log.e(TAG,t.getLocalizedMessage());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
