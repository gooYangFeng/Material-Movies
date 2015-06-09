package com.hackvg.model.rest;


import com.hackvg.common.utils.Constants;
import com.hackvg.model.entities.ConfigurationResponse;
import com.hackvg.model.entities.ImagesWrapper;
import com.hackvg.model.entities.Movie;
import com.hackvg.model.entities.MovieDetail;
import com.hackvg.model.entities.MoviesWrapper;
import com.hackvg.model.entities.ReviewsWrapper;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by saulmm on 31/01/15.
 */
public class RestMovieSource implements RestDataSource {

    private final MovieDatabaseAPI moviesDBApi;
    private final Bus bus;

    public RestMovieSource(Bus bus) {

        RestAdapter movieAPIRest = new RestAdapter.Builder()
            .setEndpoint(Constants.MOVIE_DB_HOST)
            .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
            .build();

        moviesDBApi = movieAPIRest.create(MovieDatabaseAPI.class);
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
    public void getConfiguration(int appId) {

        moviesDBApi.getConfiguration(Constants.SYSTEM_CONFIG, String.valueOf(appId), retrofitCallback);
    }

    @Override
    public void getImages(String movieId) {

        moviesDBApi.getImages(Constants.API_KEY, movieId,
                retrofitCallback);
    }

    public Callback retrofitCallback = new Callback() {
        @Override
        public void success(Object o, Response response) {

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
        }

        @Override
        public void failure(RetrofitError error) {

            System.out.printf("[DEBUG] RestMovieSource failure - " + error.getMessage());
        }
    };

    @Override
    public void getMoviesByPage(int page) {

//        moviesDBApi.getPopularMoviesByPage(
//            Constants.API_KEY,
//            page + "",
//            retrofitCallback
//        );
        MoviesWrapper wrapper;
        if (1 == page) {
            wrapper = new MoviesWrapper(movieList);
        } else {
            wrapper = new MoviesWrapper(emptyList);
        }

        retrofitCallback.success(wrapper, null);
    }

    private static final String[] TITLES = new String[] {
            "桃谷医院专家",
            "桃谷医院",
            "新乡市中心医院",
            "安阳市中医院",
            "商丘市第一人民医院",
            "驻马店市第一人民医院",
            "平顶山市第一人民医院",
    };
    private static final String[] IMAGES = new String[] {
            "",
            "",
            "http://taogu91.oss-cn-qingdao.aliyuncs.com/hospital_image/1432103365156xOrVLjbk.jpg",
            "http://taogu91.oss-cn-qingdao.aliyuncs.com/hospital_image/1432120532452tBUmhDfO.png",
            "http://taogu91.oss-cn-qingdao.aliyuncs.com/hospital_image/1432204496071TmjbjwkQ.png",
            "http://taogu91.oss-cn-qingdao.aliyuncs.com/image_upload_plugin_image/1429187163420iOVgfjqR.jpg",
            "http://taogu91.oss-cn-qingdao.aliyuncs.com/hospital_image/1433303972523WstgAtEv.jpg",
    };
    private static final String[] PKG_NAME = new String[] {
            "com.yht.b",
            "com.yht.c",
            "com.xinxiang.center",
            "com.anyang.traditional",
            "com.shangqiu.first",
            "com.zhumadian.first",
            "com.pingdingshan.first",
    };

    private static List<Movie> movieList;
    private static List<Movie> emptyList = new ArrayList<Movie>();
    static {
        movieList = new ArrayList<Movie>();
        for (int i = 0; i < TITLES.length; i++) {
            Movie movie = new Movie(Movie.instanceId(i), TITLES[i], IMAGES[i]);
            movie.setPkgName(PKG_NAME[i]);
            movieList.add(movie);
        }
    }
}
