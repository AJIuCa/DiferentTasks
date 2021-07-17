package lesson1.PersonBuilder;

    class Person {

    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    @Override
    public String toString() {
        return "Person {" +
                "FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", MiddleName='" + middleName + '\'' +
                ", Country='" + country + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + phone + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                '}';
    }

}
