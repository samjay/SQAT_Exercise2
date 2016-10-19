import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer explorer= new PlanetExplorer(100, 100, "");

	@Test
	public void test_createPlanet_size100x100() {
		Planet planet = explorer.getPlanet();
		
		assertEquals(100, planet.getWidth());
		assertEquals(100, planet.getLength());
	}
	
	@Test
	public void test_executeCommand_atStart_explorer_00N(){		
		
		String position=explorer.executeCommand("");
		
		assertEquals("(0,0,N)", position);
	}
	
	@Test
	public void test_executeCommand_turnRight_NtoE(){		
		
		String position=explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", position);
	}
	
	@Test
	public void test_executeCommand_turnLeft_NtoW(){		
		
		String position=explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", position);
	}
}
