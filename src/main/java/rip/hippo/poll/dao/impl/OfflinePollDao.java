package rip.hippo.poll.dao.impl;

import org.springframework.stereotype.Repository;
import rip.hippo.poll.dao.PollDao;
import rip.hippo.poll.model.Answer;
import rip.hippo.poll.model.Poll;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hippo
 * @version 1.0.0, 1/19/21
 * @since 1.0.0
 */
@Repository("offlinePoll")
public final class OfflinePollDao implements PollDao {

    private final List<Poll> polls = new ArrayList<>();

    @Override
    public int createPoll(Poll poll) {
        polls.add(poll);
        return polls.size() - 1;
    }

    @Override
    public boolean vote(int pollId, int answerId) {
        Poll poll = getPoll(pollId);
        if (poll == null) {
            return false;
        }
        Answer answer = poll.getAnswer(answerId);
        if (answer == null) {
            return false;
        }
        answer.vote();
        return true;
    }

    @Override
    public Poll getPoll(int id) {
        if (id >= polls.size()) {
            return null;
        }
        return polls.get(id);
    }
}
