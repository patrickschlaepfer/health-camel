package ch.soyez.guerir.systemone.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import ch.soyez.guerir.systemone.translator.SystemOneHL7In;
import ch.soyez.guerir.translator.HL7PidToPatient;

public class SystemOneDirectRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// enable Jackson json type converter
		getContext().getProperties().put("CamelJacksonEnableTypeConverter", "true");
		// allow Jackson json to convert to pojo types also (by default jackson
		// only converts to String and other simple types)
		getContext().getProperties().put("CamelJacksonTypeConverterToPojo", "true");

		// @formatter:off 
		from("direct:hl7SystemOne")
  			.routeId("SystemOneDirect")
  			.log("HL7 Request: ${body}")
  			.unmarshal()
  			.hl7()
  			.bean(SystemOneHL7In.class)
  			.bean(HL7PidToPatient.class)
  			.marshal()
  			.json(JsonLibrary.Jackson)
  			.setHeader("CamelHttpMethod", simple("PUT", String.class))
  			.to("netty4-http:http://localhost:8080/api/patient")
			.log("after procssing: ${body}")
  			.end();
		// @formatter:on

	}

}
