package rip.hippo.poll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
@Document(collection = "poll")
public final class MongoPoll {

    @Id
    private final int id;
    private final Poll poll;

    public MongoPoll(int id, Poll poll) {
        this.id = id;
        this.poll = poll;
    }

    public int getId() {
        return id;
    }

    public Poll getPoll() {
        return poll;
    }
}
