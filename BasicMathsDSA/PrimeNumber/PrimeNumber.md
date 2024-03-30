# Prime Number

## Facts

- 1 is not prime number.
- 2 is smallest prime number.

## Approch

### Naive Approach

- Let say we wanna check if a number `n` is prime or not.
  - First edge case of `n=1`, `if(n==1) return false`.
  - Run a loop from `i=2` to `i<n`.
  - Then check `if(n%i==0) return true`.
  - At the end after the `for loop`, `return true`.
