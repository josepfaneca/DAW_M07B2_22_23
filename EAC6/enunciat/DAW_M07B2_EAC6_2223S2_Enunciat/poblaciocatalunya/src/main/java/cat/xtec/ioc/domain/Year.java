package cat.xtec.ioc.domain;

import java.util.Objects;

public class Year {

    private int year;
    
    public Year(int year) { //afegir les altres propietats: total, homes, dones
        this.year = year;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
                + '}';
    }

}
