package DynamicProgramming;
public class StringInterleaving {

	public boolean isInterleave(String s1, String s2, String s3) {

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();

		boolean[][] interleave = new boolean[s1.length() + 1][s2.length() + 1];

		if (len1 + len2 != len3)
			return false;

		else if (s1.equals(""))
			return s2.equals(s3);

		else if (s2.equals(""))
			return s1.equals(s3);

		for (int i = 1; i <= len1; i++) {
			interleave[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
		}
		for (int j = 1; j <= len2; j++) {
			interleave[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(i + j - 1);

				if (c3 != c1 && c3 != c2)
					interleave[i][j] = false;

				else if (c3 == c1 && c3 == c2) {
					interleave[i][j] = interleave[i - 1][j]
							|| interleave[i][j - 1];
				}

				else if (c3 == c2) {
					interleave[i][j] = interleave[i][j - 1];
				} else if (c3 == c1) {
					interleave[i][j] = interleave[i - 1][j];
				}
			}
		}
		return interleave[len1][len2];

	}

}