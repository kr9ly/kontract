package dev.kr9ly.kontract

class ContractViolationException(message: String = "") : RuntimeException("contract violation founded. $message")