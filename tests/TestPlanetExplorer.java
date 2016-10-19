import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_createPlanet_size100x100() {
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		Planet planet = explorer.getPlanet();
		
		assertEquals(100, planet.getWidth());
		assertEquals(100, planet.getLength());
	}
}
