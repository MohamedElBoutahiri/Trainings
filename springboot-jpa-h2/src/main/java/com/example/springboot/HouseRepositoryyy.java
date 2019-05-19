package com.example.springboot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepositoryyy extends CrudRepository<House, Long> {

}
