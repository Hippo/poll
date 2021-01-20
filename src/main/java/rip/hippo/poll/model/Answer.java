package rip.hippo.poll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hippo
 * @version 1.0.0, 1/19/21
 * @since 1.0.0
 */
public final class Answer {

    private final String label;
    private int votes;

    public Answer(@JsonProperty("label") String label) {
        this.label = label;
    }

    public void vote() {
        votes++;
    }

    public String getLabel() {
        return label;
    }

    public int getVotes() {
        return votes;
    }
}
