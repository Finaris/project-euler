from decimal import Decimal
from decimal import getcontext


def recurring_cycle(d):
    """ Finds the length of the recurring cycle in 1/d, where the recurring cycle is the longest sub-sequence

    :param d: (int) any given number
    :return: (int) length of the longest recurring cycle
    """
    # Get the repeating decimal part of the fraction. Set the max length of computed decimals to 2000.
    decimal_string = str(Decimal(1)/Decimal(d))[2:]
    getcontext().prec = 2000

    # Keep a dictionary mapping all number bases to the current cycle.
    current_subsets, current_maximum = {}, 0
    for i, digit in enumerate(decimal_string):
        # Append the current digit to all numbers except if the key is the current digit.
        for sub_digit in current_subsets:
            if sub_digit != digit:
                current_subsets[sub_digit].append(digit)

        # Add the digit to the dictionary, otherwise check if the cycle is larger than the maximum.
        if digit not in current_subsets:
            current_subsets[digit] = [digit]
        else:
            if current_subsets[digit] == list(decimal_string[i:i+len(current_subsets[digit])]):
                current_maximum = max(current_maximum, len(current_subsets[digit]))
                current_subsets[digit] = [digit]
            else:
                current_subsets[digit].append(digit)
    return current_maximum

if __name__ == "__main__":
    print(max([(n, recurring_cycle(n)) for n in range(1, 1000)], key=lambda x: x[1])[0])
