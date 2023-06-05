package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Xollo;
import java.util.List;

/**
 *
 * @author Germán Flores
 */
public interface XolloRepository {
    
    void addXollo(Xollo xollo);
            
    Xollo getXolloByCodi(String codi);
     
    void updateXollo(Xollo xollo);
    
    List<Xollo> getAllXollos();
 
}
