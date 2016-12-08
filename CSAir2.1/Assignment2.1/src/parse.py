import json
from ports import Ports
"""
Parses Data from JSON
"""
def parse_graph(city_dict, convert, control):
    
# Depending on control, it loads from different files
    if(control == '1'):
        with open('csAirData.json') as data_file:    
            data = json.load(data_file)
    if(control == '2'):
        with open('data.txt') as data_file:    
            data = json.load(data_file)
    if(control == '3'):
        with open('champaign.json') as data_file:    
            data = json.load(data_file)
        
        
    
    cities = data["metros"];
    routes = data["routes"];
    
# Adds each city to Dictionary
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
        convert[name] = code
        
# Adds routes to each city. To and From.
    for route in routes:
        origin = (route["ports"][0]).encode("utf-8")
        destination = (route["ports"][1]).encode("utf-8")
        distance = route["distance"]
        
        if(destination not in city_dict[origin].flights_out):
            (city_dict[origin].flights_out).append((destination, distance))
        
            
            
        if(origin not in city_dict[destination].flights_in):
            (city_dict[destination].flights_in).append((origin, distance))
        
            
    return city_dict, convert

def save_file(city_dict):
    """
    Saves data to file data.txt
    """
    head = {}
    metros = []
    routes = []
    
    for key in city_dict:
        save_dict = {}
        save_dict["code"] = city_dict[key].code
        save_dict["name"] = city_dict[key].name
        save_dict["country"] = city_dict[key].country
        save_dict["continent"] = city_dict[key].continent
        save_dict["timezone"] = city_dict[key].timezone
        save_dict["coordinates"] = city_dict[key].coordinates
        save_dict["population"] = city_dict[key].population
        save_dict["region"] = city_dict[key].region
        
        metros.append(save_dict)
        
        for flight in city_dict[key].flights_out:
            save_route = {}
            save_route["ports"] = [key, flight[0]]
            save_route["distance"] = flight[1]
            
            routes.append(save_route)
    head["metros"] = metros
    head["routes"] = routes
    
    saved_file = open("data.txt", "w")
    saved_file.write(json.dumps(head))
        
        
        
        
        
        
