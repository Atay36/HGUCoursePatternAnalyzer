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
		Student[] studentA = new Student[numOfStudents];
		Student stu = new Student(" ");
		// TODO: implement this method
		String[] a;

		for(int j=0;j<numOfStudents;j++)
			studentA[j]= new Student(" ");
		
		while(i<numOfStudents) {
			a=lines[k].split(",");
			stu=new Student(a[1].trim());
			System.out.println(stu.toString());
			System.out.println(studentA.toString());


			if(studentExist(studentA, stu)) {
				studentA[i] = stu;
				System.out.println(studentA[i]);
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
		
		// TODO: implement this method
		for(int i =0; i<numOfStudents; i++) {
			if(students[i].equals(student)) {
				System.out.println("equals");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int i=0;
		int k=0;
		Course[] courseA = new Course[numOfCourses];

		// TODO: implement this method
		String[] a;
		
		while(i<numOfCourses) {
			a=lines[i].split(",");
			
			courseA[i] = new Course(a[2].trim());
			k=0;
			for(int j=0;j<i;j++) {
				if(courseA[j]==courseA[i]) {
					break;
				}k++;
			}
			if(k==i) i++;
		}
		return courseA;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
//	private boolean courseExist(Course[] courses, Course course) {
//		
//		// TODO: implement this method
//
//		return false;
//	}

}
