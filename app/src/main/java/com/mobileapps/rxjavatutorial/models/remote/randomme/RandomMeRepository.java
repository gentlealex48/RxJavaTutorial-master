package com.mobileapps.rxjavatutorial.models.remote.randomme;

import com.mobileapps.rxjavatutorial.models.remote.RemoteDataSource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RandomMeRepository {
    RandomMeObserver randomMeObserver;
    RemoteDataSource remoteDataSource;

    public RandomMeRepository() {
        remoteDataSource = new RemoteDataSource();
    }

    public void getRandomUsers(String gender, int results, final RandomMeCallback callback){
        remoteDataSource.getRandomUserObs(gender, results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RandomMeObserver(callback));
    }
}
