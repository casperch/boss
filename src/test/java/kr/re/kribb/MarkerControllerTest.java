package kr.re.kribb;

import javax.servlet.http.HttpServlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@WebAppConfiguration
public class MarkerControllerTest {

	@Autowired
	WebApplicationContext wac;
	MockMvc mockMvc;
	HttpServlet servlet;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testMarker() throws Exception {
		mockMvc.perform(get("/marker")).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
		// fail("Not yet implemented");
	}

	@Test
	public void testMarkerDetail() throws Exception {
		mockMvc.perform(
				get("/markerDetail")
				.param("chrom", "C09")
				.param("loci", "17647"))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
}
