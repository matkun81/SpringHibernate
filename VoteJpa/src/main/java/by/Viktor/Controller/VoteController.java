package by.Viktor.Controller;

import by.Viktor.Repo.QwestinRepository;
import by.Viktor.Model.Qwesting;
import by.Viktor.Model.Vote;
import by.Viktor.Repo.VoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vote")

public class VoteController {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private QwestinRepository qwestinRepository;
    private static List<Qwesting> BUFFER = new ArrayList<>();

    @PostMapping
    public void addVoting(@RequestParam String name) {
        Vote vote = new Vote(name);
        vote.setQwestings(BUFFER);
        voteRepository.save(vote);
        BUFFER.clear();
    }

    @PostMapping("add")
    public void addQwesting(@RequestParam String qwe) {
        Qwesting qwesting = new Qwesting(qwe);
        BUFFER.add(qwesting);
        qwestinRepository.save(qwesting);
    }

    @GetMapping("{id}")
    public Vote findVote(@PathVariable Integer id) {
        return voteRepository.findVoteById(id);
    }

    @GetMapping
    public Iterable<Vote> getAllVote() {
        Iterable<Vote> votes = voteRepository.findAll();
        return votes;
    }

    @GetMapping("/getQwesting")
    public Qwesting findQwesting(@RequestParam Integer id) {
        return qwestinRepository.findQwestingById(id);
    }

    @PostMapping("/voting")
    public Qwesting voting(Integer id) {
        Qwesting qwesting = qwestinRepository.findQwestingById(id);
        long count = qwesting.getNumberOfVotes() + 1;
        qwesting.setNumberOfVotes(count);
        return qwestinRepository.save(qwesting);
    }

    @PutMapping("{id}")
    public Vote updateVote(@PathVariable("id") Vote voteFromDb, @RequestBody Vote vote, @RequestParam String name) {
        vote.setName(name);
        BeanUtils.copyProperties(vote, voteFromDb, "id");
        return voteRepository.save(voteFromDb);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        try {
            Vote vote = voteRepository.findVoteById(id);
            voteRepository.delete(vote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "delete";
    }

    @DeleteMapping("delete/{id}")
    public String deleteQwesing(@PathVariable Integer id) {
        try {
            Qwesting qwesting = qwestinRepository.findQwestingById(id);
            qwestinRepository.delete(qwesting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "delete";

    }
}