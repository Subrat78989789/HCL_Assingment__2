package university_student_management;

import java.util.List;
import java.lang.runtime.TemplateRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.management.OperationsException;



public class StudentService_Implementation implements StudentServices {

	
	Map<String, Student> map=new HashMap<>();
	List<Student> list=new ArrayList<>();//Vector can be used
	Set<String> courses=new HashSet<>();//It don't contain duplicate
	ValidateStudent vStudent=new ValidateStudent();
	

	
	//stack for tracking the operations performed
	Stack<Operation> sOperations=new Stack<>();
	@Override
	public void addStudents(Student s)
	{
		if(!vStudent.Student_Id_Validation(s.getId()))
		{
			sOperations.push(new Operation("addStudent operartion is failed due to Invalid Student ID"));
			throw new IllegalArgumentException("Invalid Student ID");
		}
		 if (map.containsKey(s.getId()))//If id exist then no entry
		 {
			 sOperations.push(new Operation("addStudent operartion is failed due to Duplicate Student ID"));
	            throw new IllegalArgumentException("Duplicate Student ID");
		 }
//after throw statements are unreachable
		 list.add(s);
			map.put(s.getId(), s);
			courses.add(s.getCourse());
			sOperations.push(new Operation("Add", s));
	}

	@Override
	public void displayStudents() {
		sOperations.push(new Operation("displayStudents"));
		list.forEach(System.out::println);
		
	}

	@Override
	public Student searchById(String id) {
		// TODO Auto-generated method stub
		if(!map.containsKey(id))
		{
			sOperations.push(new Operation("searchById operation is failed"));
			 throw new IllegalArgumentException("Student not found");
		}
		sOperations.push(new Operation("searchById",map.get(id)));
		return map.get(id);//value as student object is returned
	}

	@Override
	public void removeById(String id) {
		Student student=map.get(id);
		if(!map.containsKey(id))
		{
			sOperations.push(new Operation("removeById operation is failed"));
			 throw new IllegalArgumentException("Student not found");
		}
		if(student!=null)
		{
		
		list.remove(student);
		map.remove(id);
		
		//or
	//	stack.push(student);
		
		sOperations.push(new Operation("removeById",student));
		}
		
		System.out.println("Student Whose Id is:"+id+" has been removed");
		
	}
	
	public void undo()
	{
		if(sOperations.isEmpty())
		{
			System.out.println("No Operation to Undo");
			return;
		}
		Operation op=sOperations.pop();//Top of the stack
		if(op.action.contains("Add"))
		{
			list.remove(op.student);
			map.remove(op.student.getId());
			System.out.println("Undo ADD successful");
		}
		else if(op.action.contains("removeById"))
		{
			list.add(op.student);
			map.put(op.student.getId(),op.student);
			System.out.println("Undo DELETE successful");
		}
		
	}

	@Override
	public void sortByMarks() {
		 //we cannot directly sort map
	  //   list.sort(Comparator.comparingInt(Student::getMarks));//wrapper class::comparing terms method
	    //or
		//Ascending Order
		//list.sort((s1,s2)->s1.getMarks()-s2.getMarks());//Lambda Expression using functional Interface implementation
		//descending order
		list.sort((s1,s2)->s2.getMarks()-s1.getMarks());
		sOperations.push(new Operation("sortByMarks"));
	}
	public Map<String,Integer> CourseWise_Count()
	{
		Map<String,Integer> countmap=new Hashtable<>();
		for(Student st:list)
		{
			countmap.put(st.getCourse(), countmap.getOrDefault(st.getCourse(), 0)+1);
		}
		sOperations.push(new Operation("CourseWise_Count"));
		return countmap;
	}
	public Set<String> allCourses()
	{
		sOperations.push(new Operation("allCourses"));
		return courses;
	}
	public TreeMap<String, Student> convertintoTreeMap()
	{
		sOperations.push(new Operation("convertintoTreeMap"));
		return new TreeMap<>(map);
	}
	public void displayStudent_usingMap(Map<String, Student> map2)
	{
		for(Map.Entry<String,Student> tr:map2.entrySet())
		{
			System.out.println();
			System.out.println("Student Id:"+tr.getValue().getId());
			System.out.println("Student Name:"+tr.getValue().getName());
			System.out.println("Student Course:"+tr.getValue().getCourse());
			System.out.println("Student Marks:"+tr.getValue().getMarks());
		}
		sOperations.push(new Operation("displayStudent_usingMap"));
	}
	public void displayCourses(Set<String> sc)
	{
		System.out.println("All Courses:");
		for(String ts:sc)
		{
			System.out.println(ts);
		}
		sOperations.push(new Operation("displayCourses"));
	}
	public void displayCourse_usingMap(Map<String, Integer> map2)
	{
		System.out.println("Number of Courses Allocated to Students:");
		for(Map.Entry<String,Integer> tr:map2.entrySet())
		{
			System.out.println(tr.getKey()+"->"+tr.getValue());
		}
		sOperations.push(new Operation("displayCourse_usingMap"));
	}
	
	public void showRecentOperations() {
	    if (sOperations.isEmpty()) {
	        System.out.println("No operations performed.");
	        return;
	    }

	    System.out.println("Recent Operations (Latest First):");

	    for (int i = sOperations.size() - 1; i >= 0; i--) {
	        System.out.println(sOperations.get(i));
	    }
	}


}
