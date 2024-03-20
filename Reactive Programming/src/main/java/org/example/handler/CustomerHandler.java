package org.example.handler;

import org.example.dao.CustomerDao;
import org.example.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> loadCustomer(ServerRequest request){
        Flux<Customer> customerFlux = dao.getCustomerList();
        return ServerResponse.ok().body(customerFlux, Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request){
        Integer customerId = Integer.valueOf(request.pathVariable("input"));
        Mono<Customer> customer = dao.getCustomerList().filter(c->c.getId()==customerId).next();
        return ServerResponse.ok().body(customer, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request){

        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> map = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
        return ServerResponse.ok().body(map, String.class);
    }

}
