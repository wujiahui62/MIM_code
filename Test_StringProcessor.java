/*
 * (1)Code Sample:

Implement a method that takes in a list of strings. Its behavior should be the following for each string:

        a) Reverse the string if its length is a multiple of 4.

        b) Truncate the string to 5 characters if its length is a multiple of 5.

        c) Convert the string to all uppercase if it contains at least 3 uppercase characters in the first 5 characters.

        d) If the string ends with a hyphen, remove it, and append the next string in the list to the current one.

        e) Print the string out.

Additionally, give a final report of the total characters in the input, total characters in the output, and median length of all strings.  Give this module a name that you think is most descriptive of what it does, while still concise.

You may write this in any of the more common languages--Java, variations of C, Python, Perl, Ruby, etc.  Unlike a typical homework assignment, here you are encouraged to use functionality that your language of choice has to offer.  Please avoid numerical languages like MATLAB or IDL, as well as obscure languages like LabVIEW that may be difficult for us to read.  You may build this in an OO fashion if you like. Clean, readable code, with minimal memory overhead, and decomposed into individual pieces is a plus. Please include a set of inputs that, when considered together, would use each piece of functionality.  Your code must compile and run.


 */


package MIM_code_sample;

public class Test_StringProcessor {
	public static void main(String[] args) {
		String[] input1 = {"abcdefgh", "ABCdefghij", "hijk-", "lmnopqrstu-", "1234567890", "ABCd"};
		StringProcessor p = new StringProcessor(input1);
		System.out.print("String array in the input: ");
		for(String s: input1) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.print("String array in the output: ");
		p.print();
		System.out.println("Total characters in the input: " + p.getInputCharacterCount());
		System.out.println("Total characters in the output: " + p.getOutputCharacterCount());
		System.out.println("Median length of string in the input: " + p.getMedianLengthBeforeProcessing());
		System.out.println("Median length of string in the output: " + p.getMedianLengthAfterProcessing());
	}
}