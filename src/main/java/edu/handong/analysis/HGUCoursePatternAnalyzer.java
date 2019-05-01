package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private static final String str = null;

	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		int i=0;
		int k=0;
		boolean x=true;
		
		Student[] studentA = new Student[numOfStudents];
		Student stu = new Student(" ");
		// TODO: implement this method
		String[] a;

		for(int j=0;j<numOfStudents;j++)
			studentA[j]= new Student(" ");
		
		while(i<numOfStudents&&lines[k]!=null) {
			a=lines[k].split(",");
			stu=new Student(a[1].trim());

			x= studentExist(studentA, stu);
			//System.out.println(x);
			if(x) {
				studentA[i] = stu;
				//System.out.println(studentA[i].getName());
				i++;
			}
			k++;
		}
		return studentA;
		
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		int i=0;
		Student[] studentB = new Student[2];
		studentB[0] = student;
		//System.out.println(studentB[0].getName());
		// TODO: implement this method
		//for(int i =0; i<numOfStudents; i++) {
		while(i<numOfStudents&&students[i]!=null) {
			
			if((students[i].getName()).equals(studentB[0].getName())) {
				//System.out.println("equals");
				return false;
			}
			i++;
			
			//return false;
		}
		//}
		
		
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		int i=0;
		int k=0;
		boolean x=true;
		
		Course[] courseA = new Course[numOfCourses];
		Course cou = new Course(" ");
		// TODO: implement this method
		String[] a;

		for(int j=0;j<numOfCourses;j++)
			courseA[j]= new Course(" ");
		
		while(i<numOfCourses&&lines[k]!=null) {
			a=lines[k].split(",");
			cou=new Course(a[2].trim());

			x= courseExist(courseA, cou);
			//System.out.println(x);
			if(x) {
				courseA[i] = cou;
				i++;
			}
			k++;
		}
		return courseA;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		int i=0;
		Course[] courseB = new Course[2];
		courseB[0] = course;
		//System.out.println(studentB[0].getName());
		// TODO: implement this method
		//for(int i =0; i<numOfStudents; i++) {
		while(i<numOfCourses&&courses[i]!=null) {
			
			if((courses[i].getCourseName()).equals(courseB[0].getCourseName())) {
				//System.out.println("equals");
				return false;
			}
			i++;
			
			//return false;
		}
		//}
		
		
		return true;
	}

}
