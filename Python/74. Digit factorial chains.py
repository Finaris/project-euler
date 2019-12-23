"""

The number 145 is well known for the property that the sum of the factorial of
its digits is equal to 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

Perhaps less well known is 169, in that it produces the longest chain of
numbers that link back to 169; it turns out that there are only three such
loops that exist:

169 → 363601 → 1454 → 169
871 → 45361 → 871
872 → 45362 → 872

It is not difficult to prove that EVERY starting number will eventually get
stuck in a loop. For example,

69 → 363600 → 1454 → 169 → 363601 (→ 1454)
78 → 45360 → 871 → 45361 (→ 871)
540 → 145 (→ 145)

Starting with 69 produces a chain of five non-repeating terms, but the longest
non-repeating chain with a starting number below one million is sixty terms.

How many chains, with a starting number below one million, contain exactly
sixty non-repeating terms?

"""

from math import factorial

if __name__ == "__main__":
    # Create a map which stores the number of non-repeating terms exist in a
    # factorial chain. Preload the known cycles.
    non_repeating_terms = {}

    # Iterate through every number under a million. Keep track of those with exactly
    # a length of 60.
    sixty_non_repeating = 0
    for i in range(1000000):
        # Keep progressing the chain until it loops.
        current_term, j, order_of_seen_terms, seen_terms = i, 0, list(), set()
        while True:
            # Check if the value is cached or seen.
            if current_term in non_repeating_terms:
                j += non_repeating_terms[current_term]
                break
            if current_term in seen_terms:
                break

            # Otherwise, progress the chain and increment.
            order_of_seen_terms.append(current_term)
            seen_terms.add(current_term)
            current_term = sum(factorial(int(digit)) for digit in str(current_term))
            j += 1

        # Update the seen term cache.
        for k, term in enumerate(order_of_seen_terms):
            non_repeating_terms[term] = j - k

        # Update the non-repetition count if possible.
        if j == 60:
            sixty_non_repeating += 1

    print(f"Number of Chains with 60 Non-Repeating Terms: {sixty_non_repeating}")
