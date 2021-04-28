package demo.lib2.service;

import demo.lib2.data.Dog;
import demo.lib2.repos.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogService {
    private DogRepository repository;

    public DogService(DogRepository repository) {
        this.repository = repository;
    }

    public List<Dog> getAllDogs() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
