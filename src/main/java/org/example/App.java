package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{

    public static void main( String[] args )
    {

        // What to download
        ArrayList<Object> urls = ListURLs.getURLs();

        // Concurrency
        try
        {
            ExecutorService executor = Executors.newFixedThreadPool(10);

            // Download and upload
            for (Object u: urls)
            {
                String fileUrl = (String)u;
                String fileName = fileUrl.split("/")[fileUrl.split("/").length-1];
                executor.submit(new DownloadFile(fileUrl, fileName));
            }
            executor.shutdown();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}
