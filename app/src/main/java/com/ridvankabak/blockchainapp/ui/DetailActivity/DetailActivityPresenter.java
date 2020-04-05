package com.ridvankabak.blockchainapp.ui.DetailActivity;

public class DetailActivityPresenter implements DetailActivityContract.Presenter {

    private DetailActivityContract.View mView;

    public DetailActivityPresenter(DetailActivityContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getData() {
        mView.getCoin();
    }

    @Override
    public void getChart() {
        mView.getAreaChart();
    }
}
