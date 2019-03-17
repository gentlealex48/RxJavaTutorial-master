package com.mobileapps.rxjavatutorial.models.remote.randomme;

import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;

public interface RandomMeCallback {
    void onSucess(RandomResponse randomResponse);
}
