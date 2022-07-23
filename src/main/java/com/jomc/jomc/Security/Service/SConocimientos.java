
package com.jomc.jomc.Security.Service;

import com.jomc.jomc.Entity.Conocimientos;
import com.jomc.jomc.Repository.RConocimientos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SConocimientos {
    @Autowired
    RConocimientos rConocimientos;
    
    //Este muestra una lista de todos los conocimientos
    public List<Conocimientos> list(){
        return rConocimientos.findAll();
    }
    
    //Este muestra un conocmiento por su ID
    public Optional<Conocimientos> getOne(int id){
        return rConocimientos.findById(id);
    }
    
    //Busca el nombre por el titulo
    public Optional<Conocimientos> getByTituloC(String tituloC){
        return rConocimientos.findByTituloC(tituloC);
    }
    
    //Guarda el conocimiento
    public void save(Conocimientos conoc){
        rConocimientos.save(conoc);
    }
    
    //Borra el conocimiento segun su ID
    public void delete(int id){
        rConocimientos.deleteById(id);
    }
    
    //Busca el conocimiento por el ID y nos regresa v o f
    public boolean existsById(int id){
        return rConocimientos.existsById(id);
    }
    
    //Igual al de arriba pero este busca por el titulo
    public boolean existsByTituloC(String tituloC){
        return rConocimientos.existsByTituloC(tituloC);
    }
    
    
}
