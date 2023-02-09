public class ClockTime implements Comparable<ClockTime> {
    private int hour;
    private int minute;
    private String amOrPm;

    public ClockTime (int h, int m, String a) {
        this.hour = h;
        this.minute = m;
        this.amOrPm = a;

        if ( h < 1 || h > 12 ) {
            throw new IllegalArgumentException("The valid hours are 1-12.");
        }

        if ( m < 0 || m > 59 ) {
            throw new IllegalArgumentException("The valid minutes are 0-59.");
        }

        if ( !a.equals("am") && !a.equals("pm") ) {
            throw new IllegalArgumentException("It must be am or pm to be valid.");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getAmOrPm() {
        return amOrPm;
    }

    @Override
    public String toString() {
        if (minute < 10) {
          return hour + ":0" + minute + amOrPm;
        } else {
        return hour + ":" + minute + amOrPm;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ClockTime) {
            ClockTime other = (ClockTime) o;
            return this.hour == other.hour
                    && this.minute == other.minute
                    && this.amOrPm.equals(other.amOrPm);
        } else {
            return false;
        }

    }

    @Override
    public int compareTo(ClockTime other) {
        if (!this.amOrPm.equals(other.amOrPm)) {
            return this.amOrPm.compareTo(other.amOrPm);
        } else if (this.hour != other.hour) {
            if (this.hour == 12) {
                this.hour = 0;
            }
            if(other.hour == 12) {
                other.hour = 0;
            }
            return Integer.compare(this.hour, other.hour);
        } else {
            return Integer.compare(this.minute, other.minute);
        }

    }

}
