package Lesson1;

public class main {
    public static void main(String[] args) {
        Members[] members = new Members[4];
        members[0] = new Members("Вася", 500);
        members[1] = new Members("Петя", 300);
        members[2] = new Members("Коля", 460);
        members[3] = new Members("Ася", 420);
        Members[] members2 = new Members[4];
        members2[0] = new Members("Ваня", 510);
        members2[1] = new Members("Тема", 340);
        members2[2] = new Members("Вова", 440);
        members2[3] = new Members("Катя", 460);
        Team crossfit = new Team("CrossFit", members);
        Team bodyBuild = new Team("BodyBuilders", members2);
        Obstacle[] event = new Obstacle[2];
        event[0] = new Obstacle("Спуск на байдарках", 237);
        event[1] = new Obstacle("Бег", 222);
        Course course = new Course(event);
        System.out.println(course.run(crossfit));
        System.out.println(course.run(bodyBuild)); //
        crossfit.checkResult();
        bodyBuild.checkResult();
        crossfit.memberInfo();
        bodyBuild.memberInfo();




    }
}
