package Task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Класс предложения
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 */
public class Sentence implements Generator{
    Text owner;

    private ArrayList<Word> words;

    private String endings = ".!?";

    public Sentence(Text owner) {
        this.owner = owner;
        words = createSentence();
    }

    /**
     * Добавление строки к последнему слову
     * @param addition
     */
    public void addToLast(String addition){
        words.get(words.size() - 1).addToWord(addition);
    }

    public ArrayList<Word> createSentence(){
        int sentenceSize = newRandomInt(1, 15);
        Random random = new Random();
        ArrayList<Word> result = new ArrayList<>();

        //первое слово должно начинаться с заглавной буквы
        Word word = owner.createWord(true, random.nextBoolean());
        result.add(word);

        for( int i = 1; i < sentenceSize - 1; i++ ){
            word = owner.createWord(false, random.nextBoolean());
            result.add(word);
        }

        //добавление знака окончания предложения
        word = owner.createWord(false, false);
        word.addToWord(newRandomEnding());

        result.add(word);

        return result;
    }


    /**
     * Получение рандомного окончания предложения
     * @return строку
     */
    private String newRandomEnding(){
        return "" + endings.charAt(newRandomInt(0, 2)) + ' ';
    }

    @Override
    //Слова разделены одним пробелом
    public String toString() {
        return words.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
