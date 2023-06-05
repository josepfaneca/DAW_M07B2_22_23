package cat.xtec.ioc.domain;

import java.util.Objects;

public class Year {

    private int year;
    private int total;
    private int homes;
    private int dones;

    public Year(int year, int total, int homes, int dones) {
        this.year = year;
        this.total = total;
        this.homes = homes;
        this.dones = dones;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHomes() {
        return homes;
    }

    public void setHomes(int homes) {
        this.homes = homes;
    }

    public int getDones() {
        return dones;
    }

    public void setDones(int dones) {
        this.dones = dones;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Year)) {
            return false;
        }

        final Year other = (Year) o;
        return other.getYear() == this.year;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.year);
    }

    @Override
    public String toString() {
        return "Year {"
                + "year=" + year
                + ", total='" + total + '\''
                + ", homes=" + homes + '\''
                + ", dones=" + dones
                + '}';
    }

}
