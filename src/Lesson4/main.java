package Lesson4;

public class main {
    public static void main(String[] args) {
        PhoneBook book1 = new PhoneBook();

        book1.add("89169771785", "Иван");
        book1.add("89144444444", "Иван");
        book1.add("89169774567", "Олег");
        book1.add("89169772134", "Антон");
        book1.add("89169222225", "Ира");
        book1.add("89111111115", "Ира");
        book1.add("89435621321", "Ы");
        book1.add("89169719155", "Я");

        System.out.println(book1.get("Иван"));
        System.out.println(book1.get("Я"));
        System.out.println(book1.get("Ира"));
    }
}
