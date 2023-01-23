/*
getAllEspectacles();

getEspectacle(String espectacleID);

getEntradesVenudes(String espectacleID);

comprar(String espectacleID, int numEntrades);
 */
package cat.xtec.ioc.service;
import cat.xtec.ioc.domain.Espectacle;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
 
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface EspectacleServiceEndpoint {
    
@WebMethod ArrayList<Espectacle> getAllEspectacles();
@WebMethod Espectacle getEspectacle(String espectacleID);
@WebMethod int  numEntradesVenudesEspectacle(String nomEspectalce);
@WebMethod ArrayList<Espectacle> comprar(String espectacleID, int numEntrades);

}