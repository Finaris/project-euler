"""

The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104
(3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has
exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are
cube.

"""

if __name__ == "__main__":
    # Create a map between digits and their cube roots.
    cubes = dict()

    # Until we find 5 cubes in one permutation, continue cubing numbers.
    i = 0
    while True:
        # Find the cube and sort its digits.
        cube = i ** 3
        sorted_digits = tuple(sorted(str(cube)))
        all_cubes_for_digit = cubes.setdefault(sorted_digits, list())
        all_cubes_for_digit.append(cube)

        # Determine if we have all the numbers we need.
        if len(all_cubes_for_digit) >= 5:
            print(f"Smallest Cube: {min(all_cubes_for_digit)}")
            break

        # Increment, update the dict, and continue otherwise.
        cubes[sorted_digits] = all_cubes_for_digit
        i += 1
