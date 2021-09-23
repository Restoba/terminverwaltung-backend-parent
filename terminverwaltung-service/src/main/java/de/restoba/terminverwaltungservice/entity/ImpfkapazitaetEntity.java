package de.restoba.terminverwaltungservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "impfkapazitaet")
public class ImpfkapazitaetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer impfkapazitaetId;

    private String impfstoffName;

    private Integer impfstoffAnzahl;

    public Integer getImpfkapazitaetId() {
        return impfkapazitaetId;
    }

    public void setImpfkapazitaetId(Integer impfkapazitaetId) {
        this.impfkapazitaetId = impfkapazitaetId;
    }

    public String getImpfstoffName() {
        return impfstoffName;
    }

    public void setImpfstoffName(String impfstoffName) {
        this.impfstoffName = impfstoffName;
    }

    public Integer getImpfstoffAnzahl() {
        return impfstoffAnzahl;
    }

    public void setImpfstoffAnzahl(Integer impfstoffAnzahl) {
        this.impfstoffAnzahl = impfstoffAnzahl;
    }
}