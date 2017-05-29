import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final int SKIP_SIZE = 3;

    public static void main(String args[]) {
        try {
            //11. File型変数fを宣言してインスタンスを生成、左辺に代入 (csvファイルを読み込む) 
            File f = new File("station2.csv");

            //12. InputStreamReader型の変数osrを宣言、インスタンスを生成して左辺に代入 (文字コードの指定)
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "SJIS");

            //13. BufferedReader型の変数brを宣言、インスタンスを生成し引数osr 左辺に代入
            BufferedReader br = new BufferedReader(isr);

            //14. stationコレクションを作成　
            ArrayList<Station> stationList = new ArrayList<Station>();

            List<String> skipList = new ArrayList<>();

            //RF for文を使って最初の三行を読み飛ばしつつ、それらをリストに格納する
            for (int i = 0; i < SKIP_SIZE; i++) {
                String skipped = br.readLine();
                skipList.add(skipped);
            }

            //15. String型の変数lineを宣言、readLineメソッドの戻り値を代入する(csvの1行を変数化) 
            String line;
            //17. lineがnullかどうかを判定(nullでない場合 18〜20 を実行) 
            while ((line = br.readLine()) != null) {
                //18.  data配列を宣言し、lineをsplitにて,で区切ったものを左辺に代入 (リスト変数はファイルを読込もの 行を,で区切り配列に変換)
                String[] data = line.split(",", 0);

                //19.　Station型の変数stationを宣言、stationインスタンスを作る（csvファイルのデータを格納のため）
                Station station = new Station(data);

                //20. stationコレクションにstationを保存する
                stationList.add(station);
            }

            //21. stationListをソートする
            Collections.sort(stationList);

            //22. FileWriter型の変数fwを宣言し、インスタンスを生成する
            FileWriter fw = new FileWriter("stationSort.csv");
            //23. station2.csvファイルにある最初の3行を書出
            for (String sl : skipList) {
                fw.write(sl + "\n");
            }

            //24.　stationListから抽出した各要素を全ての行CSVに書き出す(出力) & RF StationクラスのtoCSVLineを呼び出す
            for (Station st : stationList) {
                fw.write(st.toCSVLine() + "\n");
            }
            //25. FileWriterを閉じる
            fw.close();
            //26. bufferedReaderを閉じる
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}