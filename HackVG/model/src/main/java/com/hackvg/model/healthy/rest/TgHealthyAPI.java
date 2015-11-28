package com.hackvg.model.healthy.rest;

import com.hackvg.model.healthy.entities.IntroductionResponse;
import com.hackvg.model.healthy.entities.SystemConfigResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Interface representing the TgHealthyAPI endpoints
 * used by retrofit
 */
public interface TgHealthyAPI {
    @Headers("User-Agent: RetrofitTg")
    @GET("/3/movie/popular")
    Call<IntroductionResponse> getIntroduction(
            @Query("api_key") String apiKey
    );

//    @GET("/3/movie/{id}")
//    Call<MovieDetail> getMovieDetail(
//            @Path("id") String id,
//            @Query("api_key") String apiKey
//    );

//    @GET("/3/movie/popular")
//    Call<MoviesWrapper> getPopularMoviesByPage(
//            @Query("api_key") String apiKey,
//            @Query("page") String page
//    );
//
    @GET("/3/configuration")
    Call<SystemConfigResponse> getConfiguration(
            @Query("api_key") String apiKey
    );
//
//    @GET("/3/movie/{id}/reviews")
//    Call<ReviewsWrapper> getReviews(
//            @Path("id") String id,
//            @Query("api_key") String apiKey
//    );
//
//    @GET("/3/movie/{id}/images")
//    Call<ImagesWrapper> getImages(
//            @Path("id") String movieId,
//            @Query("api_key") String apiKey
//    );
}
