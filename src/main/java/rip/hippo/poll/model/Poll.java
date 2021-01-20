package rip.hippo.poll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author Hippo
 * @version 1.0.0, 1/19/21
 * @since 1.0.0
 */
public final class Poll {
    private final String question;
    private final List<Answer> answers;

    public Poll(
            @JsonProperty("question") String question,
            @JsonProperty("answers") List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Answer getAnswer(int id) {
        if (id >= answers.size()) {
            return null;
        }
        return answers.get(id);
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
