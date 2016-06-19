package ch.soyez.guerir.sap;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.soyez.guerir.sap.route.SapRESTRoute;

public class SapCamelBoot {

	private static final Logger LOGGER = LoggerFactory.getLogger(SapCamelBoot.class);

	public static void main(String[] args) throws Exception {

		LOGGER.info("Starting Sap route");

		Main main = new Main();

		main.addRouteBuilder(new SapRESTRoute());

		main.run();

	}

}
