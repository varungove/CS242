from graph import Graph
import stats

"""
Main UI 
"""

def main():
    """
    Main function that controls Gameplay
    """
    control = 'z'
    
    while(control == 'z'):
        print("Welcome to CSAir! Enter corresponding letter for options below.")
        print("1) To load original data")
        print("2) To load from saved data. May or may not contain additional data")
        print("3) To load from original data + Additional Data")
        control = raw_input()
        
    
    g = Graph(control)
    control = 'x'
    print("Welcome to CSAir! Enter corresponding letter for options below.")
     
    while (control == 'x'):        
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
        print("l) Remove a City")
        print("m) Remove a Route")
        print("n) Add a City")
        print("o) Add a Route")
        print("p) Edit a City")
        print("r) Save File")
        print("s) Get Route Information")
        
        print("q) Quit")
        choice = raw_input()
        
        if(choice == "a"):
            print(stats.print_cities(g))
            
        if(choice == "b"):
            city_name = raw_input("Enter name of City\n")
            stats.get_city_info(g, city_name)
            
        if(choice == "c"):
            source, destination, distance = stats.longest_flight(g)
            print("Longest flight is from {} to {} with a distance of {}").format(source, destination, distance)
            
        if(choice == "d"):
            source, destination, distance = stats.shortest_flight(g)
            print("Shortest flight is from {} to {} with a distance of {}").format(source, destination, distance)
            
        if(choice == "e"):
            print(stats.average_flight(g))
            
        if(choice == "f"):
            max_city, max_size = stats.biggest_city(g)
            print("Biggest city is {} with a population of {}").format(max_city, max_size)
            
        if(choice == "g"):
            min_city, min_size = stats.smallest_city(g)
            print("Biggest city is {} with a population of {}").format(min_city, min_size)
            
        if(choice == "h"):
            print(stats.average_city(g))
            
        if(choice == "i"):
            stats.continents(g)
            
        if(choice == "j"):
            print("The hub cities are: \n")
            print(stats.hub_city(g))
            
        if(choice == "k"):
            print(stats.visualize(g))
            
        if(choice == "l"):
            city_name = raw_input("Enter name of City to remove\n")
            g = stats.remove_city(g, city_name)
            print("Done!")
            
        if(choice == "m"):
            origin = raw_input("Enter origin name of route to remove\n")
            destination = raw_input("Enter destination name of route to remove\n")
            choice_dir = raw_input("Remove in both directions? y or n \n")
            g = stats.remove_route(g, origin, destination, choice_dir)
            print("Done!")
            
        if(choice == "n"):
            code = raw_input("Enter code for City\n")
            name = raw_input("Enter name for City\n")
            country = raw_input("Enter Country\n")
            continent = raw_input("Enter Continent\n")
            timezone = raw_input("Enter TimeZone of City\n")
            coordinates = raw_input("Enter Coordinates of City\n")
            population = raw_input("Enter Population City\n")
            region = raw_input("Enter Region of City\n")
            g = stats.add_city(g, code, name, country, continent, timezone, coordinates, population, region)
            print("Done!")
            
        if(choice == "o"):
            origin = raw_input("Enter origin name of route to add\n")
            destination = raw_input("Enter destination name of route to add\n")
            distance = raw_input("Enter distance of route to add\n")
            choice_dir = raw_input("Add in both directions? y or n \n")
            g = stats.add_route(g, origin, destination, distance, choice_dir)
            print("Done!")
            
        if(choice == "p"):
            city_name = raw_input("Enter name of city to edit. Remember, city names and codes are immutable\n")
            option = raw_input("What do you want to edit: country, continent, timezone, coordinates, population, region\n")
            value = raw_input("Enter new value\n")
            g = stats.edit_city(g, city_name, option, value)
            print("Done")
            
        if(choice == "r"):
            g.save_file()
            
        if(choice == "s"):
            distance, cost, time = route_info(g)
            if(distance != 0):
                print("Total distance is {} with a cost of {} and taking time {} hours").format(distance, cost, time)
                
        
            
            
        if(choice != "a" and choice != "b" and choice != "c" and choice != "d" and choice != "e" and choice != "f" and choice != "g" and choice != "h" and choice != "i" and choice != "j" and choice != "q" and choice != "k" and choice != "l" and choice != "m" and choice != "n" and choice != "p" and choice != "r" and choice != "s"):
            print("Invalid Input")
            
        if(choice == "q"):
            control = 'q'
        
def route_info(g):
    """
    To get the route info
    """
    journey = []
    choice = "x"
    while(choice == "x"):
        choice = raw_input("Enter city name. One by one. q to quit")
        
        if(choice == "q"):
            distance, cost, time = stats.route_info(g, journey)
            return distance, cost, time
        else:
            journey.append(choice)
            choice = "x"
            
    
main()
