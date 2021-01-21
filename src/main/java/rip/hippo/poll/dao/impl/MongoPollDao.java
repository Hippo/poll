package rip.hippo.poll.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import rip.hippo.poll.dao.PollDao;
import rip.hippo.poll.model.Answer;
import rip.hippo.poll.model.MongoPoll;
import rip.hippo.poll.model.Poll;
import rip.hippo.poll.model.Vote;
import rip.hippo.poll.mongo.MongoConfiguration;


/**
 * @author Hippo
 * @version 1.0.0, 1/20/21
 * @since 1.0.0
 */
@Repository("mongoPoll")
public class MongoPollDao implements PollDao {

    private final MongoTemplate mongo;

    public MongoPollDao() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoConfiguration.class);
        ctx.refresh();
        this.mongo = ctx.getBean(MongoTemplate.class);
    }

    @Override
    public int createPoll(Poll poll) {
        int size = mongo.findAll(MongoPoll.class).size();
        mongo.insert(new MongoPoll(size, poll));
        return size;
    }

    @Override
    public boolean vote(Vote vote) {
        Poll poll = getPoll(vote.getPollId());
        if (poll == null) {
            return false;
        }
        Answer answer = poll.getAnswer(vote.getAnswerId());
        if (answer == null) {
            return false;
        }
        answer.vote();
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(vote.getPollId()));
        Update update = new Update();
        update.set("poll", poll);
        mongo.updateFirst(query, update, MongoPoll.class);
        return true;
    }

    @Override
    public Poll getPoll(int id) {
        MongoPoll mongoPoll = mongo.findById(id, MongoPoll.class);
        return mongoPoll == null ? null : mongoPoll.getPoll();
    }
}
