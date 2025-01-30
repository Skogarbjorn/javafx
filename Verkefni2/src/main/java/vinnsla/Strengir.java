package vinnsla;

public class Strengir {
    public String storedString;

    /**
     * Vistar storedString inn í instance variableið storedString
     * og kastar NullPointerException ef enginn texti er gefinn
     * @param storedString vistaður texti
     * @throws NullPointerException
     */
    public void saveText(String storedString) throws NullPointerException {
        if (storedString.isEmpty()) {
            throw new NullPointerException();
        }
        else {
            this.storedString = storedString;
        }
    }

    /**
     * Telur fjöldia orða í storedString og kastar
     * NullPointerException ef enginn texti er vistaður
     * @return fjöldi orða
     * @throws NullPointerException
     */
    public int count() throws NullPointerException {
        if (!storedString.isEmpty()) {
            String wordsArray[] = storedString.split(" ");
            int counter = 0;
            for (int i = 0; i < wordsArray.length; i++) {
                if (!wordsArray[i].isEmpty()) {
                    counter++;
                }
            }
            return counter;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Finnur staðsetningu fyrsta tilviks leitarord í storedString
     * og kastar NullPointerException ef ekkert er vistað
     * @param leitarord orð sem er leitað að
     * @return staðsetning fyrsta tilviks leitarord í char
     * @throws NullPointerException
     */
    public int search(String leitarord) throws NullPointerException {
        if (storedString == null) {
            throw new NullPointerException();
        }
        return storedString.indexOf(leitarord);
    }
}
