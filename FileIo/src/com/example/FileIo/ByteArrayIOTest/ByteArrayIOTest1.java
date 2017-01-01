package com.example.FileIo.ByteArrayIOTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ByteArrayIOTest1 {
	public static void main(String[] args) {
		byte[] input = {0,1,2,3,4,5,6,7,8,9};
		byte[] output = null;
		byte[] buff = new byte[10];
		ByteArrayInputStream ins = null;
		ByteArrayOutputStream outs = null;
		
		ins = new ByteArrayInputStream(input); //배열을 넣어준다...
		outs = new ByteArrayOutputStream(); //괄호안에 배열값을 넣으면 안된다...
		
		int n = 0;
		ins.read(buff, 0, input.length);
		outs.write(buff,4,5); //배열의 위치 4번째부터 ~~ 5번째
		while((n = ins.read()) != -1){
			outs.write(n);
			//System.out.println(n); //읽어온 n값!!
		}
		output = outs.toByteArray(); // 
		System.out.println(Arrays.toString(output));
				
	}
}
