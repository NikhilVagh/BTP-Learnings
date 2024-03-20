package org.example.router;

import org.example.handler.CustomerHandler;
import org.example.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler;

    @Autowired
    private CustomerStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers",handler::loadCustomer)
                .GET("/router/customerStream",streamHandler::getCustomer)
                .GET("/router/customer/{input}",handler::findCustomer)
                .POST("/router/customer",handler::saveCustomer)
                .build();
    }
}
