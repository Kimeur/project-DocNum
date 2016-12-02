package dynamic;

public class LCSDYNAMIC {
	
	public static int LCS(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
		return 0;
		}
		int lenA = A.length();
		int lenB = B.length();
		// check if last characters are same
		if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
		// Add 1 to the result and remove the last character from both
		// the strings and make recursive call to the modified strings.
		return 1 + LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
		} else {
		// Remove the last character of String 1 and make a recursive
		// call and remove the last character from String 2 and make a
		// recursive and then return the max from returns of both recursive
		// calls
		return Math.max(
		LCS(A.substring(0, lenA - 1), B.substring(0, lenB)),
		LCS(A.substring(0, lenA), B.substring(0, lenB - 1)));
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int LCS;
			String A = new String("This is Renuka");
			String B = new String("This is Youssef");
			
			LCS = LCS(A,B);
			
			System.out.println(LCS);
			
			
	}

}
