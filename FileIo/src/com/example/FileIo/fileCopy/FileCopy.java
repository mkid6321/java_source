package com.example.FileIo.fileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.tree.FixedHeightLayoutCache;
//Buffer
//버퍼를 메모리에 두고 읽어 오는것이 빠르다...
//데이터를 모아서 한꺼번에 처리하는것이 빠르다...
public class FileCopy {
	public static void main(String[] args) throws IOException {
		String src = "C:/Users/Public/Pictures/Sample Pictures/source_img.jpg"; //소스 파일
		String target = "C:/Users/Public/Pictures/Sample Pictures/target_img.jpg"; //타겟 파일
		//src의 이미지를 target으로 복사한다...
		FileInputStream fn = null;
		FileOutputStream fo = null;
		
		int n = 0;
		int cnt = 0;
		int tot = 0; // 읽어온 바이트 수
		try {
			fn = new FileInputStream(src); //파일 스트림은 노드 스트림이라고도 한다..
			fo = new FileOutputStream(target);
			byte buf[] = new byte[1024];
			while((n = (fn.read(buf))) != -1){ //여기서 n은 읽어온 바이트 수..
				fo.write(buf,0,n);//buf를 읽어온 만큼 그대로 적얻준다..
				fo.flush(); //출력하는 과정....
				cnt++;
				tot += n;
			}
			System.out.println("cnt:" + cnt);
			System.out.println(tot + "바이트가 복사 되었습니다.");
			fo.close();
			fn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
