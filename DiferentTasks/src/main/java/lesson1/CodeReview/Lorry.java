package lesson1.CodeReview;

// Интерфейсы Moveable и Stopable должны быть не extends а implements
// Так как в абстрактном классе Car есть абстрактный метод Open необходимо реализовать его в данном классе
class Lorry extends Car, Moveable, Stopable{

    //Не хватает аннотации Override. Без неё программа не понимает что метод имплиментирован
    public void move(){
        System.out.println("Car is moving");
    }
    //Не хватает аннотации Override. Без неё программа не понимает что метод имплиментирован
    public void stop(){
        System.out.println("Car is stop");
    }
}

