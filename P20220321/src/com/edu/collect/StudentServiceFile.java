package com.edu.collect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//StudentServiceImpl (중첩클래스의 기능 대체)
//입력, 수정, 삭제 => 파일에 저장이 되도록
public class StudentServiceFile implements StudentService {

	//필드
	List<Student> list = new ArrayList<Student>();
	File file;
	
	//생성자
	//기본 생성자에 파일에 저장되어서 있는 내용을 읽어서 list값을 담아준다
	public StudentServiceFile() {
		try {
			FileReader fr = new FileReader("studentList.data");
			BufferedReader br = new BufferedReader(fr);
			String readBuffer = null;
			while((readBuffer = br.readLine()) != null) {
				String[] contents = readBuffer.split(",");
				list.add(new Student(Integer.parseInt(contents[0]), contents[1], Integer.parseInt(contents[2]), Integer.parseInt(contents[3])));
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertStudent(Student student) {
		list.add(student);
	}

	@Override
	public Student getStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == sno) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		return list;
	}

	@Override
	public void modifyStudent(Student student) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == student.getNumber()) {
				list.get(i).setEngScore(student.getEngScore());
				list.get(i).setKorScore(student.getKorScore());
			}
		}
	}

	@Override
	public void removeStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == sno) {
				list.remove(i);
			}
		}
	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> searchList = new ArrayList<Student>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}

	@Override
	public void saveToFile() {
		// 작성했던 ArrayList<Student> list => 파일저장
		try {
			FileWriter fw = new FileWriter("studentList.data");  //문자기반으로 2바이트씩 처리하는 클래스
			BufferedWriter bw = new BufferedWriter(fw);  //보조스트림의 생성자의 매개값으로 기본스트림을 넣어줌

			for (Student stud : list) {
				bw.write(stud.getNumber() + "," + stud.getName() + "," + stud.getEngScore() + "," + stud.getKorScore()+"\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
