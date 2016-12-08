import json
from ports import Ports
"""
Parses Data from JSON
"""
class Parse:
    
    city_dict = {}
    convert = {}
    
    with open('csAirData.json') as data_file:    
        data = json.load(data_file)
    
    cities = data["metros"];
    routes = data["routes"];
    
#Adds each city to Dictionary
    for city in cities:
        code = city['code'].encode("utf-8")
        name = city['name'].encode("utf-8")
        country = city['country'].encode("utf-8")
        continent = city['continent'].encode("utf-8")
        timezone = city['timezone']
        coordinates = city['coordinates']
        population = city['population']
        region = city['region']
         
        port = Ports(code, name, country, continent, timezone, coordinates, population, region)
        city_dict[code] = port
        convert[code] = name
        
#Adds routes to each city. To and From.
    for route in routes:
        origin = (route["ports"][0]).encode("utf-8")
        destination = (route["ports"][1]).encode("utf-8")
        distance = route["distance"]
        
        if(destination not in city_dict[origin].flights_out):
            (city_dict[origin].flights_out).append((destination, distance))
        if(destination not in city_dict[origin].flights_in):
            (city_dict[origin].flights_in).append((destination, distance))
            
            
        if(origin not in city_dict[destination].flights_in):
            (city_dict[destination].flights_in).append((origin, distance))
        if(origin not in city_dict[destination].flights_out):
            (city_dict[destination].flights_out).append((origin, distance))