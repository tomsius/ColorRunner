package dev.runnergame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	private static int line = 0;
	private static List<String> lines = new ArrayList<String>();

	public static void loadFileAsString(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = br.readLine()) != null) {
				lines.add(line);
			}
			
			br.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static float parseFloat(String number) {
		try {
			return Float.parseFloat(number);
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
			return -1.0f;
		}
	}
	
	public static boolean hasLinesLeft() {
		return line < lines.size();
	}
	
	public static String getLine(int index) {
		String result = lines.get(index);
		line++;
		return result;
	}
}
