/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.utils;

import cat.xtec.ioc.domain.Year;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jfaneca
 */
public class Utilitats {

    public static List<Year> listaYearsFromCsv(String fitxer, String separador) {
        List<Year> listaYears = new ArrayList<>();
        
        //https://mkyong.com/java/java-read-a-file-from-resources-folder/
        InputStream is = Utilitats.class.getClassLoader().getResourceAsStream(fitxer);
        
        String line;
        try (InputStreamReader streamReader= new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            
            while ((line = reader.readLine()) != null) {
                String[] tempArr = line.split(separador);
                Year year = new Year(Integer.parseInt(tempArr[0]),
                        Integer.parseInt(tempArr[1]),
                        Integer.parseInt(tempArr[2]),
                        Integer.parseInt(tempArr[3]));
                listaYears.add(year);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listaYears;
    }
    
    public static Year getYearFromString (String stryear){
        JSONArray array = new JSONArray(stryear);
        JSONObject object = array.getJSONObject(0);
        int ano = Integer.parseInt(object.getString("year"));
        int total = Integer.parseInt(object.getString("total"));
        int homes = Integer.parseInt(object.getString("homes"));
        int dones = Integer.parseInt(object.getString("dones"));
        Year yearNew = new Year(ano, total, homes, dones);
        return yearNew;
    }
    
    public static int getYearFromJson(String stryear){
        JSONArray array = new JSONArray(stryear);
        JSONObject object = array.getJSONObject(0);
        int ano = Integer.parseInt(object.getString("year"));
        return ano;
    }

}
