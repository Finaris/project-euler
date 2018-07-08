class CalendarConverter:
    """ Collection of various conversion methods that can be used in calendar related programming. """

    # Dictionary mapping a particular month (1 is January, 2 is February, etc.) to the number of days in that
    # month in a non-leap year.
    _DAYS_IN_MONTH = {
        1: 31,
        2: 28,
        3: 31,
        4: 30,
        5: 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10: 31,
        11: 30,
        12: 31
    }

    # Given a numerical representation of a day, retrieve the String name.
    _DAY_NUMBER_TO_STRING = {
        0: "Sunday",
        1: "Monday",
        2: "Tuesday",
        3: "Wednesday",
        4: "Thursday",
        5: "Friday",
        6: "Saturday",
    }

    def __init__(self):
        pass

    def string_day_from_integer(self, day):
        """ Converts the provided day number to its corresponding string name.

        :param day: (int) day of the week in the range [0, 6]
        :return: (str) name of the requested day of the week
        """
        if not 0 <= day <= 6:
            raise ValueError("expected day to be between 0 and 6 (inclusive) but was {0}".format(day))
        return self._DAY_NUMBER_TO_STRING[day]

    def month_in_year_to_days(self, year, month):
        """ Given a year and month, determines the number of days in that month.

        :param year: (int) numerical year in the common era (i.e. positive integers)
        :param month: (int) months ranging from 1-12 (1 is January, 12 is December, etc.)
        :return: (int) number of days in the requested (month, year) pair
        """
        if not 1 <= month <= 12:
            raise ValueError("expected month to be between 1 and 12 (inclusive) but was {0}".format(month))
        if year <= 0:
            raise ValueError("expected year to be greater than 0 but was {0}".format(year))

        # If the requested month is 2 (February) and the year is a leap year, then there are 29 days in the month.
        return 29 if month == 2 and self.is_leap_year(year) else self._DAYS_IN_MONTH[month]

    def year_to_days(self, year):
        """ Given a year, determines the number of days in that year.

        :param year: (int) numerical year in the common era (i.e. positive integers)
        :return: (int) number of days in the requested year
        """
        return 366 if self.is_leap_year(year) else 365

    @staticmethod
    def is_leap_year(year):
        """ Determines if the provided year is a leap year.

        :param year: (int) numerical year in the common era (i.e. positive integers)
        :return: (bool) true if the provided year is a leap year, false otherwise
        """
        return year % 4 == 0 and (year % 400 == 0 or year % 100 != 0)

if __name__ == "__main__":
    cc = CalendarConverter()

    # In the tracker variables below, 0 is Sunday, 1 is Monday, ..., 6 is Saturday.
    # 1 Jan 1900 was a Monday.
    current_day = 1
    # Counts the number of times each day of the week occurs on the first of the month.
    day_of_week_to_first_of_month = {i: 0 for i in range(7)}
    day_of_week_to_first_of_month[current_day] += 1

    # Iterate through each month between the beginning of 1901 and the end of 2000 (includes 1st of January 2001).
    for current_year in range(1900, 2001):
        for current_month in range(1, 13):
            current_day = (current_day + cc.month_in_year_to_days(current_year, current_month)) % 7
            # Only count for the 20th century (1901 through 2000).
            if 1901 <= current_year <= 2000:
                day_of_week_to_first_of_month[current_day] += 1

    print(day_of_week_to_first_of_month[0])
