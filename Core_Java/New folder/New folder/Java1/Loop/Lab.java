class Lab{
public static void main(String as[]){
for(int i=1;i<=5;i++){
 for(int j=1;j<=i;j++){
   System.out.print(" * ");
    }
for(int j=4;j>=i;j--){
   System.out.print("   ");
    }
for(int j=3;j>=i;j--){
   System.out.print("   ");
    }
	int k=i;
	if(i==5)
	   k--;
for(int j=1;j<=k;j++){
   System.out.print(" * ");
    }

 System.out.println("");
 }
 

for(int i=4;i>=1;i--){
 for(int j=1;j<=i;j++){
   System.out.print(" * ");
    }
for(int j=4;j>=i;j--){
   System.out.print("   ");
    }
for(int j=3;j>=i;j--){
   System.out.print("   ");
    }	
for(int j=1;j<=i;j++){
   System.out.print(" * ");
    }
	System.out.println("");
 } 
 
 
}
}

/*
E:\Prashant\Loop>java Lab
 *                       *
 *  *                 *  *
 *  *  *           *  *  *
 *  *  *  *     *  *  *  *
 *  *  *  *  *  *  *  *  *
 *  *  *  *     *  *  *  *
 *  *  *           *  *  *
 *  *                 *  *
 *                       *
 
 */