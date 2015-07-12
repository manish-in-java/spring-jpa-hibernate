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
 * Integration tests for [[TeacherRepository]].
 */
@ContextConfiguration(locations = Array("classpath:springContext.xml"))
@RunWith(classOf[SpringJUnit4ClassRunner])
@Transactional
@TransactionConfiguration(defaultRollback = true)
class TeacherRepositorySpec {
  @Autowired
  private[this] var repository: TeacherRepository = _

  /**
   * Sets up data required for the tests to run.
   */
  @Before
  def setup(): Unit = {
    for (i <- 1 to 20) {
      val teacher = new Teacher

      for (j <- 1 to 5) {
        teacher.assignSubject(new Subject)
      }

      repository.saveAndFlushAndDetach(teacher)
    }
  }

  /**
   * Tests that teachers can be retrieved correctly.
   */
  @Test
  def testFindAll {
    val teachers = repository.findAll

    assert(teachers != null)
    assert(teachers.size > 0)

    teachers.foreach(teacher => {
      assert(teacher != null)
      assert(teacher.getID != null)
      assert(teacher.getSubjects != null)
      assert(teacher.getSubjects.size > 0)

      teacher.getSubjects.foreach(subject => {
        assert(subject != null)
        assert(subject.getID != null)
        assert(subject.getTeachers != null)
        assert(subject.getTeachers.size > 0)
      })
    })
  }
}
