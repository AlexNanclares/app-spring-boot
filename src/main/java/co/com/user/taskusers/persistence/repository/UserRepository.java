package co.com.user.taskusers.persistence.repository;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "UPDATE USERS SET date_birth =:dateBirth, active =:active, dependence =:dependence WHERE ID=:id", nativeQuery = true)
    void updateUser(@Param("dateBirth") LocalDate dateBirth, @Param("active") Boolean active,
                    @Param("dependence") String dependence, @Param("id") Long id);

}
