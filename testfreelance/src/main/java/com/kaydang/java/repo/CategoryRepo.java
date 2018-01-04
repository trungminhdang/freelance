package com.kaydang.java.repo;

import com.kaydang.java.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, String> {

    @Query(value = " SELECT array_to_string(categories,',') " +
            " FROM company " +
            " WHERE categories IS NOT NULL"
            , nativeQuery = true)
    List<String> getCategories();

    @Query(value = " SELECT array_to_string(specialties,',') " +
            " FROM company " +
            " WHERE specialties IS NOT NULL"
            , nativeQuery = true)
    List<String> getSpecialties();

    @Query(value = " SELECT array_to_string(application_name,',') " +
            " FROM company " +
            " WHERE application_name IS NOT NULL"
           , nativeQuery = true)
    List<String> getApplicationNames();
}
