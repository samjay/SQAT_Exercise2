
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {

	private static final String NORTH = "N";
	private static final String EAST = "E";
	private static final String SOUTH = "S";
	private static final String WEST = "W";

	private static final String TURN_LEFT = "l";
	private static final String TURN_RIGHT = "r";

	private static final String FORWARD = "f";
	private static final String BACKWARD = "b";

	Planet planet;
	Integer xCoordinate = 0;
	Integer yCoordinate = 0;
	String facing = "";

	public PlanetExplorer(int x, int y, String obstacles) {
		/*
		 * x and y represent the size of the grid. Obstacles is a String
		 * formatted as follows:
		 * "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white
		 * spaces.
		 * 
		 * Example use: For a 100x100 grid with two obstacles at coordinates
		 * (5,5) and (7,8) PlanetExplorer explorer = new
		 * PlanetExplorer(100,100,"(5,5)(7,8)")
		 * 
		 */
		planet = new Planet();
		planet.setLength(x);
		planet.setWidth(y);
		if (!obstacles.equals("")) {
			planet.setObstacles(obstacles);
		}
		xCoordinate = 0;
		yCoordinate = 0;
		facing = NORTH;

	}

	public String executeCommand(String command) throws PlanetExplorerException {

		/*
		 * The command string is composed of "f" (forward), "b" (backward), "l"
		 * (left) and "r" (right) Example: The explorer is on a 100x100 grid at
		 * location (0, 0) and facing NORTH. The explorer is given the commands
		 * "ffrff" and should end up at (2, 2) facing East.
		 * 
		 * The return string is in the format:
		 * "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)"
		 * Where pos_x and pos_y are the final coordinates, facing is the
		 * current direction the explorer is pointing to (N,S,W,E). The return
		 * string should also contain a list of coordinates of the encountered
		 * obstacles. No white spaces.
		 */
		for (char singleCommand : command.toCharArray()) {
			String stringCommand = String.valueOf(singleCommand);
			if (stringCommand.equals(TURN_RIGHT)) {
				turnRight();
			} else if (stringCommand.equals(TURN_LEFT)) {
				turnLeft();
			} else if (stringCommand.equals(FORWARD)) {
				moveForward();
			} else if (stringCommand.equals(BACKWARD)) {
				moveBackWard();
			}
		}

		return createPositionString();
	}

	private String createPositionString() {
		return "(" + xCoordinate + "," + yCoordinate + "," + facing + ")";
	}

	public Planet getPlanet() {
		return this.planet;
	}

	private void turnRight() throws PlanetExplorerException {
		switch (facing) {
		case NORTH:
			facing = EAST;
			break;
		case EAST:
			facing = SOUTH;
			break;
		case SOUTH:
			facing = WEST;
			break;
		case WEST:
			facing = NORTH;
			break;
		default:
			throw new PlanetExplorerException();
		}
	}

	private void turnLeft() throws PlanetExplorerException {
		switch (facing) {
		case NORTH:
			facing = WEST;
			break;
		case EAST:
			facing = NORTH;
			break;
		case SOUTH:
			facing = EAST;
			break;
		case WEST:
			facing = SOUTH;
			break;
		default:
			throw new PlanetExplorerException();
		}
	}

	private void moveForward() throws PlanetExplorerException {
		switch (facing) {
		case NORTH:
			yCoordinate++;
			break;
		case EAST:
			xCoordinate++;
			break;
		case SOUTH:
			yCoordinate--;
			break;
		case WEST:
			xCoordinate--;
			break;
		default:
			throw new PlanetExplorerException();
		}
		wrap();

	}

	private void moveBackWard() throws PlanetExplorerException {
		switch (facing) {
		case NORTH:
			yCoordinate--;
			break;
		case EAST:
			xCoordinate--;
			break;
		case SOUTH:
			yCoordinate++;
			break;
		case WEST:
			xCoordinate++;
			break;
		default:
			throw new PlanetExplorerException();
		}
		wrap();

	}

	private void wrap() {
		if (xCoordinate < 0) {
			xCoordinate = planet.getLength() - 1;
		}
		if (xCoordinate == planet.getLength()) {
			xCoordinate = 0;
		}
		if (yCoordinate < 0) {
			yCoordinate = planet.getWidth() - 1;
		}
		if (yCoordinate == planet.getWidth()) {
			yCoordinate = 0;
		}
	}

}
