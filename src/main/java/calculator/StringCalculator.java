package calculator;

class StringCalculator {

	public int add(String input) throws Exception {
		String delimiter = ",";
		int totalSum = 0;
		
		// Checking for empty string
		if (input.length() == 0)
			return 0;

		// Invalid input String validation
		if (input.endsWith("\n")) {
			throw new Exception("INVALID input");
		}
		else {
			input = input.replace("\n", delimiter);
		}

		
		String[] numbersArray = input.split(delimiter);

		//Adding numbers
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