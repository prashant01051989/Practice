package com.test.lang;

public class StringTest {

	public void test() {
		String st1 = "Prashant";
		System.out.println("st1 :" + st1);
		String st2 = new String();
		System.out.println("st2 :" + st2);
		String st3 = new String("Prashant3");
		System.out.println("st3 :" + st3);
	
		byte[] b1 = new byte[4];
		b1[0] = 65;
		b1[1] = 66;
		b1[2] = 67;
		b1[3] = 68;
		String st4 = new String(b1);
		System.out.println("st4 :" + st4);
		System.out.println("st3.length() :" + st3.length());
		System.out.println("st3.isEmpty() :" + st3.isEmpty());
		System.out.println("st3.charAt() :" + st3.charAt(1));
		System.out.println("st3.codePointAt(1) :" + st3.codePointAt(1));
		System.out.println("st3.codePointBefore(1) :" + st3.codePointBefore(1));
		System.out.println("st3.codePointcount(1,4) :"
				+ st3.codePointCount(1, 4));
		char c[] = new char[st4.length()];
		st3.getChars(1, 4, c, 0);
		System.out.println(c);
		byte[] b2 = st3.getBytes();

		for (int i = 0; i < b2.length; i++) {
			System.out.print(b2[i] + "  ");
		}
		System.out.println();

		String st5 = "Prashant";
		String st6 = new String("Prashant3");
		System.out.println("st1.equals(st3) :" + st1.equals(st3));
		System.out.println("st1.equals(st5) :" + st1.equals(st5));
		System.out.println("st3.equals(st6) :" + st3.equals(st6));
		boolean bol = st1 == st3;
		System.out.println("st1==st3 :" + bol);
		bol = st1 == st5;
		System.out.println("st1==st5 :" + bol);
		bol = st3 == st6;
		System.out.println("st3==st6 :" + bol);
		st3 = st3.intern();
		st6 = st6.intern();
		bol = st3 == st6;
		System.out.println("st3==st6 :" + bol);
		final String st8 = "Infinite";
		final String st9 = "Computer";
		String st12 = "Infinite";
		String st13 = "Computer";
		String st7 = "InfiniteComputer";
		String st10 = st8 + st9;
		String st14 = st12 + st13;
		String st11 = "Infinite" + "Computer";
		bol = st7 == st10;
		System.out.println("st7==st10 :" + bol);
		bol = st7 == st14;
		System.out.println("st7==st14 :" + bol);
		bol = st7 == st14.intern();
		System.out.println("st7==st14 :" + bol);
		System.out.println("st7.equals(st10) :" + st7.equals(st10));
		bol = st7 == st11;
		System.out.println("st7==st11 :" + bol);
		System.out.println("st7.equals(st11) :" + st7.equals(st11));
		System.out.println( "Anshu".equalsIgnoreCase("anshu"));
		int i="Anshu".compareTo("Anshu");
		System.out.println("compareTo(): "+i);
		i="Anshu".compareTo("anshu");
		System.out.println("compareTo(): "+i);
		i="ansha".compareTo("Ansha");
		System.out.println("compareTo(): "+i);
		i="Anshu".compareToIgnoreCase("anshu");
		System.out.println("compareTo(): "+i);
		bol="Anshu".regionMatches(0, "anshu", 0, 3);
		System.out.println("regionMatcher :"+bol);
		bol="Anshu".regionMatches(true,0, "anshu", 0, 3);
		System.out.println("regionMatcher :"+bol);
		bol="Anshu".startsWith("An");
		System.out.println("StartsWith :"+bol);
		bol="AnshuAn".startsWith("An",5);
		System.out.println("StartsWith :"+bol);
		bol="Anshu".endsWith("hu");
		System.out.println("endsWith :"+bol);
		System.out.println("st1.hashCode() :"+st1.hashCode());
		System.out.println("st1.indexOf(\'p\') :"+st1.indexOf('p'));
		System.out.println("st1.indexOf(\'P\') :"+st1.indexOf('P'));
		System.out.println("st1.indexOf(\'a\',3) :"+st1.indexOf('a',3));

		System.out.println("st1.lastIndexOf(\'p\') :"+st1.lastIndexOf('p'));
		System.out.println("st1.indexOf(\'a\') :"+st1.lastIndexOf('a'));
		System.out.println("st1.lastIndexOf(\'a\',3) :"+st1.lastIndexOf('a',1));
		System.out.println("Infinite Computer Solution".indexOf("computer"));
		System.out.println("Infinite Computer Solution".indexOf("Computer"));
		System.out.println("Infinite Computer Solution Computer".indexOf("Computer",10));
		System.out.println("Infinite Computer Solution Computer".lastIndexOf("Computer"));
		System.out.println("Infinite Computer Solution Computer".lastIndexOf("Computer",1));
		System.out.println("Infinite Computer Solution Computer".substring(6));
		System.out.println("Infinite Computer Solution Computer".substring(6,25));
		System.out.println("Infinite".concat("Computer").concat("Solution"));
		System.out.println("Anshun".replace('n', 'N'));
		System.out.println(String.valueOf(100));
		System.out.println(String.valueOf(100.00f));
		System.out.println(String.valueOf(100l));
		System.out.println(String.valueOf('c'));
		System.out.println("String.valueOf(true) :"+String.valueOf(true));
		c=st8.toCharArray();
		System.out.println(c);
		st14="  Infinite Computer Solution    ";
		System.out.println(st14.length());
		st14=st14.trim();
		System.out.println(st14.length());
		System.out.println(st14.toUpperCase());
		System.out.println(st14.toLowerCase());
		String st15[]="A B C D E".split(" ");
		for (int j = 0; j < st15.length; j++) {
			System.out.println(st15[j]);
		}
		
		
		
		
		
	}

	public static void main(String[] args) {
		StringTest st = new StringTest();
		st.test();
	}

}
