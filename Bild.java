import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bild {                                                                                 //Superklasse

//________________________________________________***Verschachtelte_Pixel_Klasse***______________________________________________________________________________________________________\\

    public class Pixel {                                                                            //Klasse der einzelnden Pixel des Bildes
        int Red = 0;                                                                                //Rotanteil des RGB-Pixels
        int Green = 0;                                                                              //Grünanteil des RGB-Pixels
        int Blue = 0;                                                                               //Blauanteil des RGB-Pixels
        float Compare = 0;                                                                          //Kriterium zum Vergleichen der Pixel

        public Pixel(int x,int y,int z){                                                            //Construktor der Klasse Pixels
            this.Red = x;                                                                           //Integerwert der Pixelfarbe Rot
            this.Green = y;                                                                         //Integerwert der Pixelfarbe Grün
            this.Blue = z;                                                                          //Integerwert der Pixelfarbe Blau
            this.Compare = (this.Red*3)+(this.Green*2)+(this.Blue*1);                               //Integerwert des Vergleichskriteriums
        }
    }

//________________________________________________***Construktor_und_Globale_Variablen***________________________________________________________________________________________________\\

    int width = 0;                                                                                  //Breite des Bildes
    int hight = 0;                                                                                  //Höhe des Bildes
    Pixel[][] bild = new Pixel[0][0];                                                               //Zwei Dimensionales Array für die Bild Daten ohne Daten

    public Bild(String a, int X, int Y)throws Exception{
        this.width = X;                                                                             //Breite des Bildes wird an die Klasse Bild übergeben
        this.hight = Y;                                                                             //Höhe des Bildes wird an die Klasse Bild übergeben
        File f = new File("D:\\IntellIJ\\BildEditing\\src\\"+a);                                    //importiert eine Bild Datei
        BufferedImage img = ImageIO.read(f);                                                        //fügt die datei in ein BufferImage ein
        Pixel[][] temp = new Pixel[this.width][this.hight];                                         //Temporäres Array zum einfügen der RGB-Information
        for(int i = 0;i < this.width;i++){                                                          //iteriert in horizontaler ebene
            for(int j = 0;j < this.hight;j++) {                                                     //iteriert in vertikaler ebene
                int rgb = img.getRGB(i,j);                                                          //Holt sich die Farben des Pixels(i,j)
                Color c = new Color(rgb);                                                           //Fügt die RGB Information in eine Color Klasse ein
                temp[i][j] = new Pixel(c.getRed(), c.getGreen(), c.getBlue());                      //Holt sich den jewiligen RGB Farbton
            }
        }
        bild = temp;                                                                                //ersetzt den Temporären mit dem Globalen bild Array
    }
//_______________________________________________***Funktion_zum_Ausgeben***____________________________________________________________________________________________________________\\

    //------------------Ausgabe eines Bestimmten Pixels--------------------\\

    public void getPixelColor(int x,int y){
        System.out.println("Red: "+bild[x-1][y-1].Red);                                             //Ausgabe des Rotanteils des Pixels(x/y)
        System.out.println("Green: "+bild[x-1][y-1].Green);                                         //Ausgabe des Grünanteils des Pixels(x/y)
        System.out.println("Blue: "+bild[x-1][y-1].Blue);                                           //Ausgabe des Blauanteils des Pixels(x/y)
        System.out.println("Comp: "+ bild[x-1][y-1].Compare);                                       //Ausgabe des Vergleichswertes
    }

    //-----------------Ausgabe des Sortierten Bildes-----------------------\\

    protected void ausgabeSortedBild()throws Exception{

        BufferedImage img = new BufferedImage(this.width,this.hight,BufferedImage.TYPE_INT_RGB);    //Erstellt ein BufferImage

        for(int i = 0;i < this.width;i++){                                                          //iteriert in horizontaler ebene
            for(int j = 0;j < this.hight;j++) {                                                     //iteriert in vertikaler ebene
                Color c = new Color(this.bild[i][j].Red,this.bild[i][j].Green,this.bild[i][j].Blue);//Color wird mit RGB-Information gefüllt
                int rgb = c.getRGB();                                                               //RGB Inteher wird erstellt
                img.setRGB(i,j,rgb);                                                                //setzt am Pixel(i,j) die Farbe des rgb Integer ein
            }
        }
        File outputfile = new File("D:\\IntellIJ\\BildEditing\\src\\ProcessedPicture.png");            //legt ein Outputfile an
        outputfile.createNewFile();                                                                 //angelegter file wird erstellt
        ImageIO.write(img, "png", outputfile);                                                      //schreibt auf dem Outputfile
    }
}
