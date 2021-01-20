package rip.hippo.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rip.hippo.poll.dao.PollDao;

/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
@Service
public final class PollService {
    private final PollDao pollDao;

    @Autowired
    public PollService(@Qualifier("offlinePoll") PollDao pollDao) {
        this.pollDao = pollDao;
    }

    public PollDao getPollDao() {
        return pollDao;
    }
}
