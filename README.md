# 🔍 Suspicious URL Detector

A simple Java-based command-line tool to analyze URLs for common signs of phishing or malicious intent. This utility checks for suspicious patterns such as IP-based URLs, risky top-level domains (TLDs), brand typosquatting, and unusually long URLs.

---

## 🚀 Features

- **IP Address Detection**: Flags URLs that use raw IP addresses instead of domain names.
- **Suspicious TLD Check**: Identifies risky domains like `.tk`, `.ml`, `.xyz`, etc.
- **Brand Typosquatting Detection**: Scans for misspelled brand names (e.g., `paypa1`, `go0gle`) to catch phishing attempts.
- **URL Length Check**: Warns if the URL exceeds a typical length threshold (75+ characters).

---

## 🛠 How It Works

The tool uses regular expressions and string matching to analyze each URL entered by the user. It prints out warnings for any suspicious patterns it detects.

---

## 📦 Requirements

- Java 8 or higher
- No external libraries required

---

## 🧪 Usage

1. **Compile the program**:

   ```bash
   javac SuspiciousURLDetector.java

TO RUN THE PROGRAM

java SuspiciousURLDetector


📚 Example
text
Enter URL to check (or type 'exit'):
http://192.168.0.1/login
Analyzing: http://192.168.0.1/login
 ⚠ Suspicious: Contains IP address instead of domain
 ✅ Analysis complete




 Enter URLs to analyze them one by one. Type exit to quit.


 thank you guys
