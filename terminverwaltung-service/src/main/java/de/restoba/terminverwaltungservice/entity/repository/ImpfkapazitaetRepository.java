package de.restoba.terminverwaltungservice.entity.repository;

import de.restoba.terminverwaltungservice.entity.ImpfkapazitaetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpfkapazitaetRepository extends JpaRepository<ImpfkapazitaetEntity, Integer> {
}
