package rip.hippo.poll.dao;

import rip.hippo.poll.model.Poll;
import rip.hippo.poll.model.Vote;

/**
 * @author Hippo
 * @version 1.0.0, 1/19/21
 * @since 1.0.0
 */
public interface PollDao {
    int createPoll(Poll poll);
    boolean vote(Vote vote);
    Poll getPoll(int id);
}
