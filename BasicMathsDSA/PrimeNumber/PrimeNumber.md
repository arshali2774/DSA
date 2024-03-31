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

- Approach

---

### Sieve of Eratosthenes

- Approach

---

### Segmented Sieve

- Approach
