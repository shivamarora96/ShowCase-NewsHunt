package com.example.shivamarora.showcase_newshunt.Network.Retrofit_Client;

import com.example.shivamarora.showcase_newshunt.Constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ShivamArora on 04-12-2016.
 */

public class Youtube_Client {

    private static Retrofit retrofit = null ;

    public static Retrofit getRetrofitClient() {

        if (retrofit == null) {
            Retrofit r = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_YOUTUBE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return r;
        }

        return retrofit ;
    }

}
