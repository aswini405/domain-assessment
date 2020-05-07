/**
 * 
 */
package com.ps.coding.domainassessment.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import com.ps.coding.domainassessment.exception.NotFoundException;
import com.ps.coding.domainassessment.model.RequestBody;

/**
 * @author aswini.nellimarla
 *
 */
public interface ITeamStandingService {

	String teamStandings(RequestBody request);

	String teamStandings(String action, String leagueId, String apiKey)
			throws MalformedURLException, ProtocolException, IOException, NotFoundException;

}
