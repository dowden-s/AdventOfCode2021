import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day3 {
	
	
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
		
		String epsilon = "";
		String gamma = "";
		
		
		for(int count=0; count<12; count++) {
			int num0 = 0;
			int num1 = 1;
			
			for(int i=0; i<a.size(); i++) {
				String s = a.get(i);
				if(s.charAt(count)=='0') {
					num0+=1;
				}
				else {
					num1+=1;
				}
			}
			if(num0<num1) {
				epsilon+="0";
				gamma+="1";
			}
			else {
				epsilon+="1";
				gamma+="0";
			}
			

		}

		
		
		int evalue = Integer.parseInt(epsilon, 2);
		int gvalue = Integer.parseInt(gamma, 2);
		
		System.out.println(epsilon);
		System.out.println(gamma);
		
		System.out.println(evalue);
		System.out.println(gvalue);
		
		int answer = evalue*gvalue;
		System.out.println(answer);
		
		
		
	}
}
