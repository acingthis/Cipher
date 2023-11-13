package Cipher;

public class Caesar extends Cipher{

    public void Encode()
    {
        shiftAlphabet(6);

        PrintAlpha();

        System.out.println("reset");

        resetAlphabet();

        PrintAlpha();
    }
}
