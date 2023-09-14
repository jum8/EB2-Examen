package com.example.msusers.repository;

import com.example.msusers.domain.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class KeycloakRepository {
    @Autowired
    private Keycloak keycloak;
    @Value("${dh.keycloak.realm}")
    private String realm;

    public List<User> findAll() {
        List<UserRepresentation> users = keycloak.realm(realm).users().list();
        return users.stream().map(this::toUser).collect(Collectors.toList());
    }


    public Optional<User> findById(String id) {
        UserRepresentation userRepresentation = keycloak
                .realm(realm)
                .users()
                .get(id)
                .toRepresentation();
        return Optional.of(toUser(userRepresentation));
    }
    private User toUser(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getId(),
                userRepresentation.getUsername(),
                userRepresentation.getFirstName(),
                userRepresentation.getEmail());
    }
}
