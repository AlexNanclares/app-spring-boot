package co.com.user.taskusers.persistence.repository;

import co.com.user.taskusers.persistence.entity.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RowRepository extends JpaRepository<Row, Long> {

    @Modifying
    @Query(value = "UPDATE ROWS SET duration =:duration WHERE ID=:id", nativeQuery = true)
    void updateRow(@Param("duration") Long duration, @Param("id") Long id);
}
