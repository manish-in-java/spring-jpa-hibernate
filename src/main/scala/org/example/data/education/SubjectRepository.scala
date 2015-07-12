package org.example.data.education

import org.example.data.ModelRepository
import org.example.domain.education.Subject

/**
 * Contract for data access operations on [[Subject]].
 */
trait SubjectRepository extends ModelRepository[Subject]
