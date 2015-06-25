package org.example.data.library;

import org.example.data.DataTest;
import org.example.domain.library.Book;
import org.example.domain.library.Library;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Integration tests for {@link LibraryRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LibraryRepositoryTest extends DataTest
{
  @Autowired
  private LibraryRepository libraryRepository;

  /**
   * Adds a library with some books for the tests to run.
   */
  @Before
  public void setup()
  {
    final Library library = new Library(getString());

    IntStream.range(1, 11).forEach(i -> library.addBook(new Book(getString())));

    libraryRepository.saveAndFlush(library);
  }

  /**
   * Tests that libraries can be loaded successfully.
   */
  @Test
  public void testFindAll()
  {
    final List<Library> libraries = libraryRepository.findAll();

    Assert.assertFalse(libraries.isEmpty());
    libraries.forEach(library -> {
      Assert.assertNotNull(library.getBooks());
      Assert.assertNotEquals(0, library.getBooks().size());
      Assert.assertNotNull(library.getID());
      Assert.assertNotNull(library.getName());

      library.getBooks().forEach(book -> {
        Assert.assertNotNull((book.getID()));
        Assert.assertNotNull((book.getTitle()));
      });
    });
  }
}
