package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImp implements CarDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.openSession().createQuery("from Car", Car.class);
        return query.getResultList();
    }

    @Override
    public void add(Car car) {
        sessionFactory.openSession().save(car);
    }
}
