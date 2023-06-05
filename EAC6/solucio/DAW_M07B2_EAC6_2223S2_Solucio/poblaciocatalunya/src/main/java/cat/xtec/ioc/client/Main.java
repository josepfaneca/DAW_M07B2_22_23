package cat.xtec.ioc.client;

import org.springframework.web.client.RestTemplate;

public class Main {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        YearClient info = restTemplate.getForObject("http://localhost:8080/poblaciocatalunya/years/2000", YearClient.class);
        System.out.println(info.toString());
    }
}
