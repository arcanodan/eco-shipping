package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.domain.Role;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    //per la psw come gestirla (in un metodo) inserire il campo in UtenteDto ???
    //vedi metodo creazioneUtenti


    private UtenteDto toUtenteDto(Utente utente) {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setIdUtente(utente.getIdUtente());
        utenteDto.setNome(utente.getNome());
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setIndirizzoResidenza(utente.getIndirizzoResidenza());
        utenteDto.setCitta(utenteDto.getCitta());
        utenteDto.setCap(utente.getCap());
        utenteDto.setNumTelefono(utente.getNumTelefono());
        utenteDto.setPassword(utente.getPassword());
        utenteDto.setIban(utente.getIban());  //devi sempre gestire la visualizzazione dell'iban in base al caso (vedi findAllByTipoUtente)
        return utenteDto;
    }

    //restituisce una lista di utentiDTO (vedi UtenteDto) che hanno lo specifico tipoUtente passato al metodo
    public List<UtenteDto> findAllByRole(Role role) {
        List<Utente> utenteList = utenteRepository.findAllByRole(role);
        List<UtenteDto> utenteDtoList = new ArrayList<>();
        for (Utente utente : utenteList) {
            UtenteDto utenteDto = toUtenteDto(utente);
            utenteDto.setIban("******************************");
            utenteDtoList.add(utenteDto);
        }
        return utenteDtoList;

    }

    /*
    public UtenteDto findUtenteById(long id) {
        Utente utente = utenteRepository.findUtenteById(id);
        UtenteDto utenteDto = new UtenteDto();
        for (Utente utente : utenteList) {

        }


    }
    Come si gestisce il metodo ???
*/

    public UtenteDto findUtenteById (int id)  {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (utente.isPresent()) {
            UtenteDto utenteDto = toUtenteDto(utente.get());
            return utenteDto;
        }
        else
            throw new RuntimeException("Nessun utente trovato con id:  " + id);

    }


    public Utente createNewClientUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setRole(Role.USER);
        return utenteRepository.save(newUser);
    }
    public Utente createNewRiderUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setRole(Role.RIDER);
        return utenteRepository.save(newUser);
    }

    public Utente createNewAdminUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setRole(Role.ADMIN);
        return utenteRepository.save(newUser);
    }


    /* (41.11756379579976, 16.871091585638478) (Bari)
       44.52512585109125, 11.390366494774641 (Bologna)
       Δs = 591.07 km (circa)

     */


    private Utente utilsForCreation (UtenteDto utenteDto) {
        Utente newUser = new Utente();
        newUser.setNome(utenteDto.getNome());
        newUser.setCognome(utenteDto.getCognome());
        newUser.setCap(utenteDto.getCap());
        newUser.setCitta(utenteDto.getCitta());
        newUser.setIndirizzoResidenza(utenteDto.getIndirizzoResidenza());
        newUser.setDataNasc(utenteDto.getDataNas());
        newUser.setNumTelefono(utenteDto.getNumTelefono());
        newUser.setPassword(utenteDto.getPassword());
        newUser.setDisponibilitaLavoro(false);
        newUser.setIban(utenteDto.getIban());
        newUser.setLongitudineRider(10.2548441);
        newUser.setLatitudineRider(12.25151);
        return newUser;

    }

    public List<UtenteDto> findAllUsers() {
        List<Utente> utenteList = utenteRepository.findAll();
        List<UtenteDto> utenteDtoList = new ArrayList<>();
        for (Utente utente : utenteList) {
            UtenteDto utenteDto = toUtenteDto(utente);
            utenteDtoList.add(utenteDto);
        }
        return utenteDtoList;
    }
























       /*
    public String deleteAllUser() {
        utenteRepository.deleteAll();
        return "DB vuoto";
    }
     */


    }




