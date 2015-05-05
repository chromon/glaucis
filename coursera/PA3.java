public class PA3 {

	public void prime() {
		int[] a = new int[101];
		//0 = undiscovered
		//1 = prime
		//2 = selectd out
		for(int i=2; i<a.length; i++) {
			if(a[i] == 0) {
				a[i] = 1;
			}else if(a[i] == 2) {
				continue;
			}else {
				System.out.println("Error!");
			}
			for(int j=i+1; j<a.length; j++) {
				if(a[j] == 0 && j%i == 0) {
					a[j] = 2;
				}
			}	
		}
		for(int k = 2; k<a.length; k++) {
			if(a[k] == 1) {
				System.out.print(k+ " ");
			}
		}
	}

	public static void main(String []args) {
		new PA3().prime();
	}
}