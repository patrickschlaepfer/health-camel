package ch.soyez.guerir.sap.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class SapRESTRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// @formatter:off 
		rest("/api")
			.get("/hello")
			.produces("application/json")
			.to("direct:sayHello");
		
		from("direct:sayHello")
			.log("got a new request")
			.setBody(constant("{\"resp\": \"hello,summit\"}"));
		// @formatter:on 
		
		restConfiguration().component("netty4-http").port(8080).bindingMode(RestBindingMode.auto);
	}

}
