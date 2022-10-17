package dictionay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.Scanner;

public class FileExistsOrNot {
	static String path = "src/dictionay/Dictionary.txt";
	public static void main(String[] args) {
	
	if (path.length()<1) {
		System.err.println("Please provide the path to the dictionary file");
		System.exit(1);
	}
	
		try {
			if (!doesFileExist(path)) {
				throw new FileNotFoundException("File does not exist");
			}else {
				File f = new File(path);
				if (!f.canRead()) {
					System.err.println("File exists but doesn't have permission for reading");
					System.exit(1);
				}else if (f.length()==0) {
					System.err.println("File exists but is empty.");
					System.exit(1);
				}
				else {
					System.out.println("File exists and will be read by this program");
					System.out.println();
					printDictionary(f);
				}
			}
				
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	
	}
	
	public static boolean doesFileExist(String path) {
		File file = new File(path);
		
		if (!file.exists()|| !file.isFile()) {
			return false;
		}else {
			return true;
		}
		
		
	}
	
	public static void printDictionary(File f) {
		try {
			Scanner sc = new Scanner(f);
			String line;
			int i=1;
			
			while(sc.hasNextLine()) {
				line=sc.nextLine();
				
				String[] splitLine = line.split("-");
				String[] meaning = splitLine[1].split(",");
				System.out.println("Word"+i+": "+ splitLine[0].trim());
				i++;
				
				for (int j=0; j<meaning.length;j++) {
					System.out.println("Meaning"+(j+1)+": "+meaning[j].trim());
					
				}
				System.out.println();
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
