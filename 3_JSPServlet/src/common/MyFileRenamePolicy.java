package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {//MyFileRenamePolicy를 오버라이딩해준다. //implements
		long currentTime = System.currentTimeMillis();
		int ranNum = (int)(Math.random() * 10000);
		
		String name = originFile.getName();//파일이름
		String ext = null;//확장자
		 int dot = name.lastIndexOf(".");//가장마지막에 있는 .에 대한 인덱스를 가지고 와라
		 if(dot == -1) {
			 ext = "";
		 } else {
			 ext = name.substring(dot); // .PNG라고 나옴 확장자
		 }
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 String fileName = sdf.format(new Date(currentTime)) + ranNum + ext; //Date : util import
		 
		 File newFile = new File(originFile.getParent(), fileName);
		//파일이 만들어지면서 바꿔준 이름으로 fileName만들어 줘서 그 상태로 return newFile에 저장 
		
		return newFile;
	}
	
	
}
