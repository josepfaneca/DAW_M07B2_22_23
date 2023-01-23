
package cat.xtec.ioc.domain;


public class Espectacle {
    
private String EspectacleID;
private String nomEspectacle;
private String nomTeatre;
private int capacitat;
private int entradesVenudes;

    public Espectacle(String idEspectacle,String nomEspectacle, String nomTeatre, int capacitat, int entradesVenudes) {
        this.EspectacleID=idEspectacle;
        this.nomEspectacle = nomEspectacle;
        this.nomTeatre = nomTeatre;
        this.capacitat = capacitat;
        this.entradesVenudes = entradesVenudes;
    }

    public String getEspectacleID() {
        return EspectacleID;
    }

    public void setEspectacleID(String EspectacleID) {
        this.EspectacleID = EspectacleID;
    }

    public String getNomEspectacle() {
        return nomEspectacle;
    }

    public void setNomEspectacle(String nomEspectacle) {
        this.nomEspectacle = nomEspectacle;
    }

    public String getNomTeatre() {
        return nomTeatre;
    }

    public void setNomTeatre(String nomTeatre) {
        this.nomTeatre = nomTeatre;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getEntradesVenudes() {
        return entradesVenudes;
    }

    public void setEntradesVenudes(int entradesVenudes) {
        this.entradesVenudes = entradesVenudes;
    }
    
    
}
