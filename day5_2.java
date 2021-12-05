import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day5_2 {
	
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
		
		int oceanFloor[][] = new int[1000][1000];
		
		ArrayList<int[]> verticalCoordinates = new ArrayList<int[]>();
		ArrayList<int[]> horizontalCoordinates = new ArrayList<int[]>();
		ArrayList<int[]> diagonalCoordinatesHigherFirst = new ArrayList<int[]>();
		ArrayList<int[]> diagonalCoordinatesLowerFirst = new ArrayList<int[]>();
		
		//405,945 -> 780,945
		
		for(int i=0; i<a.size(); i++) {
			String str = a.get(i);
			int[] coordinates = {0, 0, 0, 0};
			int c1 = Integer.parseInt(str.substring(0, str.indexOf(',')));
			int c2 = Integer.parseInt(str.substring((str.indexOf(',')+1), str.indexOf(' ')));
			str = str.substring((str.indexOf('>')+2));
			int c3 = Integer.parseInt(str.substring(0, str.indexOf(',')));
			int c4 = Integer.parseInt((str.substring(str.indexOf(',')+1)));
			
			if(c1!=c3 && c2==c4) {
				if(c1>c3) {
					int h = c1;
					c1 = c3;
					c3 = h;
				}
				
				coordinates[0] = c1;
				coordinates[1] = c2;
				coordinates[2] = c3;
				coordinates[3] = c4;
				
				horizontalCoordinates.add(coordinates);
			}
			if(c1==c3&&c2!=c4) {
				if(c2>c4) {
					int h = c2;
					c2 = c4;
					c4 = h;
				}
				
				coordinates[0] = c1;
				coordinates[1] = c2;
				coordinates[2] = c3;
				coordinates[3] = c4;
				
				verticalCoordinates.add(coordinates);
			}
			if(c1!=c3&&c2!=c4) {
				int y = c4-c2;
				int x = c3-c1;
				double slope = y/x;
				if(slope==-1.0) {
					if(c1<c3) {
						coordinates[0] = c1;
						coordinates[1] = c2;
						coordinates[2] = c3;
						coordinates[3] = c4;
						diagonalCoordinatesHigherFirst.add(coordinates);
					}
					else {
						coordinates[0] = c3;
						coordinates[1] = c4;
						coordinates[2] = c1;
						coordinates[3] = c2;
						diagonalCoordinatesHigherFirst.add(coordinates);
					}
				}
				if(slope==1.0) {
					if(c1<c3) {
						coordinates[0] = c1;
						coordinates[1] = c2;
						coordinates[2] = c3;
						coordinates[3] = c4;
						diagonalCoordinatesLowerFirst.add(coordinates);
					}
					else {
						coordinates[0] = c3;
						coordinates[1] = c4;
						coordinates[2] = c1;
						coordinates[3] = c2;
						diagonalCoordinatesLowerFirst.add(coordinates);
					}
				}
			}
		}
		
		ArrayList<int[]> totalCoordinates = new ArrayList<int[]>();
		
		for(int i=0; i<verticalCoordinates.size(); i++) {
			int endPoints[] = verticalCoordinates.get(i);
			
			ArrayList<Integer> numList = new ArrayList<Integer>();
			
			for(int k=endPoints[1]; k<=endPoints[3]; k++) {
				numList.add(k);
			}
			
			for(int j=0; j<numList.size(); j++) {
				int point[] = {endPoints[0], endPoints[1]+j};
				totalCoordinates.add(point);
			}
		}
		
		for(int i=0; i<horizontalCoordinates.size(); i++) {
			int endPoints[] = horizontalCoordinates.get(i);
			
			ArrayList<Integer> numList = new ArrayList<Integer>();
			
			for(int k=endPoints[0]; k<=endPoints[2]; k++) {
				numList.add(k);
			}
			
			for(int j=0; j<numList.size(); j++) {
				int point[] = {endPoints[0]+j, endPoints[1]};
				totalCoordinates.add(point);
			}
		}
		
		for(int i=0; i<diagonalCoordinatesHigherFirst.size(); i++) {
			int endPoints[] = diagonalCoordinatesHigherFirst.get(i);
			int counter = endPoints[2]-endPoints[0];
			
			for(int j=0; j<=counter; j++) {
				int point[] = {endPoints[0]+j, endPoints[1]-j};
				totalCoordinates.add(point);
			}
		}
		
		
		
		for(int i=0; i<diagonalCoordinatesLowerFirst.size(); i++) {
			int endPoints[] = diagonalCoordinatesLowerFirst.get(i);
			int counter = endPoints[2]-endPoints[0];
			
			for(int j=0; j<=counter; j++) {
				int point[] = {endPoints[0]+j, endPoints[1]+j};
				totalCoordinates.add(point);
			}
		}
		
		for(int i=0; i<totalCoordinates.size(); i++) {
			int x = totalCoordinates.get(i)[0];
			int y = totalCoordinates.get(i)[1];
			oceanFloor[y][x]+=1;
		}
		
		int sum = 0;
		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				if(oceanFloor[i][j]>=2) {
					sum+=1;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}
}