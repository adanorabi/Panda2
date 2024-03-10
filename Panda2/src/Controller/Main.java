package Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Enum.Levels;
import Model.Board;
import Model.Dice;
import Model.Game;
import Model.Question;
import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainF= new MainFrame();
		mainF.setVisible(true);
		SysData.UploadQuestions(); // uploading questions from json -Yara

	}
}

