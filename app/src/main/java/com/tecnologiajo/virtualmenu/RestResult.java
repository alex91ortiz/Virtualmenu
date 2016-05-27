package com.tecnologiajo.virtualmenu;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by programador2 on 03/11/2015.
 */
public class RestResult extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.

            String response = "";
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                switch (urls[1]) {
                    case "GET":
                        conn.setRequestMethod(urls[1]);
                        conn.setDoInput(true);
                        // Starts the query
                        conn.connect();
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line = br.readLine()) != null) {
                            response += line;
                        }
                        break;
                    case "POST":
                        conn.setDoOutput(true);
                        conn.setChunkedStreamingMode(0);
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setUseCaches (false);
                        DataOutputStream  out = new DataOutputStream(conn.getOutputStream());
                        out.write(urls[2].toString().getBytes("UTF-8"));
                        out.flush();
                        out.close();
                        int responseCode = conn.getResponseCode();
                        BufferedReader wbr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String lines = "";
                        while((lines = wbr.readLine()) != null ) {
                            response += lines;
                        }
                        wbr.close();
                        break;
                    case "PUT":
                        conn.setDoOutput(true);
                        conn.setRequestMethod(urls[1]);
                        conn.setChunkedStreamingMode(0);
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setUseCaches (false);
                        DataOutputStream  out2 = new DataOutputStream(conn.getOutputStream());
                        out2.write(urls[2].toString().getBytes("UTF-8"));
                        out2.flush();
                        out2.close();
                        int responseCode2 = conn.getResponseCode();
                        BufferedReader wbr2= new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String lines2 = "";
                        while((lines2 = wbr2.readLine()) != null ) {
                            response += lines2;
                        }
                        wbr2.close();
                        break;
                    case "DELETE":
                        conn.setDoOutput(true);
                        conn.setRequestMethod(urls[1]);
                        conn.setChunkedStreamingMode(0);
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setUseCaches (false);
                        conn.connect();
                        break;
                }
                conn.disconnect();
                conn=null;
            } catch (IOException e) {
                Log.e("service","Unable to retrieve web page. URL may be invalid." + e.getMessage());
                response="";
            }
            return  response;
        }
}

