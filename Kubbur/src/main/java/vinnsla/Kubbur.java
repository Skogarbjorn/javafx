package vinnsla;

import java.util.Random;

public class Kubbur {
    private Stykki[][] bord;
    private Stykki[] number;

    /**
     * Smiður sem býr til nýjan kubb af gefinni stærð
     * @param radir Raðir
     * @param dalkar Dálkar
     */
    public Kubbur(int radir, int dalkar) {
        frumstillaKubb(radir, dalkar);
    }

    /**
     * Setur slembigildi fyrir hvern og einn reit í kubbnum
     * @param radir Raðir
     * @param dalkar Dálkar
     */
    private void frumstillaKubb(int radir, int dalkar) {
        Stykki[][] bord = new Stykki[radir][dalkar];
        Stykki[] number = new Stykki[radir*dalkar];
        int counter=0;
        Random random = new Random();
        for (int i=0;i<radir;i++) {
            for (int j=0;j<dalkar;j++) {
                Stykki newStykki = new Stykki("mynd" + ++counter);
                int randI;
                int randJ;
                do {
                    randI = random.nextInt(3);
                    randJ = random.nextInt(3);
                } while (bord[randI][randJ] != null);
                bord[randI][randJ] = newStykki;
                number[counter-1] = newStykki;
            }
        }
        this.bord = bord;
        this.number = number;
    }

    /**
     * Skilar stykki á kubbnum útfrá hnitum
     * @param i x hnit
     * @param j y hnit
     * @return Stykkið
     */
    public Stykki getBordStykki(int i, int j) {
        return bord[i][j];
    }

    /**
     * Skilar einvíða fylki kubbsins með öllum Stykkjum
     * @return Einvítt Stykkja-fylki
     */
    public Stykki[] getNumber() {
        return number;
    }
}
