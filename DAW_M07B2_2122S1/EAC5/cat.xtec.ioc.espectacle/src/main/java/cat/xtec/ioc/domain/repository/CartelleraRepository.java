package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Espectacle;
import java.util.ArrayList;
import java.util.Collection;


public interface CartelleraRepository {
Collection<Espectacle> getAllEspectacles();
Espectacle getEspectacle(String espectacleID);
    int  numEntradesVenudesEspectacle(String nomEspectalce);
ArrayList<Espectacle> comprar(String espectacleID, int numEntrades);
    
    
    
}
