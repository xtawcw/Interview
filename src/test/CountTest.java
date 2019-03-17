package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import assignment.CountriesCounter;

public class CountTest {
	@Test
	public void testCount(){
		int[][] A = new int[7][3];
		A[0][0] = 5;
		A[0][1] = 4;
		A[0][2] = 4;
		A[1][0] = 4;
		A[1][1] = 3;
		A[1][2] = 4;
		A[2][0] = 3;
		A[2][1] = 2;
		A[2][2] = 4;
		A[3][0] = 2;
		A[3][1] = 2;
		A[3][2] = 2;
		A[4][0] = 3;
		A[4][1] = 3;
		A[4][2] = 4;
		A[5][0] = 1;
		A[5][1] = 4;
		A[5][2] = 4;
		A[6][0] = 4;
		A[6][1] = 1;
		A[6][2] = 1;
		
		int number = CountriesCounter.countCountries(A);
		Assert.assertEquals(number, 11);
	}
	
	private int[][] generateArray(){
		int rowCount = 5;
		int columnCount = 5;
		int maxValue = 5;
		int[][] array = new int[rowCount][columnCount];
		Random random = new Random();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				array[i][j] = random.nextInt(maxValue) + 1;
			}
		}
		
		return array;
	}
	
	private void print(int[][] array, int count){
		try {
			FileWriter writer = new FileWriter(new File("./src/test/result.js"));
			writer.write("var result = {count:" + count + ",");
			writer.write("array: [");
			for (int i = 0; i < array.length; i++) {
				writer.write(Arrays.toString(array[i]));
				if(i + 1 != array.length){
					writer.write(",");
				}
			}
			writer.write("]}");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAutomation(){
		int[][] array = generateArray();
		int count1 = CountriesCounter.countCountries(array);
		int count2 = CountriesCounter.countCountries1(array);
		Assert.assertEquals(count1, count2);
		print(array, count1);
		try {
			Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" ./src/test/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
