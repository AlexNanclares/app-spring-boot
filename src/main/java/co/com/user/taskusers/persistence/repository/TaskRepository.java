package co.com.user.taskusers.persistence.repository;

import co.com.user.taskusers.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query(value = "UPDATE TASKS SET name =:name WHERE ID=:id", nativeQuery = true)
    void updateTask(@Param("name") String name, @Param("id") Long id);

}
