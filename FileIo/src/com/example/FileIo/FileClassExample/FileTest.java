package com.example.FileIo.FileClassExample;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		String fname = "D:/02javaStudy/FileTest/fileTest.txt";
		
		File file = new File(fname);
		
		System.out.println("파일명:" + file.getName()); //해당 파일의 이름을 얻을수 있다...
		System.out.println("파일의 절대경로 나타내는 메서드:" + file.getAbsolutePath());
		System.out.println("파일의 상대경로:" + file.getPath());
		System.out.println("파일의 사이즈:" + file.length());
		
		File file2 = new File("Test","ftest2.txt");
		System.out.println(file2.exists());//존재시 true | false : 일시 파일은 존재하는데
											//생성이되지 않은것...
											//File 객체는 추상적인 표현이다...
		System.out.println(file2.getAbsolutePath()); //여기서 ftest2.txt가 출력이 되지만
													 //실제 존재하는 파일이 아니다 
													//인스턴스만 생성한 것이다!!!!
		System.out.println("file이 파일인지 여부:" + file.isFile()); //true 출력
		System.out.println("file2 파일인지 여부:" + file2.isFile()); //false 출력
		
		System.out.println("file2.txt 의 부모경로:" + file2.getParent());
		System.out.println("file의 부모경로:" + file.getParent());
		System.out.println("file의 부모경로:" + file.isDirectory()); //false값이 나온댜..
		//파일의 읽고쓰기 가능한지 테스트
		System.out.println(file.canWrite() ? "쓰기가능":"쓰기불가능"); //쓰기가능 출력
		System.out.println(file2.canWrite() ? "쓰기가능":"쓰기불가능"); //쓰기불가능
		System.out.println(file.canRead() ? "읽기가능" : "읽기불가능");
		System.out.println(file2.canRead() ? "읽기가능" : "읽기불가능");
		
		//디렉토리만 생성..
		//추상적인 형태로만 존재...
		File file3 = new File("test");
		//실제로 생성
		file3.mkdir();
		
		File file4 = new File("aaa","aaa1");
		file4.mkdirs(); //위의 두개의 폴더를 지정하므로 
		//aaa폴더안의 aaa1폴더를 지우고 bbb라는 폴더가 새롭게 생성
		boolean ren = file4.renameTo(new File("bbb"));
		System.out.println(ren);
		
		boolean ren2 = file3.renameTo(new File("test1"));
		System.out.println(ren2);
		
		boolean res = file4.delete();
		System.out.println(res);
		
		
		int pos = fname.lastIndexOf("."); //구분자의 위치값을 얻어온다...
		int fos = fname.lastIndexOf("/"); //  경로 위치값 얻어온다...
		System.out.println(fos);
		//확장자를 제외한 파일명을 출력한다.
		System.out.println("확장자를 제외한 파일명:" + fname.substring(0, pos));
		//경로를 제외한 파일명만 보게 하는 방법..
		System.out.println("경로제외 확장자명:" + fname.substring(fos + 1,pos));
		//확장자만 출력하는 방법..
		System.out.println("확장자:" + fname.substring(pos+1));
		
		System.out.println("파일 구분자:" + file.separator);
		System.out.println("파일 구분자:" + file.separatorChar);
	}
}
