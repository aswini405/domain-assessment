package com.ps.coding.domainassessment.function;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.ps.coding.domainassessment.model.RequestBody;
import com.ps.coding.domainassessment.service.ITeamStandingService;

@Component
public class TeamStandings implements Function<Message<RequestBody>, String> {

	@Autowired
	private ITeamStandingService iTeamStandingService;

	@Override
	public String apply(Message<RequestBody> body) {
		RequestBody request = body.getPayload();
		System.out.println("Function layer");
		String response = iTeamStandingService.teamStandings(request);
		return response;
	}

}
