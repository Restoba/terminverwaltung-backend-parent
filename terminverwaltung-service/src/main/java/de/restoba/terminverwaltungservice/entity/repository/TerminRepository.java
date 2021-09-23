package de.restoba.terminverwaltungservice.entity.repository;

import de.restoba.terminverwaltungservice.entity.TerminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepository extends JpaRepository<TerminEntity, Integer> {
}
