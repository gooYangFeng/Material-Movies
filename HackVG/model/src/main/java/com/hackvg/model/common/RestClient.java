package com.hackvg.model.common;

import com.hackvg.common.utils.Constants;
import com.hackvg.model.common.ToStringConverter;
import com.hackvg.model.healthy.rest.TgHealthyAPI;
import com.hackvg.model.movie.rest.MovieDatabaseAPI;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RestClient {

    private static MovieDatabaseAPI gitApiInterface ;

    public static MovieDatabaseAPI getClient() {
        if (gitApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.MOVIE_DB_HOST)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gitApiInterface = client.create(MovieDatabaseAPI.class);
        }
        return gitApiInterface ;
    }

    private static TgHealthyAPI gitHealthyApiInterface ;

    public static TgHealthyAPI getHealthyClient() {
        if (gitApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://api.91taogu.com/")
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gitHealthyApiInterface = client.create(TgHealthyAPI.class);
        }
        return gitHealthyApiInterface ;
    }
}
