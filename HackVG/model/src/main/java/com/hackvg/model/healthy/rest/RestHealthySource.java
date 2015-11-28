package com.hackvg.model.healthy.rest;


import com.hackvg.model.common.RestClient;
import com.hackvg.model.healthy.TgHealthyDataSource;
import com.hackvg.model.healthy.entities.IntroductionResponse;
import com.hackvg.model.healthy.entities.SystemConfigResponse;
import com.squareup.otto.Bus;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by saulmm on 31/01/15.
 */
public class RestHealthySource implements TgHealthyDataSource {

    private final TgHealthyAPI moviesDBApi;
    private final Bus bus;

    public RestHealthySource(Bus bus) {
        moviesDBApi = RestClient.getHealthyClient();
        this.bus = bus;
    }

    @Override
    public void getIntroduction(String appid) {
        moviesDBApi.getIntroduction(appid).enqueue(retrofitCallback);
    }

//    @Override
//    public void getDetailMovie(String id) {
//        moviesDBApi.getMovieDetail(id, Constants.API_KEY).enqueue(retrofitCallback);
//    }
//
//    @Override
//    public void getReviews(String id) {
//        moviesDBApi.getReviews(id, Constants.API_KEY).enqueue(retrofitCallback);
//    }

    @Override
    public void getConfiguration(String appid) {
        moviesDBApi.getConfiguration(appid).enqueue(retrofitCallback);
    }

//    @Override
//    public void getImages(String movieId) {
//        moviesDBApi.getImages(movieId, Constants.API_KEY).enqueue(retrofitCallback);
//    }

    public Callback retrofitCallback = new Callback() {
        @Override
        public void onResponse(Response response) {
            if (response.isSuccess()) {
                // request successful (status code 200, 201)
                Object o = response.body();

                if (o instanceof SystemConfigResponse) {
                    SystemConfigResponse configResponse = (SystemConfigResponse) o;
                    bus.post(configResponse);

                } else if (o instanceof IntroductionResponse) {
                    IntroductionResponse introductionResponse = (IntroductionResponse) o;
                    bus.post(introductionResponse);
                }
            } else {
                // response received but request not successful (like 400,401,403 etc)
                //Handle errors

            }
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.printf("[DEBUG] RestHealthySource failure - " + t.getMessage());
        }
    };
}
