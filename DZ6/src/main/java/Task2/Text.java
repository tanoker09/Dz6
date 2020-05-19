package Task2;

import java.util.Random;

/**
 * Класс Текст.
 * Используется для компоновки классов Слово и предложение.
 */
public class Text implements Generator{

    private String[] words;
    private int probability;

    public Text(String[] words, int probability){
        this.words = words;
        this.probability = probability;
    }

    public Sentence createSentence(){
        return new Sentence(this);
    }

    public Word createWord(boolean isFirstCapital, boolean addComma){
        Random rand = new Random();
        int chance = rand.nextInt(probability);
        if(chance == 1){
            char[] newWord = words[rand.nextInt(words.length)].toCharArray();
            if(isFirstCapital)
                newWord[0] = Character.toUpperCase(newWord[0]);
            if(addComma)
                return new Word(new String(newWord) + ",");
            return new Word(new String(newWord));
        }
        return new Word(isFirstCapital, addComma);

    }

}
