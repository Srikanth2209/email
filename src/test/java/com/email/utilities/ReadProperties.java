package com.email.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties
{
    Properties properties;
    public ReadProperties()
    {
        String UserDir = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        File src = new File(UserDir+pathSeparator+"Configuration"+pathSeparator+"email.properties");
        properties= new Properties();
        try {
            properties.load(new FileInputStream(src));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }
    }

    public String getApplicationUrl()
    {
        String url = properties.getProperty("BaseUrl");
        return url;
    }
    public String email() {
        String Email = properties.getProperty("UserName");
        return Email;
    }
    public String password()
    {
        String Password = properties.getProperty("Password");
        return Password;
    }
    public String names_path() {
        String names = properties.getProperty("nmaes");
        return names;
    }
    public String subject_path()
    {
        String sub = properties.getProperty("subject");
        return sub;
    }
    public String time_path()
    {
        String time = properties.getProperty("time");
        return time;
    }


}
