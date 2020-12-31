
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class day8 {

	private static String[] data = new String[594]; // Manually check length of input file

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
    // Part 1
    List<Integer> beenTo = new ArrayList<>();
    int index = 0;
    int acc = 0;
    while (!(beenTo.contains(index))) {
      beenTo.add(index);
      if (data[index].split(" ")[0].equals("jmp")) {
        index += Integer.parseInt(data[index].split(" ")[1]);
      } else if (data[index].split(" ")[0].equals("nop")){
        index++;
      } else {
        acc += Integer.parseInt(data[index].split(" ")[1]);
        index++;
      }
    }
    System.out.println(acc);

    // Part 2
    // for (int i = 0; i < data.length; i++) {
    //   if (!(data[i].split(" ").equals("acc"))) {
    //     swap(i);
    //     System.out.println(run());
    //   }
    // }
  }

  private static void swap(int i) {
    if (data[i].split(" ")[0].equals("jmp")) {
      data[i] = "nop " + data[i].split(" ")[1];
    } else if (data[i].split(" ")[0].equals("nop")) {
      data[i] = "jmp " + data[i].split(" ")[1];
    }
  }

  private static int run() {
    List<Integer> beenTo = new ArrayList<>();
    int index = 0;
    int acc = 0;
    while (!(beenTo.contains(index))) {
      if (index > data.length) {
        return -1;
      }
      beenTo.add(index);
      if (data[index].split(" ")[0].equals("jmp")) {
        index += Integer.parseInt(data[index].split(" ")[1]);
      } else if (data[index].split(" ")[0].equals("nop")){
        index++;
      } else {
        acc += Integer.parseInt(data[index].split(" ")[1]);
        index++;
      }
    }
    return acc;
  }


  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day8_data.txt"));

  	String line = reader.readLine(); int i = 0;
  	while (line != null) {
  		data[i] = line; i++;
  		line = reader.readLine();
  	}
  	reader.close();
  }
}