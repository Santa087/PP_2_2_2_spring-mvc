package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int count;
    private List<Car> cars;

    public CarDAO() {
        cars = new ArrayList<>();
        cars.add(new Car(++count, "RED", "BMW 2020"));
        cars.add(new Car(++count, "BLUE", "TOYOTA 1995"));
        cars.add(new Car(++count, "BLACK", "FORD 1986"));
        cars.add(new Car(++count, "YELLOW", "PORSCHE 2009"));
        cars.add(new Car(++count, "PURPLE", "LADA 2012"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id)
                .findAny()
                .orElse(null);
    }
}
