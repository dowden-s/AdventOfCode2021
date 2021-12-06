import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day6_2 {
	
	public static void main(String[] args) {
		long initialList[] = {1,1,3,1,3,2,1,3,1,1,3,1,1,2,1,3,1,1,3,5,1,1,1,3,1,2,1,1,1,1,4,4,
				1,2,1,2,1,1,1,5,3,2,1,5,2,5,3,3,2,2,5,4,1,1,4,4,1,1,1,1,1,1,5,1,2,4,3,2,2,2,2,
				1,4,1,1,5,1,3,4,4,1,1,3,3,5,5,3,1,3,3,3,1,4,2,2,1,3,4,1,4,3,3,2,3,1,1,1,5,3,1,
				4,2,2,3,1,3,1,2,3,3,1,4,2,2,4,1,3,1,1,1,1,1,2,1,3,3,1,2,1,1,3,4,1,1,1,1,5,1,1,
				5,1,1,1,4,1,5,3,1,1,3,2,1,1,3,1,1,1,5,4,3,3,5,1,3,4,3,3,1,4,4,1,2,1,1,2,1,1,1,
				2,1,1,1,1,1,5,1,1,2,1,5,2,1,1,2,3,2,3,1,3,1,1,1,5,1,1,2,1,1,1,1,3,4,5,3,1,4,1,
				1,4,1,4,1,1,1,4,5,1,1,1,4,1,3,2,2,1,1,2,3,1,4,3,5,1,5,1,1,4,5,5,1,1,3,3,1,1,1,
				1,5,5,3,3,2,4,1,1,1,1,1,5,1,1,2,5,5,4,2,4,4,1,1,3,3,1,5,1,1,1,1,1,1};
		
		long list[] = {0,0,0,0,0,0,0,0,0};
		
		for(int i=0; i<initialList.length; i++) {
			list[(int)initialList[i]]+=1;
		}
		
		for(int i=0; i<256; i++) {
			long fish0 = list[0];
			list[0] = list[1];
			list[1] = list[2];
			list[2] = list[3];
			list[3] = list[4];
			list[4] = list[5];
			list[5] = list[6];
			list[6] = fish0+list[7];
			list[7] = list[8];
			list[8] = fish0;
		}
		
		long sum = 0;
		
		for(int i=0; i<list.length; i++) {
			sum+=list[i];
		}
		
		System.out.println(sum);
	}
}
