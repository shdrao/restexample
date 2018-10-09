package com.capgemini.rest.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.rest.SimpleController;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest
public class RestTest {

	@InjectMocks
	private SimpleController simpleController;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(simpleController).build();
	}
	
	@Test
	public void testHelloWhichReturnsString() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("HelloWorld"));
	}

	@Test
	public void testDisplayWorkerWhichReturndWorker() throws Exception {
		mockMvc.perform(get("/worker")).andExpect(status().isOk()).andExpect(content().json(
				"{\"name\":\"ABC\",\"id\":123}"));
	}
	
	@Test
	public void testSuccessWhichReturnsString() throws Exception {
		mockMvc.perform(post("/test").contentType(MediaType.APPLICATION_JSON).content
			("{\r\n"+"\"name\":\"ABC\",\r\n"+"\"id\":123\r\n"+"}").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().string("success"));
	}
}
