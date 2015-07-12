package org.example.domain.education

import java.util.{ArrayList, Collections, List}
import javax.persistence._

import org.example.domain.Model

/**
 * Represents a subject taught at a teaching institution.
 */
@Entity
@Table(name = "subject")
class Subject extends Model {
  @JoinTable(inverseJoinColumns = Array(new JoinColumn(name = "teacher_id")), joinColumns = Array(new JoinColumn(name = "subject_id")), name = "subject_teacher")
  @ManyToMany(cascade = Array(CascadeType.ALL), fetch = FetchType.LAZY)
  var teachers: List[Teacher] = _

  /**
   * Assigns a teacher to this subject.
   *
   * @param teacher The [[Teacher]] to assign.
   */
  def assignTeacher(teacher: Teacher): Unit = {
    if (teachers == null) {
      teachers = new ArrayList
    }

    if (!teachers.contains(teacher)) {
      teachers.add(teacher)
      teacher.assignSubject(this)
    }
  }

  /**
   * Gets all teachers assigned to this subject.
   *
   * @return A [[List]] of [[Teacher]]s.
   */
  def getTeachers: List[Teacher] = Collections.unmodifiableList(teachers)
}
