from parse import Parse
from graph import Graph

"""
Main UI 
"""

def main():
    """
    Main function that controls Gameplay
    """
    pa = Parse()
    g = Graph(pa.cities, pa.routes, pa.city_dict, pa.convert)
    control = 'x'
    print("Welcome to CSAir! Enter corresponding letter for options below.")
     
    while (control=='x'):        
        print("a) Cities CSAir flies to")
        print("b) Info of a particular city")
        print("c) Longest flight in CSAir network")
        print("d) Shortest flight in CSAir network")
        print("e) Average distance of flights in CSAir network")
        print("f) Biggest city served by CSAir")
        print("g) Smallest city served by CSrAir")
        print("h) Average size of cities served by CSAir")
        print("i) Continents served by CSAir")
        print("j) CSAir's hub city")
        print("k) Visualize Routes")
        print("q) Quit")
        choice = raw_input()
        
        if(choice == "a"):
            g.print_cities()
            
        if(choice == "b"):
            city_name = raw_input("Enter name of City\n")
            g.get_city_info(city_name)
            
        if(choice == "c"):
            x = g.longest_flight()
            
        if(choice == "d"):
            x = g.shortest_flight()
            
        if(choice == "e"):
            x = g.average_flight()
            
        if(choice == "f"):
            x = g.biggest_city()
            
        if(choice == "g"):
            x = g.smallest_city()
            
        if(choice == "h"):
            x = g.average_city()
            
        if(choice == "i"):
            g.continents()
            
        if(choice == "j"):
            g.hub_city()
            
        if(choice == "k"):
            g.visualize()
            
        if(choice != "a" and choice != "b" and choice != "c" and choice != "d" and choice != "e" and choice != "f" and choice != "g" and choice != "h" and choice != "i" and choice != "j" and choice!= "q" and choice!= "k"):
            print("Invalid Input")
            
        if(choice == "q"):
            control = 'q'
        

    
main()