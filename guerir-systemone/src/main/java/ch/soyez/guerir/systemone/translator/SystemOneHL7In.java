package ch.soyez.guerir.systemone.translator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.segment.MSH;

public class SystemOneHL7In {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemOneHL7In.class);

	@Handler
	public Message handle(Message message) throws HL7Exception {
		LOGGER.info("In handle");
		Message response = (Message) message;
		
		MSH msh = (MSH) response.get("MSH");
		
		LOGGER.info("sending Appication: {}", msh.getMsh3_SendingApplication().getHd1_NamespaceID());

		return response;
	}
	
}
