
public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSquare(10);
	}
	static void printSquare(int n){
		if(n>0){
			printSquare(n-1);
		System.out.println("Square of "+n+":"+n*n);}
	}

}
