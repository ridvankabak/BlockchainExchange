package com.ridvankabak.blockchainapp.Service;

import com.ridvankabak.blockchainapp.Model.CoinResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BlockchainDaoInterface {

    @Headers({"packageName: com.ridvankabak.blockchainexchange"})
    @GET("coins")
    Call<CoinResponse> allCoins(@Query("base") String base, @Query("offset") String offset, @Query("limit") String limit);
}
