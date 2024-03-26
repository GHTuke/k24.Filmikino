package k24.Filmikino;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class RestTest {
	
	@Autowired
	private WebApplicationContext webappc;
	private MockMvc mockmvc;
	
	@BeforeEach
	public void testSetup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webappc).build();
	}
	
	@Test
	public void moviesStatusOk() throws Exception {
		mockmvc.perform(get("/movies"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void movieByIdStatusOk() throws Exception {
		mockmvc.perform(get("/movie/{id}", 0L))
			//.andDo(print()) //remove comment here if you want the result in console
			.andExpect(status().isOk());
	}
	
	@Test
	public void moviesTypeOfJson() throws Exception {
		mockmvc.perform(get("/movies"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void screensStatusOk() throws Exception {
		mockmvc.perform(get("/screens"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void showingsStatusOk() throws Exception {
		mockmvc.perform(get("/showings"))
		.andExpect(status().isOk());
	}

}
