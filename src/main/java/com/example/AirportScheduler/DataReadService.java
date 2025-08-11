package com.example.AirportScheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Configuration
public class DataReadService {
    HashMap<String, List<Flight>> flightMap = new HashMap<>();
    @Bean(name = "flightMap")
    public HashMap<String, List<Flight>> flightListMap(@Value("${app.data.pathname}") String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String src = data[1];
                String dest = data[2];
                int start = Integer.parseInt(data[3]);
                int end = Integer.parseInt(data[4]);
                Flight flight = new Flight(id, src, dest, start, end);
                flightMap.computeIfAbsent(src, k -> new LinkedList<>()).add(flight);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightMap;
    }

    public void printData(){

        for(Map.Entry<String, List<Flight>> itr : flightMap.entrySet()){
            String key = itr.getKey();
            System.out.println(key +" : ");
            for(Flight f : itr.getValue()){
                System.out.println("\t|-"+f.getDestination());
            }
        }
    }

}
