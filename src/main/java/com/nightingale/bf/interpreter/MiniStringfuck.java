package com.nightingale.bf.interpreter;

import java.util.Deque;

import com.nightingale.bf.Interpreter;
import com.nightingale.bf.ctrl.Helper;

public class MiniStringfuck implements Interpreter {
	private static final String OP = "+.";

	private static final String REGEX = INCR + "|" + OUT;

	public String interpret(String code, Deque<Integer> input) {
		StringBuilder output = new StringBuilder();
		int value = 0;
		int length = code.length();
		for (int i = 0; i < length; i++) {
			switch (code.charAt(i)) {
				case '+':
					value++;
					if (value == 256) value = 0;
					break;
				case '.':
					output.append((char)value);
					break;
				default:
					break;
			}
		}
		return output.toString();
	}
	
	public String fromString(String target) {
		//TODO: implement from String
		return "Not implemented yet";
	}
	public String toC(String code) {
		Deque<String> tokens = Helper.tokenize(code, REGEX);		

		StringBuilder result = new StringBuilder();			

		String next = tokens.poll();
		while(next != null) {
			int length = next.length();
			if (next.matches(INCR)) 
				result.append("    " + CELL + " += " + length + END_LINE);
			else if (next.matches(OUT))
				result.append("    putchar(" + CELL + ")" + END_LINE);
			
			next = tokens.poll();
		}
		
		return result.toString();
	}
	public String fromHighLevel(String highLevelCode) {
		//TODO: implement from High level
		return "Not implemented yet";
	}	
	
	public String getOp() {
		return OP;
	}

	@Override
	public String optimize(String code) {
		// Is it really possible to optimize dis one?
		return null;
	}
}