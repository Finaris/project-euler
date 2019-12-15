"""
In England the currency is made up of pound, £, and pence, p, and
there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
"""


def number_coin_combinations(coins: set, target: int, current_coins: list = None, memo=None):
    """ Determines all permutations of coins that can hit the target.

    :param coins: (set) The available coins to make combinations with.
    :param target: (int) The number that is trying to be achieved.
    :param current_coins: (list) A list of all currently used coins.
    :param memo: (dict) A cache of results.
    :return: (list) All permutations which lead to the target.
    """
    # We keep a cache of all values and what coins they account for and build up.
    cache = {0: 1}
    for i in range(1, target+1):
        running_total_for_i = 0
        for coin in coins:
            if coin <= i:
                running_total_for_i += cache[i-coin]
        cache[i] = running_total_for_i
    print(cache)
    return cache[target]


if __name__ == "__main__":
    # Define all the variables for this problem.
    possible_coins = {1, 2, 5, 10, 20, 50, 100, 200}
    goal = 4

    # Find all the permutations then filter for duplicates.
    print(number_coin_combinations(possible_coins, goal))
