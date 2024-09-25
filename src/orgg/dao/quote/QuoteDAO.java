package orgg.dao.quote;

import java.util.List;
import orgg.entities.Quote;

public abstract class QuoteDAO {
    public abstract void addQuote(Quote quote);
    public abstract List<Quote> displayQuotes(int projectId);
}
