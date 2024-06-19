package com.utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Utility class to read data from a properties file.
 */
public class propertiesFileUtility {

    WebDriver driver;
    /**
     * Constructor to initialize WebDriver.
     *
     * @param driver The WebDriver instance.
     */
    public propertiesFileUtility(WebDriver driver) {
        this.driver=driver;
    }
    /**
     * Retrieves data from the properties file based on the provided key.
     *
     * @param key The key to retrieve the value for.
     * @return The value associated with the provided key.
     * @throws IOException If an I/O error occurs while reading the properties file.
     */
    public String getDataFromPropertyFile(String key) throws IOException {
        // Initialize Properties object
        Properties file = new Properties();
        // Specify the path to the properties file
        FileInputStream Path = new FileInputStream("/Users/dilipkumar/Desktop/Automation nagaraj/My-Repo/src/main/resources/Properties");
        // Load the properties file
       file.load(Path);
        // Get the value associated with the provided key
      String KeyValue = file.getProperty(key);
        // Return the retrieved value
      return KeyValue;
    }
}
