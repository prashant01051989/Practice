package com.test.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	
	public static void fun(int i,Map<Integer, Employee> map){
	
	}
	public static void main(String[] args) {
		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(new Employee(0, 0));
		emplist.add(new Employee(1, 0));
		emplist.add(new Employee(2, 0));
		emplist.add(new Employee(3, 0));
		emplist.add(new Employee(1, 1));
	/*	emplist.add(new Employee(2, 1));
		emplist.add(new Employee(4, 1));
		emplist.add(new Employee(3, 1));
		emplist.add(new Employee(3, 2));
		emplist.add(new Employee(1, 2));*/
		System.out.println(emplist);
		//emplist.remove(2);
		
		for (int col = 0; col < 3; col++) {
			Map<Integer, Employee> map = new TreeMap<Integer, Employee>();
			int max=1;
			int i = 0;
			for (Employee employee : emplist) {
				
				if (employee.getColumn() == col) {
					
					map.put(employee.getRow(), employee);
					max++;
				}
			}
			
			int row=0;
			
			for (Map.Entry<Integer, Employee> emp : map.entrySet()) {
				System.out.println("????????????");
				if (emp.getKey() != row) {
					emp.getValue().setRow(row);
				}
				row++;
			}
			
			if(max<=5 && (!map.isEmpty())){
				boolean flag=true;
			for (Employee employee : emplist) {

				if (employee.getColumn() == col+1) {
					flag=false;
					map.put(employee.getRow(), employee);
				}
			}
			if(!flag)
			for (Map.Entry<Integer, Employee> emp : map.entrySet()) {
				if (emp.getKey() != row) {
					emp.getValue().setRow(row);
					emp.getValue().setColumn(col);
				}
				row++;
			}
			max=0;
		}		
	}
		
		
		System.out.println(emplist);
		
		/*for (int col = 0; col < 3; col++) {
			int i = 0;
			for (Employee employee : emplist) {
				if (employee.getColumn() == col) {
					i++;
				}
			}

			if (i < 4) {
				emplist.add(new Employee(i, col));
				break;
			}
		}
		System.out.println(emplist);*/

		/*for (int col = 0; col < 3; col++) {
			int i = 0;
			for (Employee employee : emplist) {
				if (employee.getColumn() == col) {
					i++;
				}
			}

			if (i < 4) {
				emplist.add(new Employee(i, col));
				break;
			}
		}*/
		System.out.println(emplist);

	}
}

class Employee {
	int row;
	int column;

	public Employee(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "[row=" + row + ", column=" + column + "]";
	}

}