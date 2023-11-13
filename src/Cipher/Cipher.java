package Cipher;

public class Cipher {

    private char[] Alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                                'Q','R','S','T','U','V','W','X','Y','Z'};

    protected void resetAlphabet()
    {
        Alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    //moves all the letter in the alphabet one place and then replaces that first with the last letter
    protected void shiftAlphabet()
    {
        char lastLetter = Alphabet[25];

        for (int x = 25; x > 0; x--)
        {
            Alphabet[x] = Alphabet[x-1];
        }

        Alphabet[0] = lastLetter;
    }

    //more than one shift required at once
    protected void shiftAlphabet(int shiftval)
    {
        for(int i = 0; i < shiftval; i++)
        {
            shiftAlphabet();
        }
    }

    //shift alphabet until a set letter is at the beginning
    protected void shiftAlphabet(char shiftval)
    {
        while(Alphabet[0] != shiftval)
        {
            shiftAlphabet();
        }
    }

    //Debug
    protected void PrintAlpha()
    {
        System.out.println(Alphabet);
    }
}
