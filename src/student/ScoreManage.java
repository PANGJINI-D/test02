package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* 
 * 해시맵 관련 메서드들이 기억이 안나서 메서드 관련 전체적으로 검색해본 후 코딩했습니다ㅠㅠ
 * 예외처리 다시 공부해서 코드 수정할것
 */
public class ScoreManage implements StudentManage {
//	o   학생이름과 점수 관리하는 HashMap 사용
//	o   이름을 키로, 점수를 값으로 저장할 것
//	   단, 모든 필드는 private으로 설정 / toString 오버라이딩
//	o   인터페이스를 이용하여 구현 클래스 만들 것
//	o   생성자는 기본 생성자만 이용
//	   예외상황 생각할 것(ex: 학생 점수가 음수인 경우, 학생 점수에 정수형이 아닌 경우 등)

	private Map<String, Integer> student;
	
	public ScoreManage() {
		student = new HashMap<String, Integer>();
	}
	
	@Override
	//이름과 점수 추가
	public void addStudent(String name, int score) {
		// 예외처리할 것 : 학생 이름이 없는 경우, 학생 점수가 음수인 경우
		if(score < 0 || score > 100) {
			//throw new Exception("---- 점수는 0과 100 사이의 값이 입력되어야 함. ----");
			System.out.println("----- 점수는 0과 100 사이의 값을 입력하세요. -----");
		} else {
			student.put(name, score);			
		}
	}

	@Override
	//특정 학생의 점수 조회
	public void getStudentScore(String name) {
		// 예외처리 할 것 : 검색했는데 학생이 없는 경우
		int score = student.get(name);
		String result = "[" +name + "의 점수] " + score;
		System.out.println(result);
		
//		if(score == null) {
//			System.out.println("---- 없는 학생입니다. ----");
//		} 
	}

	@Override
	//모든 학생의 이름과 점수 조회
	public void showStudents() {
		List<Map.Entry<String, Integer>> studentList = new ArrayList<>(student.entrySet());

		System.out.println("[전체 학생 정보]");
		for(Entry<String, Integer> stu : studentList) {
			System.out.println(stu.getKey() + " : " + stu.getValue());
		}
		System.out.println("--------------------");
	}

	@Override
	//평균 이상의 점수를 받은 학생만 출력
	public void showAvgStu() {
		//예외처리 할 것 : 등록된 학생이 없을 때
		if(student.isEmpty()) {
			System.out.println("---- 등록된 학생이 없습니다. ----");
			return;
		}
		
		// 평균 계산
		int sum = 0;
		for(int score : student.values()) {
			sum += score;
		}
		double avg = sum / student.size();
		System.out.println("[평균점수] " + avg);
		
		// 평균 이상의 학생 추출
		// key:value 모두 쓰이니까 entrySet으로 맵 순회
		List<Map.Entry<String, Integer>> studentList = new ArrayList<>(student.entrySet());
		//System.out.println(studentList);
		
		System.out.println("[평균 점수 이상을 받은 학생]");
		for(Entry<String, Integer> stu : studentList) {
			if(stu.getValue() >= avg) {
				System.out.println(stu.getKey() + " : " + stu.getValue());
			}
		}
		System.out.println("--------------------");
	}

	@Override
	//이름순으로 정렬하여 학생 출력
	public void showSorted() {
		//key만 필요하니까 keySet
		List<String> nameSorted = new ArrayList<String>(student.keySet());
		//System.out.println(nameSort);
		Collections.sort(nameSorted);
		
		System.out.println("[이름순으로 학생 정렬]");
		for(String name : nameSorted) {
			System.out.println(name + " : " + student.get(name));
		}
		System.out.println("--------------------");
	}

	@Override
	//학생 점수 상위 3명 출력
	public void showTop() {
		// 맵을 점수를 기준으로 내림차순 정렬하고 위에서 3개 추출
		// 예외처리 할 것 : 학생이 3명이 안될 때 -> 1개 혹은 2개만 출력되도록 for문 반복범위 설정
		List<Map.Entry<String, Integer>> studentList = new ArrayList<Map.Entry<String,Integer>>(student.entrySet());
		
		// 리스트 내림차순 정렬.. 버블정렬?
		// 두개씩 비교하면서 큰게 앞으로 오게 정렬
		for(int i=0; i < studentList.size()-1; i++) {
			for(int j = i+1; j < studentList.size(); j++) {
				if(studentList.get(i).getValue() < studentList.get(j).getValue()) {
					Map.Entry<String, Integer> temp = studentList.get(i);
					// i랑 j 자리 변경
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
		}
		// System.out.println(studentList);
		
		//앞에서부터 3개 가져오기
		int loopNum = Math.min(3, studentList.size());
		System.out.println("[Top" + loopNum + "]");
		for(int i=0; i < loopNum; i++) {
			Map.Entry<String, Integer> stu = studentList.get(i);
			System.out.println(stu.getKey() + " : " + stu.getValue());
		}
		System.out.println("--------------------");
	}

	// toString
	@Override
	public String toString() {
		return "ScoreManage [student=" + student + "]";
	}
	
	

}
