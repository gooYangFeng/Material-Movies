package com.hackvg.model;

public interface MediaDataSource {

    void getMovies(String appId);

    void getDetailMovie (String id);

    /**
     * Get the reviews for a particular movie id.
     *
     * @param id movie id
     */
    void getReviews (String id);

    void getConfiguration (int appId);

    /**
     * Get a list of images represented by a MoviesWrapper
     * class
     *
     * @param movieId the movie id
     */
    void getImages (String movieId);
}
