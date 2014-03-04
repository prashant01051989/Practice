package om.arrat.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {
public static void main(String as[]){
	int arr[]={10,45,25,6,78,12,21};
	int arr1[]={10,45,25,6,78,12,21};
	int arr2[]={10,45,525,36,758,1,621};
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+",");
	}
	System.out.println();
	System.out.println();
	for(int i=0;i<arr1.length;i++){
		System.out.print(arr1[i]+",");
	}
	System.out.println();
	System.out.println();
	for(int i=0;i<arr2.length;i++){
		System.out.print(arr2[i]+",");
	}
	System.out.println();
	System.out.println(Arrays.equals(arr,arr1));
	System.out.println(Arrays.binarySearch(arr,6));
	Arrays.fill(arr,32);
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+"\t");
	}
	System.out.println();
	System.out.println();
	Arrays.sort(arr2);
	for(int i=0;i<arr2.length;i++){
		System.out.print(arr2[i]+"\t");
	}
	System.out.println();
	System.out.println();
	
	Object obj[]={"I","am","a","Student","anshu"};
	for(int i=0;i<obj.length;i++){
		System.out.print(obj[i]+"\t");
	}
	System.out.println();
	System.out.println();
	
	List<Object> list=Arrays.asList(obj);
	Iterator<Object> it=list.iterator();
	while(it.hasNext()){
		System.out.print(it.next()+"\t");
	}
	System.out.println();
	System.out.println();
	System.out.println(Arrays.hashCode(arr));
	int []arr3=new int[9];
	System.arraycopy(arr,0,arr3,0,4);
	System.out.println(arr3.length);
	for(int i=0;i<arr3.length;i++){
		System.out.print(arr3[i]+"\t");
	}
}
}
