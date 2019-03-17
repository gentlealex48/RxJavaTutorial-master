package com.mobileapps.rxjavatutorial.models.remote;

import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mobileapps.rxjavatutorial.models.local.APIConstants.BASE_URL_RANDOMME;

public class RemoteDataSource {
    private Retrofit createRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL_RANDOMME)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        }

    private  RandomMeRemoteService getRandomMeRemoteService() {
        return createRetrofitInstance().create(RandomMeRemoteService.class);
    }

    public Observable<RandomResponse> getRandomUserObs(String gender, int results) {
        return getRandomMeRemoteService().getRandomUserObservable(gender, results);
    }
}
