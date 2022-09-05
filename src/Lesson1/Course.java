package Lesson1;

public class Course {

    private Obstacle[] obstacleСourse;
    String result;


    public Course(Obstacle[] obstacleСourse) {
        this.obstacleСourse = obstacleСourse;
    }

    public String run(Team team) {
        result = "Команда " + team.getTeamName() + " " + '\n';
        for (Members members: team.getMembers()) {
            result += "Участник " + members.getNickname() + " " + '\n';
            int powerful = members.getStamina();
            powerful = startObstacle(powerful);
            members.setStamina(powerful);
        }
        return result;
    }
    public int startObstacle(int powerful) {
        for (int i = 0; i < obstacleСourse.length; i++) {
            if (obstacleСourse[i].getComplexity() < powerful)
                result = result + "Испытание " + obstacleСourse[i].getNameObs() + " пройдено " + '\n';
            else result += "Испытание " + obstacleСourse[i].getNameObs() + " провалено " + '\n';
            powerful = powerful - obstacleСourse[i].getComplexity();
        }

        return powerful;
    }

}
