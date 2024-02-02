package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user1= new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("Model1", 1);
        Car car2 = new Car("Model2", 2);
        Car car3 = new Car("Model3", 3);
        Car car4 = new Car("Model4", 4);

        userService.add(car1);
        userService.add(car2);
        userService.add(car3);
        userService.add(car4);

        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println("Id = "+car.getId());
            System.out.println("Model = " + car.getModel());
            System.out.println("Series = " + car.getSeries());
            System.out.println();
        }
        List<Car> cars1 = userService.listCars();
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", cars1.get(0)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", cars1.get(1)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", cars1.get(2)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", cars1.get(3)));

        System.out.println(userService.getUserByCar("Model1",1));


        context.close();


    }


}