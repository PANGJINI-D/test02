package student;

public interface StudentManage {
	// 이름(문자열)과 점수(정수형) 추가하는 addStudent 메소드
	void addStudent(String name, int score);
	
	// 특정 학생의 점수 조회하는 getStudentScore 메소드
	void getStudentScore(String name);

	// 모든 학생의 이름과 점수 추가하는 showStudents 메소드
	void showStudents();

	// 평균 점수 계산하고 평균 이상의 점수를 받은 학생만 출력하는 showAvgStu 메소드
	void showAvgStu();
	
	// 이름순으로 정렬하여 학생 출력(->???)하는 showStored 메소드
	void showSorted();
	
	// 학생 점수 상위 3명 출력하는 showTop 메소드
	void showTop();
	
	
}
