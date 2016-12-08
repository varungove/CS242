"""
Each city is of type Port that stores all it's information
"""

class Ports:
    
    def __init__(self, code, name, country, continent, timezone, coordinates, population, region):
        """
        Constructor for each Port
        """
        self.code = code
        self.name = name
        self.country = country
        self.continent = continent
        self.timezone = timezone
        self.coordinates = coordinates
        self.population = population
        self.region = region
        self.flights_in = []
        self.flights_out = []
        
        
    """
    Getters for Ports
    """
    def get_continent(self):
        return self.continent
    
    def get_info(self):
        return self.name, self.code, self.country, self.continent, self.timezone, self.coordinates, self.population, self.region, self.flights_out
    
    def get_code(self):
        return self.code
    
    def get_name(self):
        return self.name
    
    def get_country(self):
        return self.country
    
    def get_timezone(self):
        return self.timezone
    
    def get_coordinates(self):
        return self.coordinates
    
    def get_population(self):
        return self.population
    
    def get_region(self):
        return self.region
    
    def get_flights_in(self):
        return self.flights_in
    
    def get_flights_out(self):
        return self.flights_out
    """
    Setters for Ports
    """
    
    def set_flights_in(self, new_flights_in):
        self.flights_in = new_flights_in
        
    def set_flights_out(self, new_flights_out):
        self.flights_out = new_flights_out
    
    def set_code(self, code):
        self.code = code
    
    def set_name(self, name):
        self.name = name
        
    def set_country(self, country):
        self.country = country
    
    def set_continent(self, continent):
        self.continent = continent
        
    def set_timezone(self, timezone):
        self.timezone = timezone
    
    def set_coordinates(self, coordinates):
        self.coordinates = coordinates
        
    def set_population(self, population):
        self.population = population
        
    def set_region(self, region):
        self.region = region
        
    def add_flights_in(self, new_flights_in):
        self.flights_in.append(new_flights_in)
        
    def add_flights_out(self, new_flights_out):
        self.flights_out.append(new_flights_out)
    
