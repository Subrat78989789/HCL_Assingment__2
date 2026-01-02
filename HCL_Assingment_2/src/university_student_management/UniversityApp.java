package university_student_management;


import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class UniversityApp {
	
	public static void main(String[] args) {
		try {
		int choice;
		String name;
		String id;
		String course;
		int marks;
		Student s;
		StudentService_Implementation sr=new StudentService_Implementation();
		Scanner sc=new Scanner(System.in);
		do {
		
			System.out.println("******Welcome to University******");
			System.out.println("1.Add Students");
			System.out.println("2.Display Students");
			System.out.println("3.Search Student By ID");
			System.out.println("4.Remove Student By ID");
			System.out.println("5.Sort Student By Marks");
			System.out.println("6.Courses Allocated");
			System.out.println("7.Display All Courses");
			System.out.println("8.Convert into Tree Map");
			System.out.println("9.Undo Last Operation");
			System.out.println("10.Show Recent OPERATIONS");
			System.out.println("11.Exit..........");
			System.out.print("Enter Your Choice:");
			choice=sc.nextInt();
			switch (choice) {
			case 1: 
				sc.nextLine();
				System.out.print("Enter Student Name:");
				name=sc.nextLine();
				System.out.print("Enter Student Id:");
				id=sc.nextLine();
				System.out.print("Enter Student Course:");
				course=sc.nextLine();
				System.out.println("Enter Marks:");
				marks=sc.nextInt();
				
				s=new Student(id, name, course, marks);
				sr.addStudents(s);
				break;
			case 2:
				sr.displayStudents();
				break;
			
			case 3:
				sc.nextLine();
				System.out.print("Enter Student Id:");
				id=sc.nextLine();
			Student search=sr.searchById(id);
			System.out.println(search);
			    break;
			case 4:
				sc.nextLine();
				System.out.print("Enter Student Id:");
				id=sc.nextLine();
				sr.removeById(id);
				break;
			case 5:
				sr.sortByMarks();
				System.out.println("Sorted Update:");
				sr.displayStudents();
				break;
			case 6:
				Map<String, Integer> cn=sr.CourseWise_Count();
				sr.displayCourse_usingMap(cn);
				break;
			case 7:
				Set<String> scc=sr.allCourses();
				sr.displayCourses(scc);
				break;
			case 8:
				TreeMap<String, Student> tm=sr.convertintoTreeMap();
				System.out.println("Displaying Student Using Tree Map:");
				sr.displayStudent_usingMap(tm);
				break;
			case 9:
				sr.undo();
				break;
			case 10:
				sr.showRecentOperations();
				break;
			case 11:
				System.out.println("Exit..................");
				
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} while (choice>0 && choice<11);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
