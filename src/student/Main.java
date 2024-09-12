package student;

public class Main {
	public static void main(String[] args) {
		ScoreManage sm = new ScoreManage();
		
		// 학생 추가
		sm.addStudent("황진", 80);
		sm.addStudent("김도영", 100);
		sm.addStudent("나재민", 92);
		sm.addStudent("정재현", 75);
		sm.addStudent("김정우", 88);
//		sm.addStudent("ㅋㅋㅋ", -1000);
		
		// 특정 학생의 점수 조회
		sm.getStudentScore("김도영");
		sm.getStudentScore("김정우");
		
		// 전체 학생 정보 조회
		sm.showStudents();
		
		// 평균 점수 이상 받은 학생 조회
		sm.showAvgStu();
		
		// 이름순으로 정렬
		sm.showSorted();
		
		// 상위3명 점수
		sm.showTop();
	}
}
