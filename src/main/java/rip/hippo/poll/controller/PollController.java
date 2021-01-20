package rip.hippo.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rip.hippo.poll.model.Poll;
import rip.hippo.poll.service.PollService;

/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("api")
public final class PollController {

    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public int createPoll(@RequestBody Poll poll) {
        return pollService.getPollDao().createPoll(poll);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable("id") int id) {
        Poll poll = pollService.getPollDao().getPoll(id);
        if (poll == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(poll);
    }
}