import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class pointConnection extends Frame {

	private static int xDimension = 400, yDimension = 400;
	private static int numberOfPoints = 10;
	private static int dotWidth = 10, dotHeight = 10;
	public static int[][] pointArray = new int[numberOfPoints][3]; 
	
	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		pointJoin frame = new pointJoin();
		frame.setVisible(true);
		frame.setBackground(Color.black);
		frame.setTitle("Point Connection");
		frame.setSize(xDimension, yDimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resetPoints(numberOfPoints);
			for(int r = 0; r < numberOfPoints; r++) {
				setNewPoint(r, rand.nextInt((int) (xDimension * 0.90)) + 15, rand.nextInt((int) (yDimension * 0.75)) + 35 , 1);
				System.out.print("Number:" + r);
				System.out.print(" X: " + pointArray[r][0]);
				System.out.println(" Y: " + pointArray[r][1]);
				frame.repaint();
				Thread.sleep(100);
			}
	}
	
	static class pointJoin extends JFrame{
		public void paint(Graphics g) {
			Graphics2D g1 = (Graphics2D) g;
				g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
				g1.setColor(Color.white);
				for(int x = 0; x < numberOfPoints; x++) {
				g1.fillOval(pointArray[x][0], pointArray[x][1], dotWidth, dotHeight);
				for(int y = x - 1; y >= 0; y--) {
					if(x != y && pointArray[y][2] == 1 && pointArray[x][0] != 0 && pointArray[x][1] != 0) {
						g1.drawLine(pointArray[x][0] + (dotWidth / 2), pointArray[x][1] + (dotHeight / 2), pointArray[y][0]  + (dotWidth / 2), pointArray[y][1] + (dotHeight / 2));
					}
				}
			}
		}
	}

	public static void setNewPoint(int number, int x, int y, int active) {
		pointArray[number][0] = x;
		pointArray[number][1] = y;
		pointArray[number][2] = active;
	}

	public static void resetPoints(int numberOfPoints) {
		for(int i = 0; i < numberOfPoints; i++) {
			pointArray[i][0] = 0;
			pointArray[i][1] = 0;
			pointArray[i][2] = 0;
		}
	}
	
}
