package br.com.sinn.resource;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
class CompanyControllerTest {

	@Before
    public void beforeTestCase() {
        RestAssuredMockMvc.standaloneSetup(new CompanyController());
    }
	
	@Test
	void testCompanySave() {
	}

}
