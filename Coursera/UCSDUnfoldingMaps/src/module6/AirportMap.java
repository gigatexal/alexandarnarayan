package module6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.data.ShapeFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.geo.Location;
import parsing.ParseFeed;
import processing.core.PApplet;

/** An applet that shows airports (and routes)
 * on a world map.  
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMap extends PApplet {
	
	UnfoldingMap map;
	private List<Marker> airportList;
	List<Marker> routeList;
	
	private CommonMarker lastSelected;
	private CommonMarker lastClicked;
	//*********************************************************************************************
	HashMap<Marker,Marker> portsAndDests = new HashMap<Marker,Marker>();
	//*********************************************************************************************
	
	public void setup() {
		// setting up PAppler
		
		
		
		// setting up map and default events
		map = new UnfoldingMap(this, 50, 50, 750, 550);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// get features from airport data
		List<PointFeature> features = ParseFeed.parseAirports(this, "airports.dat");
		
		// list for markers, hashmap for quicker access when matching with routes
		airportList = new ArrayList<Marker>();
		
		HashMap<Integer, Location> airports = new HashMap<Integer, Location>();
		
		
		// create markers from features
		for(PointFeature feature : features) {
			AirportMarker m = new AirportMarker(feature);
	
	
			m.setRadius(5);
			airportList.add(m);
			
			// put airport in hashmap with OpenFlights unique id for key
			airports.put(Integer.parseInt(feature.getId()), feature.getLocation());
		
		}
		
		
		// parse route data
		List<ShapeFeature> routes = ParseFeed.parseRoutes(this, "routes.dat");
		routeList = new ArrayList<Marker>();
		for(ShapeFeature route : routes) {
			
			// get source and destination airportIds
			int source = Integer.parseInt((String)route.getProperty("source"));
			int dest = Integer.parseInt((String)route.getProperty("destination"));
			
			// get locations for airports on route
			if(airports.containsKey(source) && airports.containsKey(dest)) {
				route.addLocation(airports.get(source));
				route.addLocation(airports.get(dest));
			}
			
			SimpleLinesMarker sl = new SimpleLinesMarker(route.getLocations(), route.getProperties());
			sl.setColor(color(0,0,128));
			
			//System.out.println(sl.getProperties());
			
			//UNCOMMENT IF YOU WANT TO SEE ALL ROUTES
			routeList.add(sl);
		}
		
		System.out.println("length of airportList is");
		System.out.println(airportList.size());
		System.out.println("length of routeList is");
		System.out.println(routeList.size());
		
		for (Marker m: routeList){
			System.out.println(m.getProperties());
		}
		
		for (int i = 0; i < airports.size(); i++){
			System.out.println(airports.get(i));
			
		}
		
		//UNCOMMENT IF YOU WANT TO SEE ALL ROUTES
		map.addMarkers(routeList);
		
		map.addMarkers(airportList);
		size(800,600, OPENGL);
	}
	
	public void draw() {
		background(0);
		map.draw();
		
	}
	
	@Override
	public void mouseClicked()
	{
		if (lastClicked != null) {
			unhideMarkers();
			lastClicked = null;
		}
		else if (lastClicked == null) 
		{
			checkEarthquakesForClick();
			if (lastClicked == null) {
				//checkCitiesForClick();
			}
		}
	}
	
	// Helper method that will check if a city marker was clicked on
	// and respond appropriately
	private void checkCitiesForClick()
	{
		if (lastClicked != null) return;
		// Loop over the earthquake markers to see if one of them is selected
		for (Marker marker : airportList) {
			if (!marker.isHidden() && marker.isInside(map, mouseX, mouseY)) {
				lastClicked = (CommonMarker)marker;
				// Hide all the other earthquakes and hide
				for (Marker mhide : airportList) {
					if (mhide != lastClicked) {
						mhide.setHidden(true);
					}
				}/*
				for (Marker mhide : airportList) {
					EarthquakeMarker quakeMarker = (EarthquakeMarker)mhide;
					if (quakeMarker.getDistanceTo(marker.getLocation()) 
							> quakeMarker.threatCircle()) {
						quakeMarker.setHidden(true);
					}
				}*/
				return;
			}
		}		
	}
	
	// Helper method that will check if an earthquake marker was clicked on
	// and respond appropriately
	private void checkEarthquakesForClick()
	{
		if (lastClicked != null) return;
		// Loop over the earthquake markers to see if one of them is selected
		for (Marker m : airportList) {
			AirportMarker marker = (AirportMarker)m;
			if (!marker.isHidden() && marker.isInside(map, mouseX, mouseY)) {
				lastClicked = marker;
				// Hide all the other earthquakes and hide
				for (Marker mhide : routeList) {
					if (mhide != lastClicked) {
						//airportList.
						mhide.setHidden(true);
						
						for (Marker a: routeList){
							//System.out.println(a);
							
						}
					}
				for (Marker routes : routeList) {
						if (routes != lastClicked) {
							routes.setHidden(true);
						}
						
				}
				/*for (Marker mhide : airportList) {
					if (mhide.getDistanceTo(marker.getLocation()) 
							> marker.threatCircle()) {
						mhide.setHidden(true);
					}
				}
				*/
				return;
			}
			}
		}
	}
	
	// loop over and unhide all markers
	private void unhideMarkers() {
		for(Marker marker : airportList) {
			marker.setHidden(false);
		}
		/*	
		for(Marker marker : airportList) {
			marker.setHidden(false);
		}*/
	}


	@Override
	public void mouseMoved()
	{
		// clear the last selection
		if (lastSelected != null) {
			lastSelected.setSelected(false);
			lastSelected = null;
		
		}
		//selectMarkerIfHover(quakeMarkers);
		//selectMarkerIfHover(cityMarkers);
		//loop();
	}




}
