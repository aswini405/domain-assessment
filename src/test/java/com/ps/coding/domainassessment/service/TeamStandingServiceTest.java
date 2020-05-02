/**
 * 
 */
package com.ps.coding.domainassessment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author aswini.nellimarla
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TeamStandingServiceTest {

	@InjectMocks
	private TeamStandingService service;

	@Test
	public void testTeamStandings() {
		service.teamStandings(null);
	}

}
