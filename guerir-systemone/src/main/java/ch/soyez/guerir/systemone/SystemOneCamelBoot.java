package ch.soyez.guerir.systemone;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.soyez.guerir.systemone.route.MLLPRoute;
import ch.soyez.guerir.systemone.route.SystemOneDirectRoute;

public class SystemOneCamelBoot {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemOneCamelBoot.class);
	
	public static void main(String[] args) throws Exception {
		
		LOGGER.info("Starting systemone route");
		
		Main main = new Main();
		
		main.addRouteBuilder(new MLLPRoute());
		main.addRouteBuilder(new SystemOneDirectRoute());
		
		main.run();

	}

}
