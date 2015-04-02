package com.ame.bus3.common;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Holds the location of something on the game map.
 * @author Amelorate
 *
 */
public class Coordinate implements JSONAware {
	public Coordinate() {}

	public Coordinate(int x, int y, int z, String level) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.level = level;
	}

	public Coordinate(JSONObject object) {
		try {
			Long xLong = (Long) object.get("x");	// Wish you could cast a Boxed long to a primitive int in one step.
			x = xLong.intValue();
			Long yLong = (Long) object.get("y");
			y = yLong.intValue();
			Long zLong = (Long) object.get("z");
			z = zLong.intValue();
			level = (String) object.get("level");
		}
		catch (ClassCastException e) {
			throw new IllegalArgumentException("JsonObject lacks a x, y, z, or level field of the right type.", e);
		}
	}

	@Override
	public String toString() {
		Integer x = this.x;
		Integer y = this.y;
		Integer z = this.z;		// I do this because you can't call toString on a primitive like an int.

		return x.toString() + "," + y.toString() + "," + z.toString() + "," + level;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();	// This probably does have it's flaws, but it's better than the alternatives.
	}

	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject();

		json.put("x", x);
		json.put("y", y);
		json.put("z", z);
		json.put("level", level);

		return  json.toString();
	}
	
	public int x;
	public int y;
	public int z;
	public String level;


}
