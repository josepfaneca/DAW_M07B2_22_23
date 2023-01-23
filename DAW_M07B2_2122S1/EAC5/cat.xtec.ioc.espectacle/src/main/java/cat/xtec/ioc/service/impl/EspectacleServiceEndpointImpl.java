/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Espectacle;
import cat.xtec.ioc.domain.repository.CartelleraRepository;
import cat.xtec.ioc.domain.repository.impl.InMemoryRepository;
import cat.xtec.ioc.service.EspectacleServiceEndpoint;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jesi
 */
@WebService(serviceName = "EspectacleServiceEndpointImpl", 
        endpointInterface = "cat.xtec.ioc.service.EspectacleServiceEndpoint")
public class EspectacleServiceEndpointImpl implements EspectacleServiceEndpoint {
    
    private final CartelleraRepository cartelleraRepository = new InMemoryRepository();


    public ArrayList<Espectacle> getAllEspectacles() {
return new ArrayList<Espectacle>(this.cartelleraRepository.getAllEspectacles());    }

    public Espectacle getEspectacle(String espectacleID) {
        
    return cartelleraRepository.getEspectacle(espectacleID);
    }



    public ArrayList<Espectacle> comprar(String espectacleID, int numEntrades) {
       return cartelleraRepository.comprar(espectacleID, numEntrades);
    }

    public int numEntradesVenudesEspectacle(String string) {
   return cartelleraRepository.numEntradesVenudesEspectacle(string);

    }


}
