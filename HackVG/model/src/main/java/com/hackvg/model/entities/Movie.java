
package com.hackvg.model.entities;

import java.io.Serializable;

@SuppressWarnings("UnusedDeclaration")
public class Movie implements Serializable {

    private String adult;
    private String backdrop_path;
    private String id;
    private String original_title;
    private String release_date;
    private String poster_path;
    private String popularity;
    private String title;
    private String vote_average;
    private String vote_count;

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    private String apkUrl;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private String overview;
    private boolean movieReady;

    public Movie(String id, String title, String overview) {

        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getAdult() {

        return adult;
    }

    public String getBackdrop_path() {

        return backdrop_path;
    }

    public String getId() {

        return id;
    }

    public String getOriginal_title() {

        return original_title;
    }

    public String getRelease_date() {

        return release_date;
    }

    public String getPoster_path() {

        return poster_path;
    }

    public String getPopularity() {

        return popularity;
    }

    public String getTitle() {

        return title;
    }

    public String getVote_average() {

        return vote_average;
    }

    public String getVote_count() {

        return vote_count;
    }

    public void setMovieReady(boolean movieReady) {

        this.movieReady = movieReady;
    }

    public boolean isMovieReady() {

        return movieReady;
    }

    private static final int START_ID = 4;
    private static final String FORMAL_APK_URL_PREFIX = "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/";
    private static final String DEVELOP_APK_URL_PREFIX = "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/DEV_";
    private static final String CUSTOM_APK_SUFFIX = "_Patient.apk";
    public static String instanceId(int index) {
        if (index < START_ID) {
            return String.valueOf(index + 2);
        }
        return String.valueOf(START_ID + index);
    }

    public String getFormalApkUrl() {
        if ("2".equalsIgnoreCase(id)) {
            return "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/Doctor.apk";
        } else if ("3".equalsIgnoreCase(id)) {
            return "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/Patient.apk";
        }

        return FORMAL_APK_URL_PREFIX + id + CUSTOM_APK_SUFFIX;
    }
    public String getDevelopingApkUrl() {
        if ("2".equalsIgnoreCase(id)) {
            return "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/DEV_Doctor.apk";
        } else if ("3".equalsIgnoreCase(id)) {
            return "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/DEV_Patient.apk";
        }

        return DEVELOP_APK_URL_PREFIX + id + CUSTOM_APK_SUFFIX;
    }
}
