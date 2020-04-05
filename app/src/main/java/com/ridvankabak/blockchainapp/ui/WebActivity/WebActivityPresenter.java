package com.ridvankabak.blockchainapp.ui.WebActivity;

public class WebActivityPresenter implements WebActivityContract.Presenter {
    private WebActivityContract.View mView;

    public WebActivityPresenter(WebActivityContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getWeb() {
        mView.getLoadWeb();
    }
}
