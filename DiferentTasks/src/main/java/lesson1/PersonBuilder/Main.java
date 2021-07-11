package lesson1.PersonBuilder;

public class Main {
    public static void main(String[] args) {

        Person person1 = new PersonBuilderImpl()
                .setFirstName("Anna")
                .setLastName("Yagodka")
                .setMiddleName("Petrova")
                .setGender("Female")
                .setAge(23)
                .setPhone("123321")
                .setCountry("Poland")
                .setAddress("Center center")
                .buildNewPerson();

        Person person2 = new PersonBuilderImpl()
                .setFirstName("Ivan")
                .setLastName("Tarakanov")
                .setMiddleName("Andreevich")
                .setGender("Male")
                .setCountry("Russia")
                .buildNewPerson();

        System.out.println(person1.toString() + "\n"+ person2.toString());

    }
}
