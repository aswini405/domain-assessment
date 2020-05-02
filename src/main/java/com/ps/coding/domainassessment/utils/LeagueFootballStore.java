/**
 * 
 */
package com.ps.coding.domainassessment.utils;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author aswini.nellimarla
 *
 */
public class LeagueFootballStore {

	private static ObjectMapper mapper = new ObjectMapper();

	public static String populateStore() {
		ObjectNode finalNode = mapper.createObjectNode();
		ObjectNode objectNode = mapper.createObjectNode();

		objectNode.set("Country", mapper.valueToTree(populateDetails(3, "India")));
		objectNode.set("League", mapper.valueToTree(populateDetails(9, "Premium League")));
		objectNode.set("Team", mapper.valueToTree(populateDetails(5, "SPRTANS")));
		objectNode.set("Overall League Position", mapper.valueToTree(populatePos(1)));

		finalNode.set("Standings", mapper.valueToTree(objectNode));
		return finalNode.toString();
	}
	private static Object populatePos(int pos) {
		JSONObject object = new JSONObject();
		object.put("position", pos);
		return object;
	}
	private static Object populateDetails(int id, String name) {
		JSONObject object = new JSONObject();
		object.put("id", id);
		object.put("name", name);
		return object;
	}
}
