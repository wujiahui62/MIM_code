
package MIM_code_sample;

import java.util.ArrayList;
import java.util.Collections;

public class StringProcessor {
	// data fields
	private ArrayList<String> strings = new ArrayList<>();
	private int inputCharacterCount = 0;
	private int outputCharacterCount = 0;
	private ArrayList<Integer> stringLens = new ArrayList<>();
	
	// empty constructor
	public StringProcessor() {
		
	}
	
	// constructor that takes an array as parameter
	// the processing of string are in the order of requirement a, b and c
	// the processed strings are stored in datafield strings

	public StringProcessor(String[] input) {
		for(String s: input) {
			inputCharacterCount += s.length();
			stringLens.add(s.length());
			if(isMultipleOfN(s.length(), 4)) {
				s = reverse(s);
			}
			if(isMultipleOfN(s.length(), 5)) {
				s = s.substring(0, 5);
			}
			if(countUpperCharacters(s, 5, 3)) {
				s = s.toUpperCase();
			}
			outputCharacterCount += s.length();
			strings.add(s);
			removeCharacter('-', strings);
		}
	}
	
	public boolean isMultipleOfN(int len, int dividend) {
		return len > 0 && len % dividend == 0;
	}
	
	public String reverse(String s) {
		StringBuilder ss = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			ss.append(s.charAt(i));
		}
		return ss.toString();
	}
	
	public boolean countUpperCharacters(String s, int range, int count) {
		int upperCount = 0;
		for(int i = 0; i < range && i < s.length(); i++) {
			char c = s.charAt(i);
			if(c - 'A' >= 0 && c - 'Z' <= 0) 
				upperCount++;
		}
		return upperCount >= count;
	}
	
	// it checks the strings in the arraylist as required in d
	public void removeCharacter(Character c, ArrayList<String> stringList) {
		for(int i = 0; i < stringList.size() - 1; i++) {
			String curr = stringList.get(i);
			String next = stringList.get(i + 1);
			if(curr.length() == 0) continue;
			if(curr.charAt(curr.length() - 1) == c) {
				next = curr.substring(0, curr.length() - 1) + next;
				stringList.set(i + 1, next);
				stringList.remove(i);
				outputCharacterCount--;
			}
		}
		stringList.trimToSize();
	}
	
	// return the median length, if the length of the array list is even, it will take the average of the two median lengths
	private int getMedianLength(ArrayList<Integer> lengths) {
		Collections.sort(lengths);
		int n = lengths.size();
		if(n % 2 == 0) return (lengths.get(n / 2) + lengths.get(n / 2 - 1)) / 2;
		return lengths.get(n / 2);		
	}
	
	public int getMedianLengthBeforeProcessing() {
		return getMedianLength(stringLens);
	}
	
	public int getMedianLengthAfterProcessing() {
		ArrayList<Integer> lens = new ArrayList<>();
		for(String s: strings) {
			lens.add(s.length());
		}
		return getMedianLength(lens);
	}
	
	public int getInputCharacterCount() {
		return inputCharacterCount;
	}
	
	public int getOutputCharacterCount() {
		return outputCharacterCount;
	}
	
	public ArrayList<String> getProcessedStrings() {
		return strings;
	}
	
	public void print() {
		for(String s: strings) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
