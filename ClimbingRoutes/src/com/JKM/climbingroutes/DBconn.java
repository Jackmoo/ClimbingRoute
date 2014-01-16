package com.JKM.climbingroutes;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class DBconn {
	//constructor
	public DBconn(String dbName, String tableName){
		
	}
	
	//uri of host and php folder
	private final static String hostURI 		= "http://59.127.113.172/"; 
	private final static String androidDBPath 	= "AndroidConn/";

	//fetch test from http://seanstar5317.pixnet.net
	//catch JSON and transfer to resultString for activity
	public static String executeQuery(String query_string, int func) {
        String resultString = "";
        String finalPHPfile = "";
        
        switch (func){
        	//case 0 normal case 
        	case 0:
        		finalPHPfile = "androidDBconn.php";
        	
        	//case 1 read unserialize data (coordinate, scale)
        	case 1:
        		finalPHPfile = "ReadSerializedData.php";
        	
        	//case 2 write serialize data (coordinate, scale) not build yet
        	case 2:
        		finalPHPfile = "WriteSerializedData.php";
        }
        
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(hostURI + androidDBPath + finalPHPfile);
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("query_string", query_string));
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //view_account.setText(httpResponse.getStatusLine().toString());
            HttpEntity httpEntity = httpResponse.getEntity();
            InputStream inputStream = httpEntity.getContent();
            
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = bufReader.readLine()) != null) {
                builder.append(line + "\n");
            }
            inputStream.close();
            resultString = builder.toString();
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }
        
        return resultString;
    }
	
	
	
}
