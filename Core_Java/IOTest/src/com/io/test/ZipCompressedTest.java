package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompressedTest {

	public static void main(String[] args) throws IOException {
		String zipFile = "D:\\LABS\\JAVA_LABS\\Core_Java\\IOTest\\ZipFile.zip";
		String srcDir = "D:\\RC_Practice\\web\\RecordCenter\\src\\main\\java\\com\\ironmountain\\recordcenter\\controller";

		FileOutputStream fos = null;
		ZipOutputStream zos = null;

		FileInputStream fis = null;
		ZipInputStream zis = null;

		ZipEntry ze = null;
		byte[] buffer = new byte[1024];
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			File dir = new File(srcDir);
			File[] list = dir.listFiles();

			for (int i = 0; i < list.length-2 ; i++) {
				fis = new FileInputStream(list[i]);
				ze = new ZipEntry(list[i].getName());
				zos.putNextEntry(ze);
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
			}
			zos.close();
			fis.close();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
