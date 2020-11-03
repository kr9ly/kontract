package dev.kr9ly.kontract

object ContractContext {

    infix fun Any?.shouldBe(other: Any?) {
        if (this != other) {
            throw ContractViolationException("$this shouldBe $other.")
        }
    }

    infix fun Any?.shouldNotBe(other: Any?) {
        if (this == other) {
            throw ContractViolationException("$this shouldNotBe $other.")
        }
    }

    infix fun <T> Comparable<T>?.shouldLessThan(other: T?) {
        if (this == null || other == null || this >= other) {
            throw ContractViolationException("$this shouldLessThan $other.")
        }
    }

    infix fun <T> Comparable<T>?.shouldLessOrEqualsThan(other: T?) {
        if (this == null || other == null || this > other) {
            throw ContractViolationException("$this shouldLessOrEqualsThan $other.")
        }
    }

    infix fun <T> Comparable<T>?.shouldMoreThan(other: T?) {
        if (this == null || other == null || this <= other) {
            throw ContractViolationException("$this shouldMoreThan $other.")
        }
    }

    infix fun <T> Comparable<T>?.shouldMoreOrEqualsThan(other: T?) {
        if (this == null || other == null || this < other) {
            throw ContractViolationException("$this shouldMoreOrEqualsThan $other.")
        }
    }

    infix fun <T> Iterable<T>?.shouldContains(other: T?) {
        if (this == null || other == null || !this.contains(other)) {
            throw ContractViolationException("$this shouldContains $other.")
        }
    }

    infix fun <T> Iterable<T>?.shouldNotContains(other: T?) {
        if (this == null || other == null || this.contains(other)) {
            throw ContractViolationException("$this shouldNotContains $other.")
        }
    }

    infix fun <T> Iterable<T>?.shouldAnyBe(condition: (T) -> Boolean) {
        if (this == null || !this.any(condition)) {
            throw ContractViolationException()
        }
    }

    infix fun <T> Iterable<T>?.shouldNoneBe(condition: (T) -> Boolean) {
        if (this == null || this.any(condition)) {
            throw ContractViolationException()
        }
    }

    infix fun <T> Iterable<T>?.shouldAllBe(condition: (T) -> Boolean) {
        if (this == null || !this.all(condition)) {
            throw ContractViolationException()
        }
    }
}