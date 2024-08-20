package outLookpkg;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public class OutlookMailReading {
	
	static String linkHref="";
	

    public static void main(String[] args) {
    	
    	WebDriverManager.chromedriver().setup();
    	
    	WebDriver driver = new ChromeDriver();
    
        // Specify the subject of the email you want to process
        String targetSubject = "Microsoft account security info was added";
        readAndProcessMail(targetSubject);
        
   //     if(linkHref.contains("https://go.microsoft.com")) {
        	driver.get(linkHref);
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

       	
   //     }
        
        driver.quit();
    }

    public static void readAndProcessMail(String targetSubject) {
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");

        // Outlook IMAP server settings
        String host = "outlook.office365.com";
        String username = "invautomation1@outlook.com"; // provide your Outlook email address
        String password = "zsrhcwasdqyhzndm"; // provide your password

        try {
            Session session = Session.getDefaultInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            System.out.println("Total Messages: " + messages.length);

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];

                // Check if the current email has the desired subject
                if (message.getSubject().equals(targetSubject)) {
                    System.out.println("Found email with subject: " + targetSubject);
                    // Extract and process the email content
                    processEmailContent(message);
                    break; // Stop processing after finding the target email
                }
            }

            // Disconnect
            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processEmailContent(Message message) throws IOException, MessagingException {
        String contentType = message.getContentType();
        String messageContent = "";

        if (contentType.contains("multipart")) {
            Multipart multiPart = (Multipart) message.getContent();
            int numberOfParts = multiPart.getCount();
            for (int partCount = 0; partCount < numberOfParts; partCount++) {
                MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                    // Handle attachments if needed
                    String fileName = part.getFileName();
                    System.out.println("Attachment: " + fileName);
                } else {
                    // Handle message content
                    String htmlContent = part.getContent().toString();
                    // Extract text content using JSoup
                    Document document = Jsoup.parse(htmlContent);
                    String textContent = document.text();
                    messageContent = textContent;

                    // Process the link from the email content
                    processLinkFromEmail(textContent);
                }
            }
        } else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
            Object content = message.getContent();
            if (content != null) {
                messageContent = content.toString();
            }
            // Process the link from the email content
            processLinkFromEmail(messageContent);
        }

        System.out.println("Message Content: " + messageContent);
    }

    private static void processLinkFromEmail(String emailContent) {
    	
    	 // Parse the email content using JSoup
        Document document = Jsoup.parse(emailContent);
     // Print the entire HTML content for debugging
        System.out.println("Full HTML Content:\n" + document.html());

        // Extract the link from the email content
     // Extract the link from the email content
        Elements links = document.select("a[href]");
        System.out.println("Found links: " + links);

        if (!links.isEmpty()) {
        	for(int i=0;i<links.size();i++) {
        		
        		
        		
        	}
            Element linkElement = links.first();
             linkHref = linkElement.attr("href");

            // Perform actions on the extracted link
            
        } else {
            System.out.println("No link found in the email content.");
        }
        // Parse the email content using JSoup or other methods
        // Extract the link from the email content
        // Perform actions on the extracted link as needed
        // For example, you can use WebDriver to navigate to the link
        // and continue with your execution.
    }
}

