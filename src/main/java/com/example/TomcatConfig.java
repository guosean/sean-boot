package com.example;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by guozhenbin on 2017/7/6.
 */
@Configuration
public class TomcatConfig {

    @Bean
    public EmbeddedServletContainerCustomizer createEmbeddedServletContainerCustomizer() {
        return new MyEmbeddedServletContainerCustomizer();
    }
}

class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
    public void customize(ConfigurableEmbeddedServletContainer container) {
        TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory) container;
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            public void customize(Connector connector) {
                connector.setPort(9090);
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setMaxThreads(500);
            }
        });
    }

}
