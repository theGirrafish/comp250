package assignment2;

/*
 *   STUDENT NAME      : Abbas Yadollahi
 *   STUDENT ID        : 260680343
 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression  {
	private ArrayList<String> tokenList;

	//  Constructor

	// The constructor takes in an expression as a string
	// and tokenizes it (breaks it up into meaningful units)
	// These tokens are then stored in an array list 'tokenList'.


	Expression(String expressionString) throws IllegalArgumentException {
		tokenList = new ArrayList<String>();
		StringBuilder token = new StringBuilder();

		// ADD YOUR CODE BELOW HERE

		// Remove all spaces and use regex to split expressionString
		expressionString = expressionString.replaceAll("\\s", "");
		String pattern = "(?<![+-])(?=[*/+-[\\\\]()])|(?<=[*/+-[\\\\]()])(?![+-])";

		for (final String element : expressionString.split(pattern))
			tokenList.add(element);

		// ADD YOUR CODE ABOVE HERE
	}


	// This method evaluates the expression and returns the value of the expression
	// Evaluation is done using 2 stack ADTs, operatorStack to store operators
	// and valueStack to store values and intermediate results.
	// - You must fill in code to evaluate an expression using 2 stacks

	public Integer eval() {
		Stack<String> operatorStack = new Stack<String>();
		Stack<Integer> valueStack = new Stack<Integer>();

		// ADD YOUR CODE BELOW HERE

		for (String strToken : this.tokenList) {

			switch(strToken) {
				case "[":
				case "(":
					break;
				case "+":
				case "-":
				case "*":
				case "/":
				case "++":
				case "--":
					operatorStack.push(strToken);
					break;
				case "]":
					valueStack.push(Math.abs(valueStack.pop()));
					break;
				case ")":
					String operator = operatorStack.pop();

					switch (operator) {
						case "+":
							valueStack.push(valueStack.pop() + valueStack.pop());
							break;
						case "-":
							valueStack.push(-1*valueStack.pop() + valueStack.pop());
							break;
						case "*":
							valueStack.push(valueStack.pop() * valueStack.pop());
							break;
						case "/":
							int divisor = valueStack.pop();
							int dividend = valueStack.pop();
							valueStack.push(dividend / divisor);
							break;
						case "++":
							valueStack.push(valueStack.pop() + 1);
							break;
						case "--":
							valueStack.push(valueStack.pop() - 1);
							break;
					}
					break;
				default:
					valueStack.push(Integer.parseInt(strToken));
					break;
			}
		}

		// ADD YOUR CODE ABOVE HERE

		return valueStack.pop();
	}

	// Helper methods

	// Helper method to test if a string is an integer
	// Returns true for strings of integers like "456"
	// and false for string of non-integers like "+"
	// - DO NOT EDIT THIS METHOD

	private boolean isInteger(String element) {
		try {
			Integer.valueOf(element);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	// Method to help print out the expression stored as a list in tokenList.
	// - DO NOT EDIT THIS METHOD

	@Override
	public String toString() {
		String s = new String();
		for (String t : tokenList)
			s = s + "~"+  t;
		return s;
	}
}
