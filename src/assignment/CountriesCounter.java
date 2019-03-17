package assignment;

public class CountriesCounter {
	public static void main(String[] args) {
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
		
		int number = countCountries(A);
		System.out.println(number);
	}
	
	public static int countCountries(int[][] A){
		int number = 0;
		int rowCount = A.length;
		int columnCount = rowCount == 0 ? 0 : A[0].length;
		Mark[][] marks = new Mark[rowCount][columnCount];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				boolean topEqual = i != 0 && A[i][j] == A[i - 1][j];
				boolean leftEqual = j != 0 && A[i][j] == A[i][j - 1];
				if(topEqual || leftEqual){
					if(topEqual && leftEqual && marks[i - 1][j] != marks[i][j - 1]){
						marks[i - 1][j].setGroup(marks[i][j - 1].getGroup());
						number--;
					}else if(topEqual){
						marks[i][j] = marks[i - 1][j];
					}else {
						marks[i][j] = marks[i][j - 1];						
					}
					continue;
				}
				marks[i][j] = new Mark();
				number++;
			}
		}
		return number;
	}
}
