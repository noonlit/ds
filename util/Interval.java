package util;

public class Interval implements Comparable<Interval>
{
    private int start;
    private int length;
    private int end;

    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
    }

    public int getStart()
    {
        return start;
    }

    public int getLength()
    {
        return length;
    }

    public int getEnd()
    {
        return end;
    }

    /**
     * Longer intervals should be sorted before shorter intervals.
     * 
     * For equal length intervals, the ones with a smaller start value take precedence.
     * 
     * @param Interval interval
     */
    public int compareTo(Interval interval)
    {
        if (length != interval.getLength()) {
            return interval.getLength() - length;
        }

        return start - interval.getStart();
    }
}
