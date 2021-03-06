"""

Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal
numbers are all figurate (polygonal) numbers and are generated by the
following formulae:

Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Square	 	P4,n=n2	 	1, 4, 9, 16, 25, ...
Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three
interesting properties.

The set is cyclic, in that the last two digits of each number is the
first two digits of the next number (including the last number with the
first).

Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and
pentagonal (P5,44=2882), is represented by a different number in the
set. This is the only set of 4-digit numbers with this property.
Find the sum of the only ordered set of six cyclic 4-digit numbers
for which each polygonal type: triangle, square, pentagonal, hexagonal,
heptagonal, and octagonal, is represented by a different number in the set.

"""

import random

from typing import Callable


def generate_numbers_up_to_n(n: int, f: Callable) -> set:
    """ Generates all numbers up to a number n using the provided function f.

    :param n: (int) The number to generate other numbers up to (but not including).
    :param f: (Callable) A function which takes in a sequence number and returns a number.
    :return: (set) A set of all numbers up to n.
    """
    all_numbers, sequence_number, last_number = set(), 1, float('-inf')
    while last_number <= n:
        last_number = f(sequence_number)
        if last_number <= n:
            all_numbers.add(last_number)
        sequence_number += 1
    return all_numbers


def triangular_numbers(n: int) -> set:
    """ Returns a set of all triangular numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of triangular numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i * (i + 1) / 2)


def square_numbers(n: int) -> set:
    """ Returns a set of all square numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of square numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i**2)


def pentagonal_numbers(n: int) -> set:
    """ Returns a set of all pentagonal numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of pentagonal numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i*((3*i)-1)/2)


def hexagonal_numbers(n: int) -> set:
    """ Returns a set of all hexagonal numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of hexagonal numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i*((2*i)-1))


def heptagonal_numbers(n: int) -> set:
    """ Returns a set of all heptagonal numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of heptagonal numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i*((5*i)-3)/2)


def octagonal_numbers(n: int) -> set:
    """ Returns a set of all octagonal numbers up to (and not including) n.

    :param n: (int) The maximum sequence number.
    :return: (set) A set of octagonal numbers.
    """
    return generate_numbers_up_to_n(n, lambda i: i*((3*i)-2))


def find_cyclical_figurate_numbers(low: int, high: int) -> dict:
    """ Finds the largest set of cyclical numbers between low and high (inclusive).

    :param low: (int) Low end of numbers sought.
    :param high: (int) High end of numbers of sought.
    :return: (dict) Assignment between number type and number.
    """
    # Check all provided numbers. Track visited numbers.
    seen = set()
    for i in range(low, high+1):
        cyclical_figurate_number_assignment = find_cyclical_figurate_number_assignment(i, seen)
        if cyclical_figurate_number_assignment and validate_chain(cyclical_figurate_number_assignment):
            return cyclical_figurate_number_assignment
    return dict()


def find_cyclical_figurate_number_assignment(inp: int, seen: set, graph: dict = None, assignment: dict = None) -> dict:
    """ Tries to find a maximizing cyclical figurate number assignment,
        returning an empty dictionary if it cannot.

    :param inp: (int) Input number to search from.
    :param seen: (set) All seen numbers.
    :param graph: (dict) The graph to pull from.
    :param assignment: (dict) The existing assignment.
    :return: (dict) Dictionary mapping assignment.
    """
    # Check if the graph is populated or not.
    if graph is None:
        graph = dict(ALL_NUMBERS)
    if assignment is None:
        assignment = dict()
    if not graph:
        return assignment

    # Determine if the number has been seen yet or not, or if its valid.
    if inp < 1000 or inp in assignment.values():
        return dict()

    # Search the graph for a new child. Make an assignment if possible.
    #seen.add(inp)
    for node, values in graph.items():
        # If the input is found, try it out.
        if inp in values:
            # Make a new assignment and graph.
            new_assignment = dict(assignment)
            new_assignment[node] = inp
            new_graph = dict(graph)
            del new_graph[node]

            # Try all new next numbers and evaluate.
            last_two_digits = str(inp)[2:]
            for i in range(10, 100):
                next_number = int(last_two_digits + str(i))
                complete_assignment = find_cyclical_figurate_number_assignment(next_number, seen,
                                                                               new_graph, new_assignment)
                if complete_assignment:
                    return complete_assignment
    return dict()


def validate_chain(chain: dict) -> bool:
    """ Determines whether or not the found assignment makes a chain.

    :param chain: (dict) An assignment chain
    :return: (bool) True if the assignment makes a chain.
    """
    # Iterate through the chain and try to find a chain.
    chain_copy = dict(chain)
    value = chain_copy.popitem()[1]
    while chain_copy:
        suffix = str(value)[2:]
        for next_node, next_value in chain_copy.items():
            prefix = str(next_value)[:2]
            if suffix == prefix:
                value = next_value
                del chain_copy[next_node]
                break
        else:
            return False
    return True


# Global variables which hold all of the numbers.
ALL_TRIANGULAR_NUMBERS = triangular_numbers(10000)
ALL_SQUARE_NUMBERS = square_numbers(10000)
ALL_PENTAGONAL_NUMBERS = pentagonal_numbers(10000)
ALL_HEXAGONAL_NUMBERS = hexagonal_numbers(10000)
ALL_HEPTAGONAL_NUMBERS = heptagonal_numbers(10000)
ALL_OCTAGONAL_NUMBERS = octagonal_numbers(10000)
ALL_NUMBERS = {
    "triangular": ALL_TRIANGULAR_NUMBERS,
    "square": ALL_SQUARE_NUMBERS,
    "pentagonal": ALL_PENTAGONAL_NUMBERS,
    "hexagonal": ALL_HEXAGONAL_NUMBERS,
    "heptagonal": ALL_HEPTAGONAL_NUMBERS,
    "octagonal": ALL_OCTAGONAL_NUMBERS
}

if __name__ == "__main__":
    # Evaluate the output for 4-digit numbers.
    number_assignments = find_cyclical_figurate_numbers(1000, 10000)
    print(f"Assignment: {number_assignments}")
    print(f"Sum: {sum(number_assignments.values())}")
