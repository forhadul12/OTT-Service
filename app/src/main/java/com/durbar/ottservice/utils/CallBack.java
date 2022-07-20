package com.durbar.ottservice.utils;

public interface CallBack {

    interface TabOnClick {
        void tabLiveOnClickCallBack();
        void tabHomeOnClickCallBack();
        void tabMovieOnClickCallBack();
    }
    interface MoreOnClick {
        void moreOnClick(String title);
    }
}
