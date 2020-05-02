/**
 * 
 */
package com.ps.coding.domainassessment.service;

import org.springframework.stereotype.Service;

import com.ps.coding.domainassessment.model.RequestBody;
import com.ps.coding.domainassessment.utils.LeagueFootballStore;

/**
 * @author aswini.nellimarla
 *
 */
@Service
public class TeamStandingService implements ITeamStandingService {

	@Override
	public String teamStandings(RequestBody request) {
		System.out.println("Service layer");
		return LeagueFootballStore.populateStore();
	}

}
