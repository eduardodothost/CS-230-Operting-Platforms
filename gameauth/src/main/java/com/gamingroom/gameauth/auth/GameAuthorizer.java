package com.gamingroom.gameauth.auth;

import javax.annotation.Nullable;
import javax.ws.rs.container.ContainerRequestContext;
import io.dropwizard.auth.Authorizer;
import com.gamingroom.gameauth.auth.GameUser;
public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role, @Nullable ContainerRequestContext containerRequestContext) {
    	
        // FIXME:DONE Finish the authorize method based on BasicAuth Security Example
    	return user.getRoles() != null && user.getRoles().contains(role);
    	
    }

	@Override
	public boolean authorize(GameUser user, String role) {
		// TODO Maybe remove this
		//return user.getRoles() != null && user.getRoles().contains(role);
		return false;
		
	}
}