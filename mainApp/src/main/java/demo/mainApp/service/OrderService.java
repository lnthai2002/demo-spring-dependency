package demo.mainApp.service;

import demo.lib1.data.Car;
import demo.lib1.repos.CarRepository;
import demo.lib1.service.CarService;
import demo.lib2.data.Dog;
import demo.lib2.service.DogService;
import demo.lib3.data.Student;
import demo.lib3.service.StudentService;
import demo.mainApp.data.Order;
import demo.mainApp.repos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CarService carService;
    private DogService dogService;
    private StudentService studentService;

    public OrderService(OrderRepository orderRepository, CarService carService, DogService dogService, StudentService studentService) {
        this.orderRepository = orderRepository;
        this.carService = carService;
        this.dogService = dogService;
        this.studentService = studentService;
    }

    public void save(Long carId, Long dogId, Long studentId) {
        List<Car> cars = carService.getAllCars().stream().filter(car -> carId == car.getId()).collect(Collectors.toList());
        List<Dog> dogs = dogService.getAllDogs().stream().filter(dog -> dogId == dog.getId()).collect(Collectors.toList());
        List<Student> students = studentService.getAllStudent().stream().filter(student -> studentId == student.getId()).collect(Collectors.toList());
        Order order = Order.builder().subjectId((long) (cars.size() + dogs.size() + students.size()))
            .build();
        orderRepository.save(order);
    }
}
