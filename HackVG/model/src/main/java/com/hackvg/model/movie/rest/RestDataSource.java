package com.hackvg.model.movie.rest;

import com.hackvg.model.movie.MediaDataSource;

/**
 * Created by saulmm on 25/02/15.
 */
public interface RestDataSource extends MediaDataSource {

    public void getMoviesByPage (int page);
}
