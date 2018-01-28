package com.walmart.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumSuchThatNo2ElementsAreAdjacent {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the input Array for the algorithm seperated by comma with any { }");
		String inputLine = sc.nextLine();
		if(inputLine != null) {
			String[] splittedParts = inputLine.split(",");
			List<Integer> inpList = new ArrayList<>();
			for(String num :splittedParts) {
				inpList.add(Integer.valueOf(num));
			}
			System.out.println("The reslt of the Algorithm is :"+fetchAlgoResult(inpList));
		}else {
			System.out.println("Please enter some valid integers. You might have entered nothing !!!!");
		}
	}
	
	private static int fetchAlgoResult(List<Integer> inpList) {
		int prevInclusive =0,prevExclusive=0;
		for(Integer num : inpList) {
			int inclusive = prevExclusive + num;
			int exclusive = Math.max(prevInclusive, prevExclusive);
			prevInclusive = inclusive;
			prevExclusive = exclusive;
		}
		return Math.max(prevInclusive, prevExclusive);
	}

}
