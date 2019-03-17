package com.mobileapps.rxjavatutorial.models.remote;

import com.mobileapps.rxjavatutorial.models.local.randomme.RandomResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.mobileapps.rxjavatutorial.models.local.APIConstants.RANDOM_ME_QUERY_GENDER;
import static com.mobileapps.rxjavatutorial.models.local.APIConstants.RANDOM_ME_QUERY_RESULTS_COUNT;

public interface RandomMeRemoteService {
    @GET("/api")
    Observable<RandomResponse> getRandomUserObservable(@Query(RANDOM_ME_QUERY_GENDER) String gender, @Query(RANDOM_ME_QUERY_RESULTS_COUNT) int results);
}
