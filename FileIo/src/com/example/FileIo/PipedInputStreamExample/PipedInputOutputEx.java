package com.example.FileIo.PipedInputStreamExample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputOutputEx extends Thread {
	InputStream input;
	OutputStream output;

	public PipedInputOutputEx(InputStream in, OutputStream out) {
		input = in;
		output = out;
	}

	@Override
	public void run() {
		// 데이터를 읽어오기 위해서 배열을 선언..
		byte[] buff = new byte[1024];
		int data = 0;
		try {
			while (true) {
				data = input.read(buff);
				if (data != -1) {
					output.write(buff, 0, data);// 0~읽어온 수만큼...
				} else {
					return;
				}
			}//while
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력된 데이터를 가지고 PipedStream을 통해서 출력을 하는예..
		PipedInputStream pin = new PipedInputStream();
		PipedOutputStream po = new PipedOutputStream();
		//두개의 스트림을 연결하기 위해서...
		pin.connect(po); //pipeOutputStream을 연결해줘야 한다..
		
		PipedInputOutputEx t1 = new PipedInputOutputEx(System.in, po);
		PipedInputOutputEx t2 = new PipedInputOutputEx(pin, System.out);
		t1.start();
		t2.start();//출력 스레드..
	}
}
