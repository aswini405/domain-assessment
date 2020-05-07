/**
 * 
 */
package com.ps.coding.domainassessment.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ps.coding.domainassessment.model.RequestBody;
import com.ps.coding.domainassessment.model.Standings;
import com.ps.coding.domainassessment.utils.LeagueFootballStore;

/**
 * @author aswini.nellimarla
 *
 */
@Service
public class TeamStandingService implements ITeamStandingService {

	@Value("${SERVICE_URL}")
	private String serviceUrl;

	@Override
	public String teamStandings(RequestBody request) {
		System.out.println("Service layer");
		return LeagueFootballStore.populateStore();
	}

	@Override
	public String teamStandings(String action, String leagueId, String apiKey) throws IOException {
		URL url = new URL(serviceUrl);
		String urlParams = "action=" + action + "&league_id=" + leagueId + "&APIkey=" + apiKey;
		byte[] requestData = urlParams.getBytes(StandardCharsets.UTF_8);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Length", String.valueOf(requestData.length));
		con.setDoOutput(true);

		System.out.println("Request URL for GET method: " + url);
		try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			wr.write(requestData);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer response = new StringBuffer();

		try {
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} finally {
			in.close();
		}
		System.out.println("Response " + response.toString());
		ObjectMapper mapper = new ObjectMapper();
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		// only 'name' and 'age' will be serialized
		filterProvider.addFilter("myFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("country_name", "league_id", "league_name"));
		// mapper.setFilterProvider(filterProvider);
//		List result = mapper.readValue(response.toString(), List.class);
//		String jsonString = new Gson().toJson(result.get(0), Map.class);
//		System.out.println(jsonString);
//		Standings obj = mapper.readValue(response.toString(), List<Standings>.class);
		List<Standings> obj = Arrays.asList(mapper.readValue(response.toString(), Standings[].class));
		//System.out.println(obj.get(0).getCountryName());
		// System.out.println(result.get(0).getCountryName());
		return mapper.writeValueAsString(obj);
	}

}
