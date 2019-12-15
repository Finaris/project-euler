"""
The fraction 49/98 is a curious fraction, as an inexperienced
mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by
cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial
examples.

There are exactly four non-trivial examples of this type of
fraction,  less than one in value, and containing two digits
in the numerator and denominator.

If the product of these four fractions is given in its lowest
common terms, find the value of the denominator.
"""


def is_almost_equal_to(a: float, b:float, thresh: float = .00001) -> bool:
    """ Determines if a and b are approximately equal.

    :param a: (float) The first number of interest.
    :param b: (float) The second number of interest.
    :param thresh: (float) The margin of error between the two.
    :return: True if the two numbers are approximately equal, False otherwise.
    """
    return abs(a-b) <= thresh


if __name__ == "__main__":
    # It should be pretty easy to exhaustively check all ~10,000
    # fractions that have two-digit numerators and denominators.
    # For each one we do an 4 checks, so it's pretty reasonable
    # to track overall.
    non_trivial_fractions = set()
    for i in range(10, 100):
        for j in range(i+1, 100):
            # Ignore trivial cases:
            if (i % 11 == 0 and j % 11 == 0) or (j % 10 == i % 10) or (int(i/10) == int(j/10)):
                continue

            # Create the 4 smaller fractions.
            smaller_fractions = [(int(i/10), j % 10),
                                 (i % 10, int(j/10))]
            for smaller_fraction in smaller_fractions:
                try:
                    if is_almost_equal_to(i/j, smaller_fraction[0]/smaller_fraction[1]):
                        print((i, j), smaller_fraction)
                        non_trivial_fractions.add((i, j))
                except ZeroDivisionError:
                    continue

    # Look through the output to get the unsimplified numerator and denominator.
    print(non_trivial_fractions)
    numerator, denominator = 1, 1
    for fraction in non_trivial_fractions:
        numerator *= fraction[0]
        denominator *= fraction[1]

    print(numerator, denominator)
    print(numerator/denominator)
    # Result here is: 7546392/33958764
    #

