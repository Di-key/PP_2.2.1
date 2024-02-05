package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CarService carService = context.getBean(CarService.class);

        carService.add(new Car("Model1", 1));
        carService.add(new Car("Model2", 2));
        carService.add(new Car("Model3", 3));
        carService.add(new Car("Model4", 4));

//        List<Car> cars = carService.listCars();
//        for (Car car : cars) {
//            System.out.println("Id = "+car.getId());
//            System.out.println("Model = " + car.getModel());
//            System.out.println("Series = " + car.getSeries());
//            System.out.println();
//        }
        UserService userService = context.getBean(UserService.class);
        List<Car> cars1 = carService.listCars();
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", cars1.get(0)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", cars1.get(1)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", cars1.get(2)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", cars1.get(3)));

        System.out.println(userService.getUserByCar("Model1",1));


        context.close();


    }


}