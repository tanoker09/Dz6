package Task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Класс Абзац
 * В одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 */
public class Paragraph implements Generator{
    Text owner;

    ArrayList<Sentence> sentences;

    public Paragraph(Text owner){
        this.owner = owner;
        sentences = createParagrah();
    }

    public ArrayList<Sentence> createParagrah(){
        int paragraphSize = newRandomInt(1, 20);
        ArrayList<Sentence> result = new ArrayList<>();

        for(int i = 0; i < paragraphSize; i++){
            result.add(owner.createSentence());
        }

        //добавление разрыва строки и возврата каретки в конец абзаца
        result.get(paragraphSize - 1).addToLast("\r\n");

        return result;
    }

    @Override
    public String toString() {
        return sentences.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
