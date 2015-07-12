package org.example.data.education

import org.example.domain.education.{Subject, Teacher}
import org.junit.runner.RunWith
import org.junit.{Before, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

import scala.collection.JavaConversions._

/**
 * Integration tests for [[SubjectRepository]].
 */
@ContextConfiguration(locations = Array("classpath:springContext.xml"))
@RunWith(classOf[SpringJUnit4ClassRunner])
@Transactional
@TransactionConfiguration(defaultRollback = true)
class SubjectRepositorySpec {
  @Autowired
  private[this] var repository: SubjectRepository = _

  /**
   * Sets up data required for the tests to run.
   */
  @Before
  def setup(): Unit = {
    for (i <- 1 to 20) {
      val subject = new Subject

      for (j <- 1 to 5) {
        subject.assignTeacher(new Teacher)
      }

      repository.saveAndFlushAndDetach(subject)
    }
  }

  /**
   * Tests that subjects can be retrieved correctly.
   */
  @Test
  def testFindAll {
    val subjects = repository.findAll

    assert(subjects != null)
    assert(subjects.size > 0)

    subjects.foreach(subject => {
      assert(subject != null)
      assert(subject.getID != null)
      assert(subject.getTeachers != null)
      assert(subject.getTeachers.size > 0)

      subject.getTeachers.foreach(teacher => {
        assert(teacher != null)
        assert(teacher.getID != null)
        assert(teacher.getSubjects != null)
        assert(teacher.getSubjects.size > 0)
      })
    })
  }
}
