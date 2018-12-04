package by.Viktor.Repo;

import by.Viktor.Model.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote,Integer>  {
    Vote findVoteById(int id);
}
