package com.example.shivamarora.showcase_newshunt.Network.RetrofitInterface;

import com.example.shivamarora.showcase_newshunt.Network.Response.VideoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public interface Youtube_Api_Interface {

    @GET("search?part=snippet&maxResults=5&type=video&videoDuration=any")
    Call<VideoSearchResponse> getYoutube_Call(@Query("q") String query , @Query("userIp") String IP_ADDRESS ,@Query("key") String apiKey) ;

}


//parameters..

/*
part - >  snippet
maxResults - > 10
q - > //search query
type - > video
order - > viewCount | date | relevance
videoDuration - > short | medium

gives id :: ____ID _____
https://www.youtube.com/watch?v=

*/