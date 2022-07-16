
package com.jomc.jomc.Security.Repository;

import com.jomc.jomc.Security.Entity.Rol;
import com.jomc.jomc.Security.Enuns.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
