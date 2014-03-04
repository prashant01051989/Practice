package com.test.array;

public class ArrayTest1 {
	public static void main(String[] args) {
		/*int []a=new int[2];
		a[0]=5;
		a[1]=5;
		//a[2]=5;
		int b[];
		b=new int[2];
		b[0]=5;
		b[1]=5;
		a=new int[4];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=4;
		//a=new int;
		//a=new int[];
		//a={1,1,1,1,1};
		int c[]={1,1,1,1,1};
		//c={3,3,3,3,3,3,3};
		int x[]=new int[]{4,4,4,4};
		System.out.println(x.length);
		x=new int[]{4,4,4,4};
		*/
		int a[][]=new int[2][2];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++)
				a[i][j]=i;
		for(int i=0;i<a.length;i++)
				for(int j=0;j<a[i].length;j++)
					System.out.println(a[i][j]);
		
		a=new int[2][];
		a[0]=new int[6];
		a[1]=new int[5];
		a[0][0]=1;
		a[0][1]=1;
		a[0][2]=1;
		a[0][3]=1;
		a[1][0]=1;
		a[1][1]=1;
		a[1][2]=1;
		System.out.println(">>>"+a.length);
		System.out.println(">>>"+a[0] instanceof Object);
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++)
				System.out.println(a[i][j]);

	 int q[][]={{1,1,1,1},{}};
	 System.out.println("===="+q[1].length);
	 for(int i=0;i<q.length;i++)
			for(int j=0;j<q[i].length;j++)
				System.out.println("--"+q[i][j]);
	 
		int b[]=new int[3];
		b=new int[4];
		int c[]={4,4,4,4};
		c=new int[5];
		
		
	}
	
		

}
