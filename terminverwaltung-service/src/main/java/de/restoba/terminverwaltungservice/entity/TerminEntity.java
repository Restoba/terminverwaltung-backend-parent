package de.restoba.terminverwaltungservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "termin")
public class TerminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer terminId;

    private LocalDateTime termindatum;

    private String kundenVorname;

    private String kundenNachname;

    private String status;

    public Integer getTerminId() {
        return terminId;
    }

    public void setTerminId(Integer terminId) {
        this.terminId = terminId;
    }

    public LocalDateTime getTermindatum() {
        return termindatum;
    }

    public void setTermindatum(LocalDateTime termindatum) {
        this.termindatum = termindatum;
    }

    public String getKundenVorname() {
        return kundenVorname;
    }

    public void setKundenVorname(String kundenVorname) {
        this.kundenVorname = kundenVorname;
    }

    public String getKundenNachname() {
        return kundenNachname;
    }

    public void setKundenNachname(String kundenNachname) {
        this.kundenNachname = kundenNachname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}