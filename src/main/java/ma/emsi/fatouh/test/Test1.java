package ma.emsi.fatouh.test;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .temperature(0.7)
                .modelName("gemini-2.5-flash")
                .build();

        String reponse = modele.chat("Pourquoi le principe IOC?");
        System.out.println(reponse);

    }
}
