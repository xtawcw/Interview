package assignment;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhang Jun
 * @date 2019-03-16
 * @description Count the amount of blocks in a rectangle.
 */
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
		
//		int number = countCountries(A);
//		System.out.println(number);
		int number = countCountries1(A);
		System.out.println(number);
	}
	
	/**
	 * Traverse 2-dimension array to count connective areas.
	 * @param A
	 * @return The amount of connective areas.
	 */
	public static int countCountries(int[][] A){
		int number = 0;
		int rowCount = A.length;
		int columnCount = rowCount == 0 ? 0 : A[0].length;
		Mark[][] marks = new Mark[rowCount][columnCount];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				boolean topEqual = i != 0 && A[i][j] == A[i - 1][j];
				boolean leftEqual = j != 0 && A[i][j] == A[i][j - 1];
				
				// If current cell equals its top cell or left cell, treat them as members of the same area.
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
				
				// Otherwise, create a new group.
				marks[i][j] = new Mark();
				number++;
			}
		}
		return number;
	}
	
	private static LinkedList<LinkedList<Integer>> fromArrayToAdjacency(int[][] A){
		int rowCount = A.length;
		int columnCount = rowCount == 0 ? 0 : A[0].length;
		LinkedList<LinkedList<Integer>> lists = new LinkedList<LinkedList<Integer>>();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				LinkedList<Integer> list = new LinkedList<Integer>();
				
				if(j + 1 < columnCount && A[i][j] == A[i][j + 1]){					
					list.add(i * columnCount + j + 1);
				}
				
				if(j > 0 && A[i][j] == A[i][j - 1]){					
					list.add(i * columnCount + j - 1);
				}
				
				if(i + 1 < rowCount && A[i][j] == A[i + 1][j]){
					list.add((i + 1) * columnCount + j);
				}
				
				if(i - 1 > 0 && A[i][j] == A[i - 1][j]){
					list.add((i - 1) * columnCount + j);
				}
				
				lists.add(list);
			}
		}
		return lists;
	}
	
	/**
	 * Adjacency list depth first search algorithm.
	 * @param lists Adjacency list
	 * @param visited If the elements in the list has been touched.
	 * @param i index of the element
	 */
	private static void DFS(LinkedList<LinkedList<Integer>> lists, boolean[] visited, int i){
		if(visited[i]){
			return;
		}
		visited[i] = true;
		List<Integer> list = lists.get(i);
		for (int j = 0; j < list.size(); j++) {
			int index = list.get(j);
			if(!visited[index]){
				DFS(lists, visited, list.get(j));
			}
		}
	}
	
	/**
	 * Count connective areas in adjacency list with DFS.
	 * @param A a prepared 2-dimension array
	 * @return The amount of connective areas.
	 */
	public static int countCountries1(int[][] A){
		LinkedList<LinkedList<Integer>> lists = fromArrayToAdjacency(A);
		boolean[] visited = new boolean[lists.size()];
		int number = 0;
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]){
				DFS(lists, visited, i);
				number++;
			}
		}
		
		return number;
	}
}
