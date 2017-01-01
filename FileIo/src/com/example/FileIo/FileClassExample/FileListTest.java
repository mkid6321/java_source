package com.example.FileIo.FileClassExample;

import java.io.File;

public class FileListTest {
	public static void main(String[] args) {
		String dName = "D:/02javaStudy/FileTest";
		
		File dir = new File(dName);
		String[] filelist = dir.list(); //해당 폴더의 파일목록(서브폴더 목록)
										//배열로 반환.
		for(String f:filelist){
			//폴더 파일 목록 출력...
			System.out.println(f);
		}//end for
		for(int i = 0; i<filelist.length; i++){
			System.out.println(filelist[i]);
		}
		System.out.println("------------------------------------------------");
		System.out.println("파일/폴더 \t 크기");
		System.out.println("------------------------------------------------");
		
		File[] filelist2 = dir.listFiles();
		for(File f: filelist2){
			String str = f.getName();
			if(f.isDirectory()){
				System.out.print(str + "\t\t");
				System.out.print("DIR");
			}else{
				//텍스트 파일일 경우에
				if(str.endsWith(".txt")){
					System.out.println(str + "\t\t" + f.length() + "바이트\n");
				}
			}
		}
	}
}
