package com.test.spring.ioc1.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.test.spring.ioc1.Hello;

public class Main {
	public static void main(String as[]) throws IOException {
		//ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:config.xml");
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:*.xml");
		
		Hello hello = app.getBean("hello1", Hello.class);
	Resource rs = app.getResource("config.xml");
		System.out.println(rs);
		System.out.println(rs.getDescription());
		File file = rs.getFile();
		System.out.println(file.canRead());
		BufferedReader br = null;

		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		hello.show();

	}
}
