package it.poliba.is45.ecoshipping.repository;


import it.poliba.is45.ecoshipping.domain.Role;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

    List<Utente> findAllByRole(Role role);
    Utente findByUsername(String username);
    Optional<Utente> findByEmail(String email);
    Optional<Utente> findByMobile(String numTelefono);
    Utente findFirstByUsername(String username);


/*
    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.ClienteOrdineDto(u.nomeCliente, u.cognomeCliente, u.idCliente, o.idOrdine)  "
            + "FROM Utente u INNER JOIN u.ordines o")
    List<ClienteOrdineDto> fetchUtenteOrdinidataInnerJoin();

 */




}
