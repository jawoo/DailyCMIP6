package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

public class DownloadFile implements Callable<Object>
{

    String fileUrl;
    String fileName;

    DownloadFile(String fileUrl, String fileName)
    {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    @Override
    public Object call()
    {
        try
        {
            InputStream inputStream = new URL(fileUrl).openStream();
            InputStream in = new URL(fileUrl).openStream();
            Files.copy(in, Paths.get("./out/"+fileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("> Downloaded: "+fileName);
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
