package ee.risthein.erko.dojo.terminal;

import org.joda.time.Days;

import java.util.List;

/**
 * @author Erko Risthein
 */
class Terminal {
    public static final int MAX_SIZE = 30 * 30;
    public static final int COST_PER_DAY = 100;

    private List<Container> lot;
    private int revenue;
    private Clock clock;

    public Terminal(List<Container> lot, Clock clock) {
        this.lot = lot;
        this.clock = clock;
    }

    public void add(Container container) {
        if (lot.size() >= MAX_SIZE) {
            throw new TerminalOverflowException();
        }
        container.setCheckInDate(clock.getCurrentDate());
        lot.add(container);
    }

    public boolean contains(Container container) {
        return lot.contains(container);
    }

    public void remove(Container container) {
        container.setCheckOutDate(clock.getCurrentDate());
        updateRevenue(container);
        lot.remove(container);
    }

    private void updateRevenue(Container container) {
        int days = Days.daysBetween(container.getCheckInDate(), container.getCheckOutDate()).getDays();
        days = Math.max(days, 1);
        revenue += days * COST_PER_DAY;
    }

    public int getFreeSpots() {
        return MAX_SIZE - lot.size();
    }

    public int getRevenue() {
        return revenue;
    }
}
