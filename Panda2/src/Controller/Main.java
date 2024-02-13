package Controller;

import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainF= new MainFrame();
		mainF.setVisible(true);
		SysData.UploadQuestions() ;   // uploading the questions 
		System.out.println(SysData.EasyQues);
		
	}

}
