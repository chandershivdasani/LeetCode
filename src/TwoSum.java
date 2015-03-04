import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int[] indices = new int[] { -1, -1 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			int sum = target-numbers[i];
			Integer val = map.get(sum);

			if (val != null && val != i) {
				indices[0] = i + 1;
				indices[1] = val + 1;
				break;
			}

		}

		return indices;
	}
	
	public static void main(String[] args) {
		
		new TwoSum().twoSum(new int[]{3,2,4}, 6);
	}
}
