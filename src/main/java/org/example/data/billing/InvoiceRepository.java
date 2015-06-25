package org.example.data.billing;

import org.example.domain.billing.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Contract for data access operations on {@link Invoice}.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
}
