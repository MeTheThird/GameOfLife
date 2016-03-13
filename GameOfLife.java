package GameOfLife;

import apcs.*;

public class GameOfLife {
	
	static boolean [][] grid;
	static int size = 10;
	static int width = 50;
	static int height = 50;

	public static void main(String[] args) {
		Window.size(width * size, height * size);
		initialize();
		Window.frame();
		
		while (true) {
			draw();
			move();
			mouse();
			pulsar();
			pentadecathlon();
			glider();
			if (Window.key.pressed("c")) {
				clear();
			}
			Window.frame(100);
			
		}
	}
	
	private static void mouse() {
		if (Window.mouse.clicked()) {
			int x = Window.mouse.getX() / size;
			int y = Window.mouse.getY() / size;
			
				grid[x][y] = ! grid[x][y];
		}
	}
	
	public static void glider() {
		int x = Window.mouse.getX() / size;
		int y = Window.mouse.getY() / size;
		if (Window.key.pressed("g") && x > 0 && x < width - 1 && y > 0 && y < height - 1) {
		
			grid[x][y] = true;
			grid[x + 1][y] = true;
			grid[x][y + 1] = true;
			grid[x - 1][y + 1] = true;
			grid[x - 1][y - 1] = true;
		}
	}
	
	public static void clear() {
		for (int x = 0 ; x < width ; x++) {
			for (int y = 0 ; y < height ; y++) {
				grid[x][y] = false;
			}
		}
	}
	
	public static void pentadecathlon() {
		int x = Window.mouse.getX() / size;
		int y = Window.mouse.getY() / size;
		if (Window.key.pressed("e") && x > 4 && x < width - 4 && y > 0 && y < height - 1) {
		
			grid[x][y] = true;
			grid[x + 1][y] = true;
			grid[x - 1][y] = true;
			grid[x - 2][y] = true;
			grid[x + 2][y - 1] = true;
			grid[x + 2][y + 1] = true;
			grid[x + 3][y] = true;
			grid[x + 4][y] = true;
			grid[x - 3][y + 1] = true;
			grid[x - 3][y - 1] = true;
			grid[x - 4][y] = true;
			grid[x - 5][y] = true;
		}
	}
	
	public static void pulsar() {
		int x = Window.mouse.getX() / size;
		int y = Window.mouse.getY() / size;
		if (Window.key.pressed("p") && x > 5 && x < width - 6 && y > 5 && y < height - 6) {
		
			grid[x + 2][y - 1] = true;
			grid[x + 3][y - 1] = true;
			grid[x + 4][y - 1] = true;
			grid[x + 6][y - 2] = true;
			grid[x + 6][y - 3] = true;
			grid[x + 6][y - 4] = true;
			grid[x + 1][y - 2] = true;
			grid[x + 1][y - 3] = true;
			grid[x + 1][y - 4] = true;
			grid[x + 2][y - 6] = true;
			grid[x + 3][y - 6] = true;
			grid[x + 4][y - 6] = true;
			
			
			grid[x - 2][y - 1] = true;
			grid[x - 3][y - 1] = true;
			grid[x - 4][y - 1] = true;
			grid[x - 6][y - 2] = true;
			grid[x - 6][y - 3] = true;
			grid[x - 6][y - 4] = true;
			grid[x - 1][y - 2] = true;
			grid[x - 1][y - 3] = true;
			grid[x - 1][y - 4] = true;
			grid[x - 2][y - 6] = true;
			grid[x - 3][y - 6] = true;
			grid[x - 4][y - 6] = true;
			
			
			grid[x - 2][y + 1] = true;
			grid[x - 3][y + 1] = true;
			grid[x - 4][y + 1] = true;
			grid[x - 6][y + 2] = true;
			grid[x - 6][y + 3] = true;
			grid[x - 6][y + 4] = true;
			grid[x - 1][y + 2] = true;
			grid[x - 1][y + 3] = true;
			grid[x - 1][y + 4] = true;
			grid[x - 2][y + 6] = true;
			grid[x - 3][y + 6] = true;
			grid[x - 4][y + 6] = true;
			
			
			grid[x + 2][y + 1] = true;
			grid[x + 3][y + 1] = true;
			grid[x + 4][y + 1] = true;
			grid[x + 6][y + 2] = true;
			grid[x + 6][y + 3] = true;
			grid[x + 6][y + 4] = true;
			grid[x + 1][y + 2] = true;
			grid[x + 1][y + 3] = true;
			grid[x + 1][y + 4] = true;
			grid[x + 2][y + 6] = true;
			grid[x + 3][y + 6] = true;
			grid[x + 4][y + 6] = true;
		}
		
	}
	
	public static void initialize() {
		grid = new boolean[width][height];
		
		for (int x = 0 ; x < width ; x++) {
			for (int y = 0 ; y < height ; y++) {
				grid[x][y] = Window.flipCoin();
			}
		}
	}
	
	public static void draw() {
		Window.out.background("white");
		
		Window.out.color("orange");
		// For every column,
		for (int x = 0 ; x < width ; x++ ) {
			// Go to every valid y position in that column
			for (int y = 0 ; y < height ; y++) {
				if (grid[x][y]) {
					Window.out.square(x * 10 + 5, y * 10 + 5, 10);
				}
			}
		}
	}
	
	public static void move() {
		boolean[][] newGrid = new boolean[width][height];
		
		for (int x = 0 ; x < width ; x++) {
			for (int y = 0 ; y < height ; y++) {
				int count = 0;
				
				if (x > 0 && y > 0 && grid[x - 1][y - 1]) {
					count++;
				}
				
				if (y > 0 && grid[x][y - 1]) {
					count++;
				}
				
				if (x < height - 1 && y > 0 && grid[x + 1][y - 1]) {
					count++;
				}
				
				if (x < height - 1 && grid[x + 1][y]) {
					count++;
				}
				
				if (x < height - 1 && y < height - 1 && grid[x + 1][y + 1]) {
					count++;
				}
				
				if (y < height - 1 && grid[x][y + 1]) {
					count++;
				}
				
				if (x > 0 && y < height - 1 &&grid[x - 1][y + 1]) {
					count++;
				}
				
				if (x > 0 && grid[x - 1][y]) {
					count++;
				}
				
				// Survival rule or reproduction rule:
				//   alive     and        2    or  3 neighbors
				if ((grid[x][y] && (count == 2 || count == 3)) ||
					// dead      and   3 neighbors
					(! grid[x][y] && count == 3)) {
						newGrid[x][y] = true;
				}
			}
		}
		
		
		grid = newGrid;
	}

}
