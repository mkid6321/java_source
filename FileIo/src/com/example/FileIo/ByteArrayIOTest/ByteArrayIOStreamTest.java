package com.example.FileIo.ByteArrayIOTest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteArrayIOStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fn = new FileInputStream(args[0]);		
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		byte[] buffer = new byte[512];
		byte[] output = null; //출력용 배열..
		int n;
		while((n = fn.read(buffer)) != -1){
			byteout.write(buffer,0,n);
		}
		output = byteout.toByteArray();
		System.out.write(buffer,0,output.length);
	}
}
