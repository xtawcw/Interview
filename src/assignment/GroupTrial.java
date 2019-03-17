package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupTrial {
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
		
		List<Unit> list = new ArrayList<Unit>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				list.add(new Unit(i, j, A[i][j]));
			}
		}
		
		Map<Unit, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	}
}
