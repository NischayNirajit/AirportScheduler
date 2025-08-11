package com.example.AirportScheduler;

public class Flight {
    private final  String FlightNo;
    private final  String source;
    private final  String destination;
    private final  int startTime;
    private final  int endTime;
    private final  int duration;

    public Flight(String flightNo, String source, String destination, int startTime, int endTime) {
        this.FlightNo = flightNo;
        this.source = source;
        this.destination = destination;
        this.startTime = (startTime/100)*60+ startTime%100;
        this.endTime = (endTime/100)*60+ endTime%100;
        this.duration = this.endTime>=this.startTime?this.endTime-this.startTime : 24*60 +this.endTime-this.startTime ;
    }

    public String getFlightNo() {
        return this.FlightNo;
    }


    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getStartTime() {
        return this.startTime;
    }



    public int getEndTime() {
        return this.endTime;
    }

    public int getDuration(){
        return this.duration;
    }
}
