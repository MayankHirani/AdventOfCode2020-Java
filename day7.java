
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class day7 {

	private static String[] data = new String[594]; // Manually check length of input file

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	System.out.println(Arrays.toString(data));
    // Part 1

  }


  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day7_data.txt"));

  	String line = reader.readLine(); int i = 0;
  	while (line != null) {
  		data[i] = line; i++;
  		line = reader.readLine();
  	}
  	reader.close();
  }
}