package org.example.data.hiring;

import org.example.domain.hiring.Job;
import org.example.domain.hiring.Language;
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

/**
 * Integration tests for {@link JobRepository} and {@link LanguageRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class HiringTest
{
  @Autowired
  private JobRepository      jobRepository;
  @Autowired
  private LanguageRepository languageRepository;

  /**
   * Sets up data required for the tests.
   */
  @Before
  public void setup()
  {
    // Add some languages.
    for (final LanguageEnum language : LanguageEnum.values())
    {
      final Language lang = new Language(language.getCode(), language.getName());

      languageRepository.saveAndFlushAndDetach(lang);
    }

    // Add some jobs.
    Job job = new Job("English Interviewer");
    job.addLanguage(languageRepository.findByCode(LanguageEnum.ENGLISH.getCode()));
    jobRepository.saveAndFlushAndDetach(job);

    job = new Job("Vietnamese Interviewer");
    job.addLanguage(languageRepository.findByCode(LanguageEnum.ENGLISH.getCode()));
    job.addLanguage(languageRepository.findByCode(LanguageEnum.VIETNAMESE.getCode()));
    jobRepository.saveAndFlushAndDetach(job);

    job = new Job("Japanese Interviewer");
    job.addLanguage(languageRepository.findByCode(LanguageEnum.ENGLISH.getCode()));
    job.addLanguage(languageRepository.findByCode(LanguageEnum.JAPANESE.getCode()));
    job.addLanguage(languageRepository.findByCode(LanguageEnum.VIETNAMESE.getCode()));
    jobRepository.saveAndFlushAndDetach(job);
  }

  /**
   * Tests that jobs can be found by matching language codes.
   */
  @Test
  public void findJobsByLanguageCodes()
  {
    final List<Job> jobs = jobRepository.findAllByLanguageCodes(LanguageEnum.ENGLISH.getCode(), LanguageEnum.VIETNAMESE.getCode());

    Assert.assertEquals(2, jobs.size());

    System.out.println(String.format("   %047d", 0).replaceAll("0", "#"));
    System.out.println(String.format("   # %-25s # %-15s #", "Job Title", "Language Code"));
    System.out.println(String.format("   %047d", 0).replaceAll("0", "#"));

    for (final Job job : jobs)
    {
      Assert.assertNotNull(job);
      Assert.assertNotNull(job.getLanguages());
      Assert.assertNotNull(job.getTitle());

      for (final Language language : job.getLanguages())
      {
        Assert.assertNotNull(language);
        Assert.assertNotNull(language.getCode());
        Assert.assertNotNull(language.getName());

        System.out.println(String.format("   # %-25s # %-15s #", job.getTitle(), language.getCode()));
      }
    }

    System.out.println(String.format("   %047d", 0).replaceAll("0", "#"));
  }
}

/**
 * Represents a language.
 */
enum LanguageEnum
{
  ENGLISH("eng", "English"),
  JAPANESE("jap", "Japanese"),
  VIETNAMESE("vie", "Vietnamese");

  private final String code;
  private final String name;

  /**
   * Creates a language with a specified code and name.
   *
   * @param code The language code.
   * @param name The language name.
   */
  LanguageEnum(final String code, final String name)
  {
    this.code = code;
    this.name = name;
  }

  /**
   * Gets the language code.
   *
   * @return The language code.
   */
  public String getCode()
  {
    return code;
  }

  /**
   * Gets the language name.
   *
   * @return The language name.
   */
  public String getName()
  {
    return name;
  }
}
