package org.example.domain.education

import java.util.{ArrayList, Collections, List}
import javax.persistence._

import org.example.domain.Model

/**
 * Represents a teacher at a teaching institution.
 */
@Entity
@Table(name = "teacher")
class Teacher extends Model {
  @JoinTable(inverseJoinColumns = Array(new JoinColumn(name = "subject_id")), joinColumns = Array(new JoinColumn(name = "teacher_id")), name = "subject_teacher")
  @ManyToMany(cascade = Array(CascadeType.ALL), fetch = FetchType.LAZY)
  var subjects: List[Subject] = _

  /**
   * Assigns a subject to this teacher.
   *
   * @param subject The [[Subject]] to assign.
   */
  def assignSubject(subject: Subject): Unit = {
    if (subjects == null) {
      subjects = new ArrayList
    }

    if (!subjects.contains(subject)) {
      subjects.add(subject)
      subject.assignTeacher(this)
    }
  }

  /**
   * Gets all subjects assigned to this teacher.
   *
   * @return A [[List]] of [[Subject]]s.
   */
  def getSubjects: List[Subject] = Collections.unmodifiableList(subjects)
}
