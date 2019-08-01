"""
We shall say that an n-digit number is pandigital if it
makes use of all the digits 1 to n exactly once; for example,
the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254,
containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product
identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way
so be sure to only include it once in your sum.

"""


def is_pandigital_product(n: int) -> bool:
    """ Determines if n is a pandigital product.

    :param n: (int) The number of interest.
    :return: (bool) True if the number is pandigital and False otherwise.
    """
    # Figure out the numbers needed from the factors
    remaining_digits = {j for j in range(1, 10)} - {int(digit) for digit in str(n)}

    # There are only two possibilities: 1/4 digit factors or 2/3 digits.
    # Start with 1/4 digits.
    for j in [j for j in range(1, 10)] + [j for j in range(10, 100)]:
        if int(n/j) == n/j:
            factor_one, factor_two = j, int(n/j)
            if remaining_digits == {int(digit) for digit in str(factor_one)} | {int(digit) for digit in str(factor_two)}:
                return True
    return False


if __name__ == "__main__":
    total = 0
    for i in range(1000, 10000):
        if is_pandigital_product(i):
            total += i
    print(total)
