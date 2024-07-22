package mission.SingletonMetaTest;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SingletonConfig singletonConfig = new SingletonConfig();

        SingletonContext.executeMethodsBySingletonAnnotation(singletonConfig);
        SingletonContext.setConfig(singletonConfig);

        Book book = (Book) SingletonContext.getSingleton("book");
        Book bookCopy1 = (Book) SingletonContext.getSingleton("book");
        Book bookCopy2 = (Book) SingletonContext.getSingleton("book");

        Book book2 = (Book) SingletonContext.getSingleton("book2");

        Car redCar = (Car) SingletonContext.getSingleton("car");
        Car yellowCar = (Car) SingletonContext.getSingleton("car3");
        Car yellowCar2 = (Car) SingletonContext.getSingleton("car3");

        book.displayInfo();
        bookCopy1.displayInfo();
        bookCopy2.displayInfo();

        System.out.println("두 객체는 같나요? " + (book == bookCopy1));

        book2.displayInfo();

        redCar.showInfo();
        yellowCar.showInfo();
        yellowCar2.showInfo();

        System.out.println("두 객체는 같나요? " + (redCar == yellowCar));
        System.out.println("두 객체는 같나요? " + (yellowCar == yellowCar2));
    }
}
