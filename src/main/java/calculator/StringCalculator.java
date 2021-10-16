package calculator;

class StringCalculator {

	public int add(String input) throws Exception {
		int totalSum = 0;

		// Checking for empty string
		if (input.length() == 0)
			return 0;

		// Input string with different delimiters
		String[] operators = new String[] { "\\+", "\\*", "x", "\\^", "X" };
		for (String operator : operators) {
			input = input.replaceAll("[" + operator + "+]", ";");
		}

		// Determining the delimiter
		String delimiter = ",";
		if (input.startsWith("//")) {
			if (input.contains("[") && input.contains("]")) {
				while (input.contains("[") && input.contains("]")) {
					int startIndex = input.indexOf("[");
					int endIndex = input.indexOf("]");
					delimiter = input.substring(startIndex + 1, endIndex);
					input = input.substring(endIndex + 1).replaceAll("[" + delimiter + "+]", ";");
					delimiter = ";";
				}
			} else {
				delimiter = "" + input.charAt(2);
				input = input.substring(3);
			}
		}

		// Invalid input String validation
		if (input.endsWith("\n")) {
			throw new Exception("INVALID input");
		} else {
			input = input.replace("\n", delimiter);
		}

		String[] numbersArray = input.split(delimiter);

		// Adding numbers
		for (String num : numbersArray) {
			num = num.trim();
			if (num.length() > 0) {
				int n = Integer.parseInt(num);
				totalSum += n;
			}
		}

		return totalSum;
	}

}