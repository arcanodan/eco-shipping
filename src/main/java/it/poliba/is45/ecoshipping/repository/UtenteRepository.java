package it.poliba.is45.ecoshipping.repository;


import it.poliba.is45.ecoshipping.domain.ERole;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

    //List<Utente> findAllByRole(ERole ERole);
    Optional<Utente> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


/*
    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.ClienteOrdineDto(u.nomeCliente, u.cognomeCliente, u.idCliente, o.idOrdine)  "
            + "FROM Utente u INNER JOIN u.ordines o")
    List<ClienteOrdineDto> fetchUtenteOrdinidataInnerJoin();

 */




}
