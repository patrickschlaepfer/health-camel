package ch.soyez.guerir.sap.translator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.soyez.guerir.entities.Patient;

public class PatientToOData {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientToOData.class);

	@Handler
	public void handle(Patient patient) {

		LOGGER.info("patient.lastName: {}", patient.getLastName());
		LOGGER.info("patient.fistName: {}", patient.getFirstName());

	}
}
