import java.util.ArrayList;
import java.util.List;

public class Planet {
	
	private int width;
	private int length;
	private List<Obstacle> obstacles;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<Obstacle> getObstacles() {
		
		return this.obstacles;
	}
	public void setObstacles(String obstacles2) throws PlanetExplorerException {
		obstacles = new ArrayList<>();
		String[] obstacleStrings=obstacles2.split("[)]");
		for(String obsString:obstacleStrings){
			obsString=obsString.substring(1, obsString.length());
			String[] coordinates=obsString.split("[,]");
			Obstacle obs= new Obstacle();
			int obsX=Integer.parseInt(coordinates[0]);
			int obsy=Integer.parseInt(coordinates[1]);
			if(obsX>=length || obsy>=width){
				throw new PlanetExplorerException();
			}
			obs.setX(obsX);
			obs.setY(obsy);
			obstacles.add(obs);
		}
	}	

}
