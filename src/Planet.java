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
	public void setObstacles(String obstacles2) {
		obstacles = new ArrayList<>();
		String[] obstacleStrings=obstacles2.split("[)]");
		for(String obsString:obstacleStrings){
			obsString=obsString.substring(1, obsString.length());
			String[] coordinates=obsString.split("[,]");
			Obstacle obs= new Obstacle();
			obs.setX(Integer.parseInt(coordinates[0]));
			obs.setY(Integer.parseInt(coordinates[1]));
			obstacles.add(obs);
		}
	}	

}
