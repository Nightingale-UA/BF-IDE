package bf.cls.interpreter;

import java.util.Deque;
import bf.cls.Interpreter;

public class MiniStringfuck implements Interpreter {
	private String op = "+.";
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
	
	public String getOp() {
		return op;
	}
}