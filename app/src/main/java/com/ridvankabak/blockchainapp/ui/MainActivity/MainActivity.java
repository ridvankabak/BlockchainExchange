package com.ridvankabak.blockchainapp.ui.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ridvankabak.blockchainapp.Adapter.CoinAdapter;
import com.ridvankabak.blockchainapp.Model.Coin;
import com.ridvankabak.blockchainapp.R;

import net.bohush.geometricprogressview.GeometricProgressView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private static String TAG = "MainActivity";
    private MainActivityContract.Presenter mPresenter;

    private TextView textViewZaman;
    private GeometricProgressView progressView;
    private RecyclerView rv;
    private CoinAdapter adapter;
    private ArrayList<Coin> coins;

    private int offset=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        setListener();

        mPresenter = new MainActivityPresenter(this);
        mPresenter.requestFromDataServer();
    }

    @Override
    public void setDataToRecyclerView(List<Coin> coinss) {
        coins.addAll(coinss);
        adapter.notifyDataSetChanged();

        offset += 10;
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Log.e(TAG,t.getLocalizedMessage());
    }

    private void setListener() {
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(isLastItemDisplaying(recyclerView)){
                    if(offset<=30) {
                        mPresenter.getMoreData(offset);
                    }
                }
            }
        });
    }

    private void initUi() {
        textViewZaman = findViewById(R.id.textViewZaman);
        time();
        progressView = findViewById(R.id.progressView);
        rv = findViewById(R.id.rv);
        coins = new ArrayList<>();
        adapter = new CoinAdapter(this,coins);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(adapter);
    }

    private void time() {
        Date date = new Date();
        int hours = date.getHours();
        int min = date.getMinutes();

        textViewZaman.setText(hours +":"+min);

    }

    private boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if(recyclerView.getAdapter().getItemCount() != 0){
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();

            if(lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)
                return true;
        }

        return false;
    }


}
