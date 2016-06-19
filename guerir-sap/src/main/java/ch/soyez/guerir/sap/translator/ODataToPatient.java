package ch.soyez.guerir.sap.translator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.soyez.guerir.entities.Patient;

public class ODataToPatient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ODataToPatient.class);

	@Handler
	public Patient handle(Patient oPatient) {

		Patient patient = new Patient();
		patient.setFirstName(oPatient.getFirstName());
		patient.setLastName(oPatient.getLastName());
		patient.setId(9999);
		
		LOGGER.info("patient.id      : {}", patient.getId());
		LOGGER.info("patient.lastName: {}", patient.getLastName());
		LOGGER.info("patient.fistName: {}", patient.getFirstName());

		return patient;
	}

}
