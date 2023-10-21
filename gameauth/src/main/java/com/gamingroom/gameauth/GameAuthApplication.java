package com.gamingroom.gameauth;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamingroom.gameauth.GameAuthConfiguration;
import com.gamingroom.gameauth.auth.GameAuthenticator;
import com.gamingroom.gameauth.auth.GameAuthorizer;
import com.gamingroom.gameauth.auth.GameUser;
import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;


import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;



public class GameAuthApplication extends Application<GameAuthConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

	@Override
	public void initialize(Bootstrap<GameAuthConfiguration> b) {
	}

	@Override
	public void run(GameAuthConfiguration c, Environment e) throws Exception 
	{
		
		LOGGER.info("Registering REST resources");
		
		// FIXME:DONE Create io.dropwizard.client.JerseyClientBuilder instance and give it io.dropwizard.setup.Environment reference (based on BasicAuth Security Example)
		
		final Client DemoRESTClient = new JerseyClientBuilder(e)
		  .using(c.getJerseyClientConfiguration())
		  .build(getName());
//or
//final Client client =
//      new JerseyClientBuilder(e)
//          .using(c.getJerseyClientConfiguration())
//          .buildRx(getName(), RxFlowableInvokerProvider.class);
  //Any custom Service Resource that waits for Client in constructor
		
// FIXME:DONE register GameUserRESTController (based on BasicAuth Security Example)
		e.jersey().register(new GameUserRESTController(e.getValidator()));
		

		// Application health check
		e.healthChecks().register("APIHealthCheck", new AppHealthCheck(DemoRESTClient));

		// Run multiple health checks
		e.jersey().register(new HealthCheckController(e.healthChecks()));
		
		//Setup Basic Security
		e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
                .setAuthenticator(new GameAuthenticator())
                .setAuthorizer(new GameAuthorizer())
                .setRealm("App Security")
                .buildAuthFilter()));
        e.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
        e.jersey().register(RolesAllowedDynamicFeature.class);
	}

	public static void main(String[] args) throws Exception {
		new GameAuthApplication().run(args);
	}
}