import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day4_2 {
	public static int[] boardComputation(int[][] board) {
		int numOrder[] = {18,99,39,89,0,40,52,72,61,77,69,51,30,83,20,65,93,88,29,22,14,82,53,41,76,79,46,
				78,56,57,24,36,38,11,50,1,19,26,70,4,54,3,84,33,15,21,9,58,64,85,10,66,17,43,31,27,2,5,95,
				96,16,97,12,34,74,67,86,23,49,8,59,45,68,91,25,48,13,28,81,94,92,42,7,37,75,32,6,60,63,35,
				62,98,90,47,87,73,44,71,55,80};
		int answer[] = new int[3];
		
		boolean run = true;
		int numOrderCounter = 0;
		while(run==true) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(board[i][j]==numOrder[numOrderCounter]) {
						board[i][j] = 100;
					}
				}
			}
			
			numOrderCounter+=1;
			
			for(int i=0; i<5; i++) {
				int counter1 = 0;
				int counter2 = 0;
				
				for(int j=0; j<5; j++) {
					if(board[i][j]==100) {
						counter1+=1;
					}
					if(board[j][i]==100) {
						counter2+=1;
					}
				}
				
				if(counter1==5) {
					run = false;
				}
				
				if(counter2==5) {
					run = false;
				}
			}
		}
		
		answer[0] = numOrderCounter;
		
		int sum=0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board[i][j]!=100) {
					sum+=board[i][j];
				}
			}
		}
		
		answer[1] = sum;
		
		answer[2] = numOrder[numOrderCounter-1];
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		String line;
		while(true) {
			line = input.nextLine();
			if(line.equals("")) {
				break;
			}
			else {
				a.add(line);
			}
		}
		
		
		
		ArrayList<int[]> horizontalArrays = new ArrayList<int[]>();
		
		for(int i=0; i<a.size(); i++) {
			int arr[] = new int[5];
			String str1 = a.get(i).substring(0,2);
			if(str1.charAt(0)==' ') {
				str1 = str1.substring(1);
			}
			
			String str2 = a.get(i).substring(3,5);
			if(str2.charAt(0)==' ') {
				str2 = str2.substring(1);
			}
			
			String str3 = a.get(i).substring(6,8);
			if(str3.charAt(0)==' ') {
				str3 = str3.substring(1);
			}
			
			String str4 = a.get(i).substring(9,11);
			if(str4.charAt(0)==' ') {
				str4 = str4.substring(1);
			}
			
			String str5 = a.get(i).substring(12,14);
			if(str5.charAt(0)==' ') {
				str5 = str5.substring(1);
			}
			
			arr[0] = Integer.parseInt(str1);
			arr[1] = Integer.parseInt(str2);
			arr[2] = Integer.parseInt(str3);
			arr[3] = Integer.parseInt(str4);
			arr[4] = Integer.parseInt(str5);
			
			horizontalArrays.add(arr);
		}
		
		
		ArrayList<int[][]> boards = new ArrayList<int[][]>();
		
		int numOfArrays = a.size()/5;
		int lineCounter = 0;
		for(int i=0; i<numOfArrays; i++) {
			int board[][] = new int[5][5];
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					board[j][k] = horizontalArrays.get(lineCounter)[k];
				}
				lineCounter+=1;
			}
			boards.add(board);
		}
		
		//Array[y][x]
		
		ArrayList<int[]> boardCombos = new ArrayList<int[]>();
		
		for(int i=0; i<boards.size(); i++) {
			boardCombos.add(boardComputation(boards.get(i)));
		}
		
		int boardComboTotal = 0;
		int boardComboPos = 0;
		for(int i=0; i<boardCombos.size(); i++) {
			if(boardComboTotal<boardCombos.get(i)[0]) {
				boardComboTotal = boardCombos.get(i)[0];
				boardComboPos = i;
			}
		}
		
		int answer = boardCombos.get(boardComboPos)[1]*boardCombos.get(boardComboPos)[2];
		System.out.println(answer);
		
		
		
		
		input.close();
	}
}
