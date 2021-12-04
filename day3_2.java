import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day3_2 {

	
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
		
		ArrayList<String> oxygen = new ArrayList<String>();
		ArrayList<String> carbon = new ArrayList<String>();
		
		for(int i=0; i<a.size(); i++) {
			oxygen.add(a.get(i));
			carbon.add(a.get(i));
		}
		
		for(int pos=0; pos<12; pos++) {
			int num0 = 0;
			int num1 = 0;
			
			for(int i=0; i<oxygen.size(); i++) {
				if(oxygen.get(i).charAt(pos)=='0') {
					num0+=1;
				}
				else {
					num1+=1;
				}
			}
			
			if(num1>=num0) {
				for(int i=oxygen.size()-1; i>=0; i--) {
					if(oxygen.size()>=2) {
						if(oxygen.get(i).charAt(pos) == '0') {
							oxygen.remove(i);
						}
					}
				}
			}
			if(num1<num0) {
				for(int i=oxygen.size()-1; i>=0; i--) {
					if(oxygen.size()>=2) {
						if(oxygen.get(i).charAt(pos) == '1') {
							oxygen.remove(i);
						}
					}
				}
			}
		}
		
		for(int pos=0; pos<12; pos++) {
			int num0 = 0;
			int num1 = 0;
			
			for(int i=0; i<carbon.size(); i++) {
				if(carbon.get(i).charAt(pos)=='0') {
					num0+=1;
				}
				else {
					num1+=1;
				}
			}
			
			if(num1>=num0) {
				for(int i=carbon.size()-1; i>=0; i--) {
					if(carbon.size()>=2) {
						if(carbon.get(i).charAt(pos) == '1') {
							carbon.remove(i);
						}
					}
				}
			}
			if(num1<num0) {
				for(int i=carbon.size()-1; i>=0; i--) {
					if(carbon.size()>=2) {
						if(carbon.get(i).charAt(pos) == '0') {
							carbon.remove(i);
						}
					}
				}
			}
		}
		
		String oString = oxygen.get(0);
		String cString = carbon.get(0);
		
		System.out.println(oxygen);
		System.out.println(carbon);
		
		int answer = Integer.parseInt(oString, 2)*Integer.parseInt(cString, 2);
		System.out.println(answer);
		
	}
}
