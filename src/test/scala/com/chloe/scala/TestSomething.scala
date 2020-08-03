package com.chloe.scala

import org.scalatest.flatspec.AnyFlatSpec
import com.chloe.scala.Main.{
  getWords,
  lengthOfLongestWord,
  countSentences,
  wordsOccurMost,
  percentageOccurOnce,
  averageWordsPerSentence
}

class TestSomething extends AnyFlatSpec {

  val fullText =
    "lorem ipsum dolor sit amet consectetur lorem ipsum et mihi quoniam et adipiscing elit.sed quoniam et advesperascit et mihi ad villam revertendum est nunc quidem hactenus ex rebus enim timiditas non ex vocabulis nascitur.nummus in croesi divitiis obscuratur pars est tamen divitiarum.nam quibus rebus efficiuntur voluptates eae non sunt in potestate sapientis.hoc mihi cum tuo fratre convenit.qui ita affectus beatum esse numquam probabis duo reges constructio interrete.de hominibus dici non necesse est.eam si varietatem diceres intellegerem ut etiam non dicente te intellego parvi enim primo ortu sic iacent tamquam omnino sine animo sint.ea possunt paria non esse.quamquam tu hanc copiosiorem etiam soles dicere.de quibus cupio scire quid sentias.universa enim illorum ratione cum tota vestra confligendum puto.ut nemo dubitet eorum omnia officia quo spectare quid sequi quid fugere debeant nunc vero a primo quidem mirabiliter occulta natura est nec perspici nec cognosci potest.videmusne ut pueri ne verberibus quidem a contemplandis rebus perquirendisque deterreantur sunt enim prima elementa naturae quibus auctis virtutis quasi germen efficitur.nam ut sint illa vendibiliora haec uberiora certe sunt.cur deinde metrodori liberos commendas.mihi inquam qui te id ipsum rogavi nam adhuc meo fortasse vitio quid ego quaeram non perspicis.quibus ego vehementer assentior.cur iustitia laudatur mihi enim satis est ipsis non satis.quid est enim aliud esse versutum nobis heracleotes ille dionysius flagitiose descivisse videtur a stoicis propter oculorum dolorem.diodorus eius auditor adiungit ad honestatem vacuitatem doloris.nos quidem virtutes sic natae sumus ut tibi serviremus aliud negotii nihil habemus."

  "Words" should "be split by . or space" in {

    val words = "lorem ipsum.dolor"

    val expected = List("lorem", "ipsum", "dolor")

    val actual = getWords(words)

    assert(expected == actual)

  }

  it should "be counted correctly" in {

    val expected = 260

    val actual = getWords(fullText).size

    assert(expected == actual)
  }

  "Length of longest word" should "be calculated" in {
    val words = List("lorem", "ipsum", "contemplandis")

    val actualLength = lengthOfLongestWord(words)

    val expected = 13

    assert(expected == actualLength)
  }

  "Number of sentences" should "be counted" in {

    val sentences = "lorem ipsum dolor.sit amet consectetur.lorem."

    val actual = countSentences(sentences)
    val expected = 3

    assert(expected == actual)

  }

  "Words that occur most" should "be found" in {
    val list = List("lorem", "ipsum", "dolor", "ipsum", "dolor", "dolor")

    val expected = Set("dolor", "ipsum")

    val actual = wordsOccurMost(list, 2).toSet

    assert(expected == actual)
  }

  it should "be found in full text" in {

    val wordsList = getWords(fullText)

    val expected = Set("non", "est", "enim", "ut", "quid", "mihi")

    val actual = wordsOccurMost(wordsList, 6).toSet

    assert(expected == actual)
  }

  "Percentage of words occurring once" should "be calculated" in {

    val wordsList = getWords(fullText)

    val actual = percentageOccurOnce(wordsList)
    val expected = 60

    assert(actual == expected)
  }

  "Count sentences" should "be correct" in {
    val actual = averageWordsPerSentence(fullText)
    val expected = 11

    assert(actual == expected)

  }

}
