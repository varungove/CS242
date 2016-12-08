"""
Graph class and functionality
"""
class Graph:
    routes = []
    
    
    def __init__(self, cities, routes, city_dict, convert):
        """
        Constructor for the Graph
        """
        self.city_info = cities
        self.route_info = routes
        self.city_dict = city_dict
        self.convert = convert
        
        for route in routes:
            port = route["ports"]
            self.routes.append((port[0].encode("utf-8"),port[1].encode("utf-8")))
                        
    def print_cities(self):
        """
        List of all cities
        """
        for city in self.city_info:
            print(city["name"])
            
    def get_city_info(self, city_name):
        """
        Information of a particular city
        """
        flag =0
        for check in self.city_info:
            if(check["name"].encode("utf-8") == city_name):
                print("Name: " + check["name"].encode("utf-8"))
                print("Code: " + check["code"].encode("utf-8"))
                print("Country: " + check["country"].encode("utf-8"))
                print("Continent: " + check["continent"].encode("utf-8"))
                print("Timezone: {}" ).format(check["timezone"])
                print("Coordinates: {}" ).format(check["coordinates"])
                print("Population: {}" ).format(check["population"])
                print("Region: {}" ).format(check["region"])
                flag=1
                
        if(flag==0):
            print("Invalid Input")
            
    def longest_flight(self):
        """
        Distance and endpoints of the longest flight
        """
        max =0
        max_route = None
        
        for route in self.route_info:
            if(route["distance"]>max):
                max = route["distance"]
                max_route = route["ports"]
                
        print("Longest flight is:")
        print("From: {} to {}").format(max_route[0].encode("utf-8"), max_route[1].encode("utf-8"))
        print("Distance of: {}").format(max)
        return max
            
    def shortest_flight(self):
        """
        Distance and endpoints of the shortest flight
        """
        min =100000000
        min_route = None
        
        for route in self.route_info:
            if(route["distance"]<min):
                min = route["distance"]
                min_route = route["ports"]
                
        print("Shortest flight is:")
        print("From: {} to {}").format(min_route[0].encode("utf-8"), min_route[1].encode("utf-8"))
        print("Distance of: {}").format(min)
        return min
        
    def average_flight(self):
        """
        Average flight distance
        """
        average = 0
        ctr = 0
        
        for route in self.route_info:
            average = average + route["distance"]
            ctr = ctr+1
            
        print("Average flight distance is: {}").format(average/ctr)
        return (average/ctr)
        
    def biggest_city(self):
        """
        Calculates city with the most population
        """
        max =0
        max_city = None
        
        for city in self.city_info:
            if(city["population"]>max):
                max = city["population"]
                max_city = city["name"]
                
        print("Biggest City served by CSAir: ")
        print("{}, with a population of {}").format(max_city, max)
        return max
        
    def smallest_city(self):
        """
        Calculates city with the least population
        """
        min = 100000000000000
        min_city = None
        
        for city in self.city_info:
            if(city["population"]<min):
                min = city["population"]
                min_city = city["name"]
                
        print("Smallest City served by CSAir: ")
        print("{}, with a population of {}").format(min_city, min)
        return min
        
    def average_city(self):
        """
        Calculates the average population across all cities
        """
        average = 0
        ctr = 0
        
        for city in self.city_info:
            average = average + city["population"]
            ctr = ctr+1
            
        print("Average population of cities served be CSAir is: {}").format(average/ctr)
        return (average/ctr)
        
    def continents(self):
        """
        List of continents and sub cities
        """
        continents = []
        for city in self.city_info:
            if(city["continent"] not in continents):
                continents.append(city["continent"])
                
        for continent in continents:
            print("{}: ").format(continent)
            for city in self.city_info:
                if(city["continent"]==continent):
                    print("     {}").format(city["name"])
                              
    def hub_city(self):
        """
        Calculates the hub cities
        """
        max = 0
        hub_cities = []
        for key in self.city_dict:
            if(len((self.city_dict[key]).flights_in)>max):
                max = len((self.city_dict[key]).flights_in)
                
                
        for key in self.city_dict:
            if(len((self.city_dict[key]).flights_in)==max):    
                hub_cities.append((self.city_dict[key]).name) 
            
                  
        print("{} are CSAir's main hub cities").format(hub_cities)
        
    def visualize(self):
        """
        URL to visualize entire network
        """
        url = "http://www.gcmap.com/mapui?P="
        
        for route in self.routes:
            url = url+route[0] + "-" + route[1]
            url = url + ",+"
            
        url = url[:-2]
        print(url)
                
                
        