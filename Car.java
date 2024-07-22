package mission.SingletonMetaTest;

public class Car {
    private int year;
    private String color;

    public Car() {
    }

    public Car(int year, String color) {
        this.year = year;
        this.color = color;
    }

    public void drive() {
        System.out.println(year + "년식 자동차를 주행합니다.");
    }

    public void stopEngine() {
        System.out.println(year + "년식 자동차의 시동을 끕니다.");
    }

    public void showInfo() {
        System.out.println("이 차의 년식: " + year + "이고, 색상은 " + color + "입니다.");
    }

}
