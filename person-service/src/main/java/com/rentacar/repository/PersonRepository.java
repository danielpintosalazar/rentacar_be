package com.rentacar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentacar.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Metodo para consultar personas
     * @param nameString Cadena de texto que puede estar cintenida en el nombre
     * @return Objeto persona
     */
    List<Person> findByNameContaining(String nameString);

    /**
     * Metodo para consultar personas por el nombre completo
     * @param nameString Cadena de texto con en el nombre
     * @return Objeto persona
     */
    List<Person> findByName(String nameString);


}
