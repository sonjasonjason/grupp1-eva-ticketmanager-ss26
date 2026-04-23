package Core.Clients;

import Core.Clients.CommandHandler.ConsoleClientEventCommandHandler;
import Core.Interfaces.TicketShopInterface;

import java.util.Scanner;
import Core.TicketShop.LocalTicketShop;

public class ConsoleClientLocal {

    private final Scanner scanner;

    private final ConsoleClientEventCommandHandler eventCommandHandler;

    public ConsoleClientLocal() {
        this.scanner = new Scanner(System.in);
        TicketShopInterface shop = new LocalTicketShop();

        this.eventCommandHandler = new ConsoleClientEventCommandHandler(shop);
    }

    public void start() {
        System.out.println("=== Welcome to the Local-Ticket-shop ===");
        System.out.println(
            "Type 'help' to see available commands or 'exit' to quit.\n"
        );

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) continue;

            try {
                if (handleCommand(input)) break; // Exit if true
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private boolean handleCommand(String input) {
        return switch (input) {
            case "help" -> {
                showHelp();
                yield false;
            }
            case "events", "e" -> {
                eventCommandHandler.handleEventCommands();
                yield false;
            }
            case "exit", "quit", "q" -> {
                System.out.println("Thank you for using the Ticket-shop!");
                yield true;
            }
            default -> {
                System.out.println(
                        "Unknown command: '" +
                                input +
                                "'. Type 'help' for available commands."
                );
                yield false;
            }
        };
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("  events, e     - Enter event management mode");
        System.out.println("  help          - Show this help message");
        System.out.println("  exit, quit, q - Exit the application");
    }

}
