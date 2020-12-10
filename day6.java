
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class day6 {

	private static String[] data = new String[2248]; // Manually check length of input file

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	System.out.println(Arrays.toString(data));
  }


  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day6_data.txt"));

  	String line = reader.readLine(); int i = 0;
  	while (line != null) {
  		data[i] = line; i++;
  		line = reader.readLine();
  	}
  	reader.close();
  }
}