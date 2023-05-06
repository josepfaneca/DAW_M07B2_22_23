/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *
 * @author jfaneca
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YearClient {
    
    private int year;
    private String total;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Informació {" + "year=" + year + ", total=" + total + '}';
    }
    
 
}
