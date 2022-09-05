package Lesson1;

public class Members {
    private String nickname;
    private int stamina;

    public Members(String nickname, int stamina) {
        this.nickname = nickname;
        this.stamina = stamina;
    }

    public String getNickname() {
        return nickname;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
