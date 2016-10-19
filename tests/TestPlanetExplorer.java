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
	public void test_executeCommand_atStart_explorer_00N() throws PlanetExplorerException{		
		
		String position=explorer.executeCommand("");
		
		assertEquals("(0,0,N)", position);
	}
	
	@Test
	public void test_executeCommand_turnRight_NtoE() throws PlanetExplorerException{		
		
		String position=explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", position);
	}
	
	@Test
	public void test_executeCommand_turnLeft_NtoW() throws PlanetExplorerException{		
		
		String position=explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", position);
	}
	
	@Test
	public void test_executeCommand_turnRight_EtoS() throws PlanetExplorerException{		
		
		explorer.executeCommand("r");
		String position=explorer.executeCommand("r");
		
		assertEquals("(0,0,S)", position);
	}
	
	@Test
	public void test_executeCommand_turnLeft_WtoS() throws PlanetExplorerException{		
		
		explorer.executeCommand("l");
		String position=explorer.executeCommand("l");
		
		assertEquals("(0,0,S)", position);
	}
	
	@Test
	public void test_executeCommand_moveForward_00Nto01N() throws PlanetExplorerException{		
	
		String position=explorer.executeCommand("f");
		
		assertEquals("(0,1,N)", position);
	}
	
	@Test
	public void test_executeCommand_moveBackWard_00Nto10N() throws PlanetExplorerException{		
		explorer.executeCommand("l");
		String position=explorer.executeCommand("b");
		
		assertEquals("(1,0,W)", position);
	}
}
