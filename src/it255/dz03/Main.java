/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it255.dz03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getMethod();
        // postMethods();
    }

    public Main() {

    }

    public static void getMethod() {

        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/albums");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Pokusaj nije uspeo : HTTP error  : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String json = "";
            String output;
            while ((output = br.readLine()) != null) {
                json += output;

            }
            System.out.println(json);
            conn.disconnect();
            Gson gson = new Gson();
            ArrayList<Albums> lista = gson.fromJson(json, new TypeToken<ArrayList<Albums>>() {
            }.getType());

            for (Albums ph : lista) {
                System.out.println(ph.toString());

            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void postMethods() {

        User u = new User("Marija Mandolic", "marija.mrmot222@gmail.com", "125246", false, "Makica993");
        try {
            URL url = new URL("http://89.216.56.107:8080/restfull/rest/users/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Method", "POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.print(new Gson().toJson(u));
            pw.close();
            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
