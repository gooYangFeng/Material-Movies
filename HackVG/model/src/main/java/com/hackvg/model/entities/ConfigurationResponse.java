package com.hackvg.model.entities;

/**
 * Class that represents the configuration in the model layer,
 *
 * The configuration gets the system wide configuration information. Some elements of the API
 * require some knowledge of this configuration data. The purpose of this is to try and keep the
 * actual API responses as light as possible.
 * It is recommended you cache this data every few days.
 */
public class ConfigurationResponse {
    private int code;

    public SystemConfig getData() {
        return data;
    }

    private SystemConfig data;

//    private ConfigurationImages images;
//    private String [] change_keys;

//    public ConfigurationImages getImages() {
//
//        return images;
//    }

//    public class ConfigurationImages {
//
//        private String base_url;
//        private String secure_base_url;
//        private String [] backdrop_sizes;
//        private String [] logo_sizes;
//        private String [] poster_sizes;
//        private String [] profile_sizes;
//        private String [] still_sizes;
//
//        public String getBase_url() {
//
//            return base_url;
//        }
//
//        public String getSecure_base_url() {
//
//            return secure_base_url;
//        }
//
//        public String[] getBackdrop_sizes() {
//
//            return backdrop_sizes;
//        }
//
//        public String[] getLogo_sizes() {
//
//            return logo_sizes;
//        }
//
//        public String[] getPoster_sizes() {
//
//            return poster_sizes;
//        }
//
//        public String[] getProfile_sizes() {
//
//            return profile_sizes;
//        }
//
//        public String[] getStill_sizes() {
//
//            return still_sizes;
//        }
//    }

    /*
        "android_version": "7",
        "DOMAIN_NAME": "http://api.91taogu.com",
        "android_config": "",
        "android_dev_download_url": "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/DEV_4_Patient.apk",
        "android_dev_version": "227",
        "android_dev_upgrade_title": "",
        "SMS_SEND_INTERVAL": "60",
        "SSO_URL_PREFIX": "http://taogu91.oss-cn-qingdao.aliyuncs.com/",
        "description": "新乡市中心医院－患者版",
        "name": "新乡市中心医院－患者版",
        "android_force_upgrade": "1",
        "android_upgrade_title": "",
        "android_dev_upgrade_content": "",
        "android_download_url": "http://taogu91.oss-cn-qingdao.aliyuncs.com/download/4_Patient.apk",
        "android_upgrade_content": ""
     */
    public class SystemConfig {
        private String name;
        private String description;

        private int android_force_upgrade;
        private int android_version;
        private String android_upgrade_title;
        private String android_download_url;
        private String android_upgrade_content;

        private String android_dev_download_url;
        private int android_dev_version;
        private String android_dev_upgrade_title;
        private String android_dev_upgrade_content;

        private int SMS_SEND_INTERVAL;
        private String SSO_URL_PREFIX;
        private String DOMAIN_NAME;
        private String android_config;

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getAndroid_force_upgrade() {
            return android_force_upgrade;
        }

        public int getAndroid_version() {
            return android_version;
        }

        public String getAndroid_upgrade_title() {
            return android_upgrade_title;
        }

        public String getAndroid_download_url() {
            return android_download_url;
        }

        public String getAndroid_upgrade_content() {
            return android_upgrade_content;
        }

        public String getAndroid_dev_download_url() {
            return android_dev_download_url;
        }

        public int getAndroid_dev_version() {
            return android_dev_version;
        }

        public String getAndroid_dev_upgrade_title() {
            return android_dev_upgrade_title;
        }

        public String getAndroid_dev_upgrade_content() {
            return android_dev_upgrade_content;
        }

        public int getSMS_SEND_INTERVAL() {
            return SMS_SEND_INTERVAL;
        }

        public String getSSO_URL_PREFIX() {
            return SSO_URL_PREFIX;
        }

        public String getDOMAIN_NAME() {
            return DOMAIN_NAME;
        }

        public String getAndroid_config() {
            return android_config;
        }
    }
}


