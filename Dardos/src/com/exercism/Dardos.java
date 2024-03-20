package com.exercism;

import java.util.function.DoublePredicate;

public class Dardos {
	
	private static final double innerRing = 1.0;
	private static final double middleRing = 5.0;
	private static final double outerRing = 10.0;
	
	private int calculate(double pointRadius) {
		
		DoublePredicate within = ring -> pointRadius <= ring;
			if (within.test(innerRing)) return 10;
			if (within.test(middleRing)) return 5;
			if (within.test(outerRing)) return 1;
		
		return 0;
	}
	
	int score (double x, double y) {
		return calculate(Math.hypot(x, y));
		
	}

	public static void main(String[] args) {
		
		
		Dardos dardo = new Dardos();
		
		System.out.println(Math.hypot(0.8, 0.6));
		System.out.println(dardo.score(0.8,0.6));	
	}

}
