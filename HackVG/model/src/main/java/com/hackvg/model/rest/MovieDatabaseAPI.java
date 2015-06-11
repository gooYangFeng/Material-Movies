package com.hackvg.model.rest;

import com.hackvg.model.entities.ConfigurationResponse;
import com.hackvg.model.entities.ImagesWrapper;
import com.hackvg.model.entities.MovieDetail;
import com.hackvg.model.entities.MoviesWrapper;
import com.hackvg.model.entities.ReviewsWrapper;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Interface representing the MovieDatabaseAPI endpoints
 * used by retrofit
 */
public interface MovieDatabaseAPI {

    @GET("/api")
    void getPopularMovies(
        @Query("func") String funcName,
        @Query("app") String appId,
        Callback<MoviesWrapper> callback);

    @GET("/movie/{id}")
    void getMovieDetail (
        @Query("api_key") String apiKey,
        @Path("id") String id,
        Callback<MovieDetail> callback
    );

    @GET("/api")
    void getPopularMoviesByPage(
        @Query("func") String funcName,
        @Query("app") String appId,
        Callback<MoviesWrapper> callback
    );

    @GET("/api")
    void getConfiguration (
        @Query("func") String funcName,
        @Query("app") String appId,
        Callback<ConfigurationResponse> response
    );

    @GET("/movie/{id}/reviews")
    void getReviews (
        @Query("api_key") String apiKey,
        @Path("id") String id,
        Callback<ReviewsWrapper> response
    );

    @GET("/movie/{id}/images")
    void getImages (
        @Query("api_key") String apiKey,
        @Path("id") String movieId,
        Callback<ImagesWrapper> response
    );
}
