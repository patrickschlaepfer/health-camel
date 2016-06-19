package ch.soyez.guerir.translator;

import org.apache.camel.Handler;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ch.soyez.guerir.entities.Patient;

public class HL7PidToPatient {

	@Handler
	public Patient handle(Message message) throws HL7Exception {
		
		Patient patient = new Patient();
		
		
		return patient;
	}
	
}
