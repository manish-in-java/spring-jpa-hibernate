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

import java.util.stream.IntStream;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LibraryRepositoryTest extends DataTest
{
  @Autowired
  private LibraryRepository libraryRepository;

  @Before
  public void setup()
  {
    final Library library = new Library(getString());

    IntStream.range(1, 11).forEach(i -> library.addBook(new Book(getString())));

    libraryRepository.saveAndFlush(library);
  }

  @Test
  public void testFindAll()
  {
    Assert.assertFalse(libraryRepository.findAll().isEmpty());
  }
}