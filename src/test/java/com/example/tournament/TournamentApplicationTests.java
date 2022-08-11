package com.example.tournament;

import com.example.tournament.controller.CoachController;
import com.example.tournament.domain.Coach;
import com.example.tournament.dto.RequestCoach;
import com.example.tournament.repo.CoachRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoachController.class)
@ContextConfiguration(classes=TournamentApplication.class)

class TournamentApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	CoachRepository coachRepo;

	Coach coach1 = new Coach(10, "Ime", "Udoku");
	Coach coach2 = new Coach(11, "Ed", "Alex");
	Coach coach3 = new Coach(12, "Alex", "Len");
	@Test
	public void getAllRecords_success() throws Exception {
		List<Coach> records = new ArrayList<>(Arrays.asList(coach1, coach2, coach3));

		Mockito.when(coachRepo.findAll()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
						.get("/coach/list")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].firstName", Matchers.is("Ed")));
	}

}
