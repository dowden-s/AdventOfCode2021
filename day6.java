import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day6 {
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int initialList[] = {1,1,3,1,3,2,1,3,1,1,3,1,1,2,1,3,1,1,3,5,1,1,1,3,1,2,1,1,1,1,4,4,1,2,1,2,1,1,1,5,
				3,2,1,5,2,5,3,3,2,2,5,4,1,1,4,4,1,1,1,1,1,1,5,1,2,4,3,2,2,2,2,1,4,1,1,5,1,3,4,4,1,1,3,3,5,5,3,
				1,3,3,3,1,4,2,2,1,3,4,1,4,3,3,2,3,1,1,1,5,3,1,4,2,2,3,1,3,1,2,3,3,1,4,2,2,4,1,3,1,1,1,1,1,2,1,3,
				3,1,2,1,1,3,4,1,1,1,1,5,1,1,5,1,1,1,4,1,5,3,1,1,3,2,1,1,3,1,1,1,5,4,3,3,5,1,3,4,3,3,1,4,4,1,2,1,
				1,2,1,1,1,2,1,1,1,1,1,5,1,1,2,1,5,2,1,1,2,3,2,3,1,3,1,1,1,5,1,1,2,1,1,1,1,3,4,5,3,1,4,1,1,4,1,4,
				1,1,1,4,5,1,1,1,4,1,3,2,2,1,1,2,3,1,4,3,5,1,5,1,1,4,5,5,1,1,3,3,1,1,1,1,5,5,3,3,2,4,1,1,1,1,1,5,
				1,1,2,5,5,4,2,4,4,1,1,3,3,1,5,1,1,1,1,1,1};
		
		ArrayList<Integer> totalFish = new ArrayList<Integer>();
		
		for(int i=0; i<initialList.length; i++) {
			totalFish.add(initialList[i]);
		}
		
		for(int i=0; i<80; i++) {
			int numNew = 0;
			for(int j=0; j<totalFish.size(); j++) {
				if(totalFish.get(j)==0) {
					totalFish.set(j, 6);
					numNew+=1;
				}
				else {
					int num = totalFish.get(j)-1;
					totalFish.set(j, num);
				}
			}
			
			for(int j=0; j<numNew; j++) {
				totalFish.add(8);
			}
		}
		
		int sum = totalFish.size();
		
		System.out.println(sum);
		
		
		
		
		input.close();
	}
}
