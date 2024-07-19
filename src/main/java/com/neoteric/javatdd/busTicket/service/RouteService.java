package com.neoteric.javatdd.busTicket.service;

import com.neoteric.javatdd.busTicket.model.Bus;
import com.neoteric.javatdd.busTicket.model.Route;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteService {
    public List<Route>  routeList(){
        Route route1 = new Route();
        route1.setFromLocation("hyd");
        route1.setToLocation("KDD");
        route1.setDistance(180);
        route1.setPrice(320);
        route1.setTravelDate(new Date());


        Bus bus = new Bus();
        bus.setServiceNo("1234");
        bus.setTypeOfBus("superFast");

        Bus bus1 = new Bus();
        bus.setServiceNo("1235");
        bus.setTypeOfBus("Super luxury");

        List<Bus> busList = new ArrayList<>();

        busList.add(bus);
        busList.add(bus1);

        route1.setBusList(busList);


        Route route2 = new Route();
        route2.setFromLocation("hyd");
        route2.setToLocation("KHMM");
        route2.setDistance(210);
        route2.setPrice(350);
        route2.setTravelDate(new Date());


        Bus bus2 = new Bus();
        bus2.setServiceNo("1234");
        bus2.setTypeOfBus("superFast");

        Bus bus3 = new Bus();
        bus3.setServiceNo("1235");
        bus3.setTypeOfBus("Super luxury");

        List<Bus> busList1 = new ArrayList<>();

        busList.add(bus);
        busList.add(bus1);

        route1.setBusList(busList1);


        List<Route> routeList = new ArrayList<>();

        routeList.add(route1);
        routeList.add(route2);


        return routeList;

    }
}
