public class SteganoBild extends Bild {

    public SteganoBild(String a, int X, int Y) throws Exception {                                   //benutzt den Konstruktor der
        super(a,X,Y);                                                                               //Bild Klasse
    }

    public void stenohin(SteganoBild tmp)throws Exception{
        int k = 0;
        int l = 0;
        for(int i = 0;k < tmp.width;i = i + 50,k = k + 1, l = 0){
                for(int j = 0;l < tmp.hight;j = j + 50,l = l +1){
                        bild[i][j] = tmp.bild[k][l];
                }
        }
        ausgabeSortedBild();
    }

    public void stenoher(SteganoBild tmp)throws Exception{
        int k = 0;
        int l = 0;
        for(int i = 0;k < this.width;i = i + 50,k = k +1,l = 0){
            for(int j = 0;l < this.hight;j = j + 50,l = l + 1){
                bild[k][l] = tmp.bild[i][j];
            }
        }
        ausgabeSortedBild();
    }
}
