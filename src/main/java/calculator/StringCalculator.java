package calculator;

class StringCalculator {

	public int add(String input) {
		if (input.length() == 0)
			return 0;

		String delimiter = ",";
		String[] numbersArray = input.split(delimiter);
		int totalSum = 0;
		
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