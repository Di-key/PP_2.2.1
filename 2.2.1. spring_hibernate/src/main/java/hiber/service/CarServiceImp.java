package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }
}
