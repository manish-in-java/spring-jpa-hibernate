package org.example.data.quiz;

import org.example.data.DataTest;
import org.example.domain.quiz.Question;
import org.example.domain.quiz.Quiz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.stream.IntStream;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value = "quizTransactionManager")
@TransactionConfiguration(defaultRollback = true)
public class QuizPersistenceTest extends DataTest
{
  @PersistenceContext(unitName = "quiz")
  @Qualifier("quiz")
  private EntityManager entityManager;

  @Before
  public void setup()
  {
    final Quiz quiz = new Quiz(getString());

    IntStream.range(1, 11).forEach(i -> quiz.addQuestion(new Question(getString())));

    entityManager.persist(quiz);
    entityManager.flush();
    entityManager.detach(quiz);
  }

  @Test
  public void testQuizQuestionsSize()
  {
    final CriteriaQuery<Quiz> query = entityManager.getCriteriaBuilder().createQuery(Quiz.class);

    entityManager.createQuery(query.select(query.from(Quiz.class)))
        .getResultList()
        .forEach(quiz -> Assert.assertEquals(10, quiz.getQuestions().size()));
  }
}
