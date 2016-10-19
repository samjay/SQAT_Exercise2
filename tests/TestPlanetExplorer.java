import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	

	@Test
	public void test_createPlanet_size100x100() throws PlanetExplorerException {
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		Planet planet = explorer.getPlanet();
		
		assertEquals(100, planet.getWidth());
		assertEquals(100, planet.getLength());
	}
	
	@Test
	public void test_executeCommand_atStart_explorer_00N() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		String position=explorer.executeCommand("");
		
		assertEquals("(0,0,N)", position);
	}
	
	@Test
	public void test_executeCommand_turnRight_NtoE() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		String position=explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", position);
	}
	
	@Test
	public void test_executeCommand_turnLeft_NtoW() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		String position=explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", position);
	}
	
	@Test
	public void test_executeCommand_turnRight_EtoS() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("r");
		String position=explorer.executeCommand("r");
		
		assertEquals("(0,0,S)", position);
	}
	
	@Test
	public void test_executeCommand_turnLeft_WtoS() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("l");
		String position=explorer.executeCommand("l");
		
		assertEquals("(0,0,S)", position);
	}
	
	@Test
	public void test_executeCommand_moveForward_00Nto01N() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		String position=explorer.executeCommand("f");
		
		assertEquals("(0,1,N)", position);
	}
	
	@Test
	public void test_executeCommand_moveBackWard_00Wto10W() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("l");
		String position=explorer.executeCommand("b");
		
		assertEquals("(1,0,W)", position);
	}
	
	@Test
	public void test_executeCommand_moveforwardtoFacing_00Eto10E() throws PlanetExplorerException{	
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("r");
		String position=explorer.executeCommand("f");
		
		assertEquals("(1,0,E)", position);
	}
	
	@Test
	public void test_executeCommand_movebackWardtoFacing_00Sto01S() throws PlanetExplorerException{	
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("r");
		explorer.executeCommand("r");
		String position=explorer.executeCommand("b");
		
		assertEquals("(0,1,S)", position);
	}
	
	@Test
	public void test_executeCommand_severalCommandString_00Nto22E() throws PlanetExplorerException{	
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		String position=explorer.executeCommand("ffrff");
		
		assertEquals("(2,2,E)", position);
	}
	
	@Test
	public void test_executeCommand_wrap_moveBack_00Nto099N() throws PlanetExplorerException{		
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
	
		String position=explorer.executeCommand("b");
		
		assertEquals("(0,99,N)", position);
	}
	
	@Test
	public void test_executeCommand_wrap_moveForward_00Wto990N() throws PlanetExplorerException{	
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		explorer.executeCommand("l");
		String position=explorer.executeCommand("f");
		
		assertEquals("(99,0,W)", position);
	}
	
	@Test
	public void test_executeCommand_wrap_moveForward_990Nto00N() throws PlanetExplorerException{	
		PlanetExplorer explorer= new PlanetExplorer(100, 100, "");
		for(int i=0;i<99;i++){
			explorer.executeCommand("f");
		}
		String position=explorer.executeCommand("f");
		
		assertEquals("(0,0,N)", position);
	}
	
	@Test
	public void test_placeObstacles_1n1_4n5() throws PlanetExplorerException{
		PlanetExplorer explorerWithObs= new PlanetExplorer(6, 6, "(1,1)(4,5)");
		int obs2YCoor=explorerWithObs.getPlanet().getObstacles().get(1).getY();
		
		assertEquals(5, obs2YCoor);
	}
	
	@Test(expected=PlanetExplorerException.class)
	public void test_placeObstaclesOutOfGrid_shouldFail() throws PlanetExplorerException{
		PlanetExplorer explorerWithObs= new PlanetExplorer(6, 6, "(7,1)(4,7)");

	}
	
	@Test
	public void test_executeCommandWithObstacles() throws PlanetExplorerException{
		PlanetExplorer explorerWithObs= new PlanetExplorer(6, 6, "(2,2)");
		String position= explorerWithObs.executeCommand("ffrfff");
		
		assertEquals("(1,2,E)(2,2)", position);
	}
}
