
package com.jomc.jomc.Controller;

import com.jomc.jomc.Dto.dtoConocimientos;
import com.jomc.jomc.Entity.Conocimientos;
import com.jomc.jomc.Security.Controller.Mensaje;
import com.jomc.jomc.Security.Service.SConocimientos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conoci")
@CrossOrigin(origins = "http://localhost:4200")
public class CConocimientos {
    @Autowired
    SConocimientos sConocimientos;
    
    //Crea una variable con una lista de los conocimientos
    @GetMapping("listac")
    public ResponseEntity<List<Conocimientos>> list(){
      List<Conocimientos> list = sConocimientos.list();  
      return new ResponseEntity(list, HttpStatus.OK);
    }
    
        @GetMapping("/detailc/{id}")
    public ResponseEntity<Conocimientos> getById(@PathVariable("id") int id) {
        if (!sConocimientos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Conocimientos conocimientos = sConocimientos.getOne(id).get();
        return new ResponseEntity(conocimientos, HttpStatus.OK);
    }
    
    @PostMapping("createc")
    public ResponseEntity<?> create(@RequestBody dtoConocimientos dtoconoc){
        if(StringUtils.isBlank(dtoconoc.getTituloC()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sConocimientos.existsByTituloC(dtoconoc.getTituloC()))
            return new ResponseEntity (new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        
        Conocimientos conocimientos = new Conocimientos(dtoconoc.getTituloC(),dtoconoc.getCentroC(), dtoconoc.getAnios());
        sConocimientos.save(conocimientos);
        
        return new ResponseEntity(new Mensaje("Conocimiento agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/updatec/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoConocimientos dtoconoc){
        if(!sConocimientos.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sConocimientos.existsByTituloC(dtoconoc.getTituloC()) && sConocimientos.getByTituloC(dtoconoc.getTituloC()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese conocimiento ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoconoc.getTituloC()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Conocimientos conocimientos = sConocimientos.getOne(id).get();
        conocimientos.setTituloC(dtoconoc.getTituloC());
        conocimientos.setCentroC(dtoconoc.getCentroC());
        conocimientos.setAnios(dtoconoc.getAnios());
        
        sConocimientos.save(conocimientos);
        return new ResponseEntity(new Mensaje("Conocimiento actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/deletec/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sConocimientos.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        sConocimientos.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
}
