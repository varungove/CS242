import unittest
from graph import Graph
import stats

class Tests(unittest.TestCase):
    
    def test_longest_flight(self):
        g = Graph('1')
        source, destination, distance = stats.longest_flight(g)
        self.assertEqual(distance, 12051)
        
    def test_shortest_flight(self):
        g = Graph('1')
        source, destination, distance = stats.shortest_flight(g)
        self.assertEqual(distance, 334)
        
    def test_average_flight(self):
        g = Graph('1')
        self.assertEqual(stats.average_flight(g), 2300)
        
    def test_biggest_city(self):
        g = Graph('1')
        max_city, max_size = stats.biggest_city(g)
        self.assertEqual(max_size, 34000000)
        
    def test_smallest_city(self):
        g = Graph('1')
        min_city, min_size = stats.smallest_city(g)
        self.assertEqual(min_size, 589900)
        
    def test_average_city(self):
        g = Graph('1')
        self.assertEqual(stats.average_city(g), 11796143)
        
    def test_remove_city(self):
        g = Graph('1')
        stats.remove_city(g, "Paris")
        flights_out = g.city_dict["ALG"].get_flights_out()
        test = ("PAR", 1354) not in flights_out
        self.assertTrue(test)
        
    def test_remove_route(self):
        g = Graph('1')
        stats.remove_route(g, "Algiers", "Paris", "n")
        flights_out = g.city_dict["ALG"].get_flights_out()
        test = ("PAR", 1354) not in flights_out
        self.assertTrue(test)
        
    def test_add_city(self):
        g1 = Graph('1')
        g1 = stats.add_city(g1, "BLR", "Bangalore", "India", "Asia", 2, 43, 72, 1)
        test = g1.city_dict["BLR"].get_code()
        self.assertEqual("BLR", test)
        stats.remove_city(g1, "Bangalore")
        
    def test_add_route(self):
        g = Graph('1')
        stats.add_route(g, "London", "Milan", 100, "n") 
        flights_out = g.city_dict["LON"].get_flights_out()
        test = ("MIL", 100) in flights_out
        self.assertTrue(test)    
        stats.remove_route(g, "London", "Milan", "n")   
        
    def test_edit_city(self):
        g = Graph('1')
        stats.edit_city(g, "Paris", "region", 2)
        self.assertEqual(2, g.city_dict["PAR"].get_region())
        
    def test_save(self):
        gr = Graph('1')
        gr = stats.edit_city(gr, "Paris", "region", 4)
        gr.save_file()
        gr = Graph('2')
        self.assertEqual(4, gr.city_dict["PAR"].get_region())
        
    def test_route_info(self):
        g2 = Graph('1')
        distance, cost, time = stats.route_info(g2, ["Santiago", "Lima", "Mexico City"])
        self.assertEqual(distance, 6684)
        self.assertEqual(cost, 2863.75)
        self.assertEqual(time, 12.72)
        
        
        
    
    
