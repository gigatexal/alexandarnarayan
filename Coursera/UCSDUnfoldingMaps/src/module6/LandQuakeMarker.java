package module6;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// IMPLEMENT: drawing circle for LandQuake
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		pg.ellipse(x, y, 2*radius, 2*radius);
		
	}
	

	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}

	//auto added
	@Override
	public int compareTo(EarthquakeMarker marker) {
		// TODO Auto-generated method stub

		float mag1 = this.getMagnitude();
		float mag2 = marker.getMagnitude();
		int result = 0;
		if (mag1 < mag2){
			result = 1;
		}
		else if (mag1 > mag2){
			result = -1;
		}
		else {
			result = 0;
		}
		
		return result;
	}
}
		
