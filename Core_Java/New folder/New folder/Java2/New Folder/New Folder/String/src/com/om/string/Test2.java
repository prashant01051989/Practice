package com.om.string;

class Hello{
	int fac(int num){
		
		int fac=1;
		if(num<=-1)
			return -num;
		if(num==0){
			return 1;
		}	else{
			while(num>1){
			fac=num*fac;
			num--;
			}
		}
		
		return fac;	
	}
	void rev(int num){
		int rem=0;
		
		while(num!=0){
			rem=num%10;
			
			num=num/10;
		}
	}
		
		public void fib(int num ){
			int x=0;
			int y=1;
			int z;
			if(num <= 0)
				System.out.println("Please enter number");
			else if(num>=1)
				System.out.println(x);
				for(int i=0;i<=10;i++){
					z=x+y;
				System.out.println(z);
					x=y;
					y=z;
			}
		}

	
	boolean arm(int num){
		int rem=0;
		int sum=0;
		int num1=num;
		while(num!=0){
		rem=num%10;
		sum=(int) (sum+Math.pow(rem,3));
		num=num/10;
		}
		System.out.println(sum+"\t"+num);
		if(sum==num1){
			return true;
		}else{ 
			return false;
		}
	}
	void prim(int num){
	int	cou=0;
	
	for(int i=2;i<num;i++){
	if(num%i==0)
		cou++;
	}
	}
}
public class Test2 {

	public static void main(String[] args) {
		int i=123456;
		Hello h=new Hello();
		h.rev(7896);
		int num=-2;
		int i1=h.fac(num);
		if(num<=-1)
			System.out.println("Please enter non-negative number");
		else
			System.out.println(i1);
		
		System.out.println(h.arm(371));
	}

}
