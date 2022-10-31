package solutions;

public class LongNumberPossible {

	public static void main(String[] args) {
		int input1 = 5;
		int[] input2 = { 1, 2, 3, 8, 9 };
		System.out.println(position(input1, input2));
	}

	static int position(int n, int[] marbles) {
		int i;
		if (marbles[n - 1] == 8) {
			return n - 1;
		}
		for (i = n - 2; i >= 0; i--) {
			if (marbles[i] < 9)
				return i + 1;

		}
		return i + 2;
	}
}
