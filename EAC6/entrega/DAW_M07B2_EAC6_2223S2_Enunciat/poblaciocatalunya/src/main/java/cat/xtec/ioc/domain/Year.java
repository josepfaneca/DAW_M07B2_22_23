package cat.xtec.ioc.domain;

public class Year implements Comparable<Year> {
    
    //(total, homes i dones, tots ells int)

    private int year;
    
    private int total;
    
    private int homes;
    
    private int dones;
    
    
    public Year(int year, int total, int homes, int dones) { //afegir les altres propietats: total, homes, dones
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Year other = (Year) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.homes != other.homes) {
            return false;
        }
        if (this.dones != other.dones) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Year{" + "year=" + year + ", total=" + total + ", homes=" + homes + ", dones=" + dones + '}';
    }

    @Override
    public int compareTo(Year o) {
        return Integer.compare(this.year, o.getYear());
    }
    
    
    
    

    
    

}
