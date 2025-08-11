package com.example.AirportScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightSearchService {
    @Autowired
    @Qualifier("flightMap")
    HashMap<String, List<Flight>> flightMap;

    public static void getTop5Fastest(List<Result> listOfAns, PriorityQueue<Result> pq){
        int count = 0;
        while(!pq.isEmpty() && count<5) {
            listOfAns.add(pq.poll());
            count++;
        }

    }
    private static int timeDiff(int endTime, int startTime) {
        if(startTime>=endTime){
            return startTime -endTime;
        }
        return (24*60+ startTime) - endTime;
    }
    public List<Result> getFlightPath(String src, String dest) {
        int MIN_LAYOVER = 120;
        List<Flight> listOfDest = flightMap.get(src);
        List<Result> listOfAns = new LinkedList<>();
        HashMap<String, Result> intermediateVistedMin = new HashMap<>();
        PriorityQueue<Result> pq = new PriorityQueue<>(Comparator.comparingInt(Result::getTime));
        HashSet<String> alreadyUsed = new HashSet<>();
        for(Flight flight : listOfDest) {
            int totalTime = 0;
            String intermediateDestination = flight.getDestination();
            totalTime = flight.getDuration();
            if (dest.equalsIgnoreCase(intermediateDestination)) {
                Result result = new Result(src + "_" + dest, flight.getFlightNo(), totalTime);
                pq.add(result);
            }
            else{
                int min = Integer.MAX_VALUE;
                if(intermediateVistedMin.containsKey(intermediateDestination)){
                    min = intermediateVistedMin.get(intermediateDestination).getTime();
                }
                Result result = null;
                for (Flight secondFlight : flightMap.get(intermediateDestination)) {
                    int diff = timeDiff(flight.getEndTime(), secondFlight.getStartTime());
                    if (dest.equalsIgnoreCase(secondFlight.getDestination()) && diff>MIN_LAYOVER)
                    {
                        if(min>totalTime + diff + secondFlight.getDuration()){
                            min = totalTime + diff + secondFlight.getDuration();
                            result = new Result(src+"_"+intermediateDestination+"_"+dest, flight.getFlightNo()+"_"+secondFlight.getFlightNo(), min);
                            intermediateVistedMin.put(intermediateDestination, result);
                        }
                    }
                }

            }


        }
        for(String keys :  intermediateVistedMin.keySet()){
            pq.add(intermediateVistedMin.get(keys));
        }
//        System.out.println(intermediateVistedMin);
        getTop5Fastest(listOfAns, pq);
        return listOfAns;
    }


}
