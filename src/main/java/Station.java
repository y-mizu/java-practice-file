//1. comparableインターフェースを実装したStationクラスを作る
class Station implements Comparable<Station> {
    //2. 同クラス内にフィールドを記述(String num〜update) 
    String num;
    String line;
    String stationNumber;
    String stationName;
    String howtoRead;
    String englishName;
    String stationManager;
    String address;
    double height1; //比較に使うために double型にて定義
    String height2;
    String note1;
    String note2;
    String update;

    //3. Stationクラス内にコンストラクタを作る
    Station(String[] data) {
        //4. コンストラクタ内にフィールドをそれぞれ変数として宣言したものに適当なものを代入
        this.num = data[0];
        this.line = data[1];
        this.stationNumber = data[2];
        this.stationName = data[3];
        this.howtoRead = data[4];
        this.englishName = data[5];
        this.stationManager = data[6];
        this.address = data[7];

        //5.　String型の変数heightStringを宣言、data配列の8番目を代入（※height1を元にstationリストの並べ替えをするため)
        String heightString = data[8];
        //6.  変数heightStringに　それから文字 「m」を取り除いたものを代入する
        heightString = heightString.substring(0, heightString.length() - 1);
        //7.　double型の変数heightを宣言して、string型のheightStringをdouble型に変換する
        double height = Double.parseDouble(heightString);
        //8.　double型の変数heightをthis.height1に代入
        this.height1 = height;

        this.height2 = data[9];
        this.note1 = data[10];
        this.note2 = data[11];
        this.update = data[12];
    }
    // RF mainに大量にばらまかれていた各要素をstationにてStringBuilderを使って たくさん作る そしてmianへ、、、
    public String toCSVLine(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.num + ",");
        builder.append(this.line + ",");
        builder.append(this.stationNumber + ",");
        builder.append(this.stationName + ",");
        builder.append(this.howtoRead + ",");
        builder.append(this.englishName + ",");
        builder.append(this.stationManager + ",");
        builder.append(this.address + ",");
        builder.append(this.height1 + ",");
        builder.append(this.height2 + ",");
        builder.append(this.note1 + ",");
        builder.append(this.note2 + ",");
        builder.append(this.update + ",");

        return builder.toString();
    }

    //9. int型のcompareToメソッドに引数stationを引き渡し、この中でsort対象のクラスの項目の比較を行う (0か1か-1をreturnして比較)
    public int compareTo(Station station) {

        if(this.height1 < station.height1){
            return 1;
        }else if(this.height1 > station.height1){
            return -1;
        }else{
            return 0;
        }
    }
}