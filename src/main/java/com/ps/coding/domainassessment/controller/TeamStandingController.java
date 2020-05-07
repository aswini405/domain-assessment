/**
 * 
 */
package com.ps.coding.domainassessment.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps.coding.domainassessment.service.ITeamStandingService;

/**
 * @author aswini.nellimarla
 *
 */
@RestController
public class TeamStandingController {

	@Autowired
	private ITeamStandingService iTeamStandingService;

	@Value("${API_KEY}")
	private String apiKey;

	@GetMapping("standings")
	public ResponseEntity<String> getTeamStandings(@RequestParam(value = "action") String action,
			@RequestParam(value = "league_id") String leagueId) throws MalformedURLException, ProtocolException, IOException {
		String response = iTeamStandingService.teamStandings(action, leagueId, apiKey);
		return ResponseEntity.ok().body(response);

	}

}
