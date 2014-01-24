package com.JKM.climbingroutes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import com.JKM.climbingroutes.DBconn;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class BitmapGenerator extends AsyncTask<Void ,Void, Bitmap> {
	
	private String routePathDBName;
	private String routePathTableName;
	private int routeIndexInTable;
	
	public BitmapGenerator(String dbName, String tableName, int routeIndex){
		routePathDBName = dbName;
		routePathTableName = tableName;
		routeIndexInTable = routeIndex;
	}
	
	private Bitmap bitmap;
	
	
	//private String dbName;
	
	
	
	@Override
	protected Bitmap doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		/* TODO SQL query getting pic path and unserialize data (coordinate)
		DBconn dbconn = new DBconn(routePathDBName, routePathTableName);
		private String dbQuery = ""
		dbconn.executeQuery( ,0);
		*/
		
		bitmap = DownloadImage("http://59.127.113.172/src/123.jpg");
		
		
		
		
		
		
		
		return bitmap;
	}
	
	@Override
	protected void onPostExecute(Bitmap bitmap){
		
	}
	
	private Bitmap DownloadImage(String URL)
    {        
        Bitmap bitmap = null;
        InputStream in = null;  



        try {
            in = OpenHttpConnection(URL);
            BufferedInputStream bis = new BufferedInputStream(in, 500*1024);

            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) 
            {
                baf.append((byte)current);
            }
            byte[] imageData = baf.toByteArray();
            bitmap =BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
            in.close();
        } 
       catch (IOException e1) 
       {

            e1.printStackTrace();
        }
        return bitmap;                
    }
	
	private InputStream OpenHttpConnection(String urlString) 
		    throws IOException
		    {
		        InputStream in = null;
		        int response = -1;

		        URL url = new URL(urlString); 
		        URLConnection conn = url.openConnection();

		        if (!(conn instanceof HttpURLConnection))                     
		            throw new IOException("Not an HTTP connection");

		        try{
		            HttpURLConnection httpConn = (HttpURLConnection) conn;
		            httpConn.setAllowUserInteraction(false);
		            httpConn.setInstanceFollowRedirects(true);
		            httpConn.setRequestMethod("GET");
		            httpConn.connect();
		            response = httpConn.getResponseCode();                 
		            if (response == HttpURLConnection.HTTP_OK) {
		                in = httpConn.getInputStream();                                 
		            }                     
		        }
		        catch (Exception ex)
		        {
		            throw new IOException("Error connecting");            
		        }
		        return in;     
		    }
	
		
}
