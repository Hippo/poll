package rip.hippo.poll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
public final class Vote {
    private final int pollId;
    private final int answerId;

    public Vote(
            @JsonProperty("pollId") int pollId,
            @JsonProperty("answerId") int answerId) {
        this.pollId = pollId;
        this.answerId = answerId;
    }

    public int getPollId() {
        return pollId;
    }

    public int getAnswerId() {
        return answerId;
    }
}
