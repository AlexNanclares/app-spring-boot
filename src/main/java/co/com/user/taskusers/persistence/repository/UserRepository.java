package co.com.user.taskusers.persistence.repository;

import co.com.user.taskusers.persistence.entity.Dependence;
import co.com.user.taskusers.persistence.entity.Profile;
import co.com.user.taskusers.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "UPDATE USERS SET date_birth =:dateBirth, active =:active, dependence =:dependence WHERE ID=:id", nativeQuery = true)
    void updateUser(@Param("dateBirth") LocalDate dateBirth, @Param("active") Boolean active,
                    @Param("dependence") String dependence, @Param("id") Long id);

    @Modifying
    @Query(value = "DELETE USERS WHERE ID=:id", nativeQuery = true)
    void deleteUserById(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE USER_PROFILE WHERE USER_ID=:id", nativeQuery = true)
    void deleteProfilesFromUser(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO USER_PROFILE (USER_ID, PROFILE) VALUES (:id, :profile)", nativeQuery = true)
    void insertProfilesFromUser(@Param("id") Long id, @Param("profile") String profile);

}
