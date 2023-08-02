package com.sangamone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangamone.entity.Laptop;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

	Optional<Laptop> findById(int id);

}
