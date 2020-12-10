
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class day2 {

	private static List<String> data = new ArrayList<>();

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	// Part 1
    int totalCount = 0;
    for (String passport : data) {
      int low = Integer.parseInt(passport.split("-")[0]);
      int high = Integer.parseInt(passport.split("-")[1].split(" ")[0]);
      int count = 0;
      for (int i = 0; i < passport.split(" ")[2].length(); i++) {
        if ((passport.split(" ")[2].charAt(i)) == passport.split(" ")[1].replace(":", "").charAt(0)) {
          count++;
        }
      }
      if (count >= low && count <= high) {
        totalCount++;
      }
    }
    System.out.println(totalCount);

    // Part 2
    totalCount = 0;
    for (String passport : data) {
      int pos1 = Integer.parseInt(passport.split("-")[0]) - 1;
      int pos2 = Integer.parseInt(passport.split("-")[1].split(" ")[0]) - 1;
      if (passport.split(" ")[2].charAt(pos1) == passport.split(" ")[1].replace(":", "").charAt(0)
        ^ passport.split(" ")[2].charAt(pos2) == passport.split(" ")[1].replace(":", "").charAt(0)) {
        totalCount++;
      }
    }
    System.out.println(totalCount);
  }

  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day2_data.txt"));
  	String line = reader.readLine();
  	while (line != null) {
  		data.add(line);
  		line = reader.readLine();
  	}
  	reader.close();
    }
}