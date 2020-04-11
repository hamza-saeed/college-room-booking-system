package DataStructures;

import java.time.LocalDate;

/**
 * Defines One Term
 *
 * @author Hamza
 */
public class OneTerm {

    private LocalDate TermBeginning;
    private LocalDate TermEnding;

    public OneTerm(LocalDate termBeginning, LocalDate termEnding) {
        TermBeginning = termBeginning;
        TermEnding = termEnding;
    }

    public LocalDate getTermBeginning() {
        return TermBeginning;
    }

    public LocalDate getTermEnding() {
        return TermEnding;
    }
}
