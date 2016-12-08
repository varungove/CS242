import unittest
from parse import Parse
from graph import Graph

class Tests(unittest.TestCase):
    
    def test_longest_flight(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.longest_flight(), 12051)
        
    def test_shortest_flight(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.shortest_flight(), 334)
        
    def test_average_flight(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.average_flight(), 2300)
        
    def test_biggest_city(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.biggest_city(), 34000000)
        
    def test_smallest_city(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.smallest_city(), 589900)
        
    def test_average_city(self):
        pa = Parse()
        g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
        self.assertEqual(g.average_city(), 11796143)
    