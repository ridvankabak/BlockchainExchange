package com.ridvankabak.blockchainapp.ui.DetailActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Area3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.ridvankabak.blockchainapp.Model.AllTimeHigh;
import com.ridvankabak.blockchainapp.Model.Base;
import com.ridvankabak.blockchainapp.Model.Coin;
import com.ridvankabak.blockchainapp.Model.Social;
import com.ridvankabak.blockchainapp.R;
import com.ridvankabak.blockchainapp.ui.WebActivity.WebActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailActivityContract.View {
    private static String TAG = "DetailActivity";
    private DetailActivityContract.Presenter mPresenter;

    private Toolbar toolbar;
    private LinearLayout view;
    private ImageView imageViewIcon,imageViewWeb,imageViewBack,imageViewSatis;
    private TextView textViewName,textViewTitle,textViewPrice,textViewDesc,textViewSatis,textViewYuksekFiyat,textViewFark;
    private AnyChartView anyChartView;
    private LinearLayout linearLayout;

    public static Coin coin;
    public static Base base;
    public static AllTimeHigh allTimeHigh;

    private ArrayList<String> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initUi();
        setListener();
        mPresenter = new DetailActivityPresenter(this);
        mPresenter.getData();
        mPresenter.getChart();
    }

    private void setListener() {

        imageViewBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    private void initUi() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        imageViewSatis = findViewById(R.id.imageViewSatis);
        textViewSatis = findViewById(R.id.textViewSatis);
        textViewFark = findViewById(R.id.textViewFark);
        textViewYuksekFiyat = findViewById(R.id.textViewYuksekFiyat);
        imageViewIcon = findViewById(R.id.imageViewIconDet);
        textViewName = findViewById(R.id.textViewCoinName);
        textViewTitle = findViewById(R.id.textViewTitlee);
        textViewPrice = findViewById(R.id.textViewPricee);
        textViewDesc = findViewById(R.id.textViewDesc);
        imageViewBack = findViewById(R.id.imageViewBack);
        anyChartView = findViewById(R.id.chartView);
        linearLayout = findViewById(R.id.linerlayout);
        toolbar = findViewById(R.id.toolbarDetay);
        view = findViewById(R.id.view);

        history = new ArrayList<>();
    }

    @Override
    public void getCoin() {
        SvgLoader.pluck()
                .with(this)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(coin.getIconUrl(), imageViewIcon);

        textViewName.setText(coin.getSymbol());

        textViewTitle.setText(coin.getName());
        Double price = Double.valueOf(coin.getPrice());
        textViewPrice.setText(new DecimalFormat("##.##").format(price)+" "+base.getSign());
        textViewDesc.setText(coin.getDescription());
        String color = coin.getColor();
        if(color == null || color.isEmpty()){

            textViewTitle.setTextColor(Color.BLACK);
            textViewPrice.setTextColor(Color.BLACK);
        } else if(color.equals("#000")){
            textViewTitle.setTextColor(Color.GRAY);
            textViewPrice.setTextColor(Color.GRAY);
        }
        else{
            int a = Color.parseColor(color);
            textViewTitle.setTextColor(a);
            textViewPrice.setTextColor(a);
        }

        history.addAll(coin.getHistory());

        getUrl(coin.getSocials(),coin);

        String changee = coin.getChange().toString();

        if(changee.indexOf("-") == -1){
            imageViewSatis.setImageResource(R.drawable.artis);
            toolbar.setBackgroundColor(getResources().getColor(R.color.greenx));
            view.setBackgroundColor(getResources().getColor(R.color.greenx));
        }else{
            imageViewSatis.setImageResource(R.drawable.azalis);
            toolbar.setBackgroundColor(getResources().getColor(R.color.redx));
            view.setBackgroundColor(getResources().getColor(R.color.redx));
        }

        Double priceSatis = Double.valueOf(coin.getPrice());
        textViewSatis.setText(new DecimalFormat("##.##").format(priceSatis)+" "+base.getSign());
        Double priceYuksek = Double.valueOf(allTimeHigh.getPrice());
        textViewYuksekFiyat.setText(new DecimalFormat("##.##").format(priceYuksek)+" "+base.getSign());
        Double change = Double.valueOf(coin.getChange());
        textViewFark.setText("%"+change);
    }

    @Override
    public void getAreaChart() {
        Cartesian3d area3d = AnyChart.area3d();

        area3d.xAxis(0).labels().format("{%Value}");

        area3d.animation(true);


        area3d.xAxis(0).labels().padding(5d, 5d, 0d, 5d);

        area3d.title().useHtml(true);
        area3d.title().padding(0d, 0d, 20d, 0d);

        List<DataEntry> seriesData = new ArrayList<>();
        for(int i =3;i<history.size();i++){

            String as = history.get(i).substring(0,(history.get(i).indexOf(".") + 5));
            double price = Double.valueOf(as);

            seriesData.add(new CustomDataEntry(String.valueOf(i-2),price));
        }



        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");

        Area3d series1 = area3d.area(series1Data);
        series1.name("Değeri");
        series1.hovered().markers(false);
        series1.hatchFill("diagonal", "#000", 0.6d, 10d);

        area3d.tooltip()
                .position(Position.RIGHT_BOTTOM)
                .positionMode(TooltipPositionMode.POINT)
                .anchor(Anchor.LEFT_BOTTOM)
                .offsetX(5d)
                .offsetY(5d);

        area3d.interactivity().hoverMode(HoverMode.BY_X);
        area3d.zAspect("100%");

        anyChartView.setChart(area3d);
    }

    @SuppressLint("ResourceType")
    private void getUrl(List<Social> socials, Coin coin) {
        imageViewWeb = new ImageView(this);
        imageViewWeb.setId(0);
        imageViewWeb.setMinimumWidth(36);
        imageViewWeb.setMinimumHeight(36);
        imageViewWeb.setPadding(3,0,3,0);
        imageViewWeb.setImageResource(R.drawable.chrome);
        linearLayout.addView(imageViewWeb);
        imageViewWeb.setOnClickListener(view -> {
            Intent i = new Intent(DetailActivity.this,WebActivity.class);
            i.putExtra("url",coin.getWebsiteUrl());
            startActivity(i);
        });

        for (int i=0;i<socials.size();i++){
            if(socials.get(i).getType().equals("facebook")){
                ImageView imageView = new ImageView(this);
                imageView.setId(1);
                imageView.setMinimumWidth(36);
                imageView.setMinimumHeight(36);
                imageView.setPadding(3,0,3,0);
                imageView.setImageResource(R.drawable.facebook);
                linearLayout.addView(imageView);

                int finalI = i;
                imageView.setOnClickListener(view -> {
                    Intent j = new Intent(DetailActivity.this, WebActivity.class);
                    j.putExtra("url",socials.get(finalI).getUrl());
                    startActivity(j);
                });
            }
            if(socials.get(i).getType().equals("twitter")){
                ImageView imageView = new ImageView(this);
                imageView.setId(2);
                imageView.setMinimumWidth(36);
                imageView.setMinimumHeight(36);
                imageView.setImageResource(R.drawable.twitterr);
                linearLayout.addView(imageView);

                int finalI = i;
                imageView.setOnClickListener(view -> {
                    Intent j = new Intent(DetailActivity.this,WebActivity.class);
                    j.putExtra("url",socials.get(finalI).getUrl());
                    startActivity(j);
                });
            }
            if(socials.get(i).getType().equals("youtube")){
                ImageView imageView = new ImageView(this);
                imageView.setId(3);
                imageView.setMinimumWidth(36);
                imageView.setMinimumHeight(36);
                imageView.setImageResource(R.drawable.youtube);
                linearLayout.addView(imageView);

                int finalI = i;
                imageView.setOnClickListener(view -> {
                    Intent j = new Intent(DetailActivity.this,WebActivity.class);
                    j.putExtra("url",socials.get(finalI).getUrl());
                    startActivity(j);
                });
            }
            if(socials.get(i).getType().equals("github")){
                ImageView imageView = new ImageView(this);
                imageView.setId(4);
                imageView.setMinimumWidth(36);
                imageView.setMinimumHeight(36);
                imageView.setImageResource(R.drawable.github);
                linearLayout.addView(imageView);

                int finalI = i;
                imageView.setOnClickListener(view -> {
                    Intent j = new Intent(DetailActivity.this,WebActivity.class);
                    j.putExtra("url",socials.get(finalI).getUrl());
                    startActivity(j);
                });
            }

        }
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value) {
            super(x, value);

        }
    }

}
