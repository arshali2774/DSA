# Prime Number

## Facts

- 0 is not prime number.
- 1 is not prime number.
- 2 is smallest prime number.

## Approach

### Naive Approach

- Let say we wanna check if a number `n` is prime or not.
  - First edge case of `n=1`, `if(n==1) return false`.
  - Run a loop from `i=2` to `i<n`.
  - Then check `if(n%i==0) return true`.
  - At the end after the `for loop`, `return true`.
- Similarly if we wanna count primes between a range from `1 to n` then,
  - We can just loop from `1 to n` and then for each iteration we can check if the number is prime or not.
  - Then increase the count.
- The problem with this apporach is that we can get a **time limit exceeded** error.
- This is because of the time complexity of `O(n^2)`.

---

### Square Root Approach

- This approach says that if the number `n` is non-prime then,
  - Atleast one of the factors should be smaller than `sqrt(n)`.
  - Let say we have `n = a * b`.
  - And suppose if, `a > sqrt(n)` and `b > sqrt(n)`, then we can say that `a*b > n`.
  - Which is false therefore one of the factors should be less than square root of `n`.
- To apply this we need to just change the `for loop` of `checkPrime` function.
- In for loop we are checking till `n`, we have to change that to `i<=sqrt(n)`.
- Still we have issue of time complexity for larger test cases.

---

### Sieve of Eratosthenes

- This approach comes useful when we wanna count primes between `1 to n`. Excluding `n` i.e. `1 to n-1`.
- We take a boolean array of size `n`, and initialize all elements with `true`.
- Then we first set elements at index `0` and `1` as `false` as we know they can't be prime.
- We know that `2` is prime then its multiples can't be prime, so we mark `2` as prime and its multiples `false`.
- Then same for `3` and so on.
- At the end all indexs with `true` values are prime numbers.

---

### Segmented Sieve

- It is a variation of **Sieve of Eratosthenes** approach.
- In this we are given a `low` and `high` and we have to find primes between this range.
- The algo is same but in this we have to start from `low` instead if `0`.
