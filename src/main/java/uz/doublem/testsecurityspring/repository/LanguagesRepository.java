package uz.doublem.testsecurityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.doublem.testsecurityspring.entity.Languages;

public interface LanguagesRepository extends JpaRepository<Languages, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM languages WHERE id= :id", nativeQuery = true)
    void delete(Integer id);
}
