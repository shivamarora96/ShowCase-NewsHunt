package com.example.shivamarora.showcase_newshunt;

import android.app.SearchManager;
import android.content.ClipData;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.MediaStore;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.shivamarora.showcase_newshunt.Adapters.VideoRecyclerViewAdapter;
import com.example.shivamarora.showcase_newshunt.Constants.Constants;
import com.example.shivamarora.showcase_newshunt.Network.Response.ItemResponse;
import com.example.shivamarora.showcase_newshunt.Network.Response.VideoSearchResponse;
import com.example.shivamarora.showcase_newshunt.Network.RetrofitInterface.Youtube_Api_Interface;
import com.example.shivamarora.showcase_newshunt.Network.Retrofit_Client.Youtube_Client;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


   boolean wifi = false ;
   boolean cellular_network = false;
   private Toolbar mToolbar ;
   private String mQuery = "Re-appoint retired judges " + " latest news " ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar)findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(mToolbar);

        Retrofit retrofitClient = Youtube_Client.getRetrofitClient() ;

        Call<VideoSearchResponse> responseCall =  retrofitClient.create(Youtube_Api_Interface.class)
                                            .getYoutube_Call(mQuery , NetworkIpAddress() ,Constants.YOUTUBE_API_KEY);

            responseCall.enqueue(new Callback<VideoSearchResponse>() {
                @Override
                public void onResponse(Call<VideoSearchResponse> call, Response<VideoSearchResponse> response) {

                        Log.i("IpAddress" , NetworkIpAddress() + "");

                       if( response.isSuccessful() ){
                           Log.i("status_code"  , response.code() + "") ;


                         ArrayList<ItemResponse> itemResponseArrayList = response.body().getItems() ;

                           for(ItemResponse currentItem : itemResponseArrayList){
                               Log.i("VIDEO_ID"  , currentItem.getId().getVideoId()) ;
                           }

                       }

                }

                @Override
                public void onFailure(Call<VideoSearchResponse> call, Throwable t) {
                    Log.i("status_code"  , t.getMessage()) ;

                }
            });


        ArrayList<String>data = new ArrayList<>();

        for(int i = 0 ; i <15 ; i ++){
            data.add(i + "");
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_activity_recyclerView) ;
        VideoRecyclerViewAdapter adapter = new VideoRecyclerViewAdapter(getApplicationContext() , data) ;

        recyclerView.setAdapter(adapter);

    }


   public String NetworkIpAddress() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        @SuppressWarnings("deprecation")
        NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo netInfo : networkInfo) {

            if (netInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                if (netInfo.isConnected())
                    wifi = true;
            }

            else if (netInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (netInfo.isConnected())
                    cellular_network = true;
            }
        }

       String ipAddress = null ;

       if(wifi == true)
          ipAddress = GetWifiIpAddress() ;
        else if(cellular_network == true){
           ipAddress =   GetCellularIpAddress() ;
       }

    return  ipAddress;

    }

    public String GetCellularIpAddress(){
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements();) {
                NetworkInterface networkinterface = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = networkinterface.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception ex) {
            Log.e("Current IP", ex.toString());
        }
        return null;
    }

    public String GetWifiIpAddress()
    {

        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);

        @SuppressWarnings("deprecation")
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        return ip;

    }

}





