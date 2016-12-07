package com.example.shivamarora.showcase_newshunt.Network.Response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public class PageInfo_Response {

    @SerializedName("totalResults")
   private int totalResult = 0 ;

    @SerializedName("resultsPerPage")
   private int resultPerPage = 0 ;

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getResultPerPage() {
        return resultPerPage;
    }

    public void setResultPerPage(int resultPerPage) {
        this.resultPerPage = resultPerPage;
    }
}
