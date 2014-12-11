package dal;

import beans.Route;
import beans.RouteType;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 04.12.2014.
 */
public class DAL
{
    private String routesPath = System.getProperty("user.dir") + File.separator + "trunk" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "routes.csv";
    private String sprit_dbPath = System.getProperty("user.dir") + File.separator + "trunk" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "sprit_db.csv";

    public LinkedList<Route> getRoutes() throws IOException
    {
        LinkedList<Route> routes = new LinkedList<Route>();
        BufferedReader br = new BufferedReader(new FileReader(routesPath));
        String line;
        while ((line = br.readLine()) != null)
        {
            String[] data = line.split(";");
            double distance = Double.parseDouble(data[0]);
            RouteType typeOfRoute = RouteType.valueOf(data[1]);
            double slope = Double.parseDouble(data[2]);
            double specialFee = Double.parseDouble(data[3]);
            Route route = new Route(distance, typeOfRoute, slope, specialFee);
            routes.add(route);
        }
        return routes;
    }
}
