"""
Graph class and functionality
"""

import parse

class Graph:
    city_dict = {}
    convert = {}
    
    
    def __init__(self, control):
        """
        Constructor for the Graph
        """
        if(control == '1' or control == '2'):
            self.city_dict, self.convert = parse.parse_graph(self.city_dict, self.convert, control)
        if(control == '3'):
            self.city_dict, self.convert = parse.parse_graph(self.city_dict, self.convert, '1')
            self.city_dict, self.convert = parse.parse_graph(self.city_dict, self.convert, '3')
            
        
        
                        
    def save_file(self):
        """
        Saves graph to file
        """
        parse.save_file(self.city_dict)
                
                
        
