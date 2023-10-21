package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
 
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		//These are the roles that we can authorize, they are consumes by the Authenticator to generate a GameUser
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
	//Authenticators implement the Authenticator<C, P extends Principal> interface, which has a single method:
	//If the client uses a user name in the database and the password is "password", we return a GameUser.
	//@See Authenticator
	//
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
            // FIXME:DONE Finish the authorize method based on BasicAuth Security Example for new GameUser
        	// TODO: maybe return a role here on construction", VALID_USERS.get(credentials.getUsername())))"
  
        	 return Optional.of(new GameUser(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));

        }
        return Optional.empty();
    }
}
