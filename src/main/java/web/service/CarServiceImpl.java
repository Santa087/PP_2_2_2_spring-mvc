package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.models.Car;
import java.util.List;

@Service
public class CarServiceImpl implements  CarService {
    private final CarDAO carDAO;

    @Autowired
    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> cars = carDAO.getCars();

        if (count == null || count <= 0 || count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
