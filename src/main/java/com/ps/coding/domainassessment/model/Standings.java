/**
 * 
 */
package com.ps.coding.domainassessment.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aswini.nellimarla
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonFilter("myFilter")
public class Standings {

	@JsonProperty("league_name")
	private String leagueName;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("league_id")
	private Integer leagueId;

	@JsonProperty("team_id")
	private Integer teamId;

	@JsonProperty("overall_league_position")
	private Integer overallPos;

	@JsonProperty("country_name")
	private String countryName;

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the leagueName
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @param leagueName the leagueName to set
	 */
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the leagueId
	 */
	public Integer getLeagueId() {
		return leagueId;
	}

	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * @return the teamId
	 */
	public Integer getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the overallPos
	 */
	public Integer getOverallPos() {
		return overallPos;
	}

	/**
	 * @param overallPos the overallPos to set
	 */
	public void setOverallPos(Integer overallPos) {
		this.overallPos = overallPos;
	}

}
