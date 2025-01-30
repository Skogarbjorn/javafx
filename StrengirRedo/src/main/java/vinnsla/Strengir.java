package vinnsla;

import java.util.Objects;

public class Strengir {
    private String savedString;

    public void setString(String savedString) {
        this.savedString = savedString;
    }

    public String telja() {
        if (savedString == null) throw new NullPointerException();
        String[] splitString = skipta();
        return Integer.toString(splitString.length);
    }

    public String leita(String searchString) {
        if (savedString == null || searchString == null) throw new NullPointerException();
        String[] splitString = skipta();
        for (int i = 0; i < splitString.length; i++) {
            if (Objects.equals(splitString[i], searchString)) {
                return Integer.toString(i);
            }
        }
        return "Not found";
    }

    private String[] skipta() {
        return savedString.split(" ");
    }
}
