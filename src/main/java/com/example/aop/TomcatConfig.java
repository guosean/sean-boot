package com.example.aop;

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

        /*@Bean
        public EmbeddedServletContainerFactory servletContainer() {
            TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//            tomcat.setUriEncoding("UTF-8");
            tomcat.addAdditionalTomcatConnectors(createSslConnector());
            return tomcat;
        }

        private Connector createSslConnector() {
            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            try {
//                File truststore = new File("/Users/liaokailin/software/ca1/keystore");
                *//*connector.setScheme("https");
                protocol.setSSLEnabled(true);
                connector.setSecure(true);*//*
//                connector.setPort(8443);
                *//*protocol.setKeystoreFile(truststore.getAbsolutePath());
                protocol.setKeystorePass("123456");
                protocol.setKeyAlias("springboot");*//*
                protocol.setMaxThreads(2000);
                protocol.setPort(8080);
                return connector;
            } catch (Exception ex) {
                throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
            }
        }*/
        @Bean
        public EmbeddedServletContainerCustomizer createEmbeddedServletContainerCustomizer()
        {
            return new MyEmbeddedServletContainerCustomizer();
        }
}

class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer
{
    public void customize(ConfigurableEmbeddedServletContainer container)
    {
        TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory)container;
        //下面的操作可以参照上面的方法
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            public void customize(Connector connector) {
                connector.setPort(9090);
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setMaxThreads(500);
            }
        });
    }

}
