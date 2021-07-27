package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Triangolo;

class testCoperturaMinimaAreaTriangolo {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	  
	
	@Test
	void testArea1() {
		int latoA = 10;
		int latoB = 5;
		int latoC = 6;
		Triangolo T1 = new Triangolo(latoA,latoB,latoC);
		Double area = T1.getArea();
		assertTrue("Area errata",area > 11);
	}

}
