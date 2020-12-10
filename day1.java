
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class day1 {

	private static List<Integer> data = new ArrayList<>();

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	// Part 1
  	for (int num1 : data) {
  		for (int num2 : data) {
  			if (num1 + num2 == 2020) {
  				System.out.println(num1 * num2);
  			}
  		}
  	}

  	// Part 2
  	for (int num1 : data) {
  		for (int num2 : data) {
  			for (int num3 : data) {
  				if (num1 + num2 + num3 == 2020) {
  					System.out.println(num1 * num2 * num3);
  				}
  			}
  		}
  	}
  }

  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
	reader = new BufferedReader(new FileReader("day1_data.txt"));
	String line = reader.readLine();
	while (line != null) {
		data.add(Integer.parseInt(line));
		line = reader.readLine();
	}
	reader.close();
  }
}