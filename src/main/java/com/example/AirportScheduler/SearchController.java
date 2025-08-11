package com.example.AirportScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private FlightSearchService flightSearchService;

    @GetMapping("/getFlights")
    public ResponseEntity<?> getFlights(@RequestParam String src, @RequestParam String dest){
        List<Result> result = flightSearchService.getFlightPath(src, dest);
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
    }
}
