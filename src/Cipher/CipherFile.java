package Cipher;

import java.io.*;

public class CipherFile {

    private File myFile;

    CipherFile(String Name)
    {
        try
        {
            myFile = new File("src/Cipher/TextFiles/" + Name);
            if (myFile.createNewFile())
            {
                System.out.println("new File Created: " + myFile.getName());
            }
        }
        catch (Exception e)
        {
            System.out.println("Issue creating File");
        }
    }

    public String Read()
    {
        try{
            FileReader myReader = new FileReader(myFile);
            String FileData = "";

            int c;
            while ((c =myReader.read()) != -1)
            {
                FileData = FileData + (char) c;
            }
            myReader.close();
            return FileData;
        }
        catch (Exception e)
        {
            System.out.println("Issue Reading File: " + myFile.getName());
            return "";
        }
    }

    public void Write(String Text)
    {
        try {
            FileWriter myWriter = new FileWriter(myFile);

            for (int x = 0; x < Text.length(); x++)
            {
                myWriter.write(Text.charAt(x));
            }
            myWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("Unable to write to file: " + myFile.getName());
        }
    }
}
