package com.chloe.scala

object Main {

  def getWords(words: String): List[String] = {
    words.split(" ").flatMap(a => a.split("\\.")).toList
  }

  def lengthOfLongestWord(words: List[String]): Int = {
    words.map(word => word.length).max
  }

  def countSentences(fullText: String): Int = {
    fullText.split("\\.").toList.size
  }

  def averageWordsPerSentence(fullText: String): Int = {
    val words = getWords(fullText).size

    val sentences = countSentences(fullText)

    words / sentences

  }

  def countByOccurrence(words: List[String]): List[(String, Int)] = {
    words.groupBy(identity).mapValues(_.size).toList
  }

  def wordsOccurMost(words: List[String], howMany: Int): List[String] =
    countByOccurrence(words)
      .sortBy(a => a._2)(Ordering[Int].reverse)
      .take(howMany)
      .map(a => a._1)

  def percentageOccurOnce(words: List[String]): Int = {
    val wordCounts = countByOccurrence(words)
    val totalWordCount: Double = words.size
    val wordsOccurringOnce: Double = wordCounts.count(a => a._2 == 1)

    ((wordsOccurringOnce / totalWordCount) * 100).toInt

  }

  def main(args: Array[String]): Unit = {}
}
