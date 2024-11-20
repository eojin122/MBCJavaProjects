package ch18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExample1 {
	
	/* 
	 * File 클래스
	 * 	: file 객체를 생성하는 클래스. 파일(파일과 디렉터리)과 관련된 작업을 진행할 수 있음
	 */
	
	// cmd에서 path 입력해서 나온 PATH= 뒤에 있는 경로값 복사해온 것
	// 주의) "" 안에서 ctrl + v 할 것(이스케이프 문자때문에 값이 안들어갈 수 있음)
	static String env_path = "C:\\Program Files\\Python313\\Scripts\\;C:\\Program Files\\Python313\\;C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files (x86)\\NVIDIA Corporation\\PhysX\\Common;C:\\Program Files\\Java\\jdk-21\\bin;C:\\Program Files (x86)\\Windows Kits\\10\\Windows Performance Toolkit\\;C:\\Users\\Admin\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\Admin\\AppData\\Local\\Programs\\Microsoft VS Code\\bin";

	public static void main(String[] args) {
		// File 객체 생성
		File f = new File("D:/Temp/a.txt");	// 일반 파일 정보를 담은 객체
		File dir = new File("./");			// 디렉터리 파일 정보를 담은 객체
		// "./" : 현재 디렉터리를 의미함
		
		// 1. exists : 파일 혹은 디렉터리의 존재 여부 확인
		System.out.println("exists? : " + f.exists());		// false
		System.out.println("exists? : " + dir.exists());	// true
		
		// 2. isDirectory : 디렉터리인지 여부 확인 (파일이면 false)
		System.out.println("isDirectory? : " + f.isDirectory());	// false
		System.out.println("isDirectory? : " + dir.isDirectory());	// true
		
		// 3. isAbsolute : 해당 경로가 절대 경로인지 여부 확인
		// 절대 경로 : 최상위 디렉토리부터 모든 경로를 다 표시하는 경우
			// C:\Program files\java\jdk-21\bin\java.exe
			// D:\Temp\a.txt
			// File 작업에서 디렉토리 구분값으로 "\\" 또는 "/"
		// 상대 경로 : 현재 작업 위치로부터 경로를 표시하는 경우
			// ./ : 현재 디렉터리
			// ../ : 상위 디렉터리(바로 위)
			// ../test/test.txt -> 부모 디렉터리에서 test 디렉터리에 있는 test.txt파일
		System.out.println("isAbsolute? : " + f.isAbsolute());		// true
	    System.out.println("isAbsolute? : " + dir.isAbsolute());	// false
	    
	    // 4. canExecute(실행권한), canRead(읽기권한), canWrite(쓰기권한) : 권한 확인
	    System.out.println("canExecute? : " + f.canExecute());
	    System.out.println("canRead? : " + f.canRead());
	    System.out.println("canWrite? : " + f.canWrite());	// 파일의 속성에서 읽기 전용 체크시 canWrite(쓰기권한) false
	    
		// 5. getAbsolutePath : 절대 경로 반환 (상대경로를 절대경로로 찾아줌)
	    System.out.println("./의 실제 위치 (절대 경로) : " + dir.getAbsolutePath()); 	// 출력 : D:\[KDT]AI-eojin\Javaprojects\thisisjava\.
	    
	    // 6. 부모 폴더를 문자열로 반환
	    String parentDir = f.getParent();
	    System.out.println(parentDir); 		// 출력 : D:\Temp -> 단순 문자열(Stirng)
	    
	    // 7. 부모 폴더를 file 객체로 변환 : getParentFile()
	    File f_parent = f.getParentFile();
	    System.out.println(f_parent); 		// 출력 : D:\Temp -> 파일 객체(File Object) => 경로에 파일이 있는지 확인 등 파일과 관련된 작업을 할 수 있음
	    
	    // 8. File 상수값 : 구분값 기호
	    System.out.println(File.separator);			// 출력 : \	-> 디렉토리 구분값을 상수값으로 가지고 있음(String로 불러움)
	    System.out.println(File.separatorChar);		// 출력 : \	-> 구분값을 Char로 불러옴
	    System.out.println(File.pathSeparator);		// 출력 : ;	-> 경로 구분값을 상수값으로 가지고 있음(String로 불러움)
	    System.out.println(File.pathSeparatorChar);	// 출력 : ;	-> 구분값을 Char로 불러옴
	    
	    // 환경 변수
	    String[] path = env_path.split(File.pathSeparator);
	    
	    for (String p : path) {
	    	System.out.println(p);
	    }
	    
	    // 파일 생성/수정/삭제 메서드
	    File test = new File("D:/Temp/Temp/abc");
	    // mkdir : 해당 경로에 폴더(디렉터리)를 만든다.
	    // mkdirs : 존재하지 않은 부모 폴더(디렉터리)까지 모두 포함해서 폴더 생성
	    if(!test.exists()) {
//	    	test.mkdir();	// 경로에 부모 디렉터리 중 하나라도 없으면 생성 X, 반환값 boolean(만들기 성공하면 true, 실패하면 false) "D:/Temp/Temp"일때 실행 가능했음
	    	test.mkdirs();	// 
	    }
	    
	    // createNewFile : 파일이 없으면 새로 생성
	    test = new File("D:/Temp/filetest3/test/a.txt");
	    
	    try {
	    	File testDir = test.getParentFile();	// 부모 디렉터리를 File객체로 반환
	    	if(!testDir.exists()) {
	    		if(testDir.mkdir()) {	// 부모를 상관하지 않고 그냥 만들고 싶으면 밑에 조건문 과정 없이 mkdirs() 사용
	    			//mkdir() 실행시 : 경로가 "D:/Temp/filetest3/test/a.txt"이고, filetest3이 존재하면 만들 수 있고, filetest3이 없으면 실패 
	    			//mkdirs() 실행시 : 경로가 "D:/Temp/filetest3/test/a.txt"이고, filetest3이 존재하지 않아도 mkdirs()가 경로에 없는 파일을 만들어서 성공시킴
	    			System.out.println("디렉터리 생성");
	    			if(test.createNewFile()) { 		// 반환 타입 boolean
	    				System.out.println("파일 생성");
	    			} else {
	    				System.out.println("파일 생성 실패");
	    			}
	    		} else {
	    			System.out.println("디렉터리 생성 실패");
	    			throw new FileNotFoundException("파일 경로 못찾음");
	    		}
	    	}
			test.createNewFile();	// 반환 타입 boolean
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 생성 중 에러가 발생했음");		// java.io.IOException: 지정된 경로를 찾을 수 없습니다. 
		}
	    
	    // 디렉터리내에 정보 확인: listFiles() 디렉터리 내용 출력
	    File[] dirFiles = f_parent.listFiles();
	    System.out.println("D:\\Temp 디렉터리 내용");
	    for(File af : dirFiles) {
	    	System.out.println(af);
	    }
	    System.out.println();
	    
	    
	    // delete : 파일이나 디렉터리를 삭제, 디렉터리는 비어있지 않으면 삭제 불가
	    test = new File("D:/Temp/filetest3/test/");	// 파일인 경우는 상관 없는데, 디렉터리인 경우 비어있지 않으면 삭제 불가
	    
	    if (!test.delete()) {	// 삭제 실패시
	    	if (test.isDirectory()) {
	    		System.out.println("디렉터리 삭제 실패");
	    		System.out.println(test + "디렉터리가 비어있지 않음");
	    		for (File df : test.listFiles()) {
	    			if(!df.delete()) {
	    				System.out.println(df + " 삭제 실패!");
	    			}
	    		}
	    		test.delete();
	    	} else {
	    		System.out.println("파일 삭제 실패");
	    	}
	    	
	    } else {
	    	System.out.println("삭제를 성공했습니다.");
	    }
	    
	}

}
