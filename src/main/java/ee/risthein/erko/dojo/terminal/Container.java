package ee.risthein.erko.dojo.terminal;

import org.joda.time.LocalDate;

/**
 * @author Erko Risthein
 */
public class Container {
    private String owner;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
