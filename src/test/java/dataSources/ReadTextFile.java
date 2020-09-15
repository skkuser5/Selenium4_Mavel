package dataSources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadTextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projPath = System.getProperty("user.dir");
		File textFile = new File(projPath+"\\src\\test\\resources\\testData\\data.txt");
		
		try {
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
