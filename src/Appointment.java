import java.time.LocalDateTime;

public class Appointment implements Comparable<Appointment> {
    private String id;
    private LocalDateTime start;
    private int lengthInMinutes;

    public Appointment(String id,
                       LocalDateTime start,
                       int lengthInMinutes) {
        this.id = id;
        this.start = start;
        this.lengthInMinutes = lengthInMinutes;
    }

    // one kind of copy mechanism that a class can offer -- a copy constructor:
    public Appointment(Appointment original) {
        this.id = original.id;
        this.start = original.start;
        this.lengthInMinutes = original.lengthInMinutes;
    }

    // another kind of copy mechanism that a class can offer -- a clone method:
    public Appointment clone() {
        return new Appointment(id, start, lengthInMinutes);
    }

    @Override
    public String toString() {
        return id + " " + start + " " + lengthInMinutes;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void addTime(int numMinutes) {
        if (numMinutes < 0) {
            throw new IllegalArgumentException("cannot add a negative amount of time");
        }

        lengthInMinutes += numMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Appointment) {
            Appointment other = (Appointment) o;
            return this.id.equals(other.id)
                    && this.start.equals(other.start)
                    && this.lengthInMinutes == other.lengthInMinutes;
        } else {
            return false;
        }
    }

    // appointments are ordered as follows:
    // - first, chronologically by start,
    // - then (if the starts are equal) numerically by length,
    // - and then (if the lengths are also equal) lexicographically by id.
    @Override
    public int compareTo(Appointment other) {
        if (!this.start.equals(other.start)) {
            return this.start.compareTo(other.start);
        } else if (this.lengthInMinutes != other.lengthInMinutes) {
            return Integer.compare(this.lengthInMinutes, other.lengthInMinutes);
        } else {
            return this.id.compareTo(other.id);
        }
    }
}