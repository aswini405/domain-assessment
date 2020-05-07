/**
 * 
 */
package com.ps.coding.domainassessment.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import junit.framework.Assert;

/**
 * @author aswini.nellimarla
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TeamStandingServiceTest {

	@InjectMocks
	private TeamStandingService service;

	private Field url;
	Class clazz;

	@Before
	public void setup()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		url = TeamStandingService.class.getDeclaredField("serviceUrl");
		url.setAccessible(true);
		url.set(service, "https://apiv2.apifootball.com/");
	}

	@Test
	public void testTeamStandings() {
		service.teamStandings(null);
	}

	@Test
	public void testTeamStandingsReal() throws IOException {
		service.teamStandings("get_standings", "148",
				"9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
	}

	@Test
	public void testTeamStandingsReal404() throws IOException {
		String response = service.teamStandings("get_standings2", "148", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		assertEquals("[]", response);
	}

}
