package com.ridvankabak.blockchainapp.ui.MainActivity;

import com.ridvankabak.blockchainapp.Model.Coin;


import java.util.List;

public interface MainActivityContract {

    interface View{

        void setDataToRecyclerView(List<Coin> coins);

        void showProgress();

        void hideProgress();

        void onResponseFailure(Throwable t);
    }

    interface Presenter{

        void requestFromDataServer();

        void getMoreData(int offset);
    }

    interface Model{
        interface OnFinishedListener{
            void onFinished(List<Coin> coins);

            void onFailure(Throwable t);
        }

        void getAllCoins(OnFinishedListener onFinishedListener, int offset);
    }
}
