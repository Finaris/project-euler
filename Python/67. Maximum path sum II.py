import math


def triangular_number(n):
    """ Calculates the nth triangular number. A triangular number is the nth term in a sequence of successive additions
        of incrementally increasing terms. For example, consider the successive addition of 5 numbers, beginning at 0:

           0  =  0
         + 1  =  1
         + 2  =  3
         + 3  =  6
         + 4  =  10

        In this case, the 1st triangular number is 0, the 2nd is 1, the 3rd is 3, and so on and so forth. Thus, the
        nth term can simply be found by calculating the partial sum of the sequence 1, 2, 3, ..., n, which is denoted
        by:
            SUM = n * (x_0 + x_n)/2
        where n is the number of terms in the sequence, x_0 is the first term, and x_n is the last term. This formula,
        when applied to an incrementally increasing sequence, simplifies to (n^2+n)/2.

    :param n: (int) position of the desired triangular number in the triangular sequence
    :return: (int) triangular number at the desired position
    """
    return (n**2+n)//2


def index_in_triangular_sequence(number):
    """ Calculates the position of a provided number in the triangular sequence. Assuming the provided number is a
        triangular number, then it necessarily follows that:
            x = (n^2+n)/2
            n^2 + n - 2x = 0     (rearrange quadratic equation)
            (-1 +- sqrt(1+8x))/2 (quadratic formula)
        In this case, only the positive root is considered since otherwise the solution is negative (which does not
        make sense as we can't have a "negative" indexed term in the sequence). Thus, we can calculate the index via:
            (-1 + sqrt(1+8x))/2

    :param number: (int) provided triangular number
    :return: (int) position in the triangular sequence
    """
    return int((math.sqrt(1+8*number)-1)//2)


def largest_path_weight(triangle):
    """ Calculates the weight of the largest path of the provided triangle. Instead of calculating the size of the
        longest path, we calculate the weight of the longest path (which is the sum of all elements on the path).
        For example, in the triangle: [[1], [2, 3]], the largest path's weight is 4 (the path is [1, 3]).

    :param triangle: (list) 2D array where each successive row has a size which is 1 larger than the previous one
    :return: (float) sum of all numbers on the largest path
    """
    if len(triangle) == 0:
        return 0
    if len(triangle) == 1:
        return triangle[0][0]

    # Begin by considering the 2nd to last row. Only consider routes which are strictly superior when recursing.
    # This is done by comparing an element in the 2nd to last row to the two directly below it, and picking only
    # the maximal weight. Create a new row out of these new weights, and replace the bottom two rows with the
    # new list of weights. Continue until we condense at the top of the list.
    return largest_path_weight(triangle[:-2] + [[num + max(triangle[-1][i], triangle[-1][i + 1])
                                                for i, num in enumerate(triangle[-2])]])


if __name__ == "__main__":
    """ NOTE: This is the same algorithm (and almost exact same code) as is used in problem 18. """
    # Generate the 2D list containing the triangle.
    raw_triangle = "".join(open("resources/p067_triangle.txt").readlines()).split()
    formatted_triangle = [[float(raw_triangle[j]) for j in range(triangular_number(i), triangular_number(i+1))]
                          for i in range(index_in_triangular_sequence(len(raw_triangle)))]
    print(largest_path_weight(formatted_triangle))
