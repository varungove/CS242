import sys
import math
from ports import Ports
"""
Contains functionality of CSAir
"""
def print_cities(g):
        """
        List of all cities
        """
        cities = []
        for key in g.city_dict:
            cities.append(g.city_dict[key].get_name())
        return cities
            
            
def get_city_info(g, city_name):
        """
        Information of a particular city
        """
        flag = 0
        for key in g.city_dict:
            if(g.city_dict[key].get_name() == city_name):
                print g.city_dict[key].get_info()
                flag = 1
                
        if(flag == 0):
            print ("Invalid Input")
            
def longest_flight(g):
        """
        Distance and endpoints of the longest flight
        """
        max_distance = None
        max_destination = None
        max_key = None
        
        for key in g.city_dict:
            for flight in g.city_dict[key].get_flights_out():
                if(flight[1] > max_distance):
                    max_key = key
                    max_destination = flight[0]
                    max_distance = flight[1]
        return g.city_dict[max_key].get_code(), max_destination, max_distance
                
       
            
def shortest_flight(g):
        """
        Distance and endpoints of the shortest flight
        """
        min_distance = sys.maxsize
        min_destination = None
        min_key = None
        
        for key in g.city_dict:
            for flight in g.city_dict[key].get_flights_out():
                if(flight[1] < min_distance):
                    min_key = key
                    min_destination = flight[0]
                    min_distance = flight[1]
        return g.city_dict[min_key].get_name(), min_destination, min_distance
        
def average_flight(g):
        """
        Average flight distance
        """
        average = 0
        ctr = 0
        
        for key in g.city_dict:
            for flight in g.city_dict[key].get_flights_out():
                average = average + flight[1]
                ctr = ctr + 1
            
        
        return (average / ctr)
        
def biggest_city(g):
        """
        Calculates city with the most population
        """
        max_size = None
        max_city = None
        
        for key in g.city_dict:
            if(g.city_dict[key].get_population() > max_size):
                max_size = g.city_dict[key].get_population()
                max_city = g.city_dict[key].get_name()
                
                
        
        return max_city, max_size
        
def smallest_city(g):
        """
        Calculates city with the least population
        """
        min_size = sys.maxsize
        min_city = None
        
        for key in g.city_dict:
            if(g.city_dict[key].get_population() < min_size):
                min_size = g.city_dict[key].get_population()
                min_city = g.city_dict[key].get_name()
                
                
        
        return min_city, min_size
        
def average_city(g):
        """
        Calculates the average population across all cities
        """
        average = 0
        ctr = 0
        
        for key in g.city_dict:
            average = average + g.city_dict[key].get_population()
            ctr = ctr + 1
            
        
        return (average / ctr)
        
def continents(g):
        """
        List of continents and sub cities
        """
        continents = []
        for key in g.city_dict:
            if(g.city_dict[key].get_continent() not in continents):
                continents.append(g.city_dict[key].get_continent())
                
        for continent in continents:
            print("{}: ").format(continent)
            for key in g.city_dict:
                if(g.city_dict[key].get_continent() == continent):
                    print("     {}").format(g.city_dict[key].get_name())
                              
def hub_city(g):
        """
        Calculates the hub cities
        """
        max_flights = None
        hub_cities = []
        for key in g.city_dict:
            if(len(g.city_dict[key].get_flights_in()) > max_flights):
                max_flights = len((g.city_dict[key]).flights_in)
                
                
        for key in g.city_dict:
            if(len(g.city_dict[key].get_flights_in()) == max_flights):    
                hub_cities.append(g.city_dict[key].get_name()) 
            
                  
        return hub_cities
        
def visualize(g):
        """
        URL to visualize entire network
        """
        url = "http://www.gcmap.com/mapui?P="
        routes = []
        
        for key in g.city_dict:
            for flight in g.city_dict[key].get_flights_out():
                route = (g.city_dict[key].get_code(), flight[0])
                if(route not in routes):
                    routes.append(route)
                
        for flight in routes:
            url = url + flight[0] + "-" + flight[1]
            url = url + ",+"
            
        url = url[:-2]
        return url

def remove_city(g, city_name):
    """
    Removes a city from the system
    """
    code = g.convert[city_name]
    
    for key in g.city_dict:
        
        old_flights_in = g.city_dict[key].get_flights_in()
        new_flights_in = []
        for flight in old_flights_in:
            if(flight[0] != code):
                new_flights_in.append(flight)
        
        old_flights_out = g.city_dict[key].get_flights_out()
        new_flights_out = []
        for flight in old_flights_out:
            if(flight[0] != code):
                new_flights_out.append(flight)
        
        g.city_dict[key].set_flights_in(new_flights_in)
        g.city_dict[key].set_flights_out(new_flights_out)
        
    del g.city_dict[code]
    del g.convert[city_name]
    
    return g

def remove_route(g, origin, destination, choice_dir):
    """
    Removes routes in either one or both directions depending on choice
    """
    origin_code = g.convert[origin]
    destination_code = g.convert[destination]
        
    # Removes both directions and returns    
    if(choice_dir == "y"):
        
    
        for key in g.city_dict:
            if(key == origin_code):
                
                old_flights_in = g.city_dict[key].get_flights_in()
                new_flights_in = []
                for flight in old_flights_in:
                    if(flight[0] != destination_code):
                        new_flights_in.append(flight)
                
                old_flights_out = g.city_dict[key].get_flights_out()
                new_flights_out = []
                for flight in old_flights_out:
                    if(flight[0] != destination_code):
                        new_flights_out.append(flight)
                        
                        g.city_dict[key].set_flights_in(new_flights_in)
                        g.city_dict[key].set_flights_out(new_flights_out)
                
            if(key == destination_code):
                old_flights_in = g.city_dict[key].get_flights_in()
                new_flights_in = []
                for flight in old_flights_in:
                    if(flight[0] != origin_code):
                        new_flights_in.append(flight)
                
                old_flights_out = g.city_dict[key].get_flights_out()
                new_flights_out = []
                for flight in old_flights_out:
                    if(flight[0] != origin_code):
                        new_flights_out.append(flight)
                
                g.city_dict[key].set_flights_in(new_flights_in)
                g.city_dict[key].set_flights_out(new_flights_out)
                
        
    # Removes one direction and returns
    if(choice_dir == "n"):
        for key in g.city_dict:
            if(key == origin_code):
                
                old_flights_out = g.city_dict[key].get_flights_out()
                new_flights_out = []
                for flight in old_flights_out:
                    if(flight[0] != destination_code):
                        new_flights_out.append(flight)
                
                g.city_dict[key].set_flights_out(new_flights_out)
                
            if(key == destination_code):
                old_flights_in = g.city_dict[key].get_flights_in()
                new_flights_in = []
                for flight in old_flights_in:
                    if(flight[0] != origin_code):
                        new_flights_in.append(flight)
                g.city_dict[key].set_flights_in(new_flights_in)
                
    return g

def add_city(g, code, name, country, continent, timezone, coordinates, population, region):
    """
    Adds a city to the network
    """
    port = Ports(code, name, country, continent, timezone, coordinates, population, region)
    g.city_dict[code] = port
    g.convert[name] = code  
    return g
    
def add_route(g, origin, destination, distance, choice_dir):
    """
    Adds a route either both ways or one way
    """
    origin_code = g.convert[origin]
    destination_code = g.convert[destination]
    distance = int(distance)
    # Add route both ways
    if(choice_dir == "y"):
        g.city_dict[origin_code].add_flights_in((destination_code, distance))
        g.city_dict[origin_code].add_flights_out((destination_code, distance))
        
        g.city_dict[destination_code].add_flights_in((origin_code, distance))
        g.city_dict[destination_code].add_flights_out((origin_code, distance))
    # Add route one way 
    if(choice_dir == "n"):
        g.city_dict[origin_code].add_flights_out((destination_code, distance))
        g.city_dict[destination_code].add_flights_in((origin_code, distance))
        
             
       
    return g

def edit_city(g, city_name, option, value):
    """
    Edits a particular city's information
    """
    city_code = g.convert[city_name]
        
    if(option == "country"):
        g.city_dict[city_code].set_country(value)
        
    if(option == "continent"):
        g.city_dict[city_code].set_continent(value)
        
    if(option == "timezone"):
        g.city_dict[city_code].set_timezone(int(value)) 
        
    if(option == "coordinates"):
        g.city_dict[city_code].set_coordinates(value)       
        
    if(option == "population"):
        g.city_dict[city_code].set_population(int(value))
    
    if(option == "region"):
        g.city_dict[city_code].set_region(int(value))
        
    return g
            
            
def route_info(g, journey):
    """
    Returns the information of a particular route
    """
    distance = 0
    cost = 0.00
    time = 0
    check = 0
    
    for i in range(0, len(journey) - 1):
        city_name = journey[i]
        city_next = journey[i + 1]
        code_city = g.convert[city_name] 
        code_next = g.convert[city_next]
        
        for flight in g.city_dict[code_city].get_flights_out():
            if(flight[0] == code_next):
                distance = distance + flight[1]
                time = time + route_info_helper(g, code_city, code_next, flight[1])
                if(i < 7):
                    cost = cost + (distance * (0.35 - (i * 0.05)))
                
                check = check + 1
    if((check + 1) == len(journey)):
        return distance, cost, time
    else:
        print("Invalid Route")
        return 0, 0, 0
        
                
def route_info_helper(g, origin, destination, distance):
    """
    Helper function for route info. Calculates Time
    """
    time = 0 
    acceleration = 1406.25
    
    if(distance > 400):
        time = time + 0.53 + 0.53
        distance = distance - 400
        time = time + distance / 750
    else:
        half = distance / 2.0
        time = time + 2 (math.sqrt((2 * half) / acceleration))
        
        
    flights_out = g.city_dict[destination].get_flights_out()
    number = len(flights_out)
    time = time + (2.1 - (0.1 * number))
        
    return time
        
        
        
              
              
            
            
