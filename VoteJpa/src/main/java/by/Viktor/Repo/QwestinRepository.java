package by.Viktor.Repo;

import by.Viktor.Model.Qwesting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QwestinRepository extends JpaRepository<Qwesting,Integer> {
    Qwesting findQwestingById(int id);

}
