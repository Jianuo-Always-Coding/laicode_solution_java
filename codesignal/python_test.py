def calculate_phi(n):
    def generate_primes(n) :
        primes = []
        for num in range(2, n):
            is_prime = all(num % i != 0 for i in range(2, int(num**0.5) + 1))
            if is_prime:
                primes.append(num)
        return primes
    
    def is_prime (n, primes):
        return n in primes

    def calculate (n, primes):
        # Performs a calculation
        if is_prime (n, primes):
            return n-1 
        else:
            phi = n
            for p in primes:
                if n % p == 0:
                    phi -= phi/p
            print("phi = ", phi)
            print("n = ", n)
            return int(phi)
    primes = generate_primes (n)
    return calculate (n, primes)

a = calculate_phi(6)

print(a)