package it.poliba.is45.ecoshipping.domain;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Utente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_utente")
    private int idUtente;
    private String nome;
    private String cognome;
    @Column(name = "indirizzo_residenza")
    private String indirizzoResidenza;
    private String citta;
    private String cap;
    @Column(name = "data_nas")
    private String dataNasc;
    @Column(name = "num_telefono")
    private String numTelefono;
    private String password;
    private String IBAN;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_utente")
    private TipoUtente tipoUtente;
    @Column(name = "longitudine_rider")
    private double longitudineRider;
    @Column(name = "latitudine_rider")
    private double latitudineRider;
    @Column(name = "disponibilita_lavoro")
    private boolean disponibilitaLavoro;




}