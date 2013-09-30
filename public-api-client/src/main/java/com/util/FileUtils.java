package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileUtils {

	private FileUtils() {
	}

	public static File streamToFile(InputStream inputStream, String fileName) {

		OutputStream outputStream = null;

		File file = new File(fileName);

		try {
			outputStream = new FileOutputStream(file);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (IOException e) {
			throw new IllegalStateException(e);

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return file;
	}

	public static void deleteFolder(File folder) {

		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					file.delete();
				}
			}
		}
		folder.delete();
	}

	public static String readFileAsString(String filePath) {
		try {
			StringBuffer fileData = new StringBuffer();
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			char[] buf = new char[1024];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
			}
			reader.close();
			return fileData.toString();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
