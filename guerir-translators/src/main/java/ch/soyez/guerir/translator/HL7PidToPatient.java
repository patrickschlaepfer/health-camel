package ch.soyez.guerir.translator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ch.soyez.guerir.entities.Patient;

public class HL7PidToPatient {

	private static final Logger LOGGER = LoggerFactory.getLogger(HL7PidToPatient.class);
	
	@Handler
	public Patient handle(Message message) throws HL7Exception {
		
		LOGGER.info("Translating from HL7 to BO");
		
		PID pid = (PID) message.get("PID");
		
		Patient patient = new Patient();
		
		patient.setId(1000);
		patient.setFirstName(pid.getPatientName(0).getFamilyName().getSurname().getValue());
		patient.setLastName(pid.getPatientName(0).getGivenName().getValue());
		
		LOGGER.info("Patient: {}", patient.toString());
		
		return patient;
	}
	
}
