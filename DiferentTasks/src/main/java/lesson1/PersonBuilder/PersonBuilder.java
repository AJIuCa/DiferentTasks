package lesson1.PersonBuilder;

public interface PersonBuilder {

    PersonBuilder setFirstName(String firstname);
    PersonBuilder setLastName(String lastname);
    PersonBuilder setMiddleName(String middleName);
    PersonBuilder setCountry(String country);
    PersonBuilder setAddress(String adress);
    PersonBuilder setPhone(String phone);
    PersonBuilder setAge(int age);
    PersonBuilder setGender(String gender);
    Person buildNewPerson();
}
