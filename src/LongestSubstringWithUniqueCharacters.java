import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueCharacters {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		char[] input = s.toCharArray();
		int currStart =0, currEnd = 0;
		Map<Character, Integer> seen = new HashMap<Character, Integer>();
		
		while(currEnd < s.length()) {
			
			//If the element is not already seen,
			//increment the length and add it to the seen map
			if(!seen.containsKey(input[currEnd])) {
				seen.put(input[currEnd], currEnd);
				
				if((currEnd - currStart) + 1 > maxLength)
					maxLength = currEnd - currStart + 1;
				
				currEnd++;
				
			} else {
				/*
				 * We have already seen the element. Now we include this element
				 * to our current window(currStart and currEnd) and update our 
				 * window accordingly
				 * 
				 *  - Check when did we last see the element
				 *     - If we saw it before the current window, ignore it
				 *     - If it is in the current window, update start 
				 *  - Update the new index in the map 
				 *  - Update the maxLength  
				 */
				int lastSeenIndex = seen.get(input[currEnd]);
				
				//Only update currStart if the last seen index is after 
				//its current position
				currStart = Math.max(lastSeenIndex + 1, currStart);
				
				seen.put(input[currEnd], currEnd);
				
				if((currEnd - currStart) + 1> maxLength) {
					maxLength = currEnd - currStart + 1;
				}
				currEnd++;
				
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithUniqueCharacters().lengthOfLongestSubstring("a"));
	}
}
 