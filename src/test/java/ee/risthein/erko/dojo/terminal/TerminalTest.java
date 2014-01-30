package ee.risthein.erko.dojo.terminal;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Erko Risthein
 */

public class TerminalTest {
    @Mock
    Clock clock;
    Terminal terminal;
    Container container;

    @Before
    public void setUp() {
        initMocks(this);
        when(clock.getCurrentDate()).thenReturn(new LocalDate());
        terminal = new Terminal(new ArrayList<Container>(), clock);
        container = new Container();
    }

    @Test
    public void shouldHaveTheContainerThatWasAdded() {
        terminal.add(container);
        assertTrue(terminal.contains(container));
    }

    @Test
    public void shouldBeAbleToRemoveAContainer() {
        addAndRemoveContainer();
        assertFalse(terminal.contains(container));
    }

    @Test
    public void shouldHaveAllFreeSpots() {
        assertEquals(Terminal.MAX_SIZE, terminal.getFreeSpots());
    }

    @Test
    public void shouldHaveOneLessFreeSpot() {
        terminal.add(container);
        assertEquals(Terminal.MAX_SIZE - 1, terminal.getFreeSpots());
    }

    @Test
    public void shouldHaveZeroFreeSpots() {
        addMaxAmountOfContainers();
        assertEquals(0, terminal.getFreeSpots());
    }

    @Test(expected = TerminalOverflowException.class)
    public void shouldNotBeAbleToOverflowTheTerminal() {
        addMaxAmountOfContainers();
        terminal.add(container);
    }

    @Test
    public void shouldBeAbleToSetAndGetContainerOwner() {
        String name = "John Smith";
        container.setOwner(name);
        assertEquals(name, container.getOwner());
    }

    @Test
    public void shouldHaveZeroRevenueAtTheStart() {
        assertEquals(0, terminal.getRevenue());
    }

    @Test
    public void shouldBeAbleToGetTheRevenueForOneContainerForOneDay() {
        addAndRemoveContainer();
        assertEquals(Terminal.COST_PER_DAY, terminal.getRevenue());
    }

    @Test
    public void shouldBeAbleToGetTheRevenueForTwoContainersForOneDay() {
        addAndRemoveContainer();
        addAndRemoveContainer();
        assertEquals(Terminal.COST_PER_DAY * 2, terminal.getRevenue());
    }

    @Test
    public void shouldBeAbleToGetTheRevenueForOneContainerForTwoDays() {
        keepOneContainerForNDays(2);
        assertEquals(Terminal.COST_PER_DAY * 2, terminal.getRevenue());
    }

    @Test
    public void shouldBeAbleToGetTheRevenueForTwoContainersForTwoDays() {
        keepOneContainerForNDays(2);
        keepOneContainerForNDays(2);
        assertEquals(Terminal.COST_PER_DAY * 4, terminal.getRevenue());
    }

    private void addAndRemoveContainer() {
        terminal.add(container);
        terminal.remove(container);
    }

    private void addMaxAmountOfContainers() {
        for (int i = 0; i < Terminal.MAX_SIZE; i++) {
            terminal.add(container);
        }
    }

    private void keepOneContainerForNDays(int n) {
        terminal.add(container);
        LocalDate nDaysLater = container.getCheckInDate().plusDays(n);
        when(clock.getCurrentDate()).thenReturn(nDaysLater);
        terminal.remove(container);
    }
}
