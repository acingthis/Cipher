package Cipher;

import java.security.SecureRandom;

public class Caesar extends Cipher{

    private String InputString = "Example";


    private char[] Alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z'};

    //if you just wish for a random alphabet shift
    public String Encode()
    {
        SecureRandom rand = new SecureRandom();
        return Encode(rand.nextInt(1,26));
    }

    //the shift the alpha bet a set amount and change the data to the shifted alphabet
    public String Encode(int val)
    {
        resetAlphabet();
        shiftAlphabet(val);

        CipherFile cipherFile = new CipherFile("InputCipher.txt");
        InputString = cipherFile.Read();

        InputString = InputString.toUpperCase();
        String AfterEncode = "";

        //iterates through example string
        for (int x = 0; x < InputString.length(); x++)
        {
            //iterates through Alphabet array
            for (int i = 0; i < Alphabet.length; i++)
            {
                if (Alphabet[i] == InputString.charAt(x))
                {
                    //if the alphabet matches the iterated letter it adds shifted alphabet to string
                    AfterEncode = AfterEncode + ShiftedAlphabet(i);
                }
            }
        }
        
        CipherFile write = new CipherFile("EncodedInput.txt");
        write.Write(AfterEncode);
        return  AfterEncode;
    }

    //if you know the shift and wish to decode a shifted Caesar cipher
    public String Decode(int val)
    {
        resetAlphabet();
        shiftAlphabet(val);

        CipherFile cipherFile = new CipherFile("InputCipher.txt");
        InputString = cipherFile.Read();

        InputString = InputString.toUpperCase();
        String AfterDecode = "";

        //iterates through example string
        for (int x = 0; x < InputString.length(); x++)
        {
            //iterates through Alphabet array
            for (int i = 0; i < Alphabet.length; i++)
            {
                if (ShiftedAlphabet(i) == InputString.charAt(x))
                {
                    //if the shifted alphabet matches the iterated letter it adds shifted alphabet to string
                    AfterDecode = AfterDecode + Alphabet[i];
                }
            }
        }

        CipherFile write = new CipherFile("DecodedInput.txt");
        write.Write(AfterDecode);
        return  AfterDecode;
    }

    /**
    //TBD
    public void Decode()
    {}
     */
}
