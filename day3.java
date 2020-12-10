
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class day3 {

	private static String[] data = new String[323]; // Manually check length of input file

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	// Part 1
  	int count = 0;
  	int right = 3;
  	int down = 1;
  	int[] pos = {0, 0}; // Row, Col
  	while (pos[0] < data.length) {
  		if (data[pos[0]].charAt(pos[1]) == '#') {
  			count++;
  		}
  		pos[0] += down;
  		pos[1] += right;
  		pos[1] %= data[0].length();
  	}
  	System.out.println(count);

  	// Part 2
  	long answer = 1;
  	int[][] pairs = {{3, 1}, {1, 1}, {5, 1}, {7, 1}, {1, 2}};
  	for (int[] pair : pairs) {
  		count = 0;
	  	right = pair[0];
	  	down = pair[1];
	  	pos = new int[] {0, 0}; // Row, Col
	  	while (pos[0] < data.length) {
	  		if (data[pos[0]].charAt(pos[1]) == '#') {
	  			count++;
	  		}
	  		pos[0] += down;
	  		pos[1] += right;
	  		pos[1] %= data[0].length();
  		}
  		System.out.println("Count :" + count);
  		answer *= count;
  		System.out.println("Current Answer: " + answer);

  	}
  	System.out.println(answer);
  }

  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day3_data.txt"));

  	String line = reader.readLine(); int i = 0;
  	while (line != null) {
  		data[i] = line; i++;
  		line = reader.readLine();
  	}
  	reader.close();
    }
}