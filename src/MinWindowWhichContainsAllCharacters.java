import java.util.Arrays;

public class MinWindowWhichContainsAllCharacters {

	public static String minWindow(String S,
			String T) {
		int minWindow = Integer.MAX_VALUE;
		int currWindow = Integer.MAX_VALUE;
		int minStart = Integer.MAX_VALUE, minEnd = Integer.MAX_VALUE;
		int[] hasSeen = new int[256];
		int[] needtoFind = new int[256];

		int setLength = T.length();

		int count = 0;

		Arrays.fill(needtoFind, 0);
		Arrays.fill(hasSeen, 0);
		
		if(S.length() < T.length()) 
			return "";
		
		//If they are of same length
		if(S.length() == T.length()) 
		{
			if(S.equals(T))
				return S;
		}

		for (int i = 0; i < T.length(); i++) {
			needtoFind[T.charAt(i)] += 1;
		}

		for (int start = 0, end = 0; end < S.length(); end++) {

			// If the character is not what we are looking for, skip
			if (needtoFind[S.charAt(end)] == 0) {
				continue;
			}

			hasSeen[S.charAt(end)] += 1;

			if (hasSeen[S.charAt(end)] <= needtoFind[S.charAt(end)]) {
				count++;
			}

			if (count == setLength) {
				// Advance begin to farthest point, such that (begin - end) is
				// minimum

				// If that character is not in the set, we can easily skip
				while (hasSeen[S.charAt(start)] == 0 || hasSeen[S.charAt(start)] > needtoFind[S.charAt(start)] ){
					
					if(hasSeen[S.charAt(start)] > needtoFind[S.charAt(start)])
						hasSeen[S.charAt(start)] -= 1;
	
					start++;
				}

				currWindow = end - start + 1;

				if (currWindow < minWindow) {
					minWindow = currWindow;
					minStart = start;
					minEnd = end;
				}

			}
		}
		
		if(count == setLength) 
			return S.substring(minStart, minEnd + 1);
		
		else 
			return "";
	}

	public static void main(String[] args) {
		String input = "cabefgecdaecf";
		String t = "cae";

		System.out.println(minWindow(input, t));
	}
}
