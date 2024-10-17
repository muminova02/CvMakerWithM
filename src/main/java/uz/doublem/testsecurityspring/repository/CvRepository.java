package uz.doublem.testsecurityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.doublem.testsecurityspring.entity.Cv;
import uz.doublem.testsecurityspring.payload.CvDto;

import java.util.List;

public interface CvRepository extends JpaRepository<Cv, Integer> {


    @Query(nativeQuery = true, value = "select * from cv where user_id= :userId")
    List<Cv> getAllCvByUserId(Integer userId);



}
