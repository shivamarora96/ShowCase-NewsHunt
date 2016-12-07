package com.example.shivamarora.showcase_newshunt.Network.Response;

import java.util.ArrayList;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public class VideoSearchResponse {

    private PageInfo_Response pageInfo ;
    private ArrayList<ItemResponse> items ;

    public PageInfo_Response getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo_Response pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ArrayList<ItemResponse> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemResponse> items) {
        this.items = items;
    }
}




