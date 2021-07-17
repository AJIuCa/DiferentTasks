package lesson1.PersonBuilder;

public class PersonBuilderImpl implements PersonBuilder{

    Person newPerson = new Person();

    @Override
    public PersonBuilder setFirstName(String firstname) {
        newPerson.firstName = firstname;
        return this;
    }

    @Override
    public PersonBuilder setLastName(String lastname) {
        newPerson.lastName = lastname;
        return this;
    }

    @Override
    public PersonBuilder setMiddleName(String middleName) {
        newPerson.middleName = middleName;
        return this;
    }

    @Override
    public PersonBuilder setCountry(String country) {
        newPerson.country = country;
        return this;
    }

    @Override
    public PersonBuilder setAddress(String address) {
        newPerson.address = address;
        return this;
    }

    @Override
    public PersonBuilder setPhone(String phone) {
        newPerson.phone = phone;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        newPerson.age = age;
        return this;
    }

    @Override
    public PersonBuilder setGender(String gender) {
        newPerson.gender = gender;
        return this;
    }

    @Override
    public Person buildNewPerson() {
        return newPerson;
    }
}
