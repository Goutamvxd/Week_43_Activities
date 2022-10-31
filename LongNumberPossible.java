package solutions;

public class LongNumberPossible {

	public static void main(String[] args) {
		int no_ofbowl=
				int i1
	}
	static int log_number(int no_of_bowl,int[] marbles) {
		int i;
		for(i=no_of_bowl-1;i>=0;i--) {
			if(marbles[i]>=9)
				continue;
			else if(marbles[i]<9)
				return i+1;
		}
		return 0;
	}
}
