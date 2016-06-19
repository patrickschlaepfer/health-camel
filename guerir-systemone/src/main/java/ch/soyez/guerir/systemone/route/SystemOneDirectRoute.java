package ch.soyez.guerir.systemone.route;

import org.apache.camel.builder.RouteBuilder;

import ch.soyez.guerir.systemone.translator.SystemOneHL7In;

public class SystemOneDirectRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// @formatter:off 
		from("direct:hl7SystemOne")
  			.routeId("SystemOneDriect")
  			.log("HL7 Request: ${body}")
  			.unmarshal()
  			.hl7()
  			.bean(SystemOneHL7In.class)
			.log("after procssing: ${body}")
  			.end();
		// @formatter:on
		
	}

}
