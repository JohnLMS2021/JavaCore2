package Lesson1;

public class Team {
    private String teamName;
    private Members[] members;

    public Team(String teamName, Members[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public String getTeamName() {
        return teamName;
    }

    public Members[] getMembers() {
        return members;
    };

    public void checkResult() {
        System.out.println("Из команды " + getTeamName() + " прошли все испытания следующие участники:");
        for (Members members : members) {
            if (members.getStamina() >= 0 ){
                System.out.println(members.getNickname());
            }
        }
    }
    public void memberInfo () {
        for (Members members : members) {
            System.out.println("Имя участника команды " + teamName + ": " + members.getNickname());
            System.out.println("Выносливость: " + members.getStamina());
        }
    }

}
