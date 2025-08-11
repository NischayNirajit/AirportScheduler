package com.example.AirportScheduler;

public class Result {
    String airportPath;
    String flightPath;
    int time;

    public Result(String airportPath, String flightPath, int time) {
        this.airportPath = airportPath;
        this.flightPath = flightPath;
        this.time = time;
    }

    public String getAirportPath() {
        return airportPath;
    }

    public void setAirportPath(String airportPath) {
        this.airportPath = airportPath;
    }

    public String getFlightPath() {
        return flightPath;
    }

    public void setFlightPath(String flightPath) {
        this.flightPath = flightPath;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Result: \n{" +
                "airportPath='" + airportPath + '\'' +
                ", flightPath='" + flightPath + '\'' +
                ", time=" + time +
                '}'+"\n";
    }
}
