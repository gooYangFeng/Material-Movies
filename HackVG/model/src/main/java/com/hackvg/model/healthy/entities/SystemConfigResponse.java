
package com.hackvg.model.healthy.entities;

public class SystemConfigResponse extends BaseResponse<SystemConfigResponse.SystemConfigEntity> {
    public static class SystemConfigEntity {
        private String android_force_upgrade;

        public String getAndroid_force_upgrade() {
            return android_force_upgrade;
        }

        public void setAndroid_force_upgrade(String android_force_upgrade) {
            this.android_force_upgrade = android_force_upgrade;
        }

        public String getAndroid_version() {
            return android_version;
        }

        public void setAndroid_version(String android_version) {
            this.android_version = android_version;
        }

        public String getAndroid_download_url() {
            return android_download_url;
        }

        public void setAndroid_download_url(String android_download_url) {
            this.android_download_url = android_download_url;
        }

        public String getAndroid_upgrade_title() {
            return android_upgrade_title;
        }

        public void setAndroid_upgrade_title(String android_upgrade_title) {
            this.android_upgrade_title = android_upgrade_title;
        }

        public String getAndroid_upgrade_content() {
            return android_upgrade_content;
        }

        public void setAndroid_upgrade_content(String android_upgrade_content) {
            this.android_upgrade_content = android_upgrade_content;
        }

        public String getAndroid_dev_version() {
            return android_dev_version;
        }

        public void setAndroid_dev_version(String android_dev_version) {
            this.android_dev_version = android_dev_version;
        }

        public String getAndroid_dev_download_url() {
            return android_dev_download_url;
        }

        public void setAndroid_dev_download_url(String android_dev_download_url) {
            this.android_dev_download_url = android_dev_download_url;
        }

        public String getAndroid_dev_upgrade_title() {
            return android_dev_upgrade_title;
        }

        public void setAndroid_dev_upgrade_title(String android_dev_upgrade_title) {
            this.android_dev_upgrade_title = android_dev_upgrade_title;
        }

        public String getAndroid_dev_upgrade_content() {
            return android_dev_upgrade_content;
        }

        public void setAndroid_dev_upgrade_content(String android_dev_upgrade_content) {
            this.android_dev_upgrade_content = android_dev_upgrade_content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isENABLE_XBKP() {
            return ENABLE_XBKP;
        }

        public void setENABLE_XBKP(boolean ENABLE_XBKP) {
            this.ENABLE_XBKP = ENABLE_XBKP;
        }

        public int getGROUP_MESSAGE_RECEIVER_SIZE_LIMIT() {
            return GROUP_MESSAGE_RECEIVER_SIZE_LIMIT;
        }

        public void setGROUP_MESSAGE_RECEIVER_SIZE_LIMIT(int GROUP_MESSAGE_RECEIVER_SIZE_LIMIT) {
            this.GROUP_MESSAGE_RECEIVER_SIZE_LIMIT = GROUP_MESSAGE_RECEIVER_SIZE_LIMIT;
        }

        public int getSMS_SEND_INTERVAL() {
            return SMS_SEND_INTERVAL;
        }

        public void setSMS_SEND_INTERVAL(int SMS_SEND_INTERVAL) {
            this.SMS_SEND_INTERVAL = SMS_SEND_INTERVAL;
        }

        public String getSSO_URL_PREFIX() {
            return SSO_URL_PREFIX;
        }

        public void setSSO_URL_PREFIX(String SSO_URL_PREFIX) {
            this.SSO_URL_PREFIX = SSO_URL_PREFIX;
        }

        public String getDOMAIN_NAME() {
            return DOMAIN_NAME;
        }

        public void setDOMAIN_NAME(String DOMAIN_NAME) {
            this.DOMAIN_NAME = DOMAIN_NAME;
        }

        private String android_version;
        private String android_download_url;
        private String android_upgrade_title;
        private String android_upgrade_content;

        private String android_dev_version;
        private String android_dev_download_url;
        private String android_dev_upgrade_title;
        private String android_dev_upgrade_content;

        private String name;
        private String description;

        private boolean ENABLE_XBKP;
        private int GROUP_MESSAGE_RECEIVER_SIZE_LIMIT;
        private int SMS_SEND_INTERVAL;
        private String SSO_URL_PREFIX;
        private String DOMAIN_NAME;

        // app, saved identifier of api query
        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        private String app;

        // query and save for 'hospitalIntroduction' api with app;
//    public String getIntroIcon() {
//        return introIcon;
//    }
//
//    public void setIntroIcon(String introIcon) {
//        this.introIcon = introIcon;
//    }
//
//    public String getIntroName() {
//        return introName;
//    }
//
//    public void setIntroName(String introName) {
//        this.introName = introName;
//    }
//
//    private String introIcon;
//    private String introName;
    }
}
