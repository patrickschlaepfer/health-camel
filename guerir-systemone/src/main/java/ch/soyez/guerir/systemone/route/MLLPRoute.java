package ch.soyez.guerir.systemone.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.netty4.NettyComponent;
import org.apache.camel.component.netty4.NettyConfiguration;
import org.apache.camel.component.netty4.NettyEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MLLPRoute extends RouteBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(MLLPRoute.class);

	@Override
	public void configure() throws Exception {

		LOGGER.info("MLLPRoute being added...");

		HL7MLLPNettyDecoderFactory decoderFactory = new HL7MLLPNettyDecoderFactory();
		decoderFactory.setCharset("UTF-8");
		decoderFactory.setProduceString(false);
		decoderFactory.setConvertLFtoCR(true);

		NettyConfiguration nettyConfiguration = new NettyConfiguration();
		nettyConfiguration.setDecoder(decoderFactory);
		nettyConfiguration.setPort(9093);
		nettyConfiguration.setHost("localhost");
		nettyConfiguration.setSync(true);
		nettyConfiguration.setProtocol("tcp");

		NettyComponent nettyComponent = getContext().getComponent("netty4", NettyComponent.class);
		nettyComponent.setConfiguration(nettyConfiguration);
		NettyEndpoint endpoint = new NettyEndpoint("", nettyComponent, nettyConfiguration);

		// @formatter:off 
		from(endpoint)
			.log(":${body}")
			.to("direct:hl7SystemOne");
		// @formatter:on

	}

}
