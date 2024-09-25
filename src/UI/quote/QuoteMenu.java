package UI.quote;

import lib.ScanInput;
import orgg.dao.quote.PgQuoteDAO;
import orgg.entities.Quote;
import services.QuoteService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuoteMenu {
    static private PgQuoteDAO quoteModel = new PgQuoteDAO();
    static private QuoteDisplay quoteDisplay = new QuoteDisplay();
    static QuoteService quoteService = new QuoteService(quoteModel, quoteDisplay);

    public static void addQuote(double totalCost, int projectId) {
        System.out.println("--- Enregistrement du Devis ---");
        LocalDate creationDate = LocalDate.now();
        System.out.print("Entrez la date de validité du devis (format : jj/mm/aaaa) : ");
        String validityDateStr = ScanInput.scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate validityDate = LocalDate.parse(validityDateStr, formatter);

        Quote newQuote = new Quote(0, projectId, totalCost, creationDate, validityDate, false);
        quoteService.addQuote(newQuote);
        System.out.println("Le devis a été enregistré avec succès !");
    }
}
