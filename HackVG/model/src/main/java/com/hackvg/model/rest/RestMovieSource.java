package com.hackvg.model.rest;


import com.hackvg.common.utils.Constants;
import com.hackvg.model.entities.ConfigurationResponse;
import com.hackvg.model.entities.ImagesWrapper;
import com.hackvg.model.entities.MovieDetail;
import com.hackvg.model.entities.MoviesWrapper;
import com.hackvg.model.entities.ReviewsWrapper;
import com.squareup.otto.Bus;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by saulmm on 31/01/15.
 */
public class RestMovieSource implements RestDataSource {

    private final MovieDatabaseAPI moviesDBApi;
    private final Bus bus;

    public RestMovieSource(Bus bus) {
        moviesDBApi = RestClient.getClient();
        this.bus = bus;
    }

    @Override
    public void getMovies() {

        moviesDBApi.getPopularMovies(Constants.API_KEY, retrofitCallback);
    }

    @Override
    public void getDetailMovie(String id) {

        moviesDBApi.getMovieDetail(Constants.API_KEY, id,
            retrofitCallback);
    }

    @Override
    public void getReviews(String id) {

        moviesDBApi.getReviews(Constants.API_KEY, id,
            retrofitCallback);
    }

    @Override
    public void getConfiguration() {
        moviesDBApi.getConfiguration(Constants.API_KEY, retrofitCallback);
    }

    @Override
    public void getImages(String movieId) {

        moviesDBApi.getImages(Constants.API_KEY, movieId,
            retrofitCallback);
    }

    public Callback retrofitCallback = new Callback() {
        @Override
        public void onResponse(Response response) {
            if (response.isSuccess()) {
                // request successful (status code 200, 201)
                Object o = response.body();

                if (o instanceof MovieDetail) {
                    MovieDetail detailResponse = (MovieDetail) o;
                    bus.post(detailResponse);

                } else if (o instanceof MoviesWrapper) {
                    MoviesWrapper moviesApiResponse = (MoviesWrapper) o;
                    bus.post(moviesApiResponse);

                } else if (o instanceof ConfigurationResponse) {
                    ConfigurationResponse configurationResponse = (ConfigurationResponse) o;
                    bus.post(configurationResponse);

                } else if (o instanceof ReviewsWrapper) {
                    ReviewsWrapper reviewsWrapper = (ReviewsWrapper) o;
                    bus.post(reviewsWrapper);

                } else if (o instanceof ImagesWrapper) {
                    ImagesWrapper imagesWrapper = (ImagesWrapper) o;
                    bus.post(imagesWrapper);
                }
            } else {
                // response received but request not successful (like 400,401,403 etc)
                //Handle errors

            }
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.printf("[DEBUG] RestMovieSource failure - " + t.getMessage());
        }
    };

    @Override
    public void getMoviesByPage(int page) {

        moviesDBApi.getPopularMoviesByPage(
            Constants.API_KEY,
            page + "",
            retrofitCallback
        );
    }
}
