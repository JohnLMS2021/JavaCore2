package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Student> studentList = getListOfStudent(10,15);


        studentList.stream().flatMap(student -> student.getCourseList().stream()).distinct().collect(Collectors.toList()).forEach(course -> {
            System.out.println(course.getName());});

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        studentList.stream().sorted((student1,student2) -> student1.getCourseList().size() - student2.getCourseList().size()).limit(3).collect(Collectors.toList()).forEach(student -> {
            System.out.println(student.getName());});

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        Course course = new Course("course1");
        studentList.stream().filter(student -> student.getCourseList().contains(course)).collect(Collectors.toList()).forEach(student -> {
            System.out.println(student.getName());});


    }

    private static List<Student> getListOfStudent (int j, int m){
        ArrayList<Student> result = new ArrayList<>();
        for (int i=0; i<j ;i++){
            ArrayList<Course> courses = new ArrayList<>();
            for (int h=0; h<m ;h++){
                courses.add(new Course("course"+h));
            }
            result.add(new Student("student"+i, courses));
        }
        return result;
    }
}
