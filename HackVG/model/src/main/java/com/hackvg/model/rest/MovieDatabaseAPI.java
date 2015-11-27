package com.hackvg.model.rest;

import com.hackvg.model.entities.ConfigurationResponse;
import com.hackvg.model.entities.ImagesWrapper;
import com.hackvg.model.entities.MovieDetail;
import com.hackvg.model.entities.MoviesWrapper;
import com.hackvg.model.entities.ReviewsWrapper;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Interface representing the MovieDatabaseAPI endpoints
 * used by retrofit
 */
public interface MovieDatabaseAPI {
    @Headers("User-Agent: Retrofit2.0HackVG")
    @GET("/3/movie/popular")
    Call<MoviesWrapper> getPopularMovies(
            @Query("api_key") String apiKey
    );

    @GET("/3/movie/{id}")
    Call<MovieDetail> getMovieDetail (
            @Path("id") String id,
        @Query("api_key") String apiKey
    );

    @GET("/3/movie/popular")
    Call<MoviesWrapper> getPopularMoviesByPage(
        @Query("api_key") String apiKey,
        @Query("page") String page
    );

    @GET("/3/configuration")
    Call<ConfigurationResponse> getConfiguration (
        @Query("api_key") String apiKey
    );

    @GET("/3/movie/{id}/reviews")
    Call<ReviewsWrapper> getReviews (
            @Path("id") String id,
        @Query("api_key") String apiKey
    );

    @GET("/3/movie/{id}/images")
    Call<ImagesWrapper> getImages (
            @Path("id") String movieId,
        @Query("api_key") String apiKey
    );
}
