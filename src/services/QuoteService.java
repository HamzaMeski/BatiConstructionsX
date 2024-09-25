package services;

import UI.project.ProjectDisplay;
import orgg.dao.project.PgProjectDAO;
import orgg.dao.quote.PgQuoteDAO;
import UI.quote.QuoteDisplay;
import orgg.entities.Quote;
import java.util.List;
import java.util.ArrayList;

public class QuoteService {
    private static PgQuoteDAO model;
    private static QuoteDisplay display;

    public QuoteService(PgQuoteDAO model, QuoteDisplay display) {
        this.model = model;
        this.display = display;
    }

    public static void addQuote(Quote quote) {
        model.addQuote(quote);
    }

    public static List<Quote> getQuoteByProjectId(int projectId) {
        return model.displayQuotes(projectId);
    }
}
