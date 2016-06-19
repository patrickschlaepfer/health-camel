package ch.soyez.guerir.sap.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import ch.soyez.guerir.entities.Patient;
import ch.soyez.guerir.sap.translator.ODataToPatient;
import ch.soyez.guerir.sap.translator.PatientToOData;

public class SapRESTRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		
		// @formatter:off 
		rest("/api")
			.id("rest-sap-service").description("SAP REST Endpoint").produces("application/json").consumes("application/json")
			
			.get("/hello").to("direct:sayHello")
			// .post("/patients").type(Patient.class).to("direct:newPatient");
			
			.put("/patient").id("rest-put-sap-patient").description("Updates or create a user").type(Patient.class).to("direct:newPatient")
			// .put("/article/{id}").id("rest-put-article").type(Blog.class).to("direct:add");
		
			.post("/patient").id("rest-post-sap-patient").description("Updates or create a user").type(Patient.class).to("direct:newPatient");
			
		from("direct:sayHello")
			.log("got a new request")
			.setBody(constant("{\"resp\": \"hello,summit\"}"));
		
		from("direct:newPatient")
			.bean(PatientToOData.class)
			.log("get new Patient")
			.log("Would save to SAP")
			.bean(ODataToPatient.class);
		
		// @formatter:on 
		
		restConfiguration().component("netty4-http").port(8080).bindingMode(RestBindingMode.json);
	}

}
