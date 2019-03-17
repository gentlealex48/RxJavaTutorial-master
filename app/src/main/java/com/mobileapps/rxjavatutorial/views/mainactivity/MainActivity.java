package com.mobileapps.rxjavatutorial.views.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mobileapps.rxjavatutorial.R;
import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;
import com.mobileapps.rxjavatutorial.models.remote.RemoteDataSource;
import com.mobileapps.rxjavatutorial.models.remote.randomme.RandomMeCallback;
import com.mobileapps.rxjavatutorial.models.remote.randomme.RandomMeObserver;
import com.mobileapps.rxjavatutorial.models.remote.randomme.RandomMeRepository;
import com.mobileapps.rxjavatutorial.views.adapters.RandomMeRVAdapter;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

/* ***************************************************************** **
** **                                                             ** **
** **      RxJava2 working with Retrofit Tutorial                 ** **
** **         This tutorial is a demo on how one might            ** **
** **            might use RxJava in combo with Retrofit          ** **
** **                                                             ** **
** ***************************************************************** */
public class MainActivity extends AppCompatActivity {
    //
    //   Member Objects
    //
    RecyclerView rvRandomResults;
    RandomMeRVAdapter randomMeRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RandomMeRepository randomMeRepository = new RandomMeRepository();
        randomMeRepository.getRandomUsers("male", 2, new RandomMeCallback() {
            @Override
            public void onSucess(RandomResponse randomResponse) {
                setupRVRandomResults(randomResponse);
            }
        });
    }

    private void setupRVRandomResults(RandomResponse randomResponse) {
        rvRandomResults = findViewById(R.id.rvRandomResults);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        randomMeRVAdapter = new RandomMeRVAdapter(randomResponse);
        rvRandomResults.setLayoutManager(layoutManager);
        rvRandomResults.setAdapter(randomMeRVAdapter);

    }


}
