package class_examples;

/**
 * Calculați distanța în zile dintre 2 date calendaristice.
 */
public class DaysDiff
{
    public static void main(String[] args)
    {
        /*
         * Read first date (must be read as 3 ints).
         * 
         * TODO read instead of hardcoding.
         */
        int startDay = 1;
        int startMonth = 1;
        int startYear = 1930;

        /*
         * Read second date (must be read as 3 ints).
         */
        int endDay = 31;
        int endMonth = 12;
        int endYear = 3999;

        /*
         * Perform sanity checks
         */
        if (!isValidInterval(startDay, startMonth, startYear, endDay, endMonth, endYear)) {
            // message
            return;
        }

        int intervalInDays = 0;

        /*
         * Add days for whole years (beginning after start year and stopping before end
         * year)
         */
        int totalYears = Math.max(endYear - startYear - 1, 0);
        int wholeYearsLowerBound = startYear + 1;
        int wholeYearsUpperBound = endYear - 1;

        /*
         * Sanity check: do we have at least one whole year?
         */
        if (wholeYearsLowerBound <= wholeYearsUpperBound) {
            /*
             * Apply leap year formula to get leap years within interval
             */
            int leapYears = getMultiplesInInterval(wholeYearsLowerBound, wholeYearsUpperBound, 4);
            leapYears -= getMultiplesInInterval(wholeYearsLowerBound, wholeYearsUpperBound, 100);
            leapYears += getMultiplesInInterval(wholeYearsLowerBound, wholeYearsUpperBound, 400);

            int nonLeapYears = totalYears - leapYears;

            intervalInDays += (366 * leapYears) + (365 * nonLeapYears);
        }

        /*
         * If both dates are in the same year, add the difference between them
         */
        if (startYear == endYear) {
            intervalInDays += getDaysIntervalWithinYear(startDay, startMonth, endDay, endMonth, startYear);
        } else {
            /*
             * Add: 
             * - days remaining in start year 
             * - days that have passed since the end year has started
             */
            intervalInDays += getDaysIntervalWithinYear(startDay, startMonth, 31, 12, startYear);
            intervalInDays += getDaysIntervalWithinYear(1, 1, endDay, endMonth, endYear);
        }

        /*
         * Display result
         */
        String startDate = String.format("%s/%s/%s", startDay, startMonth, startYear);
        String endDate = String.format("%s/%s/%s", endDay, endMonth, endYear);

        System.out.println("There are " + intervalInDays + " days between " + startDate + " and " + endDate);
    }

    /**
     * Calculates the number of days between two dates in the same year.
     * 
     * @param int startDay
     * @param int startMonth
     * @param int endDay
     * @param int endMonth
     * @param int year
     * @return int
     */
    private static int getDaysIntervalWithinYear(int startDay, int startMonth, int endDay, int endMonth, int year)
    {
        int days = 0;
        boolean isLeapYear = isLeapYear(year);

        /*
         * Count days in whole months between start and end
         */
        for (int i = startMonth + 1; i < endMonth; i++) {
            days += getDaysInMonth(i, isLeapYear);
        }

        /*
         * If this is the same month, simply add the difference between days
         */
        if (endMonth == startMonth) {
            return days + (endDay - startDay) + 1; // same day returns 1
        }

        /*
         * Different months - add remaining days for start month and elapsed days for
         * end month
         */
        days += getDaysInMonth(startMonth, isLeapYear) - startDay + 1; // add 1 to include the current
        days += endDay;

        return days;
    }

    /**
     * For a range with the given bounds, calculates how many multiples of n are
     * within the closed range.
     * 
     * E.g. for range 3-9 and step 4, the function will return 2 (because 4 and 8
     * are within the range).
     * 
     * @param int start
     * @param int end
     * @param int n
     * @return int
     */
    private static int getMultiplesInInterval(int start, int end, int n)
    {
        int firstStep = start / n; // integer division. reduce space.

        if (start % n != 0) {
            firstStep += 1;
        }

        int lastStep = end / n;

        return lastStep - firstStep + 1;
    }

    /**
     * Checks whether the given interval is valid (e.g. end date is not before start
     * date).
     * 
     * @param startDay
     * @param startMonth
     * @param startYear
     * @param endDay
     * @param endMonth
     * @param endYear
     * @return boolean
     */
    private static boolean isValidInterval(int startDay, int startMonth, int startYear, int endDay, int endMonth,
            int endYear)
    {
        return true; // TODO implement
    }

    /**
     * Returns number of days in a month.
     * 
     * @param int     month
     * @param boolean isLeapYear
     * @return int
     */
    private static int getDaysInMonth(int month, boolean isLeapYear)
    {
        /*
         * Treat case of February for leap and non-leap years
         */
        if (month == 2) {
            if (isLeapYear) {
                return 29;
            }

            return 28;
        }

        /*
         * Standard pattern is that number of days starts at 31 for odd month then
         * alternates between 31 and 30 for seven months then the pattern restarts after
         * the seventh month
         */
        return 31 - ((month - 1) % 7 % 2);
    }

    /**
     * Checks whether the year is a leap year.
     * 
     * if (year is not divisible by 4) then (it is a common year) 
     * else if (year is not divisible by 100) then (it is a leap year) 
     * else if (year is not divisible by 400) then (it is a common year) 
     * else (it is a leap year)
     * 
     * @param int year
     * @return int
     */
    private static boolean isLeapYear(int year)
    {
        if (year % 4 != 0) {
            return false;
        }

        if (year % 100 != 0) {
            return true;
        }

        if (year % 400 != 0) {
            return false;
        }

        return true;
    }
}
