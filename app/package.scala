package org.jousse

package object bot {

  implicit final class debugKCombinatorAny[A](a: A) {
    def pp: A = { println(s"*DEBUG* $a"); a }
  }

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  implicit final class debugKCombinatorFutureAny[A](fua: Future[A]) {
    def thenPp: Future[A] = {
      fua onComplete { case result ⇒ result.pp }
      fua
    }
  }

  // implicit final class BotPimpedOption
}
