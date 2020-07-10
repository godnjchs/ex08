package org.zerox.ex08.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void testList() throws Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception {
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","테스트 제목")
				.param("content","테스트 컨텐츠")
				.param("writer","테스트 글쓴이")
				).andReturn().getModelAndView().getViewName();
		System.out.println(result + "*******************");
	}
	
	@Test
	public void testGetone() throws Exception {
		ModelMap result = mockMvc.perform(MockMvcRequestBuilders.get("/board/getOne")
				.param("bno","2")
				
				).andReturn().getModelAndView().getModelMap();
		
		System.out.println(result);
	}
	
	@Test
	public void testUpdate() throws Exception{
		ModelMap semiResult = mockMvc.perform(MockMvcRequestBuilders.get("/board/getOne")
				.param("bno","1")
				
				).andReturn().getModelAndView().getModelMap();
		ModelMap result = mockMvc.perform(MockMvcRequestBuilders.post("/board/update")
				.param("bno","1")
				.param("title","업데이트 제목")
				.param("content","업데이트 컨텐츠")
				.param("writer","업데이트 글쓴이")
				).andReturn().getModelAndView().getModelMap();
		System.out.println(semiResult);
		System.out.println();
		System.out.println(result);
	}
	
	@Test
	public void deleteTest() throws Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders.post("/board/delete").param("bno","2")).andReturn().getModelAndView().getViewName());
	}
	
}
