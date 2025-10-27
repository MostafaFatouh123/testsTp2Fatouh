package ma.emsi.fatouh.test;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .temperature(0.7)
                .modelName("gemini-2.5-flash")
                .build();

        PromptTemplate template = PromptTemplate.from("""
                Traduis le texte suivant en anglais : {{texte}}
                """);

        Prompt prompt = template.apply(Map.of(
                "texte", "Les LLMs sont entrainés sur de grands corpus de texte."
        ));

        String reponse = modele.chat(prompt.text());
        System.out.println(reponse);
    }
}
