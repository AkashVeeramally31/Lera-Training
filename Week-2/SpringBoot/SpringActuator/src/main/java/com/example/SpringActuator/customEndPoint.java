package com.example.SpringActuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customEndPoint")
public class customEndPoint {

    @ReadOperation
    public String getCustomData(){
        return "Custom Actuator Endpoint's Data";
    }
}
// http://localhost:8081/actuator/(@Endpoint_id)
// Navigate to this URL:- http://localhost:8081/actuator/customEndPoint
