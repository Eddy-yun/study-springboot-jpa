package com.eddystation.study.springbootjpa.web.main;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@WebMvcTest( controllers = HelloController.class )
public class HelloControllerTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void hello가_리턴된다() throws Exception {

		String hello = "hello";

		mock.perform( get( "/hello" ) )
				.andExpect( status().isOk() )
				.andExpect( content().string( hello ) );
	}

}

