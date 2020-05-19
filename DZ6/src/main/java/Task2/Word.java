package Task2;

/**
 * Класс слово
 * Слово состоит из 1<=n2<=15 латинских букв
 */
public class Word implements Generator{

    //для генерации буквы
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    String word;

    /**
     * Конструктор
     * @param isFirstCapital первая буква заглавная
     * @param addComma добавить ли запятую
     */
    public Word(boolean isFirstCapital, boolean addComma){
        word = createWord(isFirstCapital, addComma);
    }

    public Word(String word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void addToWord(String addition) {
        word = word + addition;
    }

    private String createWord(boolean isFirstCapital, boolean addComma){
        int wordSize = newRandomInt(1, 15);
        StringBuilder result = new StringBuilder( wordSize );

        if(isFirstCapital){
            result.append(newRandomUpperChar());
        }
        else{
            result.append(newRandomChar());
        }

        for( int i = 1; i < wordSize; i++ ){
            result.append( newRandomChar() );
        }

        if(addComma){
            result.append(',');
        }

        return result.toString();
    }


    private char newRandomChar(){
        return alphabet.charAt(newRandomInt(0, 25));
    }

    private char newRandomUpperChar(){
        return alphabet.toUpperCase().charAt(newRandomInt(0, 25));
    }

    @Override
    public String toString() {
        return word;
    }
}
