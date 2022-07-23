
package com.jomc.jomc.Repository;

import com.jomc.jomc.Entity.Conocimientos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RConocimientos extends JpaRepository<Conocimientos, Integer>{
    public Optional<Conocimientos> findByTituloC(String tituloC);
    public boolean existsByTituloC(String tituloC);
}
