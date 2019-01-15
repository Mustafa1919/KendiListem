package GenericList;


public class ListM<T extends Comparable<T>> {

    private int loc;
    private Object[] arrayList = {};
    private Object[] tempList = {};
    private int defaultCapasity = 10;

    public ListM(){
        this.arrayList = new Object[getDefaultCapasity()];
        setLoc(0);
    }


    private void kapasiteGenislet(){
        setDefaultCapasity(getDefaultCapasity()+10);
    }
    private void diziBuyut(){
        tempList = arrayList;
        arrayList = new Object[getDefaultCapasity()];
        arrayList = kopyala(arrayList,tempList);
    }
    private void kaydir(int loc, int endLoc){
        for(int i=endLoc; i>loc; i--){
            arrayList[i] = arrayList[i-1];
        }
    }
    /*  Listeye ekleme yapar
        Ilk paramatre eklenecek veriyi temsil eder
        Ikinci parametre ise eklenecek konumu temsil edeer
        Eger dizi boyutu eklenecek konumdan kucuk ise
        Yeniden boyutlandirma yapılır.
     */
    private void ekle(T data, int loc){
        if(arrayList.length > loc) {
            arrayList[loc] = data;
            setLoc(getLoc()+1);
        }
        else{
            kapasiteGenislet();
            diziBuyut();
            ekle(data, getLoc());
        }
    }
    private void siralaDizi(Object[] arr, int start, int end){
        for(int i=0;i<end;i++){
            for(int j=i+1;j<=end;j++){
                if(((T)arr[i]).compareTo((T)arr[j]) > 0)
                    degistir(arr,i,j);
            }
        }
    }
    private void degistir(Object[] arr, int loc1, int loc2){
        T temp = (T)arr[loc1];
        arr[loc1] = arr[loc2];
        arr[loc2] = temp;
    }


    public void ekle(T data){
        ekle(data,getLoc());
    }
    /*Parametre olarak gonderilen konuma ekleme yapar
      eger gonderilen konum son konumdan buyuk ise
      sona ekleme yapar
      degilse kaydirma islemi yapilarak ekleme gerceklestirilir.
     */
    public void arayaEkle(T data, int loc){
        if(loc > getLoc())
            ekle(data);
        else {
            if (getLoc() + 1 < getDefaultCapasity()) {
                kaydir(loc, getLoc());
                ekle(data, loc);
            } else {
                kapasiteGenislet();
                diziBuyut();
                ekle(data, loc);
            }
        }
    }
    public void yazdir(){
        System.out.print("[");
        for(int i=0; i<getLoc(); i++){
            if(i == getLoc()-1){
                System.out.print(arrayList[i] + "]");
            }
            else
                System.out.print(arrayList[i] + ", ");
        }
        System.out.println();
    }
    public Object[] kopyala(Object[] arr, Object[] copyArr){
        for(int i=0; i<copyArr.length; i++)
            arr[i] = copyArr[i];
        return arr;
    }
    /*Parametre olarak gonderilen verinin konumunu geri dondurur
      eger bu veri yok ise -1 dondurur
     */
    public int konumGetir(T data){
        for(int i=0; i<getLoc(); i++){
            if(arrayList[i].equals(data))
                return i;
        }
        return -1;
    }
    /*Parametre olarak gonderilen veri dizi icinde
      var mı yokmu diye bakar eger var ise true yoksa
      false deger dondurur.
     */
    public boolean varmi(T data){
        for(int i=0; i<getLoc(); i++){
            if(arrayList[i].equals(data))
                return true;
        }
        return false;
    }
    /*Parametre olarak gonderilen eleman Liste icinde
      kac tane oldugunu donderir.
     */
    public int kacTaneVar(T data){
        int count = 0;
        for(int i=0; i<getLoc(); i++){
            if(arrayList[i].equals(data))
                count++;
        }
        return count;
    }
    public void sirala(){
        siralaDizi(arrayList , 0, getLoc()-1);
    }
    public T degerGetir(int loc){
        return (T)arrayList[loc];
    }



    public int getLoc() {return loc;}
    public void setLoc(int loc) {this.loc = loc;}

    public int getDefaultCapasity() {return defaultCapasity;}
    public void setDefaultCapasity(int defaultCapasity) {this.defaultCapasity = defaultCapasity;}

}
