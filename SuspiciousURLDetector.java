import java.util.*;
import java.util.regex.*;

public class SuspiciousURLDetector {

    private static final String[] BAD_TLDS = {".tk", ".ml", ".ga", ".cf", ".gq", ".xyz"};

    // Common brand names to watch for (expandable list)
    private static final String[] BRANDS = {"paypal", "google", "facebook", "amazon", "microsoft"};

    // Regex to detect IP address
    private static final Pattern IP_PATTERN = Pattern.compile(
            "https?://(?:\\d{1,3}\\.){3}\\d{1,3}.*");

    public static boolean containsIPAddress(String url) {
        return IP_PATTERN.matcher(url).matches();
    }

    public static boolean containsSuspiciousTLD(String url) {
        for (String tld : BAD_TLDS) {
            if (url.endsWith(tld) || url.contains(tld + "/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsBrandTypos(String url) {
        for (String brand : BRANDS) {
            if (url.toLowerCase().contains(brand)) {
                // Check for misspellings like paypa1, go0gle
                String typoRegex = brand.replaceAll("a", "[a@4]")
                                        .replaceAll("o", "[0o]");
                if (url.toLowerCase().matches("." + typoRegex + ".")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTooLong(String url) {
        return url.length() > 75;
    }

    public static void analyzeURL(String url) {
        System.out.println("Analyzing: " + url);

        if (containsIPAddress(url)) {
            System.out.println(" ⚠ Suspicious: Contains IP address instead of domain");
        }
        if (containsSuspiciousTLD(url)) {
            System.out.println(" ⚠ Suspicious: Uses risky TLD");
        }
        if (containsBrandTypos(url)) {
            System.out.println(" ⚠ Suspicious: Possible brand typosquatting");
        }
        if (isTooLong(url)) {
            System.out.println(" ⚠ Suspicious: URL is unusually long");
        }

        System.out.println(" ✅ Analysis complete\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL to check (or type 'exit'): ");

        while (true) {
            String url = sc.nextLine().trim();
            if (url.equalsIgnoreCase("exit")) break;
            analyzeURL(url);
            System.out.println("Enter next URL (or 'exit'): ");
        }

        sc.close();
    }
}