/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.client;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jfaneca
 */
public class InformacioClient {
    
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        YearClient yearClient = restTemplate.getForObject("http://localhost:8080/poblaciocatalunya/years/2000", YearClient.class);
        System.out.println(yearClient.toString());
    }
    
}
