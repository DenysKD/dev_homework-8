package org.example.DBConnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getConnectionURL(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop = new Properties();

            if(input == null){
                System.out.println("Properties is enpty!");
                return null;
            }

            prop.load(input);

            return new StringBuilder("jdbc:postgresql://")
                    .append(prop.getProperty("postgres.db.host"))
                    .append(":")
                    .append(prop.getProperty("postgres.db.port"))
                    .append("/")
                    .append(prop.getProperty("postgres.db.database"))
                    .append("?currentSchema=public")
                    .toString();


        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserName(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop = new Properties();

            if(input == null){
                System.out.println("Priperties is empty!");
                return null;
            }

            prop.load(input);

            return prop.getProperty("postgres.db.username");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPassword(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop = new Properties();

            if(input == null){
                System.out.println("Properties is empty!");
                return null;
            }

            prop.load(input);

            return prop.getProperty("postgres.db.password");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
