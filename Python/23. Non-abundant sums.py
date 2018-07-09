import math

# Stores sets of factors for numbers.
FACTORIZATION_MEMO = {
    1: {1}
}

ABUNDANT_NUMBER_LIMIT = 28124


def prime_factorization(number):
    """ Finds the prime factorization of the provided number.

    :param number: (int) positive integer
    :return: (set) all prime factors of a provided number
    """
    if number in FACTORIZATION_MEMO:
        return FACTORIZATION_MEMO[number]

    # Known factors are 1 and the number itself. Recursively find prime factor sets of direct factors.
    factors = {1, number}
    for n in range(2, int(math.ceil(math.sqrt(number)))+1):
        if number % n == 0 and number//n != 1:
            factors |= prime_factorization(n)
            factors |= prime_factorization(number//n)

    # Update the memo and return.
    FACTORIZATION_MEMO[number] = factors
    return FACTORIZATION_MEMO[number]

if __name__ == "__main__":
    abundant_numbers_set = set()

    # Classify all numbers up until the known lower bound of numbers where all numbers greater than this bound
    # can be expressed as the sum of two abundant numbers.
    for i in range(1, ABUNDANT_NUMBER_LIMIT):
        all_factors = prime_factorization(i)
        sum_of_factors = sum(all_factors)-i
        if sum_of_factors > i:
            abundant_numbers_set.add(i)

    # Find all of the positive integers less than the proven bound which are sums of abundant numbers.
    abundant_numbers = list(abundant_numbers_set)
    abundant_sums = set()
    for i in range(len(abundant_numbers)):
        for j in range(i, len(abundant_numbers)):
            if abundant_numbers[i]+abundant_numbers[j] > ABUNDANT_NUMBER_LIMIT:
                break
            abundant_sums.add(abundant_numbers[i]+abundant_numbers[j])

    # Find all numbers which are not abundant sums and sum them together.
    all_nums_to_bound = {i for i in range(ABUNDANT_NUMBER_LIMIT)}
    all_nums_to_bound -= abundant_sums

    print(sum(all_nums_to_bound))
