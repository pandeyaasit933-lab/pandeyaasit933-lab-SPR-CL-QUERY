package Application.Repository;

import Application.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("FROM Pet WHERE name = :nameVar")
    List<Pet> example1(@Param("nameVar") String name);

    @Query("FROM Pet WHERE name = :nameVar AND species = :speciesVar")
    List<Pet> example2(
        @Param("nameVar") String name,
        @Param("speciesVar") String species
    );

    @Query("SELECT MAX(age) FROM Pet")
    int example3();

    // Lab 1: Retrieve all pets by species
    @Query("FROM Pet WHERE species = :species")
    List<Pet> lab1(@Param("species") String species);

    // Lab 2: Retrieve pets by name OR age
    @Query("FROM Pet WHERE name = :name OR age = :age")
    List<Pet> lab2(
        @Param("name") String name,
        @Param("age") int age
    );

    // Lab 3: Retrieve average age of all pets
    @Query("SELECT AVG(age) FROM Pet")
    double lab3();
}