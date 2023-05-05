package com.atuigu.boot.cus;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class MyTomcatTomcatConnectorCustomizer  implements TomcatConnectorCustomizer {
    @Override
    public void customize(Connector connector) {
//        connector.setPort();
        //我们定义关键组件
        System.out.println();
    }
}
