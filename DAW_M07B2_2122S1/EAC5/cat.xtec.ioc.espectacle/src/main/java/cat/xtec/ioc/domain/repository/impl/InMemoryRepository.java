package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Espectacle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cat.xtec.ioc.domain.repository.CartelleraRepository;
import java.util.List;


@Repository
public class InMemoryRepository implements CartelleraRepository {

    private final Map<String, Espectacle> espectacles = new HashMap<String, Espectacle>();

    public InMemoryRepository() {
        
        Espectacle espectacle1 = new Espectacle("111", "Gala ballarins catalans al món","Teatre_Girona", 400,200);
        Espectacle espectacle2 = new Espectacle("222", "Vals de Mefisto", "Teatre_Barcelona",200,100);
        Espectacle espectacle3 = new Espectacle("333","El barber de Sevilla de Rossini","Teatre_Granollers",100,50);
        Espectacle espectacle4 = new Espectacle("444","El barber de Sevilla de Rossini","Teatre_Girona",400,200);

       
        espectacles.put("111", espectacle1);
        espectacles.put("222", espectacle2);
        espectacles.put("333", espectacle3);   
        espectacles.put("444", espectacle4);         
       
    }

    public Collection<Espectacle> getAllShows() {
        return espectacles.values();
    }
    
    
    public Collection<Espectacle> getAllEspectacles() {
        return espectacles.values();
    }

    
    public Espectacle getEspectacle(String espectacleID) {
        return espectacles.get(espectacleID);        
    }

    
    public int numEntradesVenudesEspectacle(String idEspectacle) {
        int result=0;
        for (Espectacle espectacle : espectacles.values()) {
            if(espectacle.getEspectacleID().equals(idEspectacle)) {
                result=espectacle.getEntradesVenudes();
            }
        }
        return result;
    }


    public ArrayList<Espectacle> comprar(String espectacleID, int numEntrades) {

        ArrayList<Espectacle> result = new ArrayList<Espectacle>();
        for (Espectacle espectacle : espectacles.values()) {
            if(espectacle.getEspectacleID().equals(espectacleID)) {
                for (int i = 0; i < numEntrades; i++){
               espectacle.setEntradesVenudes(numEntrades);
                result.add(espectacle);
                }
                }
            }
        return result;        
    }


}
