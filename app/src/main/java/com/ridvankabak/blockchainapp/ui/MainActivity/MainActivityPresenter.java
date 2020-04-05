package com.ridvankabak.blockchainapp.ui.MainActivity;

import com.ridvankabak.blockchainapp.Model.Coin;


import java.util.List;

public class MainActivityPresenter implements MainActivityContract.Presenter, MainActivityContract.Model.OnFinishedListener{
    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    public MainActivityPresenter (MainActivityContract.View mView ){
        this.mView = mView;
        mModel = new MainActivityModel();
    }

    @Override
    public void requestFromDataServer() {
        if (mView != null) {
            mView.showProgress();
        }
        mModel.getAllCoins(this,0); }

    @Override
    public void getMoreData(int offset) {

        mModel.getAllCoins(this,offset);
    }

    @Override
    public void onFinished(List<Coin> coins) {
        mView.setDataToRecyclerView(coins);
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        mView.onResponseFailure(t);
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
