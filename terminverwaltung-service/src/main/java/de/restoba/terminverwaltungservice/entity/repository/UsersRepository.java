package de.restoba.terminverwaltungservice.entity.repository;

import de.restoba.terminverwaltungservice.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}
