package org.example.data.education

import org.example.data.ModelRepository
import org.example.domain.education.Teacher

/**
 * Contract for data access operations on [[Teacher]].
 */
trait TeacherRepository extends ModelRepository[Teacher]
