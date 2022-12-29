package it.poliba.is45.ecoshipping.domain;

import it.poliba.is45.ecoshipping.enumeratives.TipoStato;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ordine")
    private int idOrdine;       //PK
    @Column(name = "id_rider")
    private int idRider;              //FK
    @Column(name = "data_evasione")
    private Date dataEvasione;
    @Column(name = "ora_evasione")
    private Time oraEvasione;
    @Column(name = "tipo_stato")
    private TipoStato tipoStato;
    //Può essere anche null (se tipostato != "Non c..")
    @Column(name = "note_stato_nc")
    private String noteStatoNc;

    // relazione 1:1 bidirezionale
    @OneToOne
    @JoinColumn (name = "id_ordine")
    @MapsId
    private Ordine ordine;

    //relazione N:1 bidirezionale con Utente
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;










    /*scegliere se implementare o meno
    private boolean checkNonConsegnato (TipoStato tipo_stato) {
        return tipo_stato == TipoStato.NON_CONSEGNATO;
    }

*/


}
