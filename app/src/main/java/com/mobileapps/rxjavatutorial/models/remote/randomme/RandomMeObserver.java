package com.mobileapps.rxjavatutorial.models.remote.randomme;

import android.util.Log;

import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.mobileapps.rxjavatutorial.models.local.LoggingConstants.MESSAGE_ON_COMPLETE;
import static com.mobileapps.rxjavatutorial.models.local.LoggingConstants.MESSAGE_ON_ERROR;
import static com.mobileapps.rxjavatutorial.models.local.LoggingConstants.MESSAGE_ON_NEXT;
import static com.mobileapps.rxjavatutorial.models.local.LoggingConstants.MESSAGE_ON_SUBSCRIBE;
import static com.mobileapps.rxjavatutorial.models.local.LoggingConstants.TAG_RANDOM_ME_OBSERVER;

public class RandomMeObserver implements Observer<RandomResponse> {
    RandomMeCallback randomMeCallback;

    public RandomMeObserver(RandomMeCallback randomMeCallback) {
        this.randomMeCallback = randomMeCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG_RANDOM_ME_OBSERVER, MESSAGE_ON_SUBSCRIBE);
    }

    @Override
    public void onNext(RandomResponse randomResponse) {
        Log.d(TAG_RANDOM_ME_OBSERVER, MESSAGE_ON_NEXT);
        randomMeCallback.onSucess(randomResponse);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG_RANDOM_ME_OBSERVER, MESSAGE_ON_ERROR, e);
    }

    @Override
    public void onComplete() {
        Log.d(TAG_RANDOM_ME_OBSERVER, MESSAGE_ON_COMPLETE);
    }

}
