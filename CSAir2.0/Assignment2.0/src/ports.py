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
        self.timezoone = timezone
        self.coordinates = coordinates
        self.population = population
        self.region = region
        self.flights_in = []
        self.flights_out = []