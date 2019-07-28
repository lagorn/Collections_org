package demo;

import model.DemoText;
import service.ITextService;
import service.StandartTextService;
import service.StreamTextService;

public class DemoService {

    private String text = DemoText.TEXT;

    public void execute() {

        System.out.println("Дан текст:");
        line();
        System.out.println(text);
        line();

        System.out.println("Простое решение: \n");
        showResult(new StandartTextService());
        line();

        System.out.println("Stream решение: \n");
        showResult(new StreamTextService());

    }

    private void showResult(ITextService service) {

        System.out.println("Кол-во использований каждого слова: ");
        System.out.println(service.wordsCounter(text).toString());
        System.out.println();

        System.out.println("Все уникальные слова: ");
        System.out.println(service.uniqueWords(text).toString());
        System.out.println();

        System.out.println("Отсортированные слова: ");
        System.out.println(service.sortWords(text).toString());

    }

    private void line() {
        System.out.println("----------------------------------------------------------------");
    }
}
