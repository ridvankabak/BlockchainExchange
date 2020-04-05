package com.ridvankabak.blockchainapp.ui.DetailActivity;

public interface DetailActivityContract {
    interface View{

        void getCoin();

        void getAreaChart();
    }
    interface Presenter{

        void getData();

        void getChart();
    }

}
