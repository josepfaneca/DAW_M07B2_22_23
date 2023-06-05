package cat.xtec.ioc.client;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface EspectaclesServiceEndpoint {
    @WebMethod getAllEspectacles();
    @WebMethod getEspectacle(String espectacleID);
    @WebMethod getEntradesVenudes(String espectacleID);
    @WebMethod comprar(String espectacleID, int numEntrades);
}

import javax.jws.WebService;
import cat.xtec.ioc.service.JocServiceEndpoint;
import java.util.ArrayList;

@WebService(serviceName = "CartelleraService", endpointInterface =
        "cat.xtec.ioc.service.EspectaclesServiceEndpoint")
public class JocServiceEndpointImpl implements JocServiceEndpoint {
    private final CartelleraRepository cartelleraRepository = new CartelleraRepository();

    @Override
    public ArrayList<Espectacle> getAllEspectacles() {
        return new ArrayList<Espectacle>(this.cartelleraRepository.getAllEspectacles());
    }

    @Override
    public Espectacle getEspectacle(String espectacleID) {
        return this.cartelleraRepository.getEspectacle(espectacleID);
    }

    @Override
    public Espectacle getEntradesVenudes(String espectacleID) {
        return this.cartelleraRepository.getEntradesVenudes(espectacleID);
    }

    @Override
    public Espectacle comprar(String espectacleID, int numEntrades) {
        return this.cartelleraRepository.getNumUnitatsVenudes(espectacleID,numEntrades);
    }
}
