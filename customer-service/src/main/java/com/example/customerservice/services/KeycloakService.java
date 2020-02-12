package com.example.customerservice.services;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import com.example.customerservice.models.UserModel;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

	@Value("${keycloak.auth-url}")
    private String authUrl;

    @Value("${keycloak.master.realm}")
    private String masterRealm;
    
    @Value("${keycloak.master.realm.username}")
    private String masterRealmUsername;

    @Value("${keycloak.master.realm.password}")
    private String masterRealmPassword;

    @Value("${keycloak.master.realm.clientid}")
    private String masterRealmClientId;


    @Value("${keycloak.microservice.realm}")
	private String microserviceRealm;

    @Value("${keycloak.credentials.secret}")
	private String secretKey;

	@Value("${keycloak.resource}")
	private String clientId;

	
    public String createUser(UserModel userModel) {
		String createUserResponse = "";

		try {
			UsersResource usersResource = getKeycloakUserResource();
			UserRepresentation user = getUserRepresentation(userModel);
			Response result =  usersResource.create(user);
			System.out.println("Keycloak create user response code:" + result.getStatus());

			int statusId = result.getStatus();
			if (201 == statusId) {
				String userId = result.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
				System.out.println("User created with userId:" + userId);

				CredentialRepresentation passwordCred = getCredentialRepresentation(result, userModel);
				usersResource.get(userId).resetPassword(passwordCred);

				RealmResource realmResource = getRealmResource();
				RoleRepresentation savedRoleRepresentation =  realmResource.roles().get("user").toRepresentation();
				realmResource.users().get(userId).roles().realmLevel().add(Arrays.asList(savedRoleRepresentation));
				System.out.println("Username==" + userModel.getUserName() + " created in keycloak successfully");
				
				createUserResponse = "User creation success";
			} else if (409 == statusId) {
				System.out.println("Username==" + userModel.getUserName() + " already present in keycloak");
				createUserResponse = "User creation failed";
			} else {
				System.out.println("Username==" + userModel.getUserName() + " could not be created in keycloak");
				createUserResponse = "User creation failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return createUserResponse;
	}

	private RealmResource getRealmResource() {
		Keycloak kekycloak = getKeycloak();
		return kekycloak.realm(microserviceRealm);
	}
	
	private CredentialRepresentation getCredentialRepresentation(Response result, UserModel userModel){		
		CredentialRepresentation passwordCred = new CredentialRepresentation();
		passwordCred.setTemporary(false);
		passwordCred.setType(CredentialRepresentation.PASSWORD);
		passwordCred.setValue(userModel.getPassword());
		return passwordCred;
	}

    private UsersResource getKeycloakUserResource() {
        Keycloak kekycloak = getKeycloak();
		RealmResource realmResource = kekycloak.realm(microserviceRealm);
		return realmResource.users();
	}

    private Keycloak getKeycloak(){
        return KeycloakBuilder
        .builder()
        .serverUrl(authUrl).realm(masterRealm)
        .username(masterRealmUsername).password(masterRealmPassword)
        .clientId(masterRealmClientId)
        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
        .build();
    }

    private UserRepresentation getUserRepresentation(UserModel userModel){
        UserRepresentation user = new UserRepresentation();
			user.setUsername(userModel.getUserName());
			user.setEmail(userModel.getEmailAddress());
			user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setEnabled(true);
        return user;
    }
    
}