package com.test.controlStatement;

public class ForLoopTest {
	public static void main(String[] args) {
		/*
		 * for(;;){ System.out.println("Inside the for looop"); }
		 */
		/*
		 * for(int i=0;i<5;i++){ System.out.println(i); }
		 */
		/*
		 * //for(int i=0,int j=10;i<5;i++){ for(int
		 * i=0,j=10;i<5;System.out.println("Iterator")){ System.out.println(i);
		 * }
		 */

		/*
		 * for(int i=0;i<5;System.out.println("Iterator")){
		 * System.out.println(i); i++; }
		 */
		/*
		 * for(int i=0;i<5;System.out.println("Iterator")){
		 * System.out.println(i); break; }
		 */
		/*
		 * for(int
		 * i=0;i<5;i++,System.out.println("Iterator"),System.out.println(i)){
		 * return ; }
		 */
		/*// for(int i=0;i<5;i++,System.out.println("Iterator"),System.out.println(i),continue){
		for (int i = 0; i < 5; i++, System.out.println("Iterator"), System.out.println(i)) {
			System.exit(0);
		}*/
		
		int i=0;
		for(;i<5;){			
			System.out.println(i);
			i++;
		}

	}
}
