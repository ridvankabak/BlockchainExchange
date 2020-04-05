package com.ridvankabak.blockchainapp.Service;

public class ApiUtils {
    public static final String BASE_URL = "https://api.coinranking.com/v1/public/";
    public static String BASE = "TRY";
    public static String LIMIT = "10";


    public static BlockchainDaoInterface getBlockchainDaoInterface(){

        return RetrofitClient.getClient(BASE_URL).create(BlockchainDaoInterface.class);
    }
}

//base url = https://api.coinranking.com/v1/public/coins