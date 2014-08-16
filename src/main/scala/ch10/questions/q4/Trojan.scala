package ch10.questions.q4

class Trojan

class Encrypter extends Trojan with Crypto

class DuffDecrypter extends Trojan with Crypto {
  override val key = -3
}

class Decrypter extends {
  override val key = -3
} with Trojan with Crypto
