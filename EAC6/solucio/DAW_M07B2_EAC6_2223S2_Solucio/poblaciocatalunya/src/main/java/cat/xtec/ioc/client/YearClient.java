package cat.xtec.ioc.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YearClient {

    private int year;
    private int total;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year= year;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Informació {"
                + "year='" + year + '\''
                + ", total=" + total
                + '}';
    }
}
