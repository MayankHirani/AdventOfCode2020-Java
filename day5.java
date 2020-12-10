
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class day5 {

	private static String[] data = new String[872]; // Manually check length of input file

	// Solving the problem
  public static void main(String[] args) throws Exception {
  	readData();
  	
  	// Part 1
    int[] rows = makeArray(128);
    int[] cols = makeArray(8);
  	int answer = 0;
    int seatId;
    for (String passenger : data) {
      seatId = 8 * findRow(rows, passenger)[0] + findCol(cols, passenger)[0];
      if (seatId > answer) {
        answer = seatId;
      }
    }
    System.out.println("Part 1: " + answer);

    // Part 2
    int[] seatIds = new int[872];
    for (int i = 0; i < data.length; i++) {
      seatId = 8 * findRow(rows, data[i])[0] + findCol(cols, data[i])[0];
      seatIds[i] = seatId;
    }
    Arrays.sort(seatIds);

    for (int i = 0; i < seatIds.length - 1; i++) {
      if (seatIds[i] + 2 == seatIds[i + 1]) {
        System.out.println("Part 2: " + (seatIds[i] + 1));
      }
    }
  }

  private static int[] makeArray(int length) {
    int[] rows = new int[length];
    for (int i = 0; i < length; i++) {
      rows[i] = i;
    }
    return rows;
  }

  private static int[] findRow(int[] seats, String code) {
    if (code.charAt(0) == 'L' || code.charAt(0) == 'R') {
      return seats;
    } else if (code.charAt(0) == 'F') {
      return findRow(Arrays.copyOfRange(seats, 0, seats.length / 2), code.substring(1));
    } else if (code.charAt(0) == 'B') {
      return findRow(Arrays.copyOfRange(seats, seats.length / 2, seats.length), code.substring(1));
    } else {
      return findRow(seats, code.substring(1));
    }
  }

  private static int[] findCol(int[] seats, String code) {
    if (code.length() == 0) {
      return seats;
    } else if (code.charAt(0) == 'L') {
      return findCol(Arrays.copyOfRange(seats, 0, seats.length / 2), code.substring(1));
    } else if (code.charAt(0) == 'R') {
      return findCol(Arrays.copyOfRange(seats, seats.length / 2, seats.length), code.substring(1));
    } else {
      return findCol(seats, code.substring(1));
    }
  }

  // Reading the file input
  private static void readData() throws Exception {
  	BufferedReader reader;
  	reader = new BufferedReader(new FileReader("day5_data.txt"));

  	String line = reader.readLine(); int i = 0;
  	while (line != null) {
  		data[i] = line; i++;
  		line = reader.readLine();
  	}
  	reader.close();
  }
}