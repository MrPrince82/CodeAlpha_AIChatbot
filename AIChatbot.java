import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AIChatbot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    // Constructor
    AIChatbot() {

        // Frame Settings
        setTitle("Artificial Intelligence Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Layout
        setLayout(new BorderLayout());

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 18));
        chatArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        // Input Field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 18));

        // Send Button
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Add Components
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action Listener
        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        // Welcome Message
        chatArea.append("BOT: Hello! I am your AI Chatbot.\n");
        chatArea.append("BOT: Ask me anything.\n\n");

        setVisible(true);
    }

    // Button Action
    public void actionPerformed(ActionEvent e) {

        String userMessage = inputField.getText().trim();

        if (userMessage.equals("")) {
            return;
        }

        // Display User Message
        chatArea.append("YOU: " + userMessage + "\n");

        // Generate Bot Reply
        String botReply = getBotResponse(userMessage.toLowerCase());

        // Display Bot Reply
        chatArea.append("BOT: " + botReply + "\n\n");

        // Clear Text Field
        inputField.setText("");
    }

    // Chatbot Logic
    public String getBotResponse(String message) {

        if (message.contains("hello") || message.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if (message.contains("how are you")) {
            return "I am fine and working properly.";
        }

        else if (message.contains("name")) {
            return "My name is Java AI Chatbot.";
        }

        else if (message.contains("time")) {
            return "Current Time: " + LocalTime.now().withNano(0);
        }

        else if (message.contains("date")) {
            return "Today's Date: " + LocalDate.now();
        }

        else if (message.contains("java")) {
            return "Java is an object-oriented programming language.";
        }

        else if (message.contains("ai")) {
            return "Artificial Intelligence enables machines to think intelligently.";
        }

        else if (message.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else {
            return "Sorry, I don't understand that question.";
        }
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AIChatbot();
        });
    }
}