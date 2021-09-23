package de.restoba.terminverwaltungservice.control;

import de.restoba.terminverwaltungservice.entity.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepo;

    public Boolean getAuth(String username, String userpasswort, String userrolle) {
        return usersRepo.findAll().stream().filter(usersEntity -> usersEntity.getUserName().equals(username)) //
                .filter(usersEntity -> usersEntity.getUserPasswort().equals(userpasswort))
                .anyMatch(usersEntity -> usersEntity.getUserRolle().equals(userrolle));
    }
}
