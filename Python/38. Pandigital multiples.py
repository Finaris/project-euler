"""
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576.
We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by
1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is
the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can
be formed as the concatenated product of an integer with
(1,2, ... , n) where n > 1?
"""


def is_pandigital(n: int) -> bool:
    """ Determines if the provided number is pandigital or not.

    :param n: (int) The number of interest.
    :return: (bool) Whether or not the number is pandigital.
    """
    return ({j for j in range(1, 10)} - {int(digit) for digit in str(n)}) == set()


def calculate_successive_pandigital_product(n: int) -> float:
    """ Calculates a successive product for a number if it is pandigital.

    :param n: (int) The number of interest.
    :return: (float) The pandigital number produced from the product.
    """
    starting_number, running_number_string = 1, ""
    while starting_number < 10:
        if len(running_number_string) > 10:
            return float('-inf')
        elif len(running_number_string) == 9:
            return int(running_number_string) if is_pandigital(int(running_number_string)) else float('-inf')
        else:
            running_number_string += str(n*starting_number)
            starting_number += 1
    return float('-inf')


if __name__ == "__main__":
    # The range of values that we need to check is actually pretty small.
    # At maximum we need to check up to 9999 to get something in range
    # as n > 1.
    print(int(max(calculate_successive_pandigital_product(i) for i in range(1, 9999))))
